package org.sample.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.sample.service.BoardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;


@Log4j
@CrossOrigin(origins= "http://localhost:3000")
@RequestMapping("/board/*")
@RestController
@AllArgsConstructor
public class BoardController {
	
	private BoardService service;
	
	@GetMapping(value= "/list/{page}", 
			produces ="application/json; charset=utf8")
	public ResponseEntity <Map<String, Object>> getList(
			@PathVariable("page") int page
			) {
		
		Criteria cri = new Criteria(page, 10);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("postList", service.getList(cri));
		map.put("pageMaker", new PageDTO(cri, service.getTotal(cri)));	
		return new ResponseEntity<>(map ,HttpStatus.OK);
	}
	
}

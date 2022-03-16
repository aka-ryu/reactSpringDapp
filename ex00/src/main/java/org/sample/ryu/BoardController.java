//package org.sample.ryu;
//
//import java.util.List;
//
//import org.sample.board.BoardVO;
//import org.sample.board.Criteria;
//import org.sample.service.BoardService;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import lombok.extern.log4j.Log4j;
//
//
//@Log4j
//@CrossOrigin(origins= "http://localhost:3000")
//@RequestMapping("/board/*")
//@RestController
//public class BoardController {
//	
//	private BoardService service;
//	
//	@GetMapping(value= "/list", 
//			produces ="application/json; charset=utf8")
//	public ResponseEntity<List<BoardVO>> getList() {
//		log.info("어 왔니?");
//		Criteria cri = new Criteria();
//		return new ResponseEntity<>(service.getList(cri),HttpStatus.OK);
//	}
//	
//}

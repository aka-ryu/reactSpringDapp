package org.sample.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.sample.service.BoardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/board/*")
@RestController
@AllArgsConstructor
public class BoardController {

	private BoardService service;

	@GetMapping(value = "/list/{page}", produces = "application/json; charset=utf8")
	public ResponseEntity<Map<String, Object>> getList(@PathVariable("page") int page) {

		System.out.println("요청된 리스트 페이지는 : " + page);
		log.info("ㅎㅇ");
		Criteria cri = new Criteria(page, 10);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("postList", service.getList(cri));
		map.put("pageMaker", new PageDTO(cri, service.getTotal(cri)));
		return new ResponseEntity<>(map, HttpStatus.OK);
	}

	@GetMapping(value = "/detail/{bno}", produces = "application/json; charset=utf8")
	public ResponseEntity<Map<String, Object>> get(@PathVariable("bno") Long bno) {

		System.out.println(bno + "번 글 데이터 요청");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("post", service.get(bno));

		return new ResponseEntity<>(map, HttpStatus.OK);
	}

	@PostMapping(value = "/newpost", produces = "application/json; charset=utf8")
	// 글 등록은 전달할 데이터가 없어서 void로 해도 되겠지만 유효성 검사 및 status 로 성공,실패 등을 전달해주기 위해 엔티티 사용
	public ResponseEntity<Map<String, Object>> register(@RequestBody BoardVO board) {
		System.out.println("등록 컨트롤러 접속");

		Map<String, Object> map = new HashMap<String, Object>();

// POST  URL 로 데이터 못보냄 유효성 리엑트에서
//		if (board.getTitle().getBytes().length > 50) {
//			map.put("TitleERROR","제목은 최대 50바이트 입니다");
//		}
//		
//		if (board.getContent().getBytes().length > 2000) {
//			map.put("ContentERROR", "내용은 최대 2000바이트 입니다");
//		}
//		
//		
//		if(map.isEmpty()) {
		try {
			service.register(board);
		} catch (Exception e) {
			map.put("Fail", e.getMessage());
		}

//			map.put("Success", "New Posted Success");
//			
//		} else {
//			map.put("Fail","제목,내용의 크기를 확인하세요.");
//		};

		return new ResponseEntity<>(map, HttpStatus.OK);
	}

	@GetMapping(value = "/edit/{bno}", produces = "application/json; charset=utf8")
	public ResponseEntity<Map<String, Object>> getEdit(@PathVariable("bno") Long bno) {

		System.out.println(bno + "번 글 수정 요청 페이지");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("post", service.get(bno));

		return new ResponseEntity<>(map, HttpStatus.OK);
	}

	@PostMapping(value = "/modify/{bno}", produces = "application/json; charset=utf8")
	public ResponseEntity<Map<String, Object>> modify(@RequestBody BoardVO board) {

		Map<String, Object> map = new HashMap<String, Object>();
		try {
			service.modify(board);
		} catch (Exception e) {
			map.put("Fail", e.getMessage());
		}

		return new ResponseEntity<>(map, HttpStatus.OK);
	}

	@PostMapping(value = "/remove/{bno}", produces = "application/json; charset=utf8")
	public ResponseEntity<Map<String, Object>> remove(@PathVariable("bno") Long bno) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			service.remove(bno);
		} catch (Exception e) {
			map.put("Fail", e.getMessage());
		}
		return new ResponseEntity<>(map, HttpStatus.OK);
	}

//	@PreAuthorize("hasRole('user')")
	@GetMapping(value = "/write", produces = "application/json; charset=utf8")
	public ResponseEntity<Map<String, Object>> writeAuthority() {
		log.info("글쓰기 권한 체크");
		Map<String, Object> map = new HashMap<String, Object>();
		return new ResponseEntity<>(map, HttpStatus.OK);
	}

}

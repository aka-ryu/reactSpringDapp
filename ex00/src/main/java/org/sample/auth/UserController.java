package org.sample.auth;

import java.util.HashMap;
import java.util.Map;

import org.sample.domain.MemberVO;
import org.sample.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@RestController
@Log4j
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/user/*")
@AllArgsConstructor
public class UserController {

	private UserService service;
	
	@PostMapping(value = "/join", produces = "application/json; charset=utf8")
	public ResponseEntity<Map<String, Object>> Join(@RequestBody MemberVO member) {

		log.info("회원가입 하러 왓니?");
		Map<String, Object> map = new HashMap<String, Object>();
		String userid = member.getUserid();
		// 아이디 중복체크
		if ((service.duplicateCheck(userid)) != 0) {
			String duplicate = "중복된 아이디가 존재 합니다.";
			map.put("duplicate", duplicate);
		} else {
			log.info(member);
			service.join(member);
			String success = "회원가입 성공";
			map.put("success", success);
		}

		return new ResponseEntity<>(map, HttpStatus.OK);
	}

	@PostMapping(value = "/login", produces = "application/json; charset=utf8")
	public ResponseEntity<Map<String, Object>> Login(@RequestBody MemberVO member) {
		
		log.info("로그인 하러 왓니?");
		if(service.get(member) == 1) {
			
		}
		Map<String, Object> map = new HashMap<String, Object>();
		return new ResponseEntity<>(map, HttpStatus.OK);
	}

}

//package org.sample.ryu;
//
//
//
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import lombok.extern.log4j.Log4j;
//
//@RestController
//@Log4j
//@CrossOrigin(origins= "http://localhost:3000")
//@RequestMapping("/api/*")
//public class SampleController {
//
//	
//	@GetMapping(value= "/hello", 
//			produces ="application/json; charset=utf8") 
//	public String hello() {
//		String hi = "난 스프링이야";
//		log.info(hi);
//		return hi;
//	}
//	
//}

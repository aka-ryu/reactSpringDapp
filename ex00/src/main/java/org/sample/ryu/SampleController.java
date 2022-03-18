package org.sample.ryu;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/sample/*")
@Controller
@CrossOrigin(origins = "http://localhost:3000")
public class SampleController {
	
	@GetMapping("/all")
	public void doAll() {
		log.info("all");
	}
	
	@GetMapping("/member")
	public void doMember() {
		log.info("member");
	}
	
	@GetMapping("/admin")
	public void doAd() {
		log.info("admin");
	}
}

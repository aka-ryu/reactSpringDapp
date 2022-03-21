package org.sample.service;

import org.sample.domain.MemberVO;
import org.sample.mapper.MemberMapper;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

	private MemberMapper mapper;

	@Override
	public int duplicateCheck(String userid) {
		
		return mapper.duplicateCheck(userid);
	}

	@Override
	public boolean join(MemberVO member) {
		
		log.info("join" + member);
		return mapper.insert(member) == 1;
	}

	@Override
	public int get(MemberVO member) {
		return mapper.getUser(member);
	}

	
}

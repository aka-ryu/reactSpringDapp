package org.sample.service;

import org.sample.domain.MemberVO;

public interface UserService {

	public int duplicateCheck(String userid);
	
	public boolean join(MemberVO member);
	
	public int get(MemberVO member);
}

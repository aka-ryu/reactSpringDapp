package org.sample.mapper;

import org.sample.domain.MemberVO;

public interface MemberMapper {

//	public MemberVO read(String userid);
	
	public int duplicateCheck (String userid);
	
	public int insert(MemberVO member);
	
	public int getUser(MemberVO member);
}

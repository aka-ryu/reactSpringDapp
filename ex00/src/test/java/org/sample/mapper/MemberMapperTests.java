package org.sample.mapper;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.sample.domain.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
@Log4j
public class MemberMapperTests {

  @Setter(onMethod_ = @Autowired)
  private MemberMapper mapper;
  
  
  @Test
  public void duplicateCheck() {
	  String userid = "tes1t";
	  log.info(mapper.duplicateCheck(userid));
	  
  }
  
  @Test
  public void testJoin() {
    
    MemberVO member = new MemberVO();
    member.setUserid("admin");
    member.setUserpw("admin");
    member.setUsername("admin");
    
    mapper.insert(member);
    log.info(member);
  }

  @Test
  public void get() {
	  MemberVO member = new MemberVO();
	  member.setUserid("admin");
	  member.setUserpw("admi1n");
	  log.info(mapper.getUser(member));
  }
}



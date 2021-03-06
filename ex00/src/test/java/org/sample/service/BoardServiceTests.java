package org.sample.service;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.sample.board.BoardVO;
import org.sample.board.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceTests {

	@Setter(onMethod_ = @Autowired)
	private BoardService service;
	
	@Test
	public void testExist() {
		log.info(service);
		assertNotNull(service);
	}
	
	@Test
	public void testRegister() {
		BoardVO board = new BoardVO();
		
		board.setContent("임플내용");
		board.setTitle("임플제목");
		board.setWriter("임플쓰니");
		
		log.info(service.register(board));
	}
	
//	@Test
//	public void testGetList() {
//		service.getList(new Criteria(1,10));
//	}
	
	@Test
	public void testRead() {
		log.info(service.get(1L));
	}
	
	@Test
	public void testModify() {
		log.info(service.remove(1L));
	}
	
	@Test
	public void testUpdate() {
		BoardVO board = service.get(2L);
		if(board == null) {
			return;
		}
		
		board.setContent("내용수정");
		service.modify(board);
		
		log.info(service.get(2L));
	}
	
	
	
	
}

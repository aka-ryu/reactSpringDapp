package org.sample.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.sample.board.BoardVO;
import org.sample.board.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {

	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;
	
	@Test
	public void testGetList() {
		mapper.getList(new Criteria(1,10)).forEach(board -> log.info(board));
	}
	
	@Test
	public void testInsert() {
		BoardVO board = new BoardVO();
		board.setTitle("새 제목");
		board.setContent("새 내용");
		board.setWriter("새 글쓰니");
		
		mapper.insert(board);
		log.info(board);
	}
	

	@Test
	public void testRead() {
		BoardVO board = mapper.read(11L);
		log.info(board);
	}
	
	@Test
	public void testDelete() {
		log.info("DELETE" + mapper.delete(5L) );
	}
	
	@Test
	public void testUpdate() {
		BoardVO board = new BoardVO();
		
		board.setBno(7L);
		board.setTitle("수정제목");
		board.setContent("수정내용");
		
		mapper.update(board);
		
		log.info(mapper.read(7L));
	}
	
//	@Test
//	public void testPaging() {
//		Criteria cri = new Criteria();
//		List<BoardVO> list = mapper.getListWithPaging(cri);
//		list.forEach(board -> log.info(board));
//	}
	
	
}

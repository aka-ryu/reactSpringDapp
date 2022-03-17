package org.sample.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.sample.board.BoardVO;
import org.sample.board.Criteria;
import org.sample.board.PageDTO;

public interface BoardMapper {
	
//	@Select("SELECT * FROM tbl_board WHERE bno > 0")
//	public List<BoardVO> getList();
	
	public List<BoardVO> getList(Criteria cri);

	public int insert(BoardVO board);
	
	public void insertSelectKey(BoardVO board);
	
	public BoardVO read(Long bno);
	
	public int delete(Long bno);
	
	public int update(BoardVO board);

	public int getTotal(Criteria cri);
}

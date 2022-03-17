package org.sample.service;

import java.util.List;

import org.sample.board.BoardVO;
import org.sample.board.Criteria;
import org.sample.board.PageDTO;

public interface BoardService {

	public boolean register(BoardVO board);
	
	public BoardVO get(Long bno);
	
	public boolean modify(BoardVO board);
	
	public boolean remove(Long bno);
	
//	public List<BoardVO> getList();
	public List<BoardVO> getList(Criteria cri);

	public int getTotal(Criteria cri);
}

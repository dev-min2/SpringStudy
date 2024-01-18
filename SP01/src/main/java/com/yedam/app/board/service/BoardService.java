package com.yedam.app.board.service;

import java.util.List;
import java.util.Map;


public interface BoardService {
	//전체조회
	public List<BoardVO> getBoardAll();
		
	//단건조회
	public BoardVO getBoardInfo(BoardVO boardVO);
	
	//등록
	public boolean insertBoard(BoardVO boardVO);
	
	//수정
	public Map<String,Object> modifyBoard(BoardVO boardVO);
	
	//삭제
	public boolean deleteBoard(int bno);
}

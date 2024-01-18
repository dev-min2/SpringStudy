package com.yedam.app.board.service;

import java.util.List;
import java.util.Map;


public interface BoardService {
	//��ü��ȸ
	public List<BoardVO> getBoardAll();
		
	//�ܰ���ȸ
	public BoardVO getBoardInfo(BoardVO boardVO);
	
	//���
	public boolean insertBoard(BoardVO boardVO);
	
	//����
	public Map<String,Object> modifyBoard(BoardVO boardVO);
	
	//����
	public boolean deleteBoard(int bno);
}

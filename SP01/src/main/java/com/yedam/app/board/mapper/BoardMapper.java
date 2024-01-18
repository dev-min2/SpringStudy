package com.yedam.app.board.mapper;

import java.util.List;

import com.yedam.app.board.service.BoardVO;

public interface BoardMapper {
	//��ü��ȸ
	public List<BoardVO> selectBoardList();
	
	//�ܰ���ȸ
	public BoardVO selectBoardInfo(BoardVO boardVO);
	
	//���(selectKey)
	public int insertBoard(BoardVO vo);
	
	//����
	public int updateBoard(BoardVO vo);
	
	//����
	public int deleteBoard(int bno);
}

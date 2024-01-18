package com.yedam.app.board.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.board.mapper.BoardMapper;
import com.yedam.app.board.service.BoardService;
import com.yedam.app.board.service.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardMapper boardMapper = null;
	
	@Override
	public List<BoardVO> getBoardAll() {
		// TODO Auto-generated method stub
		return boardMapper.selectBoardList();
	}

	@Override
	public BoardVO getBoardInfo(BoardVO boardVO) {
		// TODO Auto-generated method stub
		return boardMapper.selectBoardInfo(boardVO);
	}

	@Override
	public boolean insertBoard(BoardVO boardVO) {
		// TODO Auto-generated method stub
		return boardMapper.insertBoard(boardVO) > 0 ? true : false;
	}

	@Override
	public Map<String,Object> modifyBoard(BoardVO boardVO) {
		// TODO Auto-generated method stub
		int result = boardMapper.updateBoard(boardVO);
		
		Map<String, Object> retMap = new HashMap<>();
		retMap.put("result", result > 0 ? true : false);
		retMap.put("target", boardVO);
		
		return retMap;
	}

	@Override
	public boolean deleteBoard(int bno) {
		// TODO Auto-generated method stub
		return boardMapper.deleteBoard(bno) > 0 ? true : false;
	}


}

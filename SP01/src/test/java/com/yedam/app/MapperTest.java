package com.yedam.app;

import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yedam.app.aop.service.AaaService;
import com.yedam.app.board.mapper.BoardMapper;
import com.yedam.app.board.service.BoardVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/**/*-context.xml")
public class MapperTest {

	@Autowired
	private BoardMapper boardMapper;

	//@Test
	public void selectAll() {
		List<BoardVO> list = boardMapper.selectBoardList();
		assertTrue(!list.isEmpty());
	}
	
	//@Test
	public void select() {
		BoardVO vo = new BoardVO();
		vo.setBno(2);
		vo = boardMapper.selectBoardInfo(vo);
		assertTrue(vo != null);
	}
	
	//@Test
	public void insert() {
		BoardVO newVO = new BoardVO();
		newVO.setContents("내용임");
		newVO.setTitle("제목임");
		newVO.setWriter("작성자임");
		newVO.setUpdatedate(new Date());
		
		int result = boardMapper.insertBoard(newVO);
		assertTrue(result != 0);
	}
	
	//@Test
	public void update() {
		BoardVO findVO = new BoardVO();
		findVO.setBno(2);
		BoardVO updateVO = boardMapper.selectBoardInfo(findVO);
		updateVO.setContents("test내용임");
		
		int result = boardMapper.updateBoard(updateVO);
		assertTrue(result != 0);
	}
	
	@Autowired
	private AaaService aaaService;
	
	@Test
	public void aopTestA() {
		aaaService.insert();
	}
	
//	
//	@Test
//	public void delete() {
//		int result = boardMapper.deleteBoard(1);
//		assertTrue(result != 0 );
//	}

}

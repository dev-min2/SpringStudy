package com.yedam.app.board.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.board.service.BoardService;
import com.yedam.app.board.service.BoardVO;

@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	
	//전체조회 : URI - boardList / Return - board/boardList
	
	@GetMapping("boardList")
	public String boardListControl(Model model) { 
		var boardList = boardService.getBoardAll();
		model.addAttribute("list", boardList);
		
		return "board/boardList";
	}
	//단건조회 : URI - boardInfo / PARAMETER - BoardVO / RETURN - board/boardInfo
	@GetMapping("boardInfo")
	public String boardInfoControl(BoardVO vo, Model model) {
		var boardInfo = boardService.getBoardInfo(vo);
		model.addAttribute("boardInfo", boardInfo);
		return "board/boardInfo";
	}
	
	//등록 - 페이지(Form) : URI - boardInsert / RETURN - board/boardInsert
	@GetMapping("boardInsert")
	public String boardInsertControl() {
		return "board/boardInsert";
	}
	//등록 - 처리 : URI - boardInsert / PARAMETER - boardVO / RETURN - 전체조회 다시 호출
	@PostMapping("boardInsert")
	public String boardInsertControl(BoardVO vo) {
		boardService.insertBoard(vo);
		return "redirect:boardList";
	}
	
	//수정 - 페이지 : URI - boardUpdate / PARAMETER - BoardVO / RETURN - board/boardUpdate
	@GetMapping("boardUpdate")
	public String boardUpdateControl(BoardVO boardVO, Model model) {
		BoardVO findVO = boardService.getBoardInfo(boardVO);
		model.addAttribute("boardInfo", findVO);
		
		// 입력을 받아야하기에 별도의 페이지로 구성 
		return "board/boardUpdate";
	}
	//수정 - 처리(ajax) : URI - boardUpdate / PARAMETER - BoardVO / RETURN - 수정결과 데이터(Map)
	@PostMapping("boardUpdate")
	@ResponseBody
	public Map<String, Object> boardAjaxUpdateControl(@RequestBody BoardVO vo, Model model) {
		// ajax를 기반으로 통신을 할 떄 @RequestBody를 쓰면 json -> javaObject변환 과정을거침
		// 그게 아니면 queryString방식 (key=value)형태로만 데이터가 전달됨.
		return boardService.modifyBoard(vo);
	}
	
	
	@GetMapping("boardDelete")
	public String boardDeleteControl(@RequestParam int bno) {
		boardService.deleteBoard(bno);
		return "redirect:boardList";
	}
	
	
	
}

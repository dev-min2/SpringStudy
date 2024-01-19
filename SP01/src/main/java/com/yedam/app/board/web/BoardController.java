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
	
	
	//��ü��ȸ : URI - boardList / Return - board/boardList
	
	@GetMapping("boardList")
	public String boardListControl(Model model) { 
		var boardList = boardService.getBoardAll();
		model.addAttribute("list", boardList);
		
		return "board/boardList";
	}
	//�ܰ���ȸ : URI - boardInfo / PARAMETER - BoardVO / RETURN - board/boardInfo
	@GetMapping("boardInfo")
	public String boardInfoControl(BoardVO vo, Model model) {
		var boardInfo = boardService.getBoardInfo(vo);
		model.addAttribute("boardInfo", boardInfo);
		return "board/boardInfo";
	}
	
	//��� - ������(Form) : URI - boardInsert / RETURN - board/boardInsert
	@GetMapping("boardInsert")
	public String boardInsertControl() {
		return "board/boardInsert";
	}
	//��� - ó�� : URI - boardInsert / PARAMETER - boardVO / RETURN - ��ü��ȸ �ٽ� ȣ��
	@PostMapping("boardInsert")
	public String boardInsertControl(BoardVO vo) {
		boardService.insertBoard(vo);
		return "redirect:boardList";
	}
	
	//���� - ������ : URI - boardUpdate / PARAMETER - BoardVO / RETURN - board/boardUpdate
	@GetMapping("boardUpdate")
	public String boardUpdateControl(BoardVO boardVO, Model model) {
		BoardVO findVO = boardService.getBoardInfo(boardVO);
		model.addAttribute("boardInfo", findVO);
		
		// �Է��� �޾ƾ��ϱ⿡ ������ �������� ���� 
		return "board/boardUpdate";
	}
	//���� - ó��(ajax) : URI - boardUpdate / PARAMETER - BoardVO / RETURN - ������� ������(Map)
	@PostMapping("boardUpdate")
	@ResponseBody
	public Map<String, Object> boardAjaxUpdateControl(@RequestBody BoardVO vo, Model model) {
		// ajax�� ������� ����� �� �� @RequestBody�� ���� json -> javaObject��ȯ ��������ħ
		// �װ� �ƴϸ� queryString��� (key=value)���·θ� �����Ͱ� ���޵�.
		return boardService.modifyBoard(vo);
	}
	
	
	@GetMapping("boardDelete")
	public String boardDeleteControl(@RequestParam int bno) {
		boardService.deleteBoard(bno);
		return "redirect:boardList";
	}
	
	
	
}

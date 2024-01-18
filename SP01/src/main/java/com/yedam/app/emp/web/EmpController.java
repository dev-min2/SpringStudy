package com.yedam.app.emp.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;

@Controller
public class EmpController {
	
	// @RequestBody : json요청 데이터를 java object로
	// @ResponseBody : javaObject를 json 응답 데이터로.
	
	@Autowired
	private EmpService empService;
	// GET : 조회, 빈페이지 호출
	// POST : 데이터조작(등록,수정,삭제)
	
	//전체조회
	@GetMapping("empList")
	//@ResponseBody
	public String getEmpList(Model model) {
		var empList = empService.getEmpAll();
		model.addAttribute("empList", empList);
		
		return "emp/empList";
	}
	
	//사원조회
	@GetMapping("emp")
	public String getEmpInfo(EmpVO vo, Model model) {
		var empInfo = empService.getEmpInfo(vo);
		model.addAttribute("empInfo", empInfo);
		
		return "emp/empInfo";
	}
	
	//사원등록 - FROM(Get 요청으로 사원등록 화면을 요청. Get요청 사용방식 1. 단순 조회 2. 페이지 요청)
	@GetMapping("empInsert")
	public String insertEmpInfoForm() {
		return "emp/empInsert";
	}
	
	//사원등록 - PROCESS
	@PostMapping("empInsert")
	public String insertEmpInfoProcess(EmpVO empVO) {
		int empId = empService.insertEmpInfo(empVO);
		String path = null;
		if(empId > -1) {
			// Spring은 밑과 같이 return되는 문자열이 redirect: 로 시작하면 새로운 경로로 요청하도록 알아서 처리해줌
			path = "redirect:emp?employeeId=" + empId;
		}
		else {
			path = "redirect:empList";
		}
		return path;
	}
	
	//사원수정 - PROCESS(Ajax => @ResponseBody)
	//1) 쿼리스트링 => 커맨드객체
	@PostMapping("empUpdate")
	@ResponseBody
	public Map<String, Object> empUpdateProcess(EmpVO empVO) {
		return empService.updateEmpInfo(empVO);
	}
	
	//2) JSON => @RequestBody
	@PostMapping("empUpdateAjax")
	@ResponseBody
	public Map<String, Object> empUpdateAjaxProcess(@RequestBody EmpVO empVO) {
		return empService.updateEmpInfo(empVO);
	}
	
	//사원삭제 - PROCESS
	@GetMapping("empDelete")
	public String empDelete(@RequestParam Integer eid) { // @RequestParam은 명시적으로 선언시 required가 true가 됨.
		empService.deleteEmpInfo(eid);
		return "redirect:empList";
	}
}
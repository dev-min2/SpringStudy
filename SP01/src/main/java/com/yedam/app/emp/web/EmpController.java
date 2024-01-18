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
	
	// @RequestBody : json��û �����͸� java object��
	// @ResponseBody : javaObject�� json ���� �����ͷ�.
	
	@Autowired
	private EmpService empService;
	// GET : ��ȸ, �������� ȣ��
	// POST : ����������(���,����,����)
	
	//��ü��ȸ
	@GetMapping("empList")
	//@ResponseBody
	public String getEmpList(Model model) {
		var empList = empService.getEmpAll();
		model.addAttribute("empList", empList);
		
		return "emp/empList";
	}
	
	//�����ȸ
	@GetMapping("emp")
	public String getEmpInfo(EmpVO vo, Model model) {
		var empInfo = empService.getEmpInfo(vo);
		model.addAttribute("empInfo", empInfo);
		
		return "emp/empInfo";
	}
	
	//������ - FROM(Get ��û���� ������ ȭ���� ��û. Get��û ����� 1. �ܼ� ��ȸ 2. ������ ��û)
	@GetMapping("empInsert")
	public String insertEmpInfoForm() {
		return "emp/empInsert";
	}
	
	//������ - PROCESS
	@PostMapping("empInsert")
	public String insertEmpInfoProcess(EmpVO empVO) {
		int empId = empService.insertEmpInfo(empVO);
		String path = null;
		if(empId > -1) {
			// Spring�� �ذ� ���� return�Ǵ� ���ڿ��� redirect: �� �����ϸ� ���ο� ��η� ��û�ϵ��� �˾Ƽ� ó������
			path = "redirect:emp?employeeId=" + empId;
		}
		else {
			path = "redirect:empList";
		}
		return path;
	}
	
	//������� - PROCESS(Ajax => @ResponseBody)
	//1) ������Ʈ�� => Ŀ�ǵ尴ü
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
	
	//������� - PROCESS
	@GetMapping("empDelete")
	public String empDelete(@RequestParam Integer eid) { // @RequestParam�� ��������� ����� required�� true�� ��.
		empService.deleteEmpInfo(eid);
		return "redirect:empList";
	}
}
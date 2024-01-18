package com.yedam.app.emp.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;

//@Controller
@CrossOrigin("*") // ��� origin�� ���� cors���(origin�� �ٸ��� ��û�� �źε�)
@RestController // Rest����� ������� �ϴ� ��Ʈ�ѷ� -> ������ ��� �޼ҵ�� �������� �ƴ� �����͸� ��ȯ��(@ResponseBody�� ������)
public class EmpRestController {
	
	@Autowired
	private EmpService empService;
	
	//��ü��ȸ
	@GetMapping("emps")
	public List<EmpVO> getEmpList() {
		return empService.getEmpAll();
	}
	
	//�ܰ���ȸ
	@GetMapping("emps/{eid}")
	public EmpVO getEmpInfo(@PathVariable Integer eid) {
		EmpVO empVO = new EmpVO();
		empVO.setEmployeeId(eid);
		return empService.getEmpInfo(empVO);
	}

	//���
	@PostMapping("emps")
	public Map<String, Object> insertEmpInfo(@RequestBody EmpVO empVO) {
		int eid = empService.insertEmpInfo(empVO);
		Map<String, Object> map = new HashMap<>();
		map.put("result", eid);
		return map;		
	}

//	//����
	@PutMapping("emps/{id}")
	public Map<String, Object> updateEmpInfo(@PathVariable Integer id, @RequestBody EmpVO empVO) {
		empVO.setEmployeeId(id);
		return empService.updateEmpInfo(empVO);
	}
	
	//���� 
	@DeleteMapping("emps/{id}")
	public boolean deleteEmpInfo(@PathVariable Integer id) {
		return empService.deleteEmpInfo(id);
	}
	
}

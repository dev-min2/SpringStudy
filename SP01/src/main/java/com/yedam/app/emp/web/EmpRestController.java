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
@CrossOrigin("*") // 모든 origin에 대한 cors허용(origin이 다르면 요청이 거부됨)
@RestController // Rest방식을 기반으로 하는 컨트롤러 -> 내부의 모든 메소드는 페이지가 아닌 데이터를 반환함(@ResponseBody를 빼도됨)
public class EmpRestController {
	
	@Autowired
	private EmpService empService;
	
	//전체조회
	@GetMapping("emps")
	public List<EmpVO> getEmpList() {
		return empService.getEmpAll();
	}
	
	//단건조회
	@GetMapping("emps/{eid}")
	public EmpVO getEmpInfo(@PathVariable Integer eid) {
		EmpVO empVO = new EmpVO();
		empVO.setEmployeeId(eid);
		return empService.getEmpInfo(empVO);
	}

	//등록
	@PostMapping("emps")
	public Map<String, Object> insertEmpInfo(@RequestBody EmpVO empVO) {
		int eid = empService.insertEmpInfo(empVO);
		Map<String, Object> map = new HashMap<>();
		map.put("result", eid);
		return map;		
	}

//	//수정
	@PutMapping("emps/{id}")
	public Map<String, Object> updateEmpInfo(@PathVariable Integer id, @RequestBody EmpVO empVO) {
		empVO.setEmployeeId(id);
		return empService.updateEmpInfo(empVO);
	}
	
	//삭제 
	@DeleteMapping("emps/{id}")
	public boolean deleteEmpInfo(@PathVariable Integer id) {
		return empService.deleteEmpInfo(id);
	}
	
}

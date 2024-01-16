package com.yedam.app.emp.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.emp.service.EmpVO;

@Controller
public class EmpTestController {
	
	@GetMapping("getTestEmp")
	@ResponseBody // jsp가 아닌 데이터를 반환
	public EmpVO getEmpInfo(EmpVO vo) {
		
		EmpVO dd = new EmpVO();
		dd.setEmployeeId(5555);
		return dd;
	}
	
	@PostMapping("getTestEmp")
	@ResponseBody // jsp가 아닌 데이터를 반환
	public EmpVO getEmpInfoPost(EmpVO empVO) {
		empVO.setEmployeeId(9000);
		return empVO;
	}
	
	@GetMapping("paramTestEmp")
	@ResponseBody
	public Map<String, Object> paramTestEmpGet(String lastName, Integer age) {
		Map<String, Object> map = new HashMap<>();
		map.put("name", lastName);
		map.put("age", age);
		return map;
	}
	
	@PostMapping("paramTestEmp")
	@ResponseBody
	public Map<String, Object> paramTestEmpPost(@RequestParam String lastName, @RequestParam(defaultValue = "10") Integer age) {
		Map<String, Object> map = new HashMap<>();
		map.put("name", lastName);
		map.put("age", age);
		return map;
	}
	
	// path테스틍
	@GetMapping("pathTestEmp/{id}/{password}")
	@ResponseBody // json
	public Map<String,String> pathTestEmpGet(@PathVariable String id, @PathVariable(name ="password") String pwd) {
		Map<String,String> object = new HashMap<>();
		object.put("id", id);
		object.put("pwd", pwd);
		return object;
	}
	
	@PostMapping("jsonTestEmp")
	@ResponseBody // json
	public EmpVO jsonTestEmpGet(@RequestBody EmpVO empVO) {
		return empVO;
	}
}

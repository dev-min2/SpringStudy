package com.example.demo.emp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.emp.EmpVO;

@Mapper
public interface EmpMapper { 
	public List<EmpVO> getEmpList(EmpVO empVO);
}

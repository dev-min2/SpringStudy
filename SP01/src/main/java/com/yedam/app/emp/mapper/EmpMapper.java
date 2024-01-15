package com.yedam.app.emp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yedam.app.emp.service.EmpVO;

public interface EmpMapper {
	public List<EmpVO> selectEmpList();
	
	public EmpVO selectEmpInfo(EmpVO empVo);
	
	// DML�� ������ intŸ���� ��ȯ
	public int insertEmpInfo(EmpVO empVo);
	
	public int updateEmpInfo(EmpVO empVo);
	
	public int deleteEmpInfo(int eId);
	
	public int updateEmpInfoDynamic(EmpVO empVO);
	
	// �Ű������� 2���ΰ��
	public int updateEmpSal(@Param("eId") int empId, @Param("info") EmpVO empVO);
}

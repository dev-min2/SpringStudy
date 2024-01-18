// 이렇게 Impl객체가 2개면 스프링은 bean주입을 할 때 어떤 인터페이스를 구현한 객체를 주입할지 알수없으므로(혹은 구현객체를 타입으로 직접명시하거나?)
// NoUniqueBeanDefinitionException 예외가 발생함.


//package com.yedam.app.emp.service.impl;
//
//import java.util.List;
//import java.util.Map;
//
//import org.springframework.stereotype.Service;
//
//import com.yedam.app.emp.service.EmpService;
//import com.yedam.app.emp.service.EmpVO;
//
//@Service
//public class EmpServiceImpl2 implements EmpService {
//
//	@Override
//	public List<EmpVO> getEmpAll() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public EmpVO getEmpInfo(EmpVO empVO) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public int insertEmpInfo(EmpVO empVO) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public Map<String, Object> updateEmpInfo(EmpVO empVO) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public boolean deleteEmpInfo(int empId) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//}

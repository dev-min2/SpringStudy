package com.yedam.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yedam.app.emp.mapper.EmpMapper;
import com.yedam.app.emp.service.EmpVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class MapperTest {
	
	@Autowired
	private EmpMapper empMapper;
	
	//�쟾泥댁“�쉶
	@Test
	public void selectAll() {
		List<EmpVO> list = empMapper.selectEmpList();
		assertTrue(!list.isEmpty());
	}
	
	//�떒嫄댁“�쉶
	//@Test
	public void selectInfo() {
		EmpVO empVO = new EmpVO();
		empVO.setEmployeeId(100);
		EmpVO findVO = empMapper.selectEmpInfo(empVO);
		System.out.println(empVO.getEmployeeId());
		assertEquals(findVO.getLastName(), "King");
	}
	
	//�벑濡�
	//@Test
	public void insertInfo() {
		EmpVO empVO = new EmpVO();
		empVO.setLastName("Hong");
		empVO.setEmail("kdong@google.com");
		empVO.setHireDate(new Date("24/01/15"));
		empVO.setJobId("IT_PROG");
		empVO.setSalary(10000);
		
		int result = empMapper.insertEmpInfo(empVO);
		assertNotEquals(result, 0);
	}
	
	//�닔�젙
	//@Test
	public void updateInfo() {
		EmpVO empVO = new EmpVO();
		empVO.setEmployeeId(205);
		EmpVO findVO = empMapper.selectEmpInfo(empVO);
		findVO.setLastName("Kang");
		int result = empMapper.updateEmpInfo(findVO);
		assertNotEquals(result, 0);
	}
	
	//�닔�젙
	//@Test
	public void updateInfoDynamic() {
		EmpVO empVO = new EmpVO();
		empVO.setEmployeeId(205);
		empVO.setSalary(5200);
		int result = empMapper.updateEmpInfoDynamic(empVO);
		assertNotEquals(result, 0);
	}
	
	//�궘�젣
	//@Test
	public void deleteInfo() {
		int result = empMapper.deleteEmpInfo(205);
		assertNotEquals(result, 0);
	}
	
}

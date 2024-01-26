package com.example.demo.member;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.emp.EmpVO;
import com.example.demo.member.mapper.MemberMapper;

@SpringBootTest
public class MemberMapperTest {

	@Autowired
	private MemberMapper memberMapper;
	
	@Test
	public void 전체조회() {
		var vo = memberMapper.getMember("hyeff");
		System.out.println(vo);
		assertThat(vo == null).isEqualTo(false);
	}
}

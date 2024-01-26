package com.example.demo.member.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.member.MemberVO;
import com.example.demo.member.UserDetailVO;
import com.example.demo.member.mapper.MemberMapper;
import com.example.demo.member.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService, UserDetailsService {

	@Autowired
	private MemberMapper memberMapper;
	
	@Override
	public MemberVO getMember(String mid) {
		// TODO Auto-generated method stub
		return memberMapper.getMember(mid);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		MemberVO vo = memberMapper.getMember(username);
		if(vo == null) {
			throw new UsernameNotFoundException("no name");
		}
		
		return new UserDetailVO(vo);
	}
}

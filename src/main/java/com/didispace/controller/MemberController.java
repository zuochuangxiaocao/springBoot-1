package com.didispace.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.didispace.dao.MemberLoginMapper;
import com.didispace.dto.PageResultDto;
import com.didispace.dto.Query;
import com.didispace.model.MemberLogin;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@RestController
@RequestMapping("/member")
public class MemberController {

	@Autowired
	MemberLoginMapper memberLoginMapper;
	
	@RequestMapping("/select")
	public PageResultDto index() {

		MemberLogin login = memberLoginMapper.selectByPrimaryKey(1);

		MemberLogin record = new MemberLogin();
		record.setMobile("22222");
		record.setCheckCode("1123132");
		record.setStatus("1");
		record.setArea("111");
		//memberLoginMapper.insert(record);
		
		Query query = new Query();
		//PageHelper.startPage(query.getSafePageNum(), query.getSafePageSize());
		PageHelper.startPage(3, 1);
		List<MemberLogin> list = memberLoginMapper.selectList();
		
		
		PageResultDto pageResultDto = new PageResultDto();
		BeanUtils.copyProperties(new PageInfo<MemberLogin>(list), pageResultDto);
		
		return pageResultDto; 
		//return list;
	}
	
	@RequestMapping("/insert")
	@Transactional
	public String insert() {
		
		MemberLogin record = new MemberLogin();
		record.setMobile("555");
		record.setCheckCode("1123132");
		record.setStatus("1");
		record.setArea("111");
		memberLoginMapper.insert(record);
		
		record = new MemberLogin();
		record.setMobile("555");
		record.setCheckCode("1123132");
		record.setStatus("1");
		record.setArea("111");
		memberLoginMapper.insert(record);
		
		
		return "ss";
	}
	
	
}

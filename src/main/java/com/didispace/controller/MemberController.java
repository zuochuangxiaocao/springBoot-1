package com.didispace.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.didispace.dao.MemberLoginMapper;
import com.didispace.dto.PageResultDto;
import com.didispace.dto.Query;
import com.didispace.dto.ResponseResult;
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
	
	@Cacheable(value = "user")
	@RequestMapping("/getUserById")
	public ResponseResult getUserById(Integer id) {
		
		MemberLogin login = memberLoginMapper.selectByPrimaryKey(id);
		
		//List<MemberLogin> list = memberLoginMapper.selectList();
		
		System.out.println(login);
		
		//System.out.println(list);
		
		return new ResponseResult(login);
	}
	
	@CachePut(value = "user",key = "#root.caches[0].name + ':' + #record.mobile")//key = "#root.caches[0].name + ':' + #record.id"
	@RequestMapping("/add")
	public MemberLogin add() {
			MemberLogin record = new MemberLogin();
			record.setMobile("sdfdsfdsfds");
			record.setCheckCode("1123132");
			record.setStatus("1");
			record.setArea("111");
			int s = memberLoginMapper.insert(record);
			record.setId(s);
			return record;
	}
	
}

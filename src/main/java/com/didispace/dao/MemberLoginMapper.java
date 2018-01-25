package com.didispace.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.didispace.model.MemberLogin;

@Mapper
public interface MemberLoginMapper {

    int insert(MemberLogin record);

    MemberLogin selectByPrimaryKey(@Param("id")Integer id);
    
    List<MemberLogin> selectList();
}
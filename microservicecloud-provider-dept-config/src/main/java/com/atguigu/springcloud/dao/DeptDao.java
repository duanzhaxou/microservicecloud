package com.atguigu.springcloud.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.atguigu.springcloud.entities.Dept;

/**
 * @ClassName:
 * @Description:
 * @author DuanZhaoXu
 * @data 2018年9月29日下午1:56:34
 */

@Mapper
public interface DeptDao {

	public boolean addDept(Dept dept);

	public Dept findById(Long id);

	public List<Dept> findAll();
}

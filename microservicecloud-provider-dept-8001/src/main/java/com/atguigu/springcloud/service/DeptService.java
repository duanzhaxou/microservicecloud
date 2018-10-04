package com.atguigu.springcloud.service;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.atguigu.springcloud.entities.Dept;

/**
 * @ClassName:
 * @Description:
 * @author DuanZhaoXu
 * @data 2018年9月29日下午1:56:34
 */


public interface DeptService {

	public boolean add(Dept dept);

	public Dept get(Long id);

	public List<Dept> list();
}

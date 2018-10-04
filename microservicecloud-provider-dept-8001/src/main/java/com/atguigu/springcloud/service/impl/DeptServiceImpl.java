package com.atguigu.springcloud.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.springcloud.dao.DeptDao;
import com.atguigu.springcloud.entities.Dept;
import com.atguigu.springcloud.service.DeptService;

/**
 * @ClassName:
 * @Description:
 * @author DuanZhaoXu
 * @data 2018年9月29日下午2:16:13
 */
@Service
public class DeptServiceImpl implements DeptService {

	
	@Autowired
	private DeptDao  deptDao;
	
	
	@Override
	public boolean add(Dept dept) {
		// TODO Auto-generated method stub
		return deptDao.addDept(dept);
	}

	
	@Override
	public Dept get(Long id) {
		// TODO Auto-generated method stub
		return deptDao.findById(id);
	}

	
	@Override
	public List<Dept> list() {
		// TODO Auto-generated method stub
		return deptDao.findAll();
	}

}

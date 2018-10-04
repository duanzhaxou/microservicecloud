package com.atguigu.springcloud.entities;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @ClassName:
 * @Description:
 * @author DuanZhaoXu
 * @data 2018年9月29日上午11:18:23
 */
@Data              //setter and getter 
@NoArgsConstructor   //lombok 无参构造
@AllArgsConstructor   //lombok 全参构造
@Accessors(chain=true)  //链式 set 
public class Dept implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8823145473094241791L;

	private Long  deptno;
	
	private String dname;
	
	private  String db_source;
	
	
	
	/**
	 * @param dname
	 */
	public Dept(String dname) {
		super();
		this.dname = dname;
	}
	
	

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Dept [deptno=" + deptno + ", dname=" + dname + ", db_source=" + db_source + "]";
	}
	
	public static void main(String[] args) {
		Dept dept =new Dept();
	}
}

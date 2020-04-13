package com.sec.model;

import javax.management.RuntimeErrorException;
/**
 * 
 * Comparable （类的自然排序 ） 和Comparator
 * 
 * 用于自己定义的数据结构  进行排序 需要我们给予他一定的排序规则  
 * @author lenovo
 *
 */
public class Student implements  Comparable {
	int id;
	private String name;
	private int age;
	@Override
	public int compareTo(Object obj) {    //  大于  小于  等于     负整数   零 正整数
		
		if(!(obj instanceof Student)){
			
			throw new RuntimeException("不是学生对象");
		}
		Student s =(Student)obj;
		// TODO Auto-generated method stub
		return 0;
	}

}

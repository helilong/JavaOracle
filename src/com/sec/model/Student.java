package com.sec.model;

import javax.management.RuntimeErrorException;
/**
 * 
 * Comparable �������Ȼ���� �� ��Comparator
 * 
 * �����Լ���������ݽṹ  �������� ��Ҫ���Ǹ�����һ�����������  
 * @author lenovo
 *
 */
public class Student implements  Comparable {
	int id;
	private String name;
	private int age;
	@Override
	public int compareTo(Object obj) {    //  ����  С��  ����     ������   �� ������
		
		if(!(obj instanceof Student)){
			
			throw new RuntimeException("����ѧ������");
		}
		Student s =(Student)obj;
		// TODO Auto-generated method stub
		return 0;
	}

}

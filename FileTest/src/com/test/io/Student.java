package com.test.io;

import java.io.Serializable;

public class Student implements Serializable{
	
	private String stuNo;
	private String stuName;
	// 该元素不会进行jvm默认的序列化,也可以自己完成这个元素的序列化
	private transient int stuAge;
	
	
	public String getStuNo() {
		return stuNo;
	}
	public void setStuNo(String stuNo) {
		this.stuNo = stuNo;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public int getStuAge() {
		return stuAge;
	}
	public void setStuAge(int stuAge) {
		this.stuAge = stuAge;
	}
	@Override
	public String toString() {
		return "Student [stuNo=" + stuNo + ", stuName=" + stuName + ", stuAge="
				+ stuAge + "]";
	}
	public Student(String stuNo, String stuName, int stuAge) {
		super();
		this.stuNo = stuNo;
		this.stuName = stuName;
		this.stuAge = stuAge;
	}
	
	
}

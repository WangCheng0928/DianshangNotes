package com.test.io;

import java.io.File;
import java.io.IOException;


public class FileDemo {
	
	public static void main(String[] args) {
		//了解构造函数的情况   查帮助
		File file = new File("D:\\Workspaces\\MyEclipse 10\\imooc");
//		System.out.println(file.exists());
		if (!file.exists()) {
			//只是创建一级目录
			file.mkdir();
			//创建多级目录时可以调用file.mkdirs()
		}
		else {
			file.delete();
		}
		//是否是一个目录  如果是目录返回true,如果不是目录or目录不存在返回的是false
		System.out.println(file.isDirectory());
		//是否是一个文件
		System.out.println(file.isFile());
		
//		File file2 = new File("D:\\Workspaces\\MyEclipse 10\\日记1.txt");
		File file2 = new File("D:\\Workspaces\\MyEclipse 10", "日记1.txt");
		if (!file2.exists()) {
			try {
				file2.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			file2.delete();
		}
		System.out.println(file);
		System.out.println(file.getAbsolutePath());
		System.out.println(file.getName());
		System.out.println(file2.getName());
		System.out.println(file.getParent());
		System.out.println(file2.getParent());
		System.out.println(file.getParentFile().getAbsolutePath());
	}
}

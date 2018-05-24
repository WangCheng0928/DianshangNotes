package com.test.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class ObjectSerializableDemo {
	
	public static void main(String[] args) throws Exception {
		String file = "src/com/test/io/file6";
		//1.对象的序列化
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
		Student student = new Student("10001", "张三", 20);
		oos.writeObject(student);   // write to oos
		oos.flush();
		oos.close();
		
		//2.对象的反序列化
//		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
//		Student student = (Student)ois.readObject();  //read from ois
//		System.out.println(student);
//		ois.close();
	}
}

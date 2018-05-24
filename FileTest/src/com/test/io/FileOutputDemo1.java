package com.test.io;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputDemo1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//如果该文件不存在，则直接创建，如果存在，删除后创建。
		FileOutputStream outputStream = new FileOutputStream("demo/out.txt");
		//如果该文件不存在，则直接创建，如果存在，则在后面添加（不删除）
//		FileOutputStream outputStream = new FileOutputStream("demo/out.txt",true);
		outputStream.write('A'); //写出了'A'的低八位
		outputStream.write('B'); //写出了'B'的低八位
		int a = 10;  //write只能写八位，那么写一个int需要写4次 每次8位
		outputStream.write(a >>> 24);
		outputStream.write(a >>> 16);
		outputStream.write(a >>> 8);
		outputStream.write(a);
		
		byte[] gbk = "中国".getBytes("gbk");
		outputStream.write(gbk);
		outputStream.close();
		IOUtil.printHex("demo/out.txt");
	}

}

package com.test.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class IsrAndOswDemo {
	
	/*
	 * 整个项目时什么编码，读取的文件如果和项目的编码一样，则不会出现乱码。否则读取的文件会出现乱码的情况
	 */
	
	public static void main(String[] args) throws IOException {
		FileInputStream inputStream = new FileInputStream("src/com/test/io/file");
		InputStreamReader isr = new InputStreamReader(inputStream); //默认项目的编码  如果读取的文件的编码时其他的编码格式，就需要添加相应的编码
		int c;
//		while ((c = isr.read()) != -1) {
//			System.out.println((char)c);
//		}
		char[] buffer = new char[1024];
		//批量读取，放入buffer这个字符数组，从第0个位置开始放置，最多放buffer.length个
		//每次批量读取1024个字节，如果没有读到最后一个，再次批量读取1024个字节. isr.read其实是 read from isr!
		while ((c = isr.read(buffer, 0, buffer.length)) != -1) {
			String string = new String(buffer, 0, c);
			System.out.println(string);
		}
		isr.close();
	}
}

package com.test.io;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FrAndFwDemo {
	public static void main(String[] args) throws IOException{
		FileReader fReader = new FileReader("src/com/test/io/file");
		FileWriter fWriter = new FileWriter("src/com/test/io/file3");
		char[] buffer = new char[2056]; //fReader的read()方法必须是char型的参数
		int c;
		while ((c = fReader.read(buffer, 0, buffer.length)) != -1) { //这里是read from fReader
			fWriter.write(buffer, 0, c); //这里是 write to fWriter
			fWriter.flush();
		}
		fReader.close();
		fWriter.close();
	}
}

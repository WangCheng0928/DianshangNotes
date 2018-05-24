package com.test.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class BrAndBwOrPw {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		//对文件进行读写操作
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("src/com/test/io/file")));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("src/com/test/io/file4")));
		PrintWriter pw = new PrintWriter("src/com/test/io/file5");
		String lineString;
		while ((lineString = br.readLine()) != null) {
			System.out.println(lineString); //一次读一行， 并不能识别换行
			bw.write(lineString);
			//单独写出换行操作
			bw.newLine();
			bw.flush();
			pw.println(lineString);
			pw.flush();
		}
		br.close();
		bw.close();
		pw.close();
	}

}

package com.test.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOUtil {

	//读取指定文件内容，按照16进制输出到控制台。 并且每输出10个byte换行
	public static void printHex(String fileName) throws IOException{
		FileInputStream inputStream = new FileInputStream(fileName);
		int b;
		int i = 1;
		while ((b = inputStream.read()) != -1) {
			if (b <= 0xf) {
				//单位数前面补0
				System.out.println("0"+ Integer.toHexString(b) + " ");
			}else {
				System.out.println(Integer.toHexString(b) + " ");
			}
			if (i++ % 10 == 0) {
				System.out.println();
			}
		}
		inputStream.close();
	}
	
	
	public static void printHexByByteArray(String fileName) throws IOException{
		FileInputStream inputStream = new FileInputStream(fileName);
		byte[] buf = new byte[8 * 1024];
		// 从InputStream中批量读取字节，放入到buf这个字节数组中，从第0个位置开始放
		//最多放buf.length个字节，返回的是读到的字节的个数
//		int bytes = inputStream.read(buf, 0, buf.length);  //bytes是个整数，表示读到的字节的数量 单位byte
//		System.out.println(bytes);
//		int j = 1;
//		for (int i = 0; i < bytes; i++) {
//			if (buf[i] <= 0xf) {
//				System.out.println("0"+ Integer.toHexString(buf[i] & 0xff) + " ");
//			}else {
//				System.out.println(Integer.toHexString(buf[i] & 0xff) + " ");
//			}
//			if (j++ % 10 == 0) {
//				System.out.println();
//			}
//		}
		int bytes = 0;
		int j = 1;
		while ((bytes = inputStream.read(buf, 0, buf.length)) != -1) {
			for (int i = 0; i < bytes; i++){
				if (buf[i] <= 0xf) {
					System.out.println("0"+ Integer.toHexString(buf[i] & 0xff) + " ");
				}else {
					System.out.println(Integer.toHexString(buf[i] & 0xff) + " ");
				}
				if (j++ % 10 == 0) {
					System.out.println();
				}
			}
		}
		inputStream.close();
	}
	
	//拷贝文件，字节批量拷贝
	public static void copyFile(File srcFile, File destFile) throws IOException{
		if (!srcFile.exists()) {
			throw new IllegalArgumentException("文件：" + srcFile + "不存在");
		}
		if (!srcFile.isFile()) {
			throw new IllegalArgumentException(srcFile + "不是文件");
		}
		FileInputStream inputStream = new FileInputStream(srcFile);
		FileOutputStream outputStream = new FileOutputStream(destFile);
		byte[] buf = new byte[8 * 1024];  //字节流的read()方法 必须是byte型的参数
		int b;
		while ((b = inputStream.read(buf, 0, buf.length)) != -1) {
			//这里只输出了一次b，说明是先读完的，然后在写  意思是说一直读，直接读到最后就跳出循环，进行写的操作
			System.out.println(b);
			System.out.println(buf);
			outputStream.write(buf, 0, b);
			System.out.println(buf);
			outputStream.flush(); //最好加上
		}
		inputStream.close();
		outputStream.close();
	}
	
	//进行文件的拷贝，利用带缓冲的字节流
	public static void copyFileByBuffer(File srcFile, File destFile) throws IOException{
		if (!srcFile.exists()) {
			throw new IllegalArgumentException("文件：" + srcFile + "不存在");
		}
		if (!srcFile.isFile()) {
			throw new IllegalArgumentException(srcFile + "不是文件");
		}
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcFile));
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFile));
		int c;
		while ((c = bis.read()) != -1) {
			bos.write(c);
			bos.flush();  //刷新缓冲区
		}
		bis.close();
		bos.close();
	}
	
	//单字节，不带缓冲进行文件拷贝
	public static void copyFileByByte(File srcFile, File destFile) throws IOException{
		if (!srcFile.exists()) {
			throw new IllegalArgumentException("文件：" + srcFile + "不存在");
		}
		if (!srcFile.isFile()) {
			throw new IllegalArgumentException(srcFile + "不是文件");
		}
		FileInputStream inputStream = new FileInputStream(srcFile);
		FileOutputStream outputStream = new FileOutputStream(destFile);
		int d;
		while ((d = inputStream.read()) != -1) {
			outputStream.write(d);
			outputStream.flush();
		}
		inputStream.close();
		outputStream.close();
	}
}

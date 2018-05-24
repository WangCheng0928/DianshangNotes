package com.test.io;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class DisDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		String file = "demo/dos.txt";
		IOUtil.printHex(file);
		DataInputStream dis = new DataInputStream(new FileInputStream(file));
		int i = dis.readInt();
		System.out.println(i);
		i = dis.readInt();
		System.out.println(i);
		long l = dis.readLong();
		System.out.println(l);
		double d = dis.readDouble();
		System.out.println(d);
		String s = dis.readUTF();
		System.out.println(s);
		char s1 = dis.readChar();
		System.out.println(s1);
		char s2 = dis.readChar();
		System.out.println(s2);
	}

}

package com.test.io;

import java.io.File;
import java.io.IOException;

public class IOUtilTest3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			IOUtil.copyFile(new File("D:\\Workspaces\\MyEclipse 10\\FileTest\\src\\com\\test\\io\\file"), 
					new File("D:\\Workspaces\\MyEclipse 10\\FileTest\\src\\com\\test\\io\\file1"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

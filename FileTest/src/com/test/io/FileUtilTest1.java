package com.test.io;

import java.io.File;
import java.io.IOException;

public class FileUtilTest1 {
	
	public static void main(String[] args) throws IOException {
		FileUtils.listDirectory(new File("F:\\电商笔记"));
	}
}

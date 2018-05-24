package com.test.io;

public class EncodeDemo {

	public static void main(String[] args) throws Exception{
		String string = "慕课ABC";
		byte[] bytes1 = string.getBytes();
		//utf-8编码中文占用3个字节，英文占用一个字节
		for (byte b:bytes1) {
			//把字节（转换成了int）以16进制的方式显示
			System.out.println(Integer.toHexString(b & 0xff) + " ");
		}
		System.out.println();
		byte[] bytes2 = string.getBytes("gbk");
		//gbk编码中文占用2个字节，英文占用一个字节
		for (byte b : bytes2) {
			System.out.println(Integer.toHexString(b & 0xff) + " ");
		}
		System.out.println();
		//java是双字节编码 utf-16be
		byte[] bytes3 = string.getBytes("utf-16be");
		//utf-16be 中文占用2个字节，英文占用2个字节
		for (byte b : bytes3) {
			System.out.println(Integer.toHexString(b & 0xff) + " ");
		}
		
		//当你的字节序列是某种编码时，这个时候想把字节序列变成字符串，也需要用这种编码方式，否则会出现乱码
		String string2 = new String(bytes3); //用项目默认编码
		System.out.println(string2);
		
		String string3 = new String(bytes3, "utf-16be");
		System.out.println(string3);
		
		/*
		 *文本文件 就是字节序列
		 * 可以使任意编码的字节序列
		 * 如果我们在中文机器上直接创建文本文件，那么该文本文件只认识ansi编码
		 * 联通、联这是一种巧合，它们正好符合了utf-8编码的规则
		 */
		
	}
}

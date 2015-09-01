package com.sywyg.string;

/**
 * 将字符串翻转，例如，输入"sywyg"，输出"gywys"。
 * @author sywyg
 * @since 2015.8.25
 * 思路：假设字符串长度为n，交换第i个字符与第n-i-1个字符（i从0开始），共交换n/2次
 *
 */
public class ReverseString {
	/**
	 * 测试
	 */
	public static void main(String[] args) {
		String string = "sywyg";
		string = reverse(string);
		System.out.println(string);
	}
	/**
	 * 算法实现
	 * @param str 需要翻转的字符串
	 * @return 返回翻转后的字符串
	 */
	public static String reverse(String str){
		if(str == null) return null;
		// 首先将字符串转换成字符数组
		char[] string = str.toCharArray();
		// 进行交换
		for (int i = 0,mid = string.length>>1
				,end = string.length-1;i < mid; i++,end--) {
			char temp = string[i];
			string[i] = string[end];
			string[end] = temp;
		}
		return new String(string);
	}
	
}

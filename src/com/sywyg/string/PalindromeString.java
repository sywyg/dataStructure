package com.sywyg.string;
/**
 * 判断字符串是否回文，例如，"sywys"是回文。
 * @author lenovo
 * 思路：假设字符串长度为n，判断第i个字符与第n-i-1个字符是否相等（i从0开始），若有一个不想等就不是回文。
 */
public class PalindromeString {

	/**
	 * 测试
	 */
	public static void main(String[] args) {
		PalindromeString ps = new PalindromeString();
		String str = "sywwys";
		System.out.println(ps.isPalindrome(str));
	}
	/**
	 * 算法实现
	 * @param str 需要判断的字符串
	 * @return 若是回文则返回true
	 */
	public boolean isPalindrome(String str){
		if(str == null) return false;
		// 首先将字符串转换成字符数组
		char[] string = str.toCharArray();
		// 比较第i个字符与第n-i-1个字符
		for(int i = 0, mid = string.length>>1,j = string.length-1;i<mid;i++,j--){
			if(string[i] != string[j])
				return false;
		}
		return true;
	}
}

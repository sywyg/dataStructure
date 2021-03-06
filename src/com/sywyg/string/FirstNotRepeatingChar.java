package com.sywyg.string;
/**
 * 第一个只出现一次的字符
 * @author sywyg
 * @since 2015.8.26
 * 思路：使用hash表保存字符，key为字符的Unicode码，value为次数。
 * 遍历两次字符串，第一次确定每个字符出现的次数，第二次确定第一次出现一次的字符。
 * 测试用例：null，不存在，存在，都是。
 * 题目扩展：
 * 1.删除重复字符：这个和本题思路一样，保留value为1的字符，其余删除。
 * 2.判断是否互为变位词：
 *		2.1变位词是指两个单词出现的字母相同，且每个字母出现的次数相同
 *		2.2思路：先遍历一个单词记录次数；在遍历另一个单词时，若字符出现在第一个单词的hash表中则次数减1，否则直接输出false；
 *			若两个单词出现的字母相同，且最后hash表中的值都为0的话，则返回true。
 */
public class FirstNotRepeatingChar {
	/**
	 * 测试
	 * @param args
	 */
	public static void main(String[] args) {
		FirstNotRepeatingChar firstNotRepeatingChar = new FirstNotRepeatingChar();
		char c = firstNotRepeatingChar.firstNotRepeatingChar("wygwyg");
		System.out.println(c);
	}
	/**
	 * 算法实现
	 * @param str 需要查找的字符串
	 * @return 第一个只出现一次的字符，不存在的话则返回'\u0000'(并不是' '，也是是''(char没有这个))
	 */
	public char firstNotRepeatingChar(String str){
		if(str == null) return '\u0000';
		char c = '\u0000';
		char[] string = str.toCharArray();
		// 使用数组模拟hash表，下标为字符的Unicode，值为次数
		int[] hashTable = new int[65536];
		// 计算每个字符出现的次数
		for (int i = 0; i < string.length; i++) 
			hashTable[string[i]]+=1;
		// 确定第一次出现一次的字符
		for (int i = 0; i < string.length; i++) {
			if(hashTable[string[i]] == 1){
				c = string[i];
				break;
			}
			if(i == string.length - 1)
				System.out.println("不存在只出现一次的字符");
		}
		return c;
	}
}

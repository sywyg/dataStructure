package com.sywyg.stackandqueue;

import java.util.Stack;

import com.sun.jndi.url.iiopname.iiopnameURLContextFactory;

import sun.tools.jar.resources.jar;

/**
 * 栈的进出序列
 * @author sywyg
 * @since 2015.7.25
 * 测试：
 */
public class Question5 {

	public static void main(String[] args) {
		Question5 question = new Question5();
		int[] array1 = {1,2,3,4,7};
		int[] array2 = {3,1,2,5,0};
		System.out.println(question.solution(array1, array2));
	}
	
	// 第一个参数为输入顺序，第二个参数为要判断的输出结果
	public boolean solution(int[] array1,int[] array2){
		// 健壮性判断
		if(array1 == null || array2 == null) return false;
		if(array1.length != array2.length) return false;
		
		Stack<Integer> stack = new Stack<Integer>();
		int i = 0,j = 0;
		for (; i < array1.length; i++) {
			stack.push(array1[i]);
			while(stack.size() != 0 && stack.peek() == array2[j]) {
				stack.pop();
				j++;
			}
		}
		return j == i?true:false;
	}

}

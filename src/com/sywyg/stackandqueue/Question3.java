package com.sywyg.stackandqueue;

import java.util.Stack;

/**
 * 设计栈，使得pop，push和min时间复杂度为O(1)（金典P135，剑指offerP132，编程P236max，进军P247）。
 * 或者使用一个每个最小值再包含一个计数标记
 * 测试：新入栈比原来的小/大/相等的最小，出栈的（不）是最小
 */
public class Question3{

	public static void main(String[] args){
		Solution<Integer> solution = new Solution();
		solution.push(4);
		solution.push(3);
		System.out.println(solution.min());
		solution.pop();
		System.out.println(solution.min());
	}

	public static class Solution<E>{
		private Stack<E> stack,stackMin;
		public Solution(){
			stack = new Stack<E>();
			stackMin = new Stack<E>();
		}
		// 入栈
		public void push(E e){
			stack.push(e);
			if(stackMin.isEmpty()){
				stackMin.push(e);
			}else if((Integer)stackMin.peek() >= (Integer)e){
				stackMin.push(e);
			}
		}
		// 出栈
		public E pop(){
			E e = stack.pop();
			if(e == stackMin.peek()){
				stackMin.pop();
			}
			return e;
		}
		// 返回最小
		public E min(){
			return stackMin.peek();
		}
		
		public int size(){
			return stack.size();
		}
	}
}

package com.sywyg.stackandqueue;

import java.util.Stack;

import com.sun.javafx.image.IntPixelAccessor;

/**
 * 滑动窗口的最大值（剑指offerP290，进军P232，P234）。
 * @author sywyg
 * 测试
 */
public class Question4 {

	public static void main(String[] args) {
		int[] array = {2,3,4,2,6,5,2,1};
		int[] max = solution(array, 3);
		for (int i = 0; i < max.length; i++) {
			System.out.println(max[i]);
		}
	}
	
	
	public static int[] solution(int[] array,int size){
		int[] max = new int[array.length - size + 1];
		MyQueue<Integer> queue = new MyQueue<Integer>(); 
		int i = 0;
		for(i = 0; i<size; i++){
			queue.enqueue(array[i]);
		}
		int j = 0;
		// 先进一个
		max[j++] = queue.stack1.max();
		for(;i<array.length;i++){
			queue.dequeue();
			queue.enqueue(array[i]);
			// 两个栈中的最大值进行比较
			if(queue.stack2.stackMax.size() == 0 || queue.stack1.max() >= queue.stack2.max()){
				max[j++] = queue.stack1.max();
			}else
				max[j++] = queue.stack2.max();
		}
		return max;
	}
	
	/**
	 * 两个栈实现队列
	 */
	public static class MyQueue<E>{
		// 应该在构造器中赋值。
		// stack1用来入队
		public MyStack<E> stack1 = new MyStack<E>();
		// stack2用来出队
		public MyStack<E> stack2 = new MyStack<E>();

		// 入队
		public void enqueue(E e){
			stack1.push(e);
			//System.out.println("此时stack1栈顶元素为：" + stack1.top());
		}

		// 出队
		public E dequeue(){
			E e = null;
			if(stack2.size() != 0){
				e = stack2.pop();
			}else if(stack1.size() != 0){
				int length = stack1.size();
				for(int i = 0;i<length;i++){
					stack2.push(stack1.pop());
					//System.out.println("此时stack2栈顶元素为：" + stack2.top());
				}
				e = stack2.pop();
			}
			return e;
		}
	}
	/**
	 * pop(),push(),max() 复杂度为O(1)
	 */
	public static class MyStack<E>{
		public Stack<E> stack,stackMax;
		public MyStack(){
			stack = new Stack<E>();
			stackMax = new Stack<E>();
		}
		// 入栈
		public void push(E e){
			stack.push(e);
			if(stackMax.isEmpty()){
				stackMax.push(e);
			}else if((Integer)stackMax.peek() <= (Integer)e){
				stackMax.push(e);
			}
		}
		// 出栈
		public E pop(){
			E e = stack.pop();
			if(e == stackMax.peek()){
				stackMax.pop();
			}
			return e;
		}
		// 返回最大
		public E max(){
			return stackMax.peek();
		}
		
		public E peek(){
			
			return stack.peek();
		}
		public int size(){
			return stack.size();
		}
	}

}

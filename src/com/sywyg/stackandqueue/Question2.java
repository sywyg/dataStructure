package com.sywyg.stackandqueue;

import java.util.Stack;

/**
 * 两个栈实现一个队列（金典P142，剑指offerP58）。
 * 使用java带的栈：java.util.Stack。
 * 这样仍然会造成假溢出。
 * 思考如何用两个队列实现一个栈。
 * 
 *
 */
public class Question2{

	public static void main(String[] args){
		Solution<String> solution = new Solution<String>();
		solution.enqueue("aa1");
		solution.enqueue("aa2");
		solution.enqueue("aa3");
		System.out.println(solution.dequeue());
		System.out.println(solution.dequeue());
		solution.enqueue("aa4");
		solution.enqueue("aa5");
		System.out.println(solution.dequeue());
		System.out.println(solution.dequeue());
		solution.enqueue("aa6");
		solution.enqueue("aa7");
		System.out.println(solution.dequeue());
		System.out.println(solution.dequeue());
	}

	public static class Solution<E>{
		// 应该在构造器中赋值。
		// stack1用来入队
		private Stack<E> stack1 = new Stack();
		// stack2用来出队
		private Stack<E> stack2 = new Stack();

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
 * 实现栈
 * 不用泛型的话，数组应该是Object类型的
 * 注意top的设置影响出栈和获取栈顶元素。
 * size也可以用top代替
 *//*
public static class MyStack<E>{
	// 栈元素个数
	private int size;
	// 栈头
	private int top;
	// 数组保存元素
	private Object[] stack = null;
	public MyStack(int length){
		stack = new Object[length];
		top = 0;
	}
	public int size(){
		return size;
	}
	// 进栈
	public void push(E e){
		if(size == stack.length){
			try{
				throw new Exception("栈已满");
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
		stack[top++] = e;
		size++;
	}
	// 出栈
	public E pop(){
		E e = null;
		if(size == 0){
			try{
				throw new Exception("栈为空");
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
		e = (E)stack[--top];
		size--;
		return e;
	}
	// 获取栈顶元素
	public E top(){
		if(size == 0){
			try{
				throw new Exception("栈为空");
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return (E)stack[top-1];
	}
}*/
}
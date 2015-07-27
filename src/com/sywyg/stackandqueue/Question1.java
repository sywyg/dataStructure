package com.sywyg.stackandqueue;

/**
 * 实现栈和实现队列（金典P49-50）。
 */
public class Question1{
	public static void main(String[] args){
		
		


		// 循环队列练习
	/*	LoopQueue<String> queue = new LoopQueue<String>(4);
		queue.enqueue("sy1");
		//System.out.println(queue.size());
		queue.enqueue("sy2");
		//System.out.println(queue.size());
		queue.enqueue("sy3");
		//System.out.println(queue.size());
		queue.dequeue();
		System.out.println(queue.size());
		System.out.println(queue.front());
		queue.dequeue();
		queue.dequeue();
		System.out.println(queue.size());
		queue.enqueue("sy4");
		System.out.println(queue.size());*/
		// 队列练习
	/*	MyQueue<String> queue = new MyQueue<String>(10);
		queue.enqueue("sy1");
		queue.enqueue("sy2");
		queue.enqueue("sy3");
		queue.enqueue("sy4");
		System.out.println(queue.size());
		queue.dequeue();
		System.out.println(queue.size());
		System.out.println(queue.front());
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		System.out.println(queue.size());*/

		// 栈练习
	/*	MyStack<String> stack = new MyStack<String>(10);
		stack.push("sywyg");
		stack.push("wyg");
		stack.push("sywyg");
		stack.push("wyg");
		stack.push("sywyg");
		stack.push("wyg");
		System.out.println(stack.size());
		String s = stack.pop();
		System.out.println(s);
		s = stack.top();
		System.out.println(s);*/
	}
}

/**
 * 实现栈
 * 不用泛型的话，数组应该是Object类型的
 * 注意top的设置影响出栈和获取栈顶元素。
 * size也可以用top代替
 */
class MyStack<E>{
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
}

/**
 * 创建队列，这种对会造成假溢出
 */
class MyQueue<E>{
	// 队列长度
	private int size;
	// 队头
	private int front;
	// 队尾
	private int back;
	private Object[] queue;
	public MyQueue(int length){
		queue = new Object[length];
		size = 0;
		front = 0;
		back = 0;
	}

	public int size(){
		return size;
	}
	// 进队
	public void enqueue(E e){
		if(size == queue.length){
			try{
				throw new Exception("队已满");
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
			queue[back++] = e;
			size++;
	}
	// 出队
	public E dequeue(){
		E e = null;
		if(size == 0 || back == front){
			try{
				throw new Exception("队为空");
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
		e = (E)queue[front++];
		size--;
		return e;
	}
	// 返回队头
	public E front(){
		return (E)queue[front];
	}
	// 返回队尾？
	public E back(){
		return (E)queue[back - 1];
	}


/**
 * 循环队列，采用浪费一个位置（使用size可以保证全利用）
 * 这里不使用size标记队列的长度，尽管这种方式很简单
 */
class LoopQueue<E>{
	// 队头
	private int front;
	// 队尾
	private int back;
	private Object[] queue;
	public LoopQueue(int length){
		// 浪费一个
		queue = new Object[length + 1];
		front = 0;
		back = 0;
	}

	public int size(){
		return (back - front + queue.length)% queue.length;
	}
	// 进队
	public void enqueue(E e){
		if((front - back + queue.length)% queue.length == 1){
			try{
				throw new Exception("队已满");
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
		queue[back ++ % queue.length] = e;

	}
	// 出队
	public E dequeue(){
		E e = null;
		 if(front == back){
			try{
				throw new Exception("队为空");
			}catch(Exception ex){
				ex.printStackTrace();
			}
		 }
			e = (E)queue[front++ % queue.length];
		return e;
	}
	// 返回队头
	public E front(){
		return  (E)queue[front];
	}
	// 返回队尾？
	public E back(){
		return  (E)queue[(back - 1 + queue.length) % queue.length];
	}
}
}
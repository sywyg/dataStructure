package com.sywyg;

/**
* 两个链表是否相交，求第一个公共结点（剑指offerP193，编程之美P233）。
* 若链表有环怎么处理
* 功能测试和时间复杂度：见剑指offer，且下面这种是否是m+n
* 下面的代码复用不好，相同的部分可以写成另一个方法
*/
public class Question4{
	public static void main(String[] args){
		Node<Integer> head1 = new Node<Integer>(1);
		Node<Integer> head2 = new Node<Integer>(11);
		Node<Integer> node2 = new Node<Integer>(2);
		Node<Integer> node3 = new Node<Integer>(3);
		Node<Integer> node4 = new Node<Integer>(4);
		head1.setNext(node2);
		//node2.setNext(node3);
		node3.setNext(node4);
		head2.setNext(node3);
		Node<Integer> p = solution(head1,head2);
		//System.out.println(head1.getNext() == head2.getNext());
		if(p != null){
			System.out.println(p.getElement());
		}
		else
			System.out.println("没有公共节点！");
	}

	public static Node<Integer> solution(Node<Integer> head1,Node<Integer> head2){
		// 判空
		if(head1 == null || head2 == null) return null;
		// 同一个链表，不用再计算长度
		if(head1 == head2) return head1;
		// 计算长度差
		int length1 = 0;
		int length2 = 0;
		Node<Integer> temp1 = head1;
		Node<Integer> temp2 = head2;
		while(temp1.getNext() != null || temp2.getNext() != null){
			if(temp1.getNext() != null)
			 	temp1 = temp1.getNext();
			else 		
				length2++;
			if(temp2.getNext() != null) 
				temp2 = temp2.getNext();
			else 		
				length1++;
		}
		temp1 = head1;
		temp2 = head2;
		/**
		 * 下面的重复代码可以封装在方法中。
		 while (temp1 != null){
				if(temp1 == temp2){
					return temp1;
				}
				else{
					temp1 = temp1.getNext();
					temp2 = temp2.getNext();
				}
			}<!--  -->
		 **/

		//链表1长
		if(length1 != 0){
			//先执行length1步
			for(int i = 0;i<length1;i++){
				temp1 = temp1.getNext();
			}
			while (temp1 != null){
				if(temp1 == temp2){
					return temp1;
				}
				else{
					temp1 = temp1.getNext();
					temp2 = temp2.getNext();
				}
			}
		}
		//链表2长
		else if(length2 != 0){
			//先执行length2步
			for(int i = 0;i<length2;i++){
				temp2 = temp2.getNext();
			}
			while (temp1 != null){
				if(temp1 == temp2){
					return temp1;
				}
				else{
					temp1 = temp1.getNext();
					temp2 = temp2.getNext();
				}
			}

		}
		// 一样长
		else{
			while (temp1 != null){
				if(temp1 == temp2){
					return temp1;
				}
				else{
					temp1 = temp1.getNext();
					temp2 = temp2.getNext();
				}
			}
		}
		return null;
	}
	
	/**
	 * 单链表定义
	 * 节点定义为内部类,定义为public是为了外部java文件中使用
	 */
	public static class Node<E>{
		private E element;//节点保存的元素
		private Node<E> next;//指向下一个节点的引用

		public Node(){}
		public Node(E element){
			this.element = element;
		}
		public Node(E element,Node<E> next){
			this.element = element;
			this.next = next;
		}

		public E getElement(){
			return element;
		}
		public Node<E> getNext(){
			return next;
		}
		public void setElement(E element){
			this.element = element;
		}
		public void setNext(Node<E> next){
			this.next = next;
		}
	}
}
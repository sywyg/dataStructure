package com.sywyg;

/**
* 反转链表（剑指offerP112，进军P105-110两种解法）。
* 功能测试和时间复杂度见：剑指offer
* 如何使用递归完成
*/
public class Question3{
	public static void main(String[] args){
		Node<Integer> head = new Node<Integer>(1);
		Node<Integer> node2 = new Node<Integer>(2);
		Node<Integer> node3 = new Node<Integer>(3);
		Node<Integer> node4 = new Node<Integer>(4);
		head.setNext(node2);
		node2.setNext(node3);
		node3.setNext(node4);
		Node<Integer> temp = head;
		System.out.println("反转前链表元素为:");
		while(temp != null){
			System.out.print(temp.getElement() + ",");
			temp = temp.getNext();
		}
		System.out.print("\n");
		temp = solution(head);
		
		System.out.println("反转后链表元素为:");
		while(temp != null){
			System.out.print(temp.getElement() + ",");
			temp = temp.getNext();
		}
		//为什么下面这样不行？？？？？？？？？？？？？？
		temp = head;
		System.out.println("\nhead的内容：");
		while(temp != null){
			System.out.print(temp.getElement() + ",");
			temp = temp.getNext();
		}
	}

	public static Node<Integer> solution(Node<Integer> head){
		//头节点为空
		if(head == null) return head;
		//只有一个节点
		if(head.getNext() == null) return head;
		//记录最后被反转的节点
		Node<Integer> temp1 = head;
		//记录将要反转的节点
		Node<Integer> temp2 = head;
		//temp2.setNext(null);
		//记录将要反转的节点的下一个节点
		Node<Integer> temp3 = head.getNext();
		while(temp3 != null){
			temp2 = temp3;
			temp3 = temp2.getNext();
			temp2.setNext(temp1);
			temp1 = temp2;
		}
		head.setNext(null);
		head = temp1;
		/*while(temp1 != null){
			System.out.print(temp1.getElement() + ",");
			temp1 = temp1.getNext();
		}*/
		return head;
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
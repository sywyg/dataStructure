package com.sywyg;

/**
 * 找到单链表的倒数第k个节点（金典P118，剑指offerP106）。
 * 假设最后一个为倒数第一个,若最后一个为第0个呢？
 * 
 * @author sywyg
 * @since 2015.7.10
 */
public class Question2{
	/**
	 *功能测试，特殊测试，分析时间复杂度
	 */
	public static void main(String[] args){
		//Node<Integer> head = null;
		Node<Integer> head = new Node<Integer>(1);
		Node<Integer> node2 = new Node<Integer>(2);
		Node<Integer> node3 = new Node<Integer>(3);
		Node<Integer> node4 = new Node<Integer>(4);
		Node<Integer> node5 = new Node<Integer>(5);
		Node<Integer> node6 = new Node<Integer>(6);
		head.setNext(node2);
		node2.setNext(node3);
		node3.setNext(node4);
		node4.setNext(node5);
		node5.setNext(node6);

		Node<Integer> result = solution(head,1);
		if(result != null){
		System.out.println(result.getElement());
		}else{
			System.out.println("查询出错");
		}

	}
	public static Node<Integer> solution(Node<Integer> head,int k){
		//判断k是否非法
		if(k < 1){return null;}
		//判断是否为空
		if(head == null) return null;
		//快指针
		Node<Integer> nAhead = head;
		//慢指针
		Node<Integer> nBehind = head;
		//快指针先走k步
		for(int i = 0;i<k-1;i++){
			if(nAhead == null){return null;}
			nAhead = nAhead.getNext();
		}
		//判断是否存在倒数第k个节点
		if(nAhead == null){return null;}
		while(nAhead.getNext() != null){
			nAhead = nAhead.getNext();
			nBehind = nBehind.getNext();
		}
		return nBehind;
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
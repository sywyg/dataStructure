package com.sywyg;

/**
* static方法中内部类也得是static的。。。。。
* 删除单链表中的某个结点（O(1)），假定你只能访问该节点（金典P120，剑指offerP99）。
* 功能测试和时间复杂度见：剑指offer
*/
public class Question2{
	public static void main(String[] args){
		Node<Integer> head = new Node<Integer>(1);
		Node<Integer> node2 = new Node<Integer>(2);
		Node<Integer> node3 = new Node<Integer>(3);
		head.setNext(node2);
		node2.setNext(node3);
		//删除第二个节点
		if(solution(node3)){
			System.out.println("删除成功！删除后的节点内容为：");
			Node<Integer> temp = head;
			while(temp != null){
				System.out.println(temp.getElement());
				temp = temp.getNext();
			}
		}else
			System.out.println("删除失败！");
	}
	//不知道头节点，并且无法删除尾节点。
	//剑指offer有知道头节点，删除尾节点，且复杂度为O(1)。
	public static boolean solution(Node<Integer> node){
		//节点为空判断
		if(node == null) return false;
		//节点为最后一个节点
		if(node.getNext() == null) return false;
		Node<Integer> temp = node.getNext();
		//交换节点存储数据
		node.setElement(temp.getElement());
		node.setNext(temp.getNext());
		return true;
	}
	//知道头节点的做法
	public static boolean solution(Node<Integer> head,Node<Integer> node){

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
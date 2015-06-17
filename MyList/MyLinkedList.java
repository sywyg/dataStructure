/**
 *链表基本操作，暂时不使用泛型，节点保存的数据是String对象
 *@author sywyg
 *@since 2015/6/11
 */
public class MyLinkedList{
	/**
	 *节点定义为内部类
	 */
	private static class Node{
		String element;//节点保存的元素
		Node next;//指向下一个节点的引用
		Node(String element,Node next){
			this.element = element;
			this.next = node;
		}
	}
}
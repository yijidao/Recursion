package org.wzp.Recursion;

public class Node {
	private final int value;
	private Node next;
	public Node(int value, Node next) {
		this.value = value;
		this.next = null;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	public int getValue() {
		return value;
	}
	/**
	 * 打印方法
	 * @param head
	 */
	public static void printLinkedList(Node head) {
		while(head != null) {
			System.out.print(head.getValue());
			System.out.print(" ");
			head = head.getNext();
		}
		System.out.println();
	}
}
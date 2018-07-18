package org.wzp.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Recursion {
	/**
	 * 生成链表
	 * @param data
	 * @return 返回头结点
	 */
    public Node createLinkedList(List<Integer> data) {
        if(data.isEmpty()) {
            return null;
        }
        Node first = new Node(data.get(0), null);
        Node headOfSubList = createLinkedList(data.subList(1, data.size()));
        first.setNext(headOfSubList);
        return first;
    }
    /**
	 * 递归反转链表
	 * @param head 头结点
	 * @return 返回头结点
	 */
    public Node reverseLinkedList(Node head) {
        if(head == null) {
            return null;
        }
        if(head.getNext() == null) {
            return head;
        }
        Node newHead = reverseLinkedList(head.getNext());
        head.getNext().setNext(head);
        head.setNext(null);
        return newHead;
    }
    /**
	 * 递归删除指定结点
	 * @param head
	 * @param N
	 * @return
	 */
    public Node deleteNode(Node head, int N) {
        if(head == null) {
            return null;
        }
        while(head.getValue() == N) {
        	head = head.getNext();
        	if(head == null)
        		return null;
        }
        head.setNext(deleteNode(head.getNext(), N));
        return head;
    }
    
    /**
	 * while 循环删除结点
	 * @param head 头结点
	 * @param value 要删除的值
	 * @return 头结点
	 */
    public Node deleteNodeByLoop(Node head, int value) {
        if(head == null) {
            return null;
        }
    
        while(head.getValue() == value) {
        	head = head.getNext();
            if(head == null){
                return null;
            }
        }
    
        Node curNode = head;
        while(curNode.getNext() != null) {
            if(curNode.getNext().getValue() == value) {
                curNode.setNext(curNode.getNext().getNext());
            } else {
                curNode = curNode.getNext();
            }
        }
        return head;
    }
    /**
	 * while 循环反转结点
	 * @param head 头结点
	 * @return 头结点
	 */
    public Node reverseLinkedListByLoop(Node head) {
        Node newHead = null;
        Node curHead = head;
        Node next;
        while(curHead != null) {
            next = curHead.getNext();
            curHead.setNext(newHead);
            newHead = curHead;
            curHead = next;
        }
        return newHead;
    }
    
    /**
	 * 测试用例
	 * @param args
	 */
	public static void main(String[] args) {
		Recursion rec = new Recursion();
		Node.printLinkedList(rec.createLinkedList(new ArrayList<>()));
		Node.printLinkedList(rec.createLinkedList(Arrays.asList(1)));
		Node.printLinkedList(rec.createLinkedList(Arrays.asList(1, 2, 3, 4, 5)));
		Node.printLinkedList(rec.reverseLinkedList(rec.createLinkedList(Arrays.asList(1, 2, 3, 4, 5))));
		Node.printLinkedList(rec.deleteNode(rec.createLinkedList(Arrays.asList(2, 2, 1, 2, 2, 3, 4, 5)), 2));
		Node.printLinkedList(rec.deleteNode(rec.createLinkedList(new ArrayList<>()), 2));
		Node.printLinkedList(rec.reverseLinkedListByLoop(rec.createLinkedList(Arrays.asList(1, 2, 3, 4, 5))));
		Node.printLinkedList(rec.deleteNodeByLoop(rec.createLinkedList(Arrays.asList(2, 2, 1, 2, 2, 3, 4, 5)), 2));
	}
}


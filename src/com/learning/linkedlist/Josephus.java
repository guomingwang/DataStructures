package com.learning.linkedlist;

public class Josephus {

    public static void main(String[] args) {
        josephus(125, 10, 20);
    }

    public static void josephus(int n, int k, int m) {
        if (n <= 0 || k <= 0 || k > n || m <= 0) {
            return;
        }
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList(n);
        Node firstNode = circleSingleLinkedList.getFirstNode();
        if (n == 1) {
            System.out.println(firstNode);
            circleSingleLinkedList.setFirstNode(null);
            System.out.println(circleSingleLinkedList);
            return;
        }
        Node tempPre = firstNode;
        Node temp = tempPre.getNext();
        while (temp.getNo() != firstNode.getNo()) {
            tempPre = temp;
            temp = temp.getNext();
        }
        while (temp.getNo() != k) {
            tempPre = temp;
            temp = temp.getNext();
        }
        while (tempPre.getNo() != temp.getNo()) {
            for (int i = 1; i < m; i++) {
                tempPre = temp;
                temp = temp.getNext();
            }
            System.out.println(temp);
            if (temp.getNo() == circleSingleLinkedList.getFirstNode().getNo()) {
                circleSingleLinkedList.setFirstNode(temp.getNext());
            }
            tempPre.setNext(temp.getNext());
            temp = tempPre.getNext();
            System.out.println(circleSingleLinkedList);
        }
        System.out.println(circleSingleLinkedList.getFirstNode());
        circleSingleLinkedList.setFirstNode(null);
        System.out.println(circleSingleLinkedList);
    }
}

class CircleSingleLinkedList {

    private Node firstNode;

    public CircleSingleLinkedList() {
    }

    public CircleSingleLinkedList(int n) {
        if (n <= 0) {
            return;
        }
        firstNode = new Node(1);
        firstNode.setNext(firstNode);
        Node temp = firstNode;
        for (int i = 2; i <= n; i++) {
            Node node = new Node(i);
            temp.setNext(node);
            node.setNext(firstNode);
            temp = node;
        }
    }

    public void print() {
        if (firstNode == null) {
            return;
        } else {
            System.out.println(firstNode);
        }
        Node temp = firstNode.getNext();
        while (temp.getNo() != firstNode.getNo()) {
            System.out.println(temp);
            temp = temp.getNext();
        }
    }

    public Node getFirstNode() {
        return firstNode;
    }

    public void setFirstNode(Node firstNode) {
        this.firstNode = firstNode;
    }

    @Override
    public String toString() {
        return "CircleSingleLinkedList{" +
                "firstNode=" + firstNode +
                '}';
    }
}

class Node {

    private Integer no;
    private Node next;

    public Node(Integer no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                '}';
    }

    public Integer getNo() {
        return no;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

}

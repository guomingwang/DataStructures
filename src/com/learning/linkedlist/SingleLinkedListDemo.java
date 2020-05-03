package com.learning.linkedlist;

public class SingleLinkedListDemo {

    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.addByNo(new Node(2, "卢俊义", "玉麒麟"));
        singleLinkedList.addByNo(new Node(4, "林冲", "豹子头"));
        singleLinkedList.addByNo(new Node(1, "宋江", "及时雨"));
        singleLinkedList.addByNo(new Node(3, "吴用", "智多星"));
        singleLinkedList.show();
        singleLinkedList = reverse(singleLinkedList);
        singleLinkedList.show();
    }

    private static SingleLinkedList reverse(SingleLinkedList singleLinkedList) {
        Node head = singleLinkedList.getHead();
        if (head.next == null || head.next.next == null) {
            return singleLinkedList;
        }
        Node temp = head.next.next;
        head.next.next = null;
        while (temp != null) {
            Node next = temp.next;
            temp.next = head.next;
            head.next = temp;
            temp = next;
        }
        return singleLinkedList;
    }

    private static Node getLastIndexNode(SingleLinkedList singleLinkedList, int index) {
        if (index <= 0) {
            return null;
        }
        Node head = singleLinkedList.getHead();
        Node temp = head;
        Node indexNode = null;
        int count = 0;
        while (temp.next != null) {
            temp = temp.next;
            count++;
            if (count == index) {
                indexNode = head.next;
            } else if (count > index) {
                indexNode = indexNode.next;
            }
        }
        return indexNode;
    }

    private static int getLength(SingleLinkedList singleLinkedList) {
        Node head = singleLinkedList.getHead();
        Node temp = head;
        int length = 0;
        while (head.next != null) {
            length++;
            head = head.next;
        }
        return length;
    }

    private static class SingleLinkedList {
        private Node head = new Node(0, null, null);

        public void add(Node node) {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }

        public void addByNo(Node node) {
            Node temp = head;
            boolean isExist = false;
            while (temp != null) {
                if (temp.next == null) {
                    break;
                } else if (temp.next.no == node.no) {
                    isExist = true;
                    break;
                } else if (temp.next.no > node.no) {
                    break;
                } else {
                    temp = temp.next;
                }
            }
            if (isExist) {
                System.out.printf("编号为 %d 的节点已存在\n", node.no);
            } else {
                node.next = temp.next;
                temp.next = node;
            }
        }

        public void updateByNo(Node node) {
            Node temp = head;
            boolean isExist = true;
            while (temp != null) {
                if (temp.no == node.no) {
                    break;
                } else if (temp.next == null) {
                    isExist = false;
                    break;
                } else {
                    temp = temp.next;
                }
            }
            if (isExist) {
                temp.name = node.name;
                temp.nickName = node.nickName;
            } else {
                System.out.printf("编号为 %d 的节点不存在\n", temp.no);
            }
        }

        public void deleteByNo(int no) {
            Node temp = head;
            boolean isExist = false;
            while (temp.next != null) {
                if (temp.next.no == no) {
                    isExist = true;
                    break;
                } else {
                    temp = temp.next;
                }
            }
            if (isExist) {
                temp.next = temp.next.next;
            } else {
                System.out.printf("编号为 %d 的节点不存在\n", no);
            }
        }

        public void show() {
            Node temp = head.next;
            while (temp != null) {
                System.out.println(temp.toString());
                temp = temp.next;
            }
        }

        public Node getHead() {
            return head;
        }
    }

    private static class Node {
        private Integer no;
        private String name;
        private String nickName;
        private Node next;

        public Node(Integer no, String name, String nickName) {
            this.no = no;
            this.name = name;
            this.nickName = nickName;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "no=" + no +
                    ", name='" + name + '\'' +
                    ", nickName='" + nickName + '\'' +
                    '}';
        }
    }
}

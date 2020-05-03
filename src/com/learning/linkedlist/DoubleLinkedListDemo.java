package com.learning.linkedlist;

public class DoubleLinkedListDemo {

    public static void main(String[] args) {
        DoubleLinkedListDemo.DoubleLinkedList doubleLinkedList = new DoubleLinkedListDemo.DoubleLinkedList();
        doubleLinkedList.addByNo(new DoubleLinkedListDemo.Node(2, "卢俊义", "玉麒麟"));
        doubleLinkedList.addByNo(new DoubleLinkedListDemo.Node(4, "林冲", "豹子头"));
        doubleLinkedList.addByNo(new DoubleLinkedListDemo.Node(1, "宋江", "及时雨"));
        doubleLinkedList.addByNo(new DoubleLinkedListDemo.Node(3, "吴用", "智多星"));
        doubleLinkedList.show();
        System.out.println();
        doubleLinkedList.deleteByNo(4);
        doubleLinkedList.show();
    }

    private static class DoubleLinkedList {
        private DoubleLinkedListDemo.Node head = new DoubleLinkedListDemo.Node(0, null, null);

        public void add(DoubleLinkedListDemo.Node node) {
            DoubleLinkedListDemo.Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
            node.pre = temp;
        }

        public void addByNo(DoubleLinkedListDemo.Node node) {
            DoubleLinkedListDemo.Node temp = head;
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
                node.pre = temp;
                if (node.next != null) {
                    node.next.pre = node;
                }
            }
        }

        public void updateByNo(DoubleLinkedListDemo.Node node) {
            DoubleLinkedListDemo.Node temp = head;
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
                System.out.printf("编号为 %d 的节点不存在\n", node.no);
            }
        }

        public void deleteByNo(int no) {
            DoubleLinkedListDemo.Node temp = head;
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
                if (temp.next != null) {
                    temp.next.pre = temp;
                }
            } else {
                System.out.printf("编号为 %d 的节点不存在\n", no);
            }
        }

        public void show() {
            DoubleLinkedListDemo.Node temp = head.next;
            while (temp != null) {
                System.out.println(temp.toString());
                temp = temp.next;
            }
        }

        public DoubleLinkedListDemo.Node getHead() {
            return head;
        }
    }

    private static class Node {
        private Integer no;
        private String name;
        private String nickName;
        private DoubleLinkedListDemo.Node pre;
        private DoubleLinkedListDemo.Node next;

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

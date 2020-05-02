package com.learning.queue;

import java.util.Arrays;
import java.util.Scanner;

public class CircleArrayQueueDemo {

    public static void main(String[] args) {
        CircleArrayQueueDemo.CircleArrayQueue circleArrayQueue = new CircleArrayQueueDemo.CircleArrayQueue(4);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("\n请输入命令:_");
            char charAt = scanner.next().charAt(0);
            switch (charAt) {
                case 'f' :
                    try {
                        Integer showFront = circleArrayQueue.showFront();
                        System.out.println("circleArrayQueue.showFront: " + showFront);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    } finally {
                        System.out.println(circleArrayQueue.toString());
                        circleArrayQueue.show();
                    }
                    break;
                case 'a' :
                    System.out.print("请输入数据:_");
                    int nextInt = scanner.nextInt();
                    circleArrayQueue.add(nextInt);
                    System.out.println(circleArrayQueue.toString());
                    circleArrayQueue.show();
                    break;
                case 'g' :
                    try {
                        Integer get = circleArrayQueue.get();
                        System.out.println("circleArrayQueue.get " + get);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    } finally {
                        System.out.println(circleArrayQueue.toString());
                        circleArrayQueue.show();
                    }
                    break;
                case 'l' :
                    Integer length = circleArrayQueue.length();
                    System.out.println("circleArrayQueue.length: " + length);
                    circleArrayQueue.show();
                    break;
                default:
                    break;
            }
        }
    }

    private static class CircleArrayQueue {
        private Integer size;
        private Integer[] array;
        private Integer front;
        private Integer rear;

        public CircleArrayQueue(Integer size) {
            this.size = size;
            this.array = new Integer[this.size];
            this.front = 0;
            this.rear = 0;
        }

        public boolean isFull() {
            return (rear + 1) % size == front;
        }

        public boolean isEmpty() {
            return front == rear;
        }

        public void add(Integer add) {
            if (isFull()) {
                System.out.println("队列已满，不能加数据~");
                return;
            }
            array[rear] = add;
            rear = (rear + 1) % size;
        }

        public Integer get() throws Exception {
            if (isEmpty()) {
                throw new Exception("队列已空，不能取数据~");
            }
            Integer get = array[front];
            array[front] = null;
            front = (front + 1) % size;
            return get;
        }

        public Integer showFront() throws Exception {
            if (isEmpty()) {
                throw new Exception("队列已空，不能查看头部数据~");
            }
            return array[front];
        }

        public void show() {
            if (isEmpty()) {
                System.out.println("队列已空，不能查看数据~");
                return;
            }
            for (int i = 0; i < length(); i++) {
                int index = (front + i) % size;
                System.out.printf("array[%d] = %d\n", index, array[index]);
            }
        }

        public Integer length() {
            if (isEmpty()) {
                return 0;
            }
            return (rear + size - front) % size;
        }

        @Override
        public String toString() {
            return "ArrayQueue{" +
                    "size=" + size +
                    ", front=" + front +
                    ", rear=" + rear +
                    ", array=" + Arrays.toString(array) +
                    '}';
        }
    }
}

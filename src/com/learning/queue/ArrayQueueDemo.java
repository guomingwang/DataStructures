package com.learning.queue;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayQueueDemo {

    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(3);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("请输入命令:_");
            char charAt = scanner.next().charAt(0);
            switch (charAt) {
                case 'f' :
                    try {
                        Integer showFront = arrayQueue.showFront();
                        System.out.println("arrayQueue.showFront: " + showFront);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    } finally {
                        System.out.println(arrayQueue.toString());
                    }
                    break;
                case 'a' :
                    System.out.print("请输入数据:_");
                    int nextInt = scanner.nextInt();
                    arrayQueue.add(nextInt);
                    System.out.println(arrayQueue.toString());
                    break;
                case 'g' :
                    try {
                        Integer get = arrayQueue.get();
                        System.out.println("arrayQueue.get " + get);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    } finally {
                        System.out.println(arrayQueue.toString());
                    }
                    break;
                default:
                    break;
            }
        }
    }

    private static class ArrayQueue {
        private Integer size;
        private Integer front;
        private Integer rear;
        private Integer[] array;

        public ArrayQueue(Integer size) {
            this.size = size;
            this.front = -1;
            this.rear = -1;
            this.array = new Integer[this.size];
        }

        public boolean isFull() {
            return rear == size - 1;
        }

        public boolean isEmpty() {
            return front == rear;
        }

        public void add(Integer add) {
            if (isFull()) {
                System.out.println("队列已满，不能加数据~");
                return;
            }
            array[++rear] = add;
        }

        public Integer get() throws Exception {
            if (isEmpty()) {
                throw new Exception("队列已空，不能取数据~");
            }
            Integer get = array[++front];
            array[front] = null;
            return get;
        }

        public Integer showFront() throws Exception {
            if (isEmpty()) {
                throw new Exception("队列已空，不能查看头部数据~");
            }
            return array[front + 1];
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

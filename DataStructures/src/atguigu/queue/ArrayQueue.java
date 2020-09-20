//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package atguigu.queue;

//使用数组模拟队列-编写一个ArrayQueue类
class ArrayQueue {
    int maxSize; //表示数组的最大容量
    int front; // 队列头
    int rear; // 队列尾
    int[] arr; // 该数据用于存放数据，模拟队列

    //创建队列的构造器
    public ArrayQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = -1; //指向队列头部，分析出front是指向队列头的前一个位置
        rear = -1; // 指向队列尾，指向队列尾的数据（就是队列最后一个数据）
    }

    //判断队列是否满
    public boolean isFull() {
        return this.rear == this.maxSize - 1;
    }

    public boolean isEmpty() {
        return this.rear == this.front;
    }

    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("队列满，不能加入数据~");
        } else {
            ++this.rear; //让rear后移
            this.arr[this.rear] = n;
        }

    }

    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列空，不能取数据");
        } else {
            ++this.front;  //front后移
            return this.arr[this.front];
        }
    }


    public void showQueue() {
        if (isFull()) {
            System.out.println("队列空的，没有数据~~");
        } else {
            for (int i = 0; i < arr.length; i++) {
                System.out.printf("arr[%d]=%d\n", i, this.arr[i]);
            }
        }
    }


    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列空的，没有数据~~");
        } else {
            return this.arr[this.front + 1];
        }
    }
}




package atguigu.queue;

public class CircleArray {
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    public CircleArray(int arrMaxSize) {
        this.maxSize = arrMaxSize;
        this.arr = new int[this.maxSize];
    }

    public boolean isFull() {
        return (this.rear + 1) % this.maxSize == this.front;
    }

    public boolean isEmpty() {
        return this.rear == this.front;
    }

    public void addQueue(int n) {
        if (this.isFull()) {
            System.out.println("队列满，不能加入数据~");
        } else {
            this.arr[this.rear] = n;
            this.rear = (this.rear + 1) % this.maxSize;
        }
    }

//    public int getQueue() {
//        if (this.isEmpty()) {
//
//        }
//    }
}

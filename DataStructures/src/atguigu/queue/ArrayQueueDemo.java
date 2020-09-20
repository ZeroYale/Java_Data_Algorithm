//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package atguigu.queue;

import java.util.Scanner;

public class ArrayQueueDemo {
    public ArrayQueueDemo() {
    }

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(3);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;

        while(loop) {
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("h(head): 查看队列头的数据");
            key = scanner.next().charAt(0);
            int res;
            switch(key) {
                case 'a':
                    System.out.println("输出一个数");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                case 'g':
                    try {
                        res = queue.getQueue();
                        System.out.printf("取出的数据是%d\n", res);
                    } catch (Exception var8) {
                        System.out.println(var8.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        res = queue.headQueue();
                        System.out.printf("队列头的数据是%d\n", res);
                    } catch (Exception var7) {
                        System.out.println(var7.getMessage());
                    }
                    break;
                case 's':
                    queue.showQueue();
            }
        }

        System.out.println("程序退出~~");
    }
}

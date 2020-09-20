package atguigu.linkedlist;

public class CircleSingleLinkedListTest {

    private Boy first = null;

    CircleSingleLinkedListTest() {
    }

    public void addBoy(int nums) {
        if (nums < 1) {
            System.out.println("nums的值不正确");
        } else {
            Boy curBoy = null;

            for (int i = 0; i <= nums; i++) {
                Boy boy = new Boy(-1);
                if (i == 1) {
                    this.first = boy;
                    this.first.setNext(this.first);
                    curBoy = this.first;
                } else {
                    curBoy.setNext(boy);
                    boy.setNext(first);
                    curBoy = boy;
                }
            }
        }
    }

    public void showBoy() {
        if (this.first == null) {
            System.out.println("没有任何小孩~~");
        } else {
            Boy curBoy = this.first;

            while(true) {
                System.out.printf("小孩的编号 %d \n", curBoy.getNo());
                if (curBoy.getNext() == this.first) {
                    return;
                }

                curBoy = curBoy.getNext();
            }
        }
    }

    /**
     *
     * @param startNo 表示从第几个小孩开始数数
     * @param countNum 表示数几下
     * @param nums 表示最初有多少小孩在圈中
     */
    public void countBoy(int startNo, int countNum, int nums) {

        while (true) {
            if (startNo < 1 || first == null || startNo > nums) {
                System.out.println("参数有误，请重新输入");
                return;
            }

            Boy helper = first;

            while (true) {
                if (helper.getNext() == first) {
                    break;
                }
                helper = first.getNext();
            }

            for (int j = 0; j < startNo - 1; j++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            while (true) {
                if (helper == first) {
                    break;
                }
                for (int i = 0; i < countNum - 1 ; i++) {
                    first = first.getNext();
                    helper = helper.getNext();
                }
                first = first.getNext();
                helper.setNext(first);
                System.out.printf("小孩%d出圈\n", this.first.getNo());
            }
        }

    }
}

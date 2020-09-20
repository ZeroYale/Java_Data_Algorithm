//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package atguigu.linkedlist;

class CircleSingleLinkedList {
    private Boy first = null;

    CircleSingleLinkedList() {
    }

    //添加小孩节点，构建成一个环形的链表
    public void addBoy(int nums) {
        if (nums < 1) {
            System.out.println("nums的值不正确");
        } else {
            Boy curBoy = null;

            for(int i = 1; i <= nums; ++i) {
                Boy boy = new Boy(i);
                if (i == 1) {
                    this.first = boy;
                    this.first.setNext(this.first);
                    curBoy = this.first;
                } else {
                    curBoy.setNext(boy);
                    boy.setNext(this.first);
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
        if (this.first != null && startNo >= 1 && startNo <= nums) {

            if (first == null || startNo < 1 || startNo > nums) {
                System.out.println("参数有误，请重新输入");
                return;
            }

            //创建要给辅助指针，帮助完成小孩出圈
            Boy helper = first;
            // 需求创建一个辅助变量helper,事先应该指向环形链表的最后这个节点
            while(true) {
                if (helper.getNext() == first) { //说明helper指向最后小孩节点
                    break;
                }
                helper = helper.getNext();
            }
            //小孩报数前，先让first和helper移动 k - 1 次
            for (int j = 0; j < startNo - 1; j++) {
                first = first.getNext();
                helper = helper.getNext();
            }

            //当小孩报数时，让first和 helper 指针同时移动 m - 1 次，然后出圈
            //这是一个循环操作，知道圈中只有一个节点
            while (true) {
                if (helper == first) { //说明圈中只有一个节点
                    break;
                }
                //让 first 和 helper 指针同时的移动countNum - 1
                for (int j = 0; j < countNum - 1; j++) {
                    first = first.getNext();
                    helper = helper.getNext();
                }
                System.out.printf("小孩%d出圈\n", this.first.getNo());
                first = first.getNext();
                helper.setNext(first);
            }


            System.out.printf("最后留在圈中的小孩编号%d \n", this.first.getNo());
        } else {
            System.out.println("参数输入有误， 请重新输入");
        }
    }
}

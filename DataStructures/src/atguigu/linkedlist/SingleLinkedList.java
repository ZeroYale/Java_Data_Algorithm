//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package atguigu.linkedlist;

class SingleLinkedList {
    private HeroNode head = new HeroNode(0, "", "");

    SingleLinkedList() {
    }

    public HeroNode getHead() {
        return this.head;
    }

    public void add(HeroNode heroNode) {
        HeroNode temp;
        for(temp = this.head; temp.next != null; temp = temp.next) {
        }

        temp.next = heroNode;
    }

    public void addByOrder(HeroNode heroNode) {
        HeroNode temp = this.head;

        boolean flag;
        for(flag = false; temp.next != null && temp.next.no <= heroNode.no; temp = temp.next) {
            if (temp.next.no == heroNode.no) {
                flag = true;
                break;
            }
        }

        if (flag) {
            System.out.printf("准备插入的英雄的编号 %d 已经存在了, 不能加入\n", heroNode.no);
        } else {
            heroNode.next = temp.next;
            temp.next = heroNode;
        }

    }

    public void update(HeroNode newHeroNode) {
        if (this.head.next == null) {
            System.out.println("链表为空~");
        } else {
            HeroNode temp = this.head.next;

            boolean flag;
            for(flag = false; temp != null; temp = temp.next) {
                if (temp.no == newHeroNode.no) {
                    flag = true;
                    break;
                }
            }

            if (flag) {
                temp.name = newHeroNode.name;
                temp.nickname = newHeroNode.nickname;
            } else {
                System.out.printf("没有找到 编号 %d 的节点，不能修改\n", newHeroNode.no);
            }

        }
    }

    public void del(int no) {
        HeroNode temp = this.head;

        boolean flag;
        for(flag = false; temp.next != null; temp = temp.next) {
            if (temp.next.no == no) {
                flag = true;
                break;
            }
        }

        if (flag) {
            temp.next = temp.next.next;
        } else {
            System.out.printf("要删除的 %d 节点不存在\n", no);
        }

    }

    public void list() {
        if (this.head.next == null) {
            System.out.println("链表为空");
        } else {
            for(HeroNode temp = this.head.next; temp != null; temp = temp.next) {
                System.out.println(temp);
            }

        }
    }
}

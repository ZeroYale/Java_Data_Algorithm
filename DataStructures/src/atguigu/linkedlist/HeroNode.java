//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package atguigu.linkedlist;

class HeroNode {
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;

    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    public String toString() {
        return "HeroNode [no=" + this.no + ", name=" + this.name + ", nickname=" + this.nickname + "]";
    }
}

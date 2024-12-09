package 代码随想录.链表;

import java.util.concurrent.locks.LockSupport;

public class 设计链表707 {
    public static void main(String[] args) {

    }
}
class MyLinkedList{
    class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val){this.val=val;}
        ListNode(int val,ListNode next){
            this.val=val;
            this.next=next;}
    }
    ListNode dummyHead=null;
    int size=0;
    public MyLinkedList(){
        dummyHead = new ListNode(-1); //虚拟头结点
        size=0;
    }
    public int get(int index){
        if (index>size-1||index<0) return -1;
        ListNode cur=dummyHead.next;
        while (index>0){
            cur=cur.next;
            index--;
        }
        return cur.val;
    }
    public void addAtHead(int val){
        //在头节点进行插入
        ListNode node=new ListNode(val);
        node.next=dummyHead.next;
        dummyHead.next=node;
        size++;
    }
    public void addAtTail(int val) {
        //在链表尾部插入
        ListNode node = new ListNode(val);
        ListNode cur=dummyHead; //指向要插入的位置的前一个
        while (cur.next!=null){
            cur=cur.next;
        }
        cur.next=node;
        size++;
    }

    public void addAtIndex(int index, int val) {

    }

    public void deleteAtIndex(int index) {

    }
}

package 拼多多提单;

import 代码随想录.链表.ListNode;

public class 删除倒数第n个节点 {
    public static void main(String[] args) {

    }
    public void deleteNode(ListNode head,int n){
        if (head==null) return;
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode slow=dummy,fast=head;
        for(int i=0;i<5;i++){
            fast=fast.next;
        }
        while (fast!=null){
            slow=slow.next;
            fast=fast.next;
        }
        //slow指向n之前的节点
        slow.next=slow.next.next;
    }
}

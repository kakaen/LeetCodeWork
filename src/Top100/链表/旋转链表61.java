package Top100.链表;

import 代码随想录.二叉树理论.二叉树的遍历方式.前序遍历方式;
import 代码随想录.链表.ListNode;

public class 旋转链表61 {
    public ListNode rotateRight(ListNode head,int k){
        //将节点的后k个节点插入到前驱
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode fast=dummy,slow=dummy;
        //先计算链表的长度
        int len=0;
        ListNode p=head;
        while (p!=null){
            len++;
            p=p.next;
        }
        //k>=0;
        k=k%len;
        for (int i=0;i<k;i++){
            fast=fast.next;
        }
        while (fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }
        p=slow.next;
        slow.next=null;
        ListNode tail=dummy;
        while (p!=null){
            ListNode temp=p.next;
            tail.next=p;
            tail=p;
            p=temp;
        }
        tail.next=head;
        return dummy.next;
    }
    //方法二合并为环
    public ListNode rotateRight2(ListNode head,int k){
        if (head==null) return head;
//        ListNode dummy=new ListNode(0);
//        dummy.next=head;
        ListNode p=head;
        int len=0;
        while (p!=null){
            len++;
        }
        k=k%len;
//        ListNode fast=dummy,slow=dummy;
        ListNode fast=head,slow=head;
        for (int i=0;i<k-1;i++){
            fast=fast.next;
        }
        //fastz指向尾元素，slow指向新节点的前一个元素
        while (fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }
        fast.next=head;
        ListNode newHead=slow.next;
        slow.next=null;
        return newHead;
    }
}

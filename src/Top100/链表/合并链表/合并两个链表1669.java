package Top100.链表.合并链表;

import 代码随想录.链表.ListNode;

public class 合并两个链表1669 {
    public static void main(String[] args) {

    }
}
class Solution1669{
    public ListNode mergeInBetween(ListNode list1,int a,int b,ListNode list2){
        //添加虚拟头节点
        ListNode dummy=new ListNode(0,list1);
        //删除下标从a到b的全部节点,即找到list1的第a-1个节点和第b+1个节点
        //然后，让a-1的下标指向List2的head，让list2的tail指向b+1；
        ListNode nodeAPre=dummy;//指向第a-1个节点
        while (a!=0){
            nodeAPre=nodeAPre.next;
            a--;
        }
        ListNode nodeBNext=dummy;
        while (b!=0){
            nodeBNext=nodeBNext.next;
            b--;
        }
        nodeBNext=nodeBNext.next.next; //指向了b的下一个节点
        ListNode tail=list2; //指list2向尾节点
        while (tail.next!=null){
            tail=tail.next;
        }
        nodeAPre.next=list2;
        tail.next=nodeBNext;
        return list1;
    }
}

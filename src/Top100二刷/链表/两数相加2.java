package Top100二刷.链表;

import 代码随想录.链表.ListNode;

public class 两数相加2 {
    public ListNode addTwoNumbers(ListNode l1,ListNode l2){
        //给你两个非空的链表，表示两个非负的整数。他们的每位数字都是按照逆序的方式存储的
        //将两个数相加，并以相同形式返回一个表示和的链表
        int flag=0; //表示上一位是否存在进位
        ListNode res=new ListNode(0);
        ListNode tail=res;

        while (l1!=null||l2!=null){
            int nodeRes=flag;
            int x=l1==null?0:l1.val;
            int y=l2==null?0:l2.val;
            nodeRes=nodeRes+x+y;
            flag=nodeRes/10;
            nodeRes=nodeRes%10;
            tail.next=new ListNode(nodeRes);
            tail=tail.next;
            if (l1!=null) l1=l1.next;
            if (l2!=null) l2=l2.next;
        }
        if (flag==1) tail.next=new ListNode(flag);

        return res.next;
    }
}

package Top100.链表;

import 代码随想录.链表.ListNode;

import java.util.List;

public class BM2链表内指定区间的反转 {
    public static void main(String[] args) {

    }
}
class SolutionBM2{
    public ListNode reverseBetween(ListNode head,int m,int n){
        //先找到第m-1个节点的位置
        ListNode dummy=new ListNode(0,head);
        ListNode pre=dummy;
        ListNode cur=dummy.next;
        //先到达m-1的节点，p指向m-1的节点
        int i=0;
        for (i=0;i<m;i++){
            pre=cur;
            cur=cur.next;
        }
        //pre指向m之前的节点。cur指向m节点
        for (;i<n-1;i++){
            ListNode tem=cur.next;
            cur.next=tem.next;
            tem.next=pre.next;
            pre.next=tem;
        }
        return dummy.next;
    }
    public ListNode reverseBetween2(ListNode head,int m,int n){
        ListNode dummy=new ListNode(0,head);
        ListNode pre=dummy;
        ListNode cur=dummy.next;
        int i=0;
        //pre指向待反转的前一个节点
        for (;i<m-1;i++){
            pre=cur;
            cur=cur.next;
        }
        //只需要遍历到n-1个节点即可。最后一个cur不需要
        for (;i<n-1;i++){
            ListNode temp=cur.next;
            cur.next=temp.next;
            temp.next=pre.next;
            pre.next=temp;
        }
        return dummy.next;
    }
}

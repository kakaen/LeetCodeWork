package Top100.链表.反转链表;

import 代码随想录.链表.ListNode;

public class K个一组翻转链表25 {
    public static void main(String[] args) {

    }
}
class Solution25 {
    //每k个节点进行反转，
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy=new ListNode(0,head);
        ListNode preNode=dummy; //反转连边的前置节点。
        ListNode cur=dummy.next; //将要反转的第一个节点
        if (!isK(cur,k)) return dummy.next; //不满足k个节点
        //判断以cur为头节点是否存在k个节点
        while (isK(cur,k)){
            //进行反转k个节点
            for (int i=0;i<k-1;i++){
                ListNode temp=cur.next;
                cur.next=temp.next;
                temp.next=preNode.next;
                preNode.next=temp;
            }
            preNode=cur;
            cur=preNode.next;
        }
        return dummy.next;
    }
    //判断是否长度大于等于k
    public boolean isK(ListNode head,int k){
        int n=0;
        while (head!=null){
            n++;
            if (n>=k){
                return true;
            }
        }
        return n>=k;
    }
}

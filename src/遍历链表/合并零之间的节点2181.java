package 遍历链表;

import 代码随想录.链表.ListNode;

public class 合并零之间的节点2181 {
    public static void main(String[] args) {

    }
}

class Solution2181 {
    public ListNode mergeNodes(ListNode head) {
        ListNode firstZero=head;
        ListNode preZero=firstZero;
        ListNode p=head.next;
        int count=0;
        while (p!=null){
            //当前节点值不是0则count+val;
            if (p.val!=0){
                count+=p.val;
            } else if (p.val==0) {
                firstZero.val=count;
                firstZero.next=p;
                firstZero=p;
                count=0;
            }
            p=p.next;
        }
        firstZero.next=null;
        return head;
    }
}
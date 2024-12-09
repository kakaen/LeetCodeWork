package Top100.链表.双指针;

import 代码随想录.链表.ListNode;

public class 奇偶链表328 {
    public static void main(String[] args) {

    }
}
class Solution328{
    public ListNode addEvenList(ListNode head){
        if (head==null) return head;
        ListNode p=head; //奇数节点的指针
        ListNode q=head.next; //偶数节点的指针。
        //O(1)的空间复杂度，O(n)时间浮渣度
        ListNode newHead=head.next; //指向偶数的节点
        ListNode temp1,temp2;
        while (p!=null&&q!=null){
            temp1=q.next; //下一个奇数节点
            temp2=temp1.next;//可能出现nullPointExceptionError
            
        }
        return head;
    }
}

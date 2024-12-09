package Top100.链表.快慢指针;

import 代码随想录.链表.ListNode;

public class 环形链表II142 {
    public static void main(String[] args) {

    }
}
class Solution142{
    public ListNode detectCycle(ListNode head){
        ListNode fast=head.next,slow=head;
        //先判断是否存在环
        boolean flag=false;
        while (fast!=null&&fast.next!=null){
            if (fast==slow) {
                flag=true; //说明
                break;
            }
        }
        if (flag==false) return null;
        return null;

    }
}
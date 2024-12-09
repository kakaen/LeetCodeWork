package Top100.链表;

import com.sun.org.apache.bcel.internal.generic.ARETURN;
import 代码随想录.链表.ListNode;

import java.util.List;

public class 删除链表中的倒数第N个节点19 {
    public ListNode removeNthFromEnd(ListNode head,int n){
        ListNode dummy=new ListNode(0);
        //删除倒数第n个节点,使用快慢指针来实现
        ListNode fast=dummy,slow=dummy;
        //fast走n步
        for (int i=1;i<=n;i++){
            fast=fast.next;
        }
        while (fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }
        slow.next=slow.next.next;
        return dummy.next;
    }

}

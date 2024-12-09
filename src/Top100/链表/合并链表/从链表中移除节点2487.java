package Top100.链表.合并链表;

import 代码随想录.链表.ListNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class 从链表中移除节点2487 {
    public static void main(String[] args) {

    }
}
class Solution2487 {
    public ListNode removeNodes(ListNode head) {
        Deque<ListNode> stack=new LinkedList<>();
        ListNode cur=head;
        stack.push(cur);
        while (!stack.isEmpty()||cur!=null){
            if (!stack.isEmpty()&&stack.peek().val<cur.val){
                ListNode pop = stack.pop();
                pop.next=null;
            }else{
                stack.push(cur);
                cur=cur.next;
            }
        }
        if (stack.isEmpty()) return null;
        ListNode newHead=null;
        while (!stack.isEmpty()){
            ListNode pop = stack.pop();
            pop.next=newHead;
            newHead=pop;
        }
        return newHead;
    }
}

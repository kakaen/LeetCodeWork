package 美团面试手撕题;

import 代码随想录.链表.ListNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class K个一组翻转链表25 {
    public ListNode reverseGroup2(ListNode head ,int k){
        Deque<ListNode> stack=new LinkedList<>();
        ListNode dummy=new ListNode(0);
        ListNode tail=dummy;
        while (true){
            int count=0;
            ListNode temp=head;
            while (temp!=null&&count<k){
                stack.push(temp);
                temp=temp.next;
                count++;
            }
            if(count!=k){
                tail.next=head;
                break;
            }
            while (!stack.isEmpty()){
                ListNode node=stack.poll();
                tail.next=node;
                tail=node;
            }
            tail.next=temp;
            head=temp;
        }
        return dummy.next;
    }
    public ListNode reverseGroup(ListNode head,int k){
        ListNode cur=head;
        int count=0;
        //此时cur指向下一组节点值
        while (cur!=null&&count!=k){
            cur=cur.next;
            count++;
        }
        if(count==k){
            cur=reverseGroup(cur,k);
            while (count!=0){
                count--;
                ListNode tem=head.next;
                head.next=cur;
                cur=head;
                head=tem;
            }
            head=cur;
        }
        return head;
    }
}

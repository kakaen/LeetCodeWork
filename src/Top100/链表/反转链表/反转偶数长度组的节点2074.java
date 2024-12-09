package Top100.链表.反转链表;

import 代码随想录.链表.ListNode;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class 反转偶数长度组的节点2074 {
    public static void main(String[] args) {

    }
}
class Solution2074{
    public ListNode reverseEvenLengthGroups(ListNode head){
        ReentrantLock lock=new ReentrantLock();
        lock.lock();
        if (head.next==null) return head;
        //反转
        int groupId=2; //表示组号
        ListNode preNode=head; //指向翻转组的前一个节点
        ListNode cur=preNode.next; //指向该组的第一个节点
        int count=0;
        while (true){
            count=groupId; //待翻转的节点个数
            //不是偶数组,把pre和cur移动到偶数组
            if (groupId%2!=0){
                while (cur!=null&&count!=0){
                    preNode=cur;
                    cur=cur.next;
                    count--;
                }
                if (count!=0) return head; //说明已经到达链表的结尾了
            }else { //进行反转偶数链表的节点
                while (cur.next!=null&&count!=1){
                    ListNode temp=cur.next;
                    cur.next=temp.next;
                    temp.next=cur;
                    preNode.next=temp;
                    count--;
                }
                if (count!=1) return head;
                preNode=cur;
                cur=cur.next;
            }
            groupId++;
        }
    }
    //反转偶数数组的组
    public ListNode reverseEvenLengthGroups2(ListNode head){
        ListNode dummy=new ListNode(-1,head);
        ListNode preNode=dummy;
        ListNode cur=dummy.next; //记录组中的第一个元素
        int groupId=1;
        int count=groupId;
        while (cur!=null){
            count=nodeCount(cur,groupId);
            if (count%2==0){
                //进行反转该组元素
                while (cur.next!=null&&count!=1){
                    ListNode temp=cur.next;
                    cur.next=temp.next;
                    temp.next=preNode.next;
                    preNode.next=temp;
                    count--;
                }
                preNode=cur;
                cur=cur.next;
            }else{
                //说明该组的节点个数为奇数
                while (cur!=null&&count!=0){
                    cur=cur.next;
                    count--;
                }

            }
            groupId++;
        }
        return dummy.next;
    }
    //判断当前组中的节点个数是否为偶数
    public int nodeCount(ListNode node,int groupId){
        int n=0;
        while (node!=null&&groupId!=0){
            node=node.next;
            groupId--;
            n++;
        }
        return n;
    }
    public ListNode reverseEvenLengthGroups3(ListNode head){

        return head;
    }
}

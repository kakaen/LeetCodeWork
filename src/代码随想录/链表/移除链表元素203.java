package 代码随想录.链表;



import javax.jnlp.ClipboardService;

public class 移除链表元素203 {
    public static void main(String[] args) {

    }
}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode2 removeElements(ListNode2 head, int val) {
        //删除头结点
        while (head!=null&&head.val==val){
            head=head.next;
        }
        ListNode2 p=head; //head一定不是val
        ListNode2 q=head.next; //进行比较
        while (q!=null){
            if (q.val==val){
                //删除q
                p.next=q.next;
                q=q.next;
            }else {
                p=q;
                q=q.next;
            }
        }
        return head;
    }
}
class Solution203{
    public ListNode removeElements(ListNode head,int val){
        //删除链表中所有val的
        ListNode preHead=new ListNode(-1); //创建虚拟节点
        preHead.next=head;
        ListNode p=preHead,q=p.next;
        while (q!=null){
            if (q.val==val){
                q=q.next;
                p.next=q;
            }else {
                p=q;
                q=q.next;
            }
        }
        return preHead.next;
    }
    //移除链表中的val元素
    public ListNode removeElements2(ListNode head,int val){
        //删除头节点
        while (head!=null&&head.val==val){
            head=head.next;
        }
        if (head==null) return head;
        ListNode pre=head,cur=head.next;
        while (cur!=null){
            if (cur.val==val){
                cur=cur.next;
                pre.next=cur;
            }else{
                pre=cur;
                cur=cur.next;
            }
        }
        return head;
    }
}
class ListNode2 {
    int val;
     ListNode2 next;
    ListNode2() {}
     ListNode2(int val) { this.val = val; }
    ListNode2(int val, ListNode2 next) { this.val = val; this.next = next; }
 }
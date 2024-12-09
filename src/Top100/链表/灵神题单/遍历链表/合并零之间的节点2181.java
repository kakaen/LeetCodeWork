package Top100.链表.灵神题单.遍历链表;

import 代码随想录.链表.ListNode;

public class 合并零之间的节点2181 {
    public static void main(String[] args) {
        合并零之间的节点2181 test = new 合并零之间的节点2181();
        ListNode head=new ListNode(0);
        head.next=new ListNode(3);
        head.next.next=new ListNode(1);
        head.next.next.next=new ListNode(0);
        head.next.next.next.next=new ListNode(4);
        head.next.next.next.next.next=new ListNode(5);
        head.next.next.next.next.next.next=new ListNode(2);
        head.next.next.next.next.next.next.next=new ListNode(0);
        ListNode node = test.mergeNodes(head);
        while (node!=null){
            System.out.println(node.val);
            node=node.next;
        }
    }
    public ListNode mergeNodes(ListNode head){
        ListNode preHead=head;
        ListNode p=head.next;
        int count=0;
        while (p!=null){
            if (p.val==0){
                p.val=count;
                preHead.next=p;
                preHead=p;
                count=0;
            }else {
                count=count+p.val;
            }
            p=p.next;
        }
        return head.next;
    }
}

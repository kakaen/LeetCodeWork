package 代码随想录.链表;

public class 删除链表中的节点237 {
    public static void main(String[] args) {

    }
}
class Solution237{
    public void deleteNode(ListNode node){
        ListNode next=node.next;
        while (next!=null&&next.next!=null){
            node.val=next.val;
            node=next;
        }
        node.next=null;
    }
    public void deleteNode2(ListNode node){
        ListNode nextNode=node.next; //不是最后一个节点
        node.val=nextNode.val;
        node.next=nextNode.next;
    }
}

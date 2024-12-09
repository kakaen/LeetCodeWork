package Top100.链表.插入链表;

import 代码随想录.链表.ListNode;

public class 对链表进行插入排序147 {
    public static void main(String[] args) {

    }
}
class Solution147 {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy=new ListNode(Integer.MIN_VALUE,null); //作为虚拟节点
        ListNode cur=head; //作为当前待排序的节点的指针
        while (cur!=null){
            ListNode temp=cur.next; //临时保存下一个节点，防止断链
            //寻找插入位置
            ListNode preNode=dummy;
            ListNode sortNode=preNode.next;
            while (sortNode!=null){
                if (sortNode.val< cur.val){
                    preNode=sortNode;
                    sortNode=sortNode.next;
                }else{
                    //需要进行插入炒作，在prenode和sortNode之间插入
                    break;
                }
            }
            //这里有两种情况，一种是cur插入到最后节点，即sortNode=null。无所谓，都一样
            cur.next=sortNode;
            preNode.next=cur;
            cur=temp;
        }
        return dummy.next;
    }
}

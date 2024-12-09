package Top100.链表;

import 代码随想录.链表.ListNode;

import java.util.HashSet;
import java.util.Set;

public class 两个链表的第一个公共节点BM10 {
    public static void main(String[] args) {

    }
    public static ListNode FindFirstCommonNode(ListNode pHead1,ListNode pHead2){
        ListNode first=pHead1,second=pHead2;
        while (first!=second){
            if (first==null){
                first=pHead2;
            }else {
                first=first.next;
            }
            if (second==null){
                second=pHead1;
            }else {
                second=second.next;
            }
        }
        return first;
    }
    public static ListNode FindFirstCommonNode2(ListNode pHead1,ListNode pHead2){
        Set<ListNode> viset=new HashSet<>();
        ListNode temp=pHead1;
        while (temp!=null){
            viset.add(temp);
            temp=temp.next;
        }
        temp=pHead2;
        while (temp!=null){
            if (viset.contains(temp)) return temp;
        }
        return temp;
    }
}

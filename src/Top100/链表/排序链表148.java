package Top100.链表;

import 代码随想录.链表.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 排序链表148 {
    public static void main(String[] args) {

    }
    //空间复杂度为O(n)，时间复杂度为O(nlogn)
    public ListNode sortList(ListNode head){
        //按升序进行排列，并返回排序后的链表
        List<Integer> list=new ArrayList<>();
        ListNode p=head;
        while (p!=null){
            list.add(p.val);
            p=p.next;
        }
        //排序
        Collections.sort(list);
        p=head;
        int i=0;
        while (p!=null){
            p.val=list.get(i);
            i++;
            p=p.next;
        }
        return head;
    }
    //如何使用O1的空间复杂度来实现，归并排序
    public ListNode sortList2(ListNode head){

        return null;
    }
}
class Solution148 {
    //O(nLogn)和O(1)的空间复杂度情况下
    public ListNode sortList(ListNode head) {
        if (head==null) return head;
        ListNode first=head;
        ListNode second=first.next;
        while (head!=null){
            if (head!=null){

            }
        }
        return head;
    }
}

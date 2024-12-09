package Top100二刷;

import 代码随想录.链表.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 排序链表148 {
    public ListNode sortList(ListNode head){
        //使用ON的
        List<Integer> list=new ArrayList<>();
        ListNode p=head;
        while (p!=null){
            list.add(p.val);
            p=p.next;
        }
        Collections.sort(list);
        p=head;
        int i=0;
        while (p!=null){
            p.val=list.get(i);
            p=p.next;
        }
        return head;
    }
    //使用OnLogn的时间浮渣度和O(1)级别的空间复杂度,nlogn的排序有归并排序，堆排序，快派
    public ListNode sortList2(ListNode head){
        //如何实现O(1)级别的空间复杂度优化？
        //原地转职链表
        ListNode dummy=new ListNode(0);
        ListNode p=head;
        while (p!=null){

        }
        return null;
    }


}

package 代码随想录.链表;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 单链表的排序BM12 {
    public ListNode sortInList(ListNode head){
        List<Integer> num=new ArrayList<>();
        ListNode p=head;
        while (p!=null){
            num.add(p.val);
            p=p.next;
        }
        Collections.sort(num);
        p=head;
        int i=0;
        while (p!=null){
            p.val=num.get(i);
            i++;
            p=p.next;
        }
        return head;
    }
    //使用空间复杂度为1的方法
    public ListNode sortList(ListNode head){
        return null;
    }
}

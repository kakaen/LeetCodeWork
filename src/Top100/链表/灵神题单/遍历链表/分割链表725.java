package Top100.链表.灵神题单.遍历链表;

import 代码随想录.链表.ListNode;

import java.util.ArrayList;
import java.util.List;

public class 分割链表725 {
    public static void main(String[] args) {

    }
    public ListNode[] splitListToParts(ListNode head,int k){
        List<ListNode> res=new ArrayList<>();
        ListNode[] array = (ListNode[]) res.toArray();
        ListNode p=head;
        int len=0;
        while (p!=null){
            len++;
            p=p.next;
        }
        int subLen=len/k;
        return null;
    }
}

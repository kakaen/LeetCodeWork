package Top100.链表.合并链表;

import 代码随想录.链表.ListNode;

import java.util.ArrayList;
import java.util.List;

public class BM5合并k个已经排序的数组 {
}
class SolutionBM5 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param lists ListNode类ArrayList
     * @return ListNode类
     */
    public ListNode mergeKLists (ArrayList<ListNode> lists) {
        // write code here
        //合并k个链表
        return merge(lists,0,lists.size()-1);
    }
    //将l和r进行合并
    public ListNode merge(List<ListNode> lists,int l,int r){
        if (l==r) return lists.get(l);
        if (l>r) return null;
        int mid=(l+r)>>1;
        return merge2Lists(merge(lists,l,mid),merge(lists,mid+1,r));
    }
    //将k个链表两两配对
    public ListNode merge2Lists(ListNode a,ListNode b){
        ListNode dummy=new ListNode(0);
        ListNode tail=dummy;
        while (a!=null&&b!=null){
            if (a.val<b.val){
                tail.next=a;
                tail=a;
                a=a.next;
            }else{
                tail.next=b;
                tail=b;
                b=b.next;
            }
        }
        if (a!=null) tail.next=a;
        if (b!=null) tail.next=b;
        return dummy.next;
    }

}
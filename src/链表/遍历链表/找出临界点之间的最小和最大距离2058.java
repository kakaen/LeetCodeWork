package 链表.遍历链表;

import 代码随想录.链表.ListNode;

import java.util.List;
import java.util.Map;

public class 找出临界点之间的最小和最大距离2058 {
    public static void main(String[] args) {

    }
}
class Solution2058{
    public int[] nodesBetweenCriticalPoints(ListNode head){
       int minDistance=-1; //记录临界点之间的最小值
       int maxDistance=-1; //记录临界点之间的最大值
       int firstIndex=-1;  //记录第一个临界点的下标
       int preIndex=-1; //记录上一个临界点的下标
       int pos=1; //记录当前节点的位置。
       ListNode first=head;
       ListNode second;
       ListNode thread;
       while (first.next!=null&&first.next.next!=null){
           second=first.next;
           thread=first.next.next;
           if (second.val>first.val&&second.val> thread.val||second.val<first.val&&second.val< thread.val){
               if (preIndex!=-1){
                   minDistance=(minDistance==-1?pos-preIndex: Math.min(minDistance,pos-preIndex));
                   maxDistance=Math.max(maxDistance,pos-firstIndex);
               }else{
                   firstIndex=pos;
               }
               preIndex=pos;
           }
           pos++;
           first=first.next;
       }
       return new int[]{minDistance,maxDistance};
    }

}

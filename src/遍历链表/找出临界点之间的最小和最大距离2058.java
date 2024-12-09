package 遍历链表;
import 代码随想录.链表.ListNode;

import java.util.ArrayList;
import java.util.List;

public class 找出临界点之间的最小和最大距离2058 {
    public static void main(String[] args) {

    }
}
class Solution2058 {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
       //维护第一个临界点和上一个临界点
        int minDistance=-1;
        int maxDistance=-1;
        int firstIndex=-1;
        int preIndex=-1;
        int pos=1;
        ListNode first=head;
        ListNode second;
        ListNode thread;
        while (first.next.next!=null){
            second=first.next;
            thread=second.next;
            if (second.val>first.val&&second.val>thread.val||(second.val<first.val&&second.val<thread.val)){
                if (preIndex!=-1){
                    minDistance=(minDistance==-1?pos-preIndex:Math.min(minDistance,pos-preIndex));
                    maxDistance=Math.max(maxDistance,pos-firstIndex);
                }
                if (firstIndex==-1){
                    firstIndex=pos;
                }
                //更新上一个临界点
                preIndex=pos;
            }
            pos++;
            first=first.next;
        }
        return new int[]{minDistance,maxDistance};
    }
}
package Top100.链表.灵神题单.遍历链表;

import 代码随想录.链表.ListNode;

import java.util.Arrays;
import java.util.List;

public class 找出临界点之间的最小和最大距离2058 {
    public static void main(String[] args) {
        找出临界点之间的最小和最大距离2058 test = new 找出临界点之间的最小和最大距离2058();
        ListNode head=new ListNode(5);
        head.next=new ListNode(3);
        head.next.next=new ListNode(1);
        head.next.next.next=new ListNode(2);
        head.next.next.next.next=new ListNode(5);
        head.next.next.next.next.next=new ListNode(1);
        head.next.next.next.next.next.next=new ListNode(2);
        int[] ints = test.nodesBetweenCriticalPoints(head);
        System.out.println(Arrays.toString(ints));
    }
    public int[] nodesBetweenCriticalPoints(ListNode head){
        //找到临界点之间的最大距离和最小距离
        //最大距离就是第一个出现的临界点index，和最后一个的index
        //最小距离是维护上一个和当前临界点的插值
        int firstPoint=-1;
        int prePoint=-1;
        int maxDistance=-1;
        int minDistance=Integer.MAX_VALUE;
        ListNode pre=head;
        ListNode cur=head.next;
        ListNode next=cur.next;
        if (next==null) return new int[]{-1,-1};
        int i=1;
        while (next!=null){
            if (isPoint(pre,cur,next)){
                //第一个临界点
                if (firstPoint==-1||prePoint==-1){
                    firstPoint=i;
                    prePoint=i;
                }else{
                    maxDistance=Math.max(maxDistance,i-firstPoint);
                    minDistance=Math.min(minDistance,i-prePoint);
                }
                prePoint=i;
            }
            pre=cur;
            cur=next;
            next=next.next;
            i++;
        }
        if (maxDistance==-1||minDistance==Integer.MAX_VALUE) return new int[]{-1,-1};
        return new int[] {minDistance,maxDistance};
    }
    public boolean isPoint(ListNode pre,ListNode cur,ListNode next){
        if ((pre.val< cur.val&&cur.val>next.val)||(pre.val>cur.val&&next.val> cur.val)){
            return true;
        }
        return false;
    }
}

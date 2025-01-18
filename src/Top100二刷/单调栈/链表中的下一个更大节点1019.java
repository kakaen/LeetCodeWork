package Top100二刷.单调栈;

import 代码随想录.链表.ListNode;

import java.util.*;

public class 链表中的下一个更大节点1019 {
    public int[] nextLargerNodes2(ListNode head){
        int n=0;
        for (ListNode cur=head;cur!=null;cur=cur.next){
            n++;
        }
        int[] ans=new int[n];
        Deque<int[]> stack=new LinkedList<>(); //栈 存放当前节点的下标和值
        int i=0;
        for (ListNode cur=head;cur!=null;cur=cur.next){
            while (!stack.isEmpty()&&cur.val>stack.peek()[1]){
                int[] node = stack.poll();
                ans[node[0]]=cur.val;
            }
            stack.push(new int[]{i, cur.val});
            i++;
        }
        return ans;
    }
    public int[] nextLargerNodes(ListNode head){

        Deque<Integer> stack=new ArrayDeque<>(); //记录下标
        List<Integer> list=new ArrayList<>();
        ListNode p=head;
        while (p!=null){
            list.add(p.val);
            p=p.next;
        }
        int[] array = list.stream().mapToInt(Integer::intValue).toArray();
        int[] ans=new int[array.length];
        for (int i=0;i<array.length;i++){
            while (!stack.isEmpty()&&array[i]>array[stack.peek()]){
                int j=stack.poll();
                ans[j]=array[i];
            }
            stack.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        链表中的下一个更大节点1019 test = new 链表中的下一个更大节点1019();
        ListNode head=new ListNode(2);
        head.next=new ListNode(1);
        head.next.next=new ListNode(5);
        int[] ints = test.nextLargerNodes2(head);
        System.out.println(Arrays.toString(ints));
    }
}

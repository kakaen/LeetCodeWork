package 单调栈;

import netscape.security.UserTarget;
import 代码随想录.链表.ListNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class 链表中的下一个更大节点1019 {
    public static void main(String[] args) {

    }
}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

/**
 * 这个只能从右向左进行遍历
 */
class Solution1019 {
    public int[] nextLargerNodes(ListNode head) {
        ListNode i=head;
        int n=0;
        while (i!=null){
            i=i.next;
            n++;
        }
        int[] result=new int[n];
      Deque<Integer> stack=new ArrayDeque<>();
      for (ListNode q=head;q!=null;q=q.next){
          while (!stack.isEmpty()&&stack.peek()<stack.pop()){

          }
      }
      return result;
    }
}

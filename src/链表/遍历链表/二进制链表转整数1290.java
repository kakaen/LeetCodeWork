package 链表.遍历链表;

import 代码随想录.链表.ListNode;

public class 二进制链表转整数1290 {
    public static void main(String[] args) {

    }
}
class Solution1290{
    public int getDecimalValue(ListNode head){
        int res=0;
        while (head!=null){
            res=res*2;
            int var=head.val;
            res+=var;
            head=head.next;
        }
        return res;
    }
}

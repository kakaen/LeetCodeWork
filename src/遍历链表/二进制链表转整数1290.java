package 遍历链表;

import 代码随想录.链表.ListNode;

import java.util.ArrayList;
import java.util.List;

public class 二进制链表转整数1290 {
    public static void main(String[] args) {

    }
}
class Solution {
    public int getDecimalValue(ListNode head) {

        int result=0;
        while (head!=null){
            result+=result*2;
        }
        head=head.next;
        return result;
    }
}
package 代码随想录.链表;

public class 删除排序列表中的重复元素88 {
    public static void main(String[] args) {

    }
}
class Solution88{
    public ListNode deleteDuplicates(ListNode head){
        ListNode pre=head;
        ListNode cur=head;
        while (cur.next!=null){
            //如果cur的值等于cur.next的值，则将cur.next给移除
            if (cur.val== cur.next.val){
                cur.next=cur.next.next;
            }else{
               cur=cur.next;
            }
        }

        return head;
    }
}

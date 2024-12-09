package 代码随想录.链表;

public class 合并两个有序的链表21 {
    public static void main(String[] args) {

    }
    public ListNode mergeTwoLists(ListNode list1,ListNode list2){
        ListNode dummy=new ListNode(0);
        ListNode tail=dummy;
        ListNode temp;
        while (list1!=null&&list2!=null){
            if (list1.val<list2.val){
                temp=list1.next;
                tail.next=list1;
                tail=list1;
                list1=temp;
            }else{
                temp=list2.next;
                tail.next=list2;
                tail=list2;
                list2=temp;
            }
        }
        while (list1!=null){
            tail.next=list1;
        }
        while (list2!=null){
            tail.next=list2;
        }
        return dummy.next;
    }
}

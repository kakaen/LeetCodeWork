package 代码随想录.链表;

public class 两数相加II445 {
    public static void main(String[] args) {

    }
    public ListNode addTwoNumber(ListNode l1,ListNode l2){
        l1=reverse(l1);
        l2=reverse(l2);
        ListNode dummy=new ListNode(-1);
        int flag=0;
        while (l1!=null||l2!=null||flag!=0){
            int count=flag;
            if (l1!=null){
                count+=l1.val;
                l1=l1.next;
            }
            if (l2!=null){
                count+=l2.val;
                l2=l2.next;
            }
            flag=count/10;
            count=count%10;
            ListNode node=new ListNode(count);
            node.next=dummy.next;
            dummy.next=node;
        }
        return dummy.next;
    }
    public ListNode reverse(ListNode head){
        ListNode dummy=new ListNode(0);
        ListNode temp;
        while (head!=null){
            temp=head.next;
            head.next=dummy.next;
            dummy.next=head;
            head=temp;
        }
        return dummy.next;
    }
}

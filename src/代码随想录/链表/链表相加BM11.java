package 代码随想录.链表;

public class 链表相加BM11 {
    public static void main(String[] args) {
        链表相加BM11 test = new 链表相加BM11();
        ListNode head=new ListNode(6);
        ListNode h2=new ListNode(3);
        head.next=h2;
        ListNode newHead=test.reverse(head);
        while (newHead!=null){
            System.out.println(newHead.val);
            newHead=newHead.next;
        }
    }
    public ListNode addInList(ListNode head1,ListNode head2){
        //先将链表进行反转
        ListNode first=reverse(head1);
        ListNode second=reverse(head2);
        ListNode p=first,q=second;
        ListNode dummy=new ListNode(0);
        int flag=0;
        ListNode temp;
        while (p!=null&&q!=null){
            temp=p.next;
            int count=p.val+q.val+flag;
            flag=count/10;
            count=count%10;
            p.val=count;
            p.next=dummy.next;
            dummy.next=p;
            p=temp;
            q=q.next;
        }
        //如果是p不为空
        while (p!=null){
            temp=p.next;
            int count=p.val+flag;
            flag=count/10;
            count=count%10;
            p.val=count;
            p.next=dummy.next;
            dummy.next=p;
            p=temp;
        }
        while (q!=null){
            temp=q.next;
            int count=q.val+flag;
            flag=count/10;
            count=count%10;
            q.val=count;
            q.next=dummy.next;
            dummy.next=q;
            q=temp;
        }
        if (flag==1){
            ListNode t=new ListNode(1);
            t.next=dummy.next;
            dummy.next=t;
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
    public ListNode addInList2(ListNode head1,ListNode head2){
        head1=reverse(head1);
        head2=reverse(head2);
        ListNode dummy=new ListNode(-1);
        int flag=0;
        while (head1!=null||head2!=null||flag!=0){
            int count=flag;
            if (head1!=null) count+=head1.val;
            if (head2!=null) count+=head2.val;
            flag=count/10;
            count=count%10;
            ListNode t=new ListNode(count);
            t.next=dummy.next;
            dummy.next=t;
        }
        return dummy.next;
    }
}

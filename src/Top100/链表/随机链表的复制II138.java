package Top100.链表;

import java.util.HashMap;
import java.util.Map;

public class 随机链表的复制II138 {
    public Node2 copyRandomList(Node2 head){
        Node2 dummy=new Node2(0);
        Node2 tail=dummy;
        Node2 p=head;
        //key是原的节点，value是对应的random指向的节点
        Map<Node2,Node2> map=new HashMap<>();
        while (p!=null){
            map.put(p,new Node2(p.val));
        }
        int index=0;
        while (p!=null){
            Node2 temp=new Node2(p.val);
            map.put(temp,temp);
            tail.next=temp;
            tail=temp;
            p=p.next;
        }
        p=head;
        while (p!=null){

        }
        return new Node2(2);
    }
}
class Node2{
    int val;
    Node2 next;
    Node2 random;
    public Node2(int val){
        this.val=val;
        this.next=null;
        this.random=null;
    }
}
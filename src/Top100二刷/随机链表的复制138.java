package Top100二刷;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 随机链表的复制138 {
    public Node copyRandomList(Node head) {
        //长度为n的链表，每个节点包含一个额外增加的随机指针random
        //构造这个列表的深拷贝
        Node dummy=new Node(0);
        Node tail=dummy;
        Node p=head;
        //设置了next的指针
        Map<Node ,Node> map=new HashMap<>(); //考虑构建原链表节点和新链表节点之间的映射关系
        while (p!=null){
            Node node=new Node(p.val);
            map.put(p,node); //构建原节点与新节点的映射关系
            tail.next=node;
            tail=node;
            p=p.next;
        }
        p=head;
        Node node;
        while (p!=null){
            //构建random
            map.get(p).random=map.get(p.random);
            p=p.next;
        }
        return dummy.next;
    }
    public Node copyRandomList2(Node head){
        //我们如何构造random的关系，使用hash映射关系

        Map<Node,Node> map=new HashMap<>(); //创建原节点和新节点之间的映射关系
        Node dummy=new Node(0);
        Node tail=dummy;
        Node p=head;
        while (p!=null){
            Node node=new Node(p.val);
            map.put(p,node); //建立映射关系
            tail.next=node;
            tail=node;
            p=p.next;
        }
        //构建random之间的关系
        p=head;
        while (p!=null){
            map.get(p).random=map.get(p.random);
            p=p.next;
        }
        return dummy.next;
    }
}
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
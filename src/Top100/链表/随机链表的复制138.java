package Top100.链表;

public class 随机链表的复制138 {
    public static void main(String[] args) {
        //随机链表的复制
    }
}
class Solution138 {
    public Node copyRandomList(Node head) {
        Node newHead=new Node(-1);
        Node p=newHead;
        //遍历旧链表，随机链表的复制
        while (head!=null){
            Node node = new Node(head.val);
            if (head.random!=null){

            }
            node.random=node;
            p.next=node;
        }
        return newHead;
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
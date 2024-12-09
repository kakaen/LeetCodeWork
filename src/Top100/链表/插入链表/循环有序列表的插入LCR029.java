package Top100.链表.插入链表;

import 代码随想录.链表.ListNode;

public class 循环有序列表的插入LCR029 {
    public static void main(String[] args) {

    }
}
class SolutionLCR029 {
    public Node insert(Node head, int insertVal) {
        if (head == null) {
            Node node = new Node(insertVal);
            node.next = node;
            head = node;
            return head;
        }
        Node node = new Node(insertVal); //待插入的节点
        Node preNode = head; //前驱节点
        Node sortNode = head.next; //待插入节点
        while (sortNode != head) {
            //查找到要插入的位置，直接退出
            if (preNode.val <= insertVal && sortNode.val >= insertVal) {
                break;
            }
            if (preNode.val > sortNode.val) {
                if (insertVal > preNode.val || insertVal < sortNode.val) {
                    break;
                }
            }
            preNode = sortNode;
            sortNode = sortNode.next;
        }
        node.next = sortNode;
        preNode.next = node;
        return head;
    }

    class Node {
        public int val;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    }
}

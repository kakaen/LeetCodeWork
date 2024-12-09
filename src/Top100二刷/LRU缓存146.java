package Top100二刷;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class LRU缓存146 {

}
//以正整数c为初始化,哈希表辅助双向链表来实现，双向链表按照被使用的顺序存储这些键值对，
//哈希表来定位，找出key在双向链表中的位置，将其插入到
class LRUCache {
    class DLinkedNode{
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
        public DLinkedNode(){}
        public DLinkedNode(int key,int value){
            this.key=key;
            this.value=value;
        }
    }
    //最近最少使用，首先是key，还有是最近的使用次数，根据使用次数来判断
    //使用哈希表来定位元素key在双向链表中的位置
    private static Map<Integer,DLinkedNode> cache=new HashMap<>();
    private static int capacity=0;
    private static int size;
    private DLinkedNode head,tail; //双向链表的头尾节点
    public LRUCache(int capacity) {
        size=0; //初始双向连边的长度为0；
        this.capacity=capacity;
        head=new DLinkedNode(); //使用伪头节点
        tail=new DLinkedNode(); //和伪尾节点
        head.next=tail;
        tail.prev=head;
    }

    public int get(int key) {
        DLinkedNode dLinkedNode = cache.get(key);
        if (dLinkedNode==null){
            return -1;
        }
        //存在，将该节点移动到头结点
        dLinkedNode.prev.next=dLinkedNode.next;
        dLinkedNode.next.prev=dLinkedNode.prev;
        dLinkedNode.prev=head;
        dLinkedNode.next=head.next;
        head.next.prev=dLinkedNode;
        head.next=dLinkedNode;
        return dLinkedNode.value;
    }
    //我们需要在O1级别中找到访问次数最少的哪个元素
    public void put(int key, int value) {
        //获取到该节点
        DLinkedNode node = cache.get(key);
        if (node==null){
            //如果key不存在，创建一个新节点并插入到对头
            DLinkedNode newNode=new DLinkedNode(key,value);
            //添加到hash表
            cache.put(key,newNode);
            addToHead(newNode);
            size++;
            //判断长度是否大于缓存容量
            if (size>capacity){
                //将队尾节点移除
                DLinkedNode tail=removeTail();
                cache.remove(tail.key);
                size--;
            }

        }else{
            node.value=value;
            //将该节点移动到头部
            node.prev.next=node.next;
            node.next.prev=node.prev;
            //插入到头部
            node.prev=head;
            node.next=head.next;
            head.next.prev=node;
            head.next=node;
        }

    }
    //添加一个元素到队列头部
    public void addToHead(DLinkedNode newNode){
        newNode.prev=head;
        newNode.next=head.next;
        head.next.prev=newNode;
        head.next=newNode;
    }
    //去除该尾节点
    public DLinkedNode removeTail(){
        DLinkedNode res=tail.prev;
        res.prev.next=res.next;
        res.next.prev=res.prev;
        return res; //返回之前的尾节点，一会要删除该元素
    }
}

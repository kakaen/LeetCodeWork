package Top100二刷;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LRUcache缓存相关 {
    public static void main(String[] args) {
        Map<Integer,Integer> map=new HashMap<>();
        new ConcurrentHashMap<>();
        Map<Integer, Integer> synchronizedMap = Collections.synchronizedMap(map);
    }
}
class LRUCache2 {

    //创建一个双向链表
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
    private Map<Integer,DLinkedNode> cache=new HashMap<>();
    private int size;
    private int capacity;
    private DLinkedNode head,tail;
    public LRUCache2(int capacity) {
        this.size=0;
        this.capacity=capacity;
        //使用伪头结点和伪尾节点
        this.head=new DLinkedNode();
        this.tail=new DLinkedNode();
        head.next=tail;
        tail.prev=head;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node==null){
            return -1;
        }
        //将该节点移动到头结点
        moveToHead(node);
        return node.value;
    }
    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node==null){
            DLinkedNode newNode = new DLinkedNode(key, value);
            //添加到哈希表
            cache.put(key,newNode);
            //添加到链表的头结点
            addToHead(newNode);
            size++;
            if (size>capacity){
                DLinkedNode tail = removeTail();
                //删除哈希表中对应的项
                cache.remove(tail.key);
                size--;
            }
        }else{
            node.value=value;
            moveToHead(node);
        }
    }
    public void moveToHead(DLinkedNode node){
        removeNode(node);
        addToHead(node);
    }
    //将节点添加到头结点
    public void addToHead(DLinkedNode node){
        node.prev=head;
        node.next=head.next;
        head.next.prev=node;
        head.next=node;
    }
    //去除节点。
    public void removeNode(DLinkedNode node){
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }
    //去除尾节点
    public DLinkedNode removeTail(){
        DLinkedNode res=tail.prev;
        removeNode(res);
        return res;
    }

}
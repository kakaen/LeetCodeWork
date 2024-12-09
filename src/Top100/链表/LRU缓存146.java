package Top100.链表;

import 代码随想录.链表.ListNode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LRU缓存146 {

}
class LRUCache{
    private Map<Integer,Integer> map=new HashMap<>();
    private int len=0; //记录当前缓存中的缓存数量
    private ListNode dummy; //指向缓存中的
    private ListNode tail;
    public LRUCache(int capacity){
        dummy=new ListNode(0);
        tail=dummy;
    }
    public int get(int key){
        //如果缓存中存在该数，则直接返回O(1)级，因此采用Map集合来存储
        if (map.containsKey(key)) return map.get(key);
        return -1;
    }
    public void put(int key,int value){

        //如果关键字存在，则变更其数据,并且调整缓存的最近是否使用的链表
        if (map.containsKey(key)){
            map.put(key,value);
        }else{
           //当前数据没有被缓存过，需要加入缓存，需要判断当前缓存是否已满
            //1.如果已满，则去除

        }
        //如何维护最近没有被使用过的键值对，
        // 使用链表，head--->tail。每新来一个元素tail将被去除
    }
}

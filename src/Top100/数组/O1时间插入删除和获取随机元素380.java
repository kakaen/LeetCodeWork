package Top100.数组;

import javax.jnlp.ClipboardService;
import java.util.*;

public class O1时间插入删除和获取随机元素380 {

}
class RandomizedSet {
    //变长数组+哈希表
    //变长数组可以在O(1)的时间内完成获取随机元素的操作
    //hash表可以在O(1)时间内完成插入和删除，但无法根据下标定位到特定元素，
    // 无法在O(1)的时间内完成随机元素的操作

    private Map<Integer,Integer> map;
    private Random random;
    //set集合的底层是什么，hashtable，根据值的hash值进行index的映射
    private List<Integer> nums;
    public RandomizedSet() {
        map=new HashMap<>(); //map存储<numValue,以及可变数组中的下标>;
        nums=new ArrayList<>();
        random=new Random();
    }
    //向集合中插入val值
    public boolean insert(int val) {
        //先使用hash表判断集合中是否存在该元素，不存在则向hash表和可变数组中都插入该元素
        boolean contains = map.containsKey(val);
        if (contains){
            return false;
        }
        //不存在该元素
        nums.add(val);
        map.put(val,nums.size());
        return true;
    }
    //移除元素val值,这里就是为什么要使用map存储元素下标了，否则无法实现O(1
    public boolean remove(int val) {
        if (map.containsKey(val)){
            int index=map.get(val);//获取待删除的元素下标
            int last=nums.get(nums.size()-1);
//            nums.remove(index); //nums的删除操作不是O(1)级别的。
            nums.set(index,last);
            map.put(last,index); //这个哈希表的index也需要进行修改
            nums.remove(nums.size()-1);
            // 因此我们将nums的最后一个元素放在index待删除下标，然后删除最后的下标
            map.remove(val);
            return true;
        }else{
            return false;
        }
    }
    //返回一个随机的元素,如何随机返回一个数呢？
    public int getRandom() {
        int i = random.nextInt(nums.size());
        return nums.get(i);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
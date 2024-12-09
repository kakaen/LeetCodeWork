package 二分查找提单;

import java.net.ContentHandler;
import java.net.Inet4Address;
import java.util.*;
public class 寻找比目标字母大的最小字母744 {
    public static void main(String[] args) {

        HashMap<Character, Integer> characterIntegerHashMap = new HashMap<>();
        Queue<Character> queue=new LinkedList<>();
        boolean add = queue.add('C');
        System.out.println(add);
        queue.offer('D');
        System.out.println(queue.poll());
        System.out.println(queue.peek());
        System.out.println("-----deque---的相关方法---");
        Deque<Character> deque=new LinkedList<>();
        deque.addFirst('C');
        deque.addFirst('D');
    }
}
class Solution744 {
    public char nextGreatestLetter(char[] letters, char target) {
        //数组按照非递减顺序排序
        //大于target的最小字符，就是找>target的字符
        int left=0,right=letters.length-1;
        while (left<right){
            int mid=left+(right-left)/2;
            if (letters[mid]<=target){
                left=mid+1;
            }else {
                right=mid-1;
            }
        }
        if (left<letters.length){
            return letters[left];
        }
        return letters[0];
    }
}
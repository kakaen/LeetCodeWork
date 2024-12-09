package 滑动窗口算法.不定长窗口.不定长求最大;

public class 每周种字符至少取K个2516 {
    public static void main(String[] args) {
        String s="aabaaaacaabc";
        int k=2;
        Solution2516 solution2516 = new Solution2516();
        System.out.println(solution2516.takeCharacters(s, k));
    }
}
class Solution2516 {
    public int takeCharacters(String s, int k) {
        //由abc组成的字符串s和一个非负整数k。每分钟可以取左侧
        int left=0;
        char[] arr=s.toCharArray();
        int[] numbers=new int[3];
        for (char c : arr) {
            numbers[c-'a']++;
        }
        if (numbers[0]<k||numbers[1]<k||numbers[2]<k){
            return -1;
        }
        int[] count=new int[3];
        int result=s.length()+1;
        //取走每种字符至少k个最少,反转思考是窗口中最多有number[i]-(char)('a'+i);
        for (int right=0;right<s.length();right++){
            count[arr[right]-'a']++;
            //如果窗口中有num
            while (count[0]>(numbers[0]-k)||count[1]>(numbers[1]-k)||count[2]>(numbers[2]-k)){
                //左指针向右进行偏移
                count[arr[left]-'a']--;
                left++;
            }
            //进行更新,c
            result=Math.min(result,s.length()-(right-left+1));
        }
        return result;
    }
    //方法二：双指针做法,i和j，从小到大
    public int takeCharacters2(String s,int k){
//        char[] chars=s.toCharArray();
//        int[] total=new int[3];
//        for (int i=0;i<chars.length;i++){
//            total[chars[i]-'a']++;
//        }
//        //计算总数
//        int ans=0;
//        for (int i=0;i<chars.length&&)
        return 0;
    }
}
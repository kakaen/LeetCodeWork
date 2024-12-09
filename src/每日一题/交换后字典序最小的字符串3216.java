package 每日一题;

public class 交换后字典序最小的字符串3216 {
    public static void main(String[] args) {
        交换后字典序最小的字符串3216 test = new 交换后字典序最小的字符串3216();
        System.out.println(test.getSmallestString("45320"));
        System.out.println(test.getSmallestString("001"));
    }
    public String getSmallestString(String s){
        //首先，找到字典序最小的是 nums[i]>nums[i+1].找到第一个该下标
        int n=s.length();
        int swap=-1;
        char[] chars = s.toCharArray();
        for (int i=0;i<n-1;i++){
           char x=chars[i];
           char y=chars[i+1];
           if (x>y&&(x-y)%2==0){
               chars[i]=y;
               chars[i+1]=x;
               break;
           }
        }
        return new String(chars);
    }
}

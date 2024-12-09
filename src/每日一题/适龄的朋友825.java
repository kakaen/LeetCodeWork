package 每日一题;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class 适龄的朋友825 {
    //暴力解法，会超时。
    public int numFriendRequests(int[] ages){
        int n=ages.length;
        //只有大的向小的发送消息
        Arrays.sort(ages);
        int count=0;
        //i向j发送消息
        for (int i=n-1;i>=0;i--){
            for (int j=i-1;j>=0;j--){
                if ((ages[j]>0.5*ages[i]+7)&&(ages[j]<=ages[i])&&(ages[j]<=100||ages[i]>=100)){
                    count++;
                }
                if ((ages[i]>0.5*ages[j]+7)&&(ages[i]<=ages[j])&&(ages[i]<=100||ages[j]>=100)){
                    count++;
                }

            }
        }
        return count;
    }
    //只有大的向小(相等)的发送消息
    public int numFriendRequests2(int[] ages){
        Arrays.sort(ages);
        int n=ages.length;
        int count=0;
        //根据前两条，发送方和接收方的年龄必须都大于14
        //当x>=15时，满足要求的接收方的年龄为（0.5*x+7,x]
        //(x大于等于100)
        int left=0,right=0;
        //遍历发送者，age的接收者的范围为(0.5*x+7,age]，由于age越大，则age的接收者也越大，因此可以使用滑动窗口解决
        for (int age:ages){
            if (age<15) continue;
            //维护左边界
            while (ages[left]<=0.5*age+7){
                left++;
            }
            //维护右边界
            while (right+1<n&&ages[right+1]==age){
                right++;
            }
            count+=right-left;
        }
        return count;
    }

    public static void main(String[] args) {
        适龄的朋友825 test = new 适龄的朋友825();
        System.out.println(test.numFriendRequests2(new int[]{16, 16}));
        System.out.println(test.numFriendRequests2(new int[]{16, 17, 18}));
        System.out.println(test.numFriendRequests2(new int[]{20, 30, 100, 110, 120}));
    }
}

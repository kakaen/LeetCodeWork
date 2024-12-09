package 难度训练;

public class 统计位数为偶数的数字1295 {
    public static void main(String[] args) {

    }
}
class Solution1295{
    public int findNumbers(int[] nums){
        int count=0;
        //num (1~10^5) [10,100),[1000,10000)
        for (int num:nums){
            if (num>=10&&num<100||num>=1000&&num<10000||num==100000) count++;
        }
        return count;
    }
}
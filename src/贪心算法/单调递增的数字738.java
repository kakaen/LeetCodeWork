package 贪心算法;

public class 单调递增的数字738 {
    public static void main(String[] args) {
        Solution738 solution738 = new Solution738();
        System.out.println(solution738.monotoneIncreasingDigits(332));
    }
}
class Solution738{
    public int monotoneIncreasingDigits(int n) {
        //如果n为单调递增的数字或小于10，则直接返回其本身
        if (n<10||isAddNumber(n)) return n;
        //把非递增数调整为递增数。从后往前调整。
        String s=String.valueOf(n);
        StringBuilder stringBuilder=new StringBuilder();
        char[] charArray = s.toCharArray();
        int[] intArray=new int[charArray.length];
        for (int i=0;i<charArray.length;i++){
            intArray[i]=charArray[i]-'0';
        }
        int start=intArray.length; //
        for (int i=intArray.length-1;i>0;i--){
            if (intArray[i]<intArray[i-1]){
                intArray[i-1]--;
                //记录需要修改为9的值
                start=i;
            }
        }
        for (int i=start;i<intArray.length;i++){
            intArray[i]=9;
        }
        int result=0;
        for (int i=0;i<intArray.length;i++){
            result=result*10+intArray[i];
        }
        return result;
    }
    public boolean isAddNumber(int n){
        String number = String.valueOf(n);
        for (int i=1;i<number.length();i++){
            if (number.charAt(i)<number.charAt(i-1)){
                return false;
            }
        }
        return true;
    }
}

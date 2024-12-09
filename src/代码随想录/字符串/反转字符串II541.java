package 代码随想录.字符串;

public class 反转字符串II541 {
    public static void main(String[] args) {

    }

}
class Solution {
    public String reverseStr(String s, int k) {
        int n=s.length();
        char[] arr=s.toCharArray();
        for (int i=0;i<n;i+=2*k){
            reverse(arr,i,Math.min(i+k,n)-1);
        }
        return new String(arr);
    }
    public void reverse(char[] arr,int left,int right){
        char temp;
        while (left<right){
            temp=arr[left];
            arr[left]=arr[right];
            arr[right]=temp;
        }

    }
}

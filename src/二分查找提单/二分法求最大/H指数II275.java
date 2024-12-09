package 二分查找提单.二分法求最大;

public class H指数II275 {
    public static void main(String[] args) {
        Solution275 solution275 = new Solution275();
        int[] h={1,2,100};
        System.out.println(solution275.hIndex(h));
    }
}
class Solution275{
    public int hIndex(int[] citations) {
        //citations已经按照升序排列了，表示引用次数
        int left=0,right=citations[citations.length-1];
        int result=0;
        while (left<=right){
            int mid=left+(right-left)/2; //表示引用次数
            //如果当前值满足，则继续往后找，mid表示引用次数
            if (check(citations,mid)){
                left=mid+1;
                result=mid;
            }else {
                right=mid-1;
            }
        }
        return result;
    }
    public boolean check(int[] citations,int mid){
        //mid为引用次数
        int n=citations.length;
        for (int i=0;i<n;i++){
            //找到第一个引用数大于等于mid的下标
            if (citations[i]>=mid){
                if ((n-i)>=mid){
                    return true;
                }else {
                    return false;
                }
            }
        }
        return false;
    }
}

package 代码随想录.数组;

import java.util.Arrays;

public class H指数274 {
    public static void main(String[] args) {
        H指数274 htest = new H指数274();
        int[] ci1=new int[]{3,0,6,1,5};
        int[] ci=new int[]{1,3,1};
        int[] ci2=new int[]{100};
        System.out.println(htest.hIndex(ci2));
    }
    public int hIndex(int[] citations){
        //至少有h篇的文章的引用大于等于h的。这说明h一定小于等于n
        int n=citations.length; //记录文章的总数为n.
        int res=-1;
        Arrays.sort(citations);
        for (int i=0;i<n;i++){
            //i就是待选的h
            int h=i+1;
            if (citations[n-h]>=h){
                res=Math.max(res,h);
            }
        }
        return res;
    }
    //使用计数排序,求一个最大的h，使得数组中至少有h个数都大于等于h
    public int hIndex2(int[] citations){
        int n=citations.length;
        int[] cnt=new int[n+1]; //cnt[i]表示引用次数大于等于i的文章个数
        //cnt[i];表示引用次数大于等于i的文章个数
        for (int c:citations){
            cnt[Math.min(c,n)]++;
        }
        int count=0;
        for (int i=n;i>=0;i--){
            //i表示h指数
            count+=cnt[i];
            if (count>=i) return i;
        }
        return 0;
    }
}

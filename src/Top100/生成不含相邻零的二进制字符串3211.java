package Top100;

import java.util.ArrayList;
import java.util.List;

public class 生成不含相邻零的二进制字符串3211 {
    public static void main(String[] args) {

    }
    public List<String> validStrings(int n){
        //返回所有长度为n的有效子串
        List<String> res=new ArrayList<>();
        char[] path=new char[n];
        tackTracking(res,path,0,n);
        return res;
    }
    public void tackTracking(List<String> res,char[] path,int start,int n){
        if (start==n){
            res.add(new String(path));
            return;
        }
       //填充1.
        path[start]='1';
        tackTracking(res,path,start+1,n);
        //填充0，这里就是单一层进行循环的操作
        if (start==0||path[start-1]=='1'){
            path[start]='0'; //直接覆盖
            tackTracking(res,path,start+1,n);
        }
    }
}

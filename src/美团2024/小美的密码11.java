package 美团2024;

import java.util.*;

public class 小美的密码11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();

        String pass=scanner.next();
        String[] strs=new String[n];
        scanner.nextLine();
        for (int i=0;i<n;i++){
            strs[i]=scanner.next();
        }
        function(strs,pass);
    }
    public static void function(String[] strs,String pass){
        int passLen=pass.length(); //获取到密码的长度。
        //先去重
        Set<String> set=new HashSet<>();
        for (String str:strs){
            set.add(str);
        }
        //将长度映射到数组中
        int[] tab=new int[passLen+1];
        for (String str:set){
            if (str.length()>passLen) continue;
            tab[str.length()]++;
        }
        System.out.println(Arrays.toString(tab));
        int res=0;
        for (int i=0;i<passLen;i++){
            res+=tab[i];
        }
        int min=res+1;
        int max=res+tab[passLen];
        System.out.println(min+" "+max);
    }
}

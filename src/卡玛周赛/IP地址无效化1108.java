package 卡玛周赛;

import java.util.Scanner;

public class IP地址无效化1108 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String ipStr=scanner.nextLine();
        solution(ipStr);
    }
    public static void solution(String ip){
        StringBuilder builder=new StringBuilder();
        for (int i = 0; i < ip.length(); i++) {
            if (ip.charAt(i)=='.'){
                builder.append("[.]");
            }else {
                builder.append(ip.charAt(i));
            }
        }
        System.out.println(builder.toString());
    }
}

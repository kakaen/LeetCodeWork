package Top100.数组;

public class 最长公共前缀14 {
    public static void main(String[] args) {
        最长公共前缀14 test = new 最长公共前缀14();
        String[] str=new String[]{"flower","flow","flight"};
        String[] str2=new String[]{"dog","racecar","car"};
        System.out.println(test.longestCommPrefix2(str));
        System.out.println(test.longestCommPrefix2(str2));
    }
    public String longestCommonPrefix(String[] str){
        StringBuilder builder=new StringBuilder();
        for (int i=0;;i++) {
            char ch=str[0].charAt(i);
            int j=1;
            for (j = 1; j < str.length; j++) {
                if (ch!=str[j].charAt(i)) break;

            }
            if (j<str.length) break;
            builder.append(str[i].charAt(i));
        }
        System.out.println(builder.length());
        String nu="";
        return builder.length()==0?nu:builder.toString();
    }
    //暴力算法
    public String longestCommPrefix2(String[] strs){
        StringBuilder builder=new StringBuilder();
        if (strs.length==1) return strs[0];
        //来遍历单个字符串的长度的
        for (int j=0;;j++){
            char ch;
            if (strs[0].isEmpty()){
                break;
            }else{
                ch=strs[0].charAt(j);
            }
            int i=0;
            for (i=0;i<strs.length;i++){
                if (strs[i].isEmpty()) break;

                if (ch!=strs[i].charAt(j)) break;
            }
            if (i<strs.length) break;
            builder.append(ch);
        }

        return builder.toString();
    }
}

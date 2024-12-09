package Top100.数组;

public class 罗马数字转整数13 {
    public static void main(String[] args) {
        罗马数字转整数13 test = new 罗马数字转整数13();
        System.out.println(test.romanToInt("MCMXCIV"));
        System.out.println(test.romanToInt("IX"));
        System.out.println(test.romanToInt("LVIII"));
    }
    public int romanToInt(String s){
        char[] chars=s.toCharArray();
        int n=chars.length;
        int res=0;
        //小的数字写在大的数字的右边。特殊IV,IX,XL,XC,CD,CM
        for (int i=0;i<n;i++){
            if (chars[i]!='I'&&chars[i]!='X'&&chars[i]!='C'){
                res+=maping(chars[i]);
            } else if (i<n-1&&(maping(chars[i+1])==maping(chars[i])*5||maping(chars[i+1])==maping(chars[i])*10)) {
                //如果第i个元素是特殊的类型，则需要查看下一个
                res+=maping(chars[i+1])-maping(chars[i]);
                i++;
            }else{
                res+=maping(chars[i]);
            }
        }
        return res;
    }
    //将罗马数字映射为数字类型
    public int maping(char ch){
        switch (ch){
            case 'I':return 1;
            case 'V':return 5;
            case 'X':return 10;
            case 'L':return 50;
            case 'C':return 100;
            case 'D':return 500;
            case 'M':return 1000;
            default:return 0;
        }
    }
}

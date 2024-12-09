package Top100.数组;

public class 最后一个单词的长度58 {
    public static void main(String[] args) {
        最后一个单词的长度58 test = new 最后一个单词的长度58();
        System.out.println(test.lengthOfLastWord("Hello World"));
        System.out.println(test.lengthOfLastWord("  fly  me  to the moon  "));

    }
    public int lengthOfLastWord(String s){
        //空格隔开
        int length=0;
        int n=s.length();
        char[] chars=s.toCharArray();
        int right=n-1;
        //right指向最后的
        while (right>=0&&chars[right]==' '){
            right--;
        }
        while (right>=0&&chars[right]!=' '){
            right--;
            length++;
        }
        return length;
    }
}

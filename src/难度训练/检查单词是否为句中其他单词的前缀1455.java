package 难度训练;

public class 检查单词是否为句中其他单词的前缀1455 {
    public static void main(String[] args) {

    }
}
class Solution1455{
    public int isPrefixOfWord(String sentence,String searchWord){
        String[] strings = sentence.split(" ");
        int res=-1;
        for (int i = 0; i < strings.length; i++) {
            if (isPrefix(strings[i],searchWord)) return i;
        }
        return res;
    }
    public boolean isPrefix(String str,String sub){
        if (str.length()<sub.length()) return false;
        int i=0;
        while (i<str.length()){
            if (str.charAt(i)!=sub.charAt(i)) return false;
            i++;
        }
        return true;
    }
}

package Top100.双指针;

public class 验证回文串125 {
    public static void main(String[] args) {
        验证回文串125 test = new 验证回文串125();
        System.out.println(test.isPalindrome("A man, a plan, a canal: Panama"));
    }
    public boolean isPalindrome(String s){
        int left=0,right=s.length()-1;
        while (left<right){
            //找到第一个为字母的
            while (left<right&&!Character.isLetterOrDigit(s.charAt(left))){
                left++;
            }
            //如果不是LetterOrDigit的话
            while (left<right&&!Character.isLetterOrDigit(s.charAt(right))){
                right--;
            }
            if (left<right){
                if (Character.toLowerCase(s.charAt(left))!=Character.toLowerCase(s.charAt(right))){
                    return false;
                }
            }
            left++;
            right--;
        }
        return true;
    }
}

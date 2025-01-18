package Top100二刷.二分查找;

public class 寻找比目标字母大的最小字符744 {
    public char nextGreatestLetter(char[] letters,char target){
        //非递减，就不是严格递增，返回letters中大于target的最小字符
        int l=0,r=letters.length-1;
        while (l<=r){
            int m=l+(r-l)/2;
            if (letters[m]<=target){
                l=m+1;
            }else{
                r=m-1;
            }
        }
        if (l==letters.length||letters[l]<=target) return letters[0];
        return letters[l];
    }

    public static void main(String[] args) {
        寻找比目标字母大的最小字符744 test = new 寻找比目标字母大的最小字符744();
        System.out.println(test.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'a'));
        System.out.println(test.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'c'));
        System.out.println(test.nextGreatestLetter(new char[]{'x', 'x', 'y','y'}, 'z'));
    }
}

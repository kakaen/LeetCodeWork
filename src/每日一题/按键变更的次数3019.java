package 每日一题;

public class 按键变更的次数3019 {
    public static void main(String[] args) {
        按键变更的次数3019 test = new 按键变更的次数3019();
        System.out.println(test.countKeyChanges("AaAaAaaA"));
    }
    public int countKeyChanges(String s){
        int count=0;
        for (int i=1;i<s.length();i++){

            if (Math.abs(s.charAt(i)-s.charAt(i-1))==0||Math.abs(s.charAt(i)-s.charAt(i-1))==32){
                continue;
            }
            count++;
        }
        return count;
    }
}

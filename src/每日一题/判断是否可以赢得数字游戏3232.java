package 每日一题;

public class 判断是否可以赢得数字游戏3232 {
    public static void main(String[] args) {
        判断是否可以赢得数字游戏3232 test = new 判断是否可以赢得数字游戏3232();
        System.out.println(test.canAliceWin(new int[]{1, 2, 3, 4, 5, 14}));
        System.out.println(test.canAliceWin(new int[]{1, 2, 3, 4, 10}));
    }
    public boolean canAliceWin(int[] nums){
        //从nums中选择所有个位数或所有两位数，剩余数字归Bob所有
        int signleCount=0;
        int doubleCount=0;
        for (int num:nums){
            if (num<10){
                signleCount+=num;
            }else{
                doubleCount+=num;
            }
        }
        return signleCount==doubleCount?false:true;
    }
}

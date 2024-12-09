package Top100.数组;

public class 求出出现两次数字的XOR值3158 {
    public static void main(String[] args) {
        求出出现两次数字的XOR值3158 test = new 求出出现两次数字的XOR值3158();
        System.out.println(test.duplicateNumbersXOR(new int[]{1, 2, 3}));
        System.out.println(test.duplicateNumbersXOR(new int[]{1, 2, 2, 1}));
    }
    public int duplicateNumbersXOR(int[] nums){
        //将所有出现两次的数字按位XOR(亦或)
        int count=0;
        int[] hash=new int[51];
        for (int i=0;i<nums.length;i++){
            hash[nums[i]]++;
        }
        for (int i=1;i<=50;i++){
            if (hash[i]==2){
              count=count^i;
            }
        }
        return count;
    }
}

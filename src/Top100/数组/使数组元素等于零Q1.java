package Top100.数组;

public class 使数组元素等于零Q1 {
    public static void main(String[] args) {
        使数组元素等于零Q1 tet = new 使数组元素等于零Q1();
        System.out.println(tet.countValidSelections(new int[]{1, 0, 2, 0, 3}));
        System.out.println(tet.countValidSelections(new int[]{16,13,10,0,0,0,10,6,7,8,7}));
    }
    public int countValidSelections(int[] nums) {
        int n = nums.length;
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        //求出是否存在total的一半的下标
        //如果是奇数的话则下标必须是值为一
        //如果是偶数的话，下标值必须是0
        int x = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            x += nums[i];
            if (x == total / 2) {
                if (total % 2 == 0) {
                    //如果和为偶数的话，出发点必须是0
                    //判断下标i+1是否为0
                    while (i + 1 < n && nums[i + 1] == 0) {
                        ans += 2;
                        i++;
                    }
                    return ans;
                } else {
                    //total不为偶数，为奇数
                    while (i + 1 < n && nums[i + 1] == 0) {
                        ans++;
                        i++;
                    }
                    if (i < n && nums[i] == 1) {
                        ans += 2;
                    } else {
                        return ans;

                    }
                }
            }
        }
        return ans;
    }
}

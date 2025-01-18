package Top100二刷.二分查找.二分法求最小;

import java.util.Arrays;

public class 移山所需要的最少秒数3296 {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        int maxT = 0;
        //每个工人最多花费m秒
        for (int t : workerTimes) {
            maxT = Math.max(maxT, t);
        }
        int n = workerTimes.length;
        //表示平均每个人降低山所需要的次数，向上取整
        int h = (mountainHeight + n - 1) / n;
        long left = 0;
        long right = (long) maxT * h * (h + 1) / 2;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (!isRemove(mid, mountainHeight, workerTimes)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public boolean isRemove(long time, int mountainHeight, int[] workerTimes) {
        for (int workTime : workerTimes) {
            mountainHeight -= (int) (Math.sqrt(time / workTime * 8 + 1) - 1);
            if (mountainHeight <= 0) {
                return true;
            }
        }
        return false;
    }
}

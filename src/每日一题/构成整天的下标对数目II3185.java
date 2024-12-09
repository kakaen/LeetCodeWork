package 每日一题;

public class 构成整天的下标对数目II3185 {
    public long countCompleteDayPairs(int[] hours){
        long[] hashTable=new long[24]; //0,24
        long pairCount=0;
        for (int hour:hours){
            hour=hour%24;
            pairCount+=hashTable[(24-hour)%24];
            hashTable[hour]++;
        }
        return pairCount;
    }
}

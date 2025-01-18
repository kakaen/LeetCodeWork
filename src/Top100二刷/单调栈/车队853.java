package Top100二刷.单调栈;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;

public class 车队853 {
    public static void main(String[] args) {
        车队853 test = new 车队853();
        int target=12;
        int target1=10;
        int target2=100;
        int[] position=new int[]{10,8,0,5,3};
        int[] position1=new int[]{0,4,2};
        int[] position2=new int[]{6,8};
        int[] speed=new int[]{2,4,1,1,3};
        int[] speed1=new int[]{2,1,3};
        int[] speed2=new int[]{3,2};
       System.out.println(test.carFleet2(target, position, speed));
        System.out.println(test.carFleet2(target1, position1, speed1));
        System.out.println(test.carFleet2(10, position2, speed2));
    }

    public int carFleet2(int target, int[] position, int[] speed) {
        int n=position.length;
        Car[] cars=new Car[n];
        for (int i=0;i<n;i++){
            cars[i]=new Car(position[i],(double)(target-position[i])/speed[i]);
        }
        //将车按照位置进行递减排序
        Arrays.sort(cars,(a,b)->{return b.position-a.position;});
        //从头遍历
        int ans=1;
        for (int i=1;i<n;i++){
            //如果后面的车辆追上了前面的车辆
            if (cars[i].time<=cars[i-1].time){
                cars[i]=cars[i-1];
            }else{
                ans++;
            }
        }
        return ans;
    }
    class Car{
        int position;
        double time;
        Car(int position,double time){
            this.position=position;
            this.time=time;
        }
    }
    public int carFleet(int target, int[] position, int[] speed) {
        //把position按照从大到小进行排序
//        Arrays.sort(position);
        int n=position.length;
        Pair[] pairs=new Pair[n];
        for (int i=0;i<n;i++){
            pairs[i]=new Pair(position[i],speed[i]);
        }
        //按照位置进行排序，在前面的
        Arrays.sort(pairs, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o2.pos-o1.pos;
            }
        });
        //遍历，计算所需时间，如果后面的小于前面的时间，则会追赶上
        //单调栈，记录所需的时间，顺序是单增的
        Deque<Float> stack=new ArrayDeque<>();
        for (Pair p:pairs){
            float time=(target-p.pos)/(float)p.speed;
            if (!stack.isEmpty()&&time<=stack.peek()){
                continue;
            }else{
                stack.push(time);
            }
        }

        return stack.size();
    }
    static class Pair {
        int pos;
        int speed;
        public Pair(int pos,int speed){
            this.pos=pos;
            this.speed=speed;
        }


    }
}

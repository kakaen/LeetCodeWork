package 难度训练;

import java.util.Deque;
import java.util.LinkedList;

public class 无法吃午餐的学生数量1700 {
    public static void main(String[] args) {
        Solution1700 solution1700 = new Solution1700();
        int[] students={1,1,1,0,0,1};
        int[] sandwiches={1,0,0,0,1,1};
        System.out.println(solution1700.countStudents(students, sandwiches));
    }
}
class Solution1700{
    public int countStudents(int[] students,int[] sandwiches){
        //
        Deque<Integer> studentQueue=new LinkedList<>();
        for(int student:students){
            studentQueue.offerLast(student);
        }
        //sandwiches(0,1).student也是(0,1)
        int i=0; //三明治的下标
        while (i<sandwiches.length){
            if(allNoLike(studentQueue,sandwiches[i])) break;
            if (studentQueue.getFirst()==sandwiches[i]){
                i++;
                studentQueue.pollFirst();
            }else{
                //队列首元素跑到队列尾部
                studentQueue.offerLast(studentQueue.pollFirst());
            }

        }
        return studentQueue.size();
    }
    public boolean allNoLike(Deque<Integer> deque,int i){
        Deque<Integer> tmpQueue=new LinkedList<>(deque);
        while (!tmpQueue.isEmpty()){
            Integer i1 = tmpQueue.pollFirst();
            if (i1==i) return false;
        }
        return true;
    }
    public int countStudents2(int[] students,int[] sandwiches){
        int s0=0,s1=0; //记录队列中喜欢吃0的人数和喜欢吃1的人数
        for (int student:students){
            if (student==0){
                s0++;
            }else{
                s1++;
            }
        }
        for (int sanwiche:sandwiches){
            if (sanwiche==0){
                if (s0==0) break;
                s0--;
            }else {
                if(s1==0) break;
                s1--;
            }
        }
        return s0+s1;
    }
}

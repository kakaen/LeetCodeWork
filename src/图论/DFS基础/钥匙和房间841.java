package 图论.DFS基础;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class 钥匙和房间841 {
    public static void main(String[] args) {
        钥匙和房间841 test = new 钥匙和房间841();
        List<List<Integer>> rooms = new ArrayList<>();
        List<Integer> r0 = new ArrayList<>();
        r0.add(1);
        List<Integer> r1 = new ArrayList<>();
        r1.add(2);
        List<Integer> r2 = new ArrayList<>();
        r2.add(3);
        List<Integer> r3 = new ArrayList<>();
        rooms.add(r0);
        rooms.add(r1);
        rooms.add(r2);
        rooms.add(r3);
        System.out.println(test.canVisitAllRooms(rooms));
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n=rooms.size();
        return true;
    }
}
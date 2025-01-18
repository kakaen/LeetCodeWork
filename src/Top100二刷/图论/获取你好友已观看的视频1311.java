package Top100二刷.图论;

import java.util.*;

public class 获取你好友已观看的视频1311 {
    public static void main(String[] args) {
        获取你好友已观看的视频1311 test = new 获取你好友已观看的视频1311();
        List<List<String>> watchedVideos=new ArrayList<>();
        List<String> w1=new ArrayList<>(); w1.add("A");w1.add("B");
        List<String> w2=new ArrayList<>(); w2.add("C");
        List<String> w3=new ArrayList<>(); w3.add("B"); w3.add("C");
        List<String> w4=new ArrayList<>(); w4.add("D");
        watchedVideos.add(w1);
        watchedVideos.add(w2);
        watchedVideos.add(w3);
        watchedVideos.add(w4);
        int[][] friends=new int[][]{{1,2},{0,3},{0,3},{1,2}};
        List<String> strings = test.watchedVideosByFriends(watchedVideos, friends, 0, 1);
        List<String> strings2 = test.watchedVideosByFriends(watchedVideos, friends, 0, 2);
        System.out.println(strings2);
        System.out.println(strings);
    }
    //遍历图结构获取到level等级的iD
    public List<Integer> BFS(int id,int level,List<Integer>[] edges){
        Deque<Integer> deque=new ArrayDeque<>();
        int count=0;
        Set<Integer> visited=new HashSet<>();
        visited.add(id);
        List<Integer> userIds=new ArrayList<>();
        deque.add(id); //从0出发
        while (!deque.isEmpty()){
            int size=deque.size();
            for (int i=0;i<size;i++){
                int s=deque.poll();
                for (int e:edges[s]){
                    if (!visited.contains(e)){
                        deque.add(e);
                        visited.add(e);
                    }
                }
            }
            count++;
            if (count==level){
                userIds=new ArrayList<>(deque);
                break;
            }
        }
        return userIds;
    }
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        //构造用户朋友ID网络
        int n=friends.length;
        List<Integer>[] edges=new List[n];
        for (int i=0;i<n;i++){
            edges[i]=new ArrayList<>();
        }
        for (int i=0;i<n;i++){
            for (int f:friends[i]){
                edges[i].add(f);
            }
        }
        List<String> res=new ArrayList<>();
        //如果是leve=1，那直接查询friends[i]的
        List<Integer> levelIds=BFS(level,1,null);


        //求所有视频的频率
        Map<String,Integer> map=new HashMap<>();
        for (int i:levelIds){
            for (String video:watchedVideos.get(i)){
                map.put(video,map.getOrDefault(video,0)+1);
            }
        }
        List<Map.Entry<String,Integer>> mapList=new ArrayList<>(map.entrySet());
        Collections.sort(mapList,new Comparator<Map.Entry<String,Integer>>(){
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o1.getValue()==o2.getValue()) return o1.getKey().compareTo(o2.getKey());
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        for (Map.Entry<String, Integer> entry : mapList) {
            res.add(entry.getKey());
        }
        return res;
    }
}

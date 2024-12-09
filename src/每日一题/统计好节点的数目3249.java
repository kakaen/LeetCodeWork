package 每日一题;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.HashMap;
import java.util.Map;

public class 统计好节点的数目3249 {
    public int countGoodNodes(int[][] edges){
        Map<Integer,Integer> map=new HashMap<>();
        for (int[] edge:edges){
            map.put(edge[0],edge[1]);
        }
        //一个节点的所有子节点为根的子树
        // (所有子节点为根的子树包含的节点数一样)
        dfs(edges,0,map);
        return 0;
    }
    //使用dfs
    public void dfs(int[][] edge,int start,Map<Integer,Integer> map){
        if (!map.containsKey(edge[start][1])){
            return;
        }
    }
}

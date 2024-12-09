package Top100二刷.前缀和题目;

import 代码随想录.二叉树理论.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class 路径总和III437 {
    private int ans=0;
    public int pathSum(TreeNode root,int targetSum){
        //采用前缀和来记录之前节点的和
        Map<Integer,Integer> map=new HashMap<>();
        //通过前序遍历
        map.put(0,1);
        dfs(root,0,targetSum,map);
        return ans;
    }
    public void dfs(TreeNode root,int s,int target,Map<Integer,Integer> map){
        if (root==null) return;
        s+=root.val;
        ans+=map.getOrDefault(s-target,0);
        map.put(s,map.getOrDefault(s,0)+1);
        dfs(root.left,s,target,map);
        dfs(root.right,s,target,map);
        //恢复现场
        if (map.get(s)==1){
            map.remove(s);
        }else{
            map.put(s,map.get(s)-1);
        }
    }
}

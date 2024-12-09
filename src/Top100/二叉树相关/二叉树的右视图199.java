package Top100.二叉树相关;

import 代码随想录.二叉树理论.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class 二叉树的右视图199 {
    public static void main(String[] args) {

    }
}
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        Deque<TreeNode> queue=new LinkedList<>();
        if (root==null) return result;
        queue.offerLast(root); //根节点
        while (!queue.isEmpty()){
            int count=queue.size();
            while (count>0){
                TreeNode tmp=queue.pollFirst();
                if (tmp.left!=null) queue.offerLast(tmp.left);
                if (tmp.right!=null) queue.offerLast(tmp.right);
                if (count==1) result.add(tmp.val);
                count--;
            }
        }
        return result;
    }
    //使用DFS进行查询
    public List<Integer> rightSideView2(TreeNode root){
        List<Integer> result=new ArrayList<>();
        dfs(root,0,result);
        return result;
    }
    public void dfs(TreeNode node,int depth,List<Integer> result){
       if (node==null) return;
       if (depth==result.size()){
           result.add(node.val);
       }
       dfs(node.right,depth+1,result);
       dfs(node.left,depth+1,result);
    }
}

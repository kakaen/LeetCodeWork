package 代码随想录.二叉树理论.DFS相关题目;

import 代码随想录.二叉树理论.TreeNode;

public class 路径总和112 {
    public static void main(String[] args) {

    }
}
class Solution112{
    public boolean isTrue=false;
    public boolean hasPathSum(TreeNode root,int targetSum){
        //就是使用深度遍历，前序遍历可以
        dfs(root,targetSum);
        return isTrue;
    }
    public void dfs(TreeNode node,int target){
        if (node==null) return;
        if (node.left==null&&node.right==null){
            if (node.val==target) isTrue=true;
        }

        dfs(node.left,target-node.val);
        dfs(node.right,target- node.val);
    }
    public boolean hasPathSum2(TreeNode root,int targetSum){
        if (root==null) return false;
        if (root.left==root.right){
            return root.val==targetSum;
        }
        return (hasPathSum(root.left,targetSum-root.val)||hasPathSum(root.right,targetSum-root.val));
    }
    //使用回溯法进行
    public boolean hasPathSum3(TreeNode root,int targetSum){
        return true;
    }
    public void backTracking(TreeNode node,int target,int path){
        if (node==null) return;
        if (node.left==null&&node.right==null&&target==path){
            isTrue=true;
            return;
        }
        if (node.left!=null){
            return;
        }
    }
}

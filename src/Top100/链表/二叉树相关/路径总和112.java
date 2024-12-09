package Top100.链表.二叉树相关;

import 代码随想录.二叉树理论.TreeNode;

public class 路径总和112 {
    public boolean hasPathSum(TreeNode root,int targetSum){
        if (root==null) return false;
        if (root.left==null&&root.right==null){
            return targetSum==root.val;
        }
        return hasPathSum(root.left,targetSum-root.val)||hasPathSum(root.right,targetSum-root.val);
    }
    public boolean hasPathSum2(TreeNode root,int targetSum){
        return backTracking(root,0,targetSum);
    }
    public boolean backTracking(TreeNode root,int cur,int sum){
        if (root==null) return false;
        cur+=root.val;
        if (root.left==null&&root.right==null){
            return cur==sum;
        }else{
            return backTracking(root.left,cur,sum)||backTracking(root.right,cur,sum);
        }
    }
}

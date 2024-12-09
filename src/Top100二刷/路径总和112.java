package Top100二刷;

import 代码随想录.二叉树理论.TreeNode;

public class 路径总和112 {
    public int sum=0;
    public boolean hasPathSum(TreeNode root, int targetSum){
        if (root==null) return false;
        targetSum-=root.val;
        if (root.left==root.right) {
            return targetSum == 0;
        }
        return hasPathSum(root.left,targetSum)||hasPathSum(root.right,targetSum);
    }
}

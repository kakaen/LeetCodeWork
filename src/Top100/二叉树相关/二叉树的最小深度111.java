package Top100.二叉树相关;

import 代码随想录.二叉树理论.TreeNode;

public class 二叉树的最小深度111 {
    public static void main(String[] args) {

    }
    public int minDepth(TreeNode root){
        if (root==null) return 0;
        if (root.left==null&&root.right==null) return 0;
        return Math.min(minDepth(root.left),minDepth(root.right))+1;
    }
}

package Top100二刷.二叉树;

import 代码随想录.二叉树理论.TreeNode;

public class 二叉树的直径543 {
    public static void main(String[] args) {

    }

    public int ans=0;
    public int diameterOfBinaryTree(TreeNode root){
        ans=1;
        depth(root);
        return ans-1;
    }
    //求node节点为根节点对应的最大深度
    public int depth(TreeNode node){
        if (node==null) return 0;
        int lDepth=depth(node.left); //左子树的最大深度
        int rDepth=depth(node.right); //右子树的最大深度
        ans=Math.max(ans,lDepth+rDepth+1); //以node节点为根节点的左右子树长度之和。
        return Math.max(lDepth,rDepth)+1;
    }

}

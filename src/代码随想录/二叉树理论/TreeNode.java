package 代码随想录.二叉树理论;

import sun.reflect.generics.tree.Tree;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {}
    public TreeNode(int val){this.val=val;}
    public TreeNode(int val, TreeNode left,TreeNode right){
        this.val=val;
        this.left=left;
        this.right=right;
    }
}

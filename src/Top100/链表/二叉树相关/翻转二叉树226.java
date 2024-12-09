package Top100.链表.二叉树相关;

import 代码随想录.二叉树理论.TreeNode;

public class 翻转二叉树226 {
    public TreeNode invertTree(TreeNode root){
        if (root==null) return root;
        invertTree(root.left);
        invertTree(root.right);
        //执行翻转的代码
        TreeNode node=root.left;
        root.left=root.right;
        root.right=node;
        return root;
    }
}

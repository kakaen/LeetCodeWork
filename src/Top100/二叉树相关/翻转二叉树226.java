package Top100.二叉树相关;

import sun.reflect.generics.tree.Tree;
import 代码随想录.二叉树理论.TreeNode;

public class 翻转二叉树226 {
    public static void main(String[] args) {

    }
    //使用递归的方法
    public TreeNode invertTree(TreeNode root){
        dfs(root);
        return root;
    }
    public void dfs(TreeNode root){
        if (root==null) return;
        TreeNode temp=root.left;
        root.left=root.right;
        root.right=temp;
        dfs(root.left);
        dfs(root.right);
    }


}

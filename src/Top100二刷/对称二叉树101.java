package Top100二刷;

import 代码随想录.二叉树理论.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class 对称二叉树101 {
    public boolean isSymmetric2(TreeNode root){
        //使用迭代的方式来实现
        if (root==null) return true;
        Deque<TreeNode> stack=new ArrayDeque<>();
        return false;
    }
    public boolean isSymmetric(TreeNode root){
        if (root==null) return true;
        return dfs(root.left,root.right);
    }
    public boolean dfs(TreeNode leftNode,TreeNode rightNode){
        if (leftNode==null&&rightNode==null) return true;
        if (leftNode==null||rightNode==null) return false;

        return leftNode.val== rightNode.val&&dfs(leftNode.left,rightNode.right)&&
                dfs(leftNode.right, rightNode.left);
    }
}

package Top100.二叉树相关;

import 代码随想录.二叉树理论.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class 对称二叉树101 {
    public boolean isSymmetric(TreeNode root){
        if (root==null) return true;
        return check(root.left,root.right);
    }
    public boolean check(TreeNode u,TreeNode v){
        if (u==null&&v==null) return true;
        if (u==null||v==null||u.val!=v.val) return false;
        return check(u.left,v.right)&&check(u.right,v.left);
    }
}

package Top100.链表.二叉树相关;

import 代码随想录.二叉树理论.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class 对称二叉树101 {
    //递归法实现，对称二叉树的判断
    public boolean isSymmetric(TreeNode root){

        return isDFS(root.left,root.right);
    }
    //递归的检查每一层
    public boolean isDFS(TreeNode root1,TreeNode root2){
        if (root1==null&&root2==null) return true;
        if (root1==null||root2==null) return false;
        if (root1.val!=root2.val) return false;
        return isDFS(root1.left,root2.right)&&isDFS(root1.right,root2.left);
    }
    //迭代法实现
    public boolean isSymmetric2(TreeNode root){
        return check(root,root);
    }
    public boolean check(TreeNode u,TreeNode v){
        Deque<TreeNode> deque=new LinkedList<>();
        deque.offerLast(u);
        deque.offerLast(v);
        while (!deque.isEmpty()){
            u=deque.pollFirst();
            v=deque.pollFirst();
            if (u==null&&v==null){
                continue;
            }
            if ((u==null||v==null)||(u.val!=v.val)){
                return false;
            }
            deque.offerLast(u.left);
            deque.offerLast(v.right);
            deque.offerLast(u.right);
            deque.offerLast(v.left);
        }
        return true;
    }
}

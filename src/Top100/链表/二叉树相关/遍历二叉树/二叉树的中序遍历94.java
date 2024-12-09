package Top100.链表.二叉树相关.遍历二叉树;

import 代码随想录.二叉树理论.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class 二叉树的中序遍历94 {
    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> res=new ArrayList<>();
        inorder(root,res);
        return res;
    }
    public void inorder(TreeNode node,List<Integer> res){
        if (node==null) return;
        inorder(node.left,res);
        res.add(node.val);
        inorder(node.right,res);
    }
    //采用迭代的方式来实现二叉树的前中后遍历
    public List<Integer> inorderTraversal2(TreeNode root){
        List<Integer> res=new ArrayList<>();
        //使用栈辅助中序遍历
        Deque<TreeNode> stack=new LinkedList<>();
        //对于
        while (root!=null||!stack.isEmpty()){
            while (root!=null){
                stack.push(root);
                root=root.left;
            }
            TreeNode node=stack.poll();
            res.add(node.val);
            root=node.right;
        }
        return res;
    }
}

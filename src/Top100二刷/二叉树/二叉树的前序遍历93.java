package Top100二刷.二叉树;

import 代码随想录.二叉树理论.TreeNode;
import 代码随想录.链表.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 二叉树的前序遍历93 {
    public List<Integer> preorderTraversal(TreeNode root){
        List<Integer> res=new ArrayList<>();
        //使用迭代的方式来实现
        Stack<TreeNode> stack=new Stack<>();
        if (root==null) return res;
        while (root!=null||!stack.isEmpty()){
            while (root!=null){
                res.add(root.val);
                stack.push(root);
                root=root.left;
            }
            root=stack.pop().right;
        }

        return res;
    }

    //这个是递归的方式来实现的
    public void preorderDFS(TreeNode node,List<Integer> res){
        if (node==null) return;
        res.add(node.val);
        preorderDFS(node.left,res);
        preorderDFS(node.right,res);

    }
}

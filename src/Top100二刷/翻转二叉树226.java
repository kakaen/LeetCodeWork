package Top100二刷;

import 代码随想录.二叉树理论.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class 翻转二叉树226 {
    //翻转二叉树，使用递归的方法
    public TreeNode invertTree(TreeNode root){
        func(root);
        return root;
    }
    public void func(TreeNode node){
        if (node==null) return;
        TreeNode tem=node.left;
        node.left=node.right;
        node.right=tem;
        func(node.left);
        func(node.right);
    }
    //使用迭代的方法来实现呢？
    public TreeNode invertTree2(TreeNode root){
        //使用什么遍历方式呢？使用层序遍历
        Deque<TreeNode> stack=new ArrayDeque<>();
        if (root==null) return root;
        stack.push(root);
        while (!stack.isEmpty()){
            int count=stack.size();
            for (int i=0;i<count;i++){
                TreeNode node = stack.poll();
                TreeNode temp=node.left;
                node.left=node.right;
                node.right=temp;
                if (node.left!=null) stack.push(node.left);
                if (node.right!=null) stack.push(node.right);
            }
        }
        return root;
    }
}

package Top100二刷.二叉树;

import 代码随想录.二叉树理论.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class 翻转二叉树226 {
    public TreeNode invertTree(TreeNode root) {
        //采用递归的方式来实现
        if (root==null) return root;
        TreeNode temp=root.left;
        root.left=root.right;
        root.right=temp;
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
    // 采用非递归的方式来实现。使用辅助队列来实现
    public TreeNode invertTree2(TreeNode root){
        if (root==null) return root;
        Deque<TreeNode> deque=new ArrayDeque<>();
        deque.push(root);
        while (!deque.isEmpty()){
            TreeNode node = deque.pollFirst();
            if (node.left!=null) deque.push(node.left);
            if (node.right!=null) deque.push(node.right);
            TreeNode temp=node.left;
            node.left=node.right;
            node.right=temp;
        }
        return root;
    }
}

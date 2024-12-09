package Top100.链表.二叉树相关;

import 代码随想录.二叉树理论.TreeNode;

import javax.swing.*;
import java.util.Deque;
import java.util.LinkedList;

public class 二叉树的最大深度104 {
    //递归的方式来实现二叉树的最大深度
    public int maxDepth(TreeNode root){
        if (root==null) return 0;

        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }
    //采用层序遍历的方式来实现
    public int maxDepth2(TreeNode root){
        Deque<TreeNode> deque=new LinkedList<>();
        int maxDepth=0;
        if (root==null) return maxDepth;
        deque.addLast(root);
        while (!deque.isEmpty()){
            int count=deque.size();
            for (int i=0;i<count;i++){
                TreeNode node = deque.pollFirst();
                if (node.left!=null) deque.addLast(node.left);
                if (node.right!=null)deque.addLast(node.right);
            }
            maxDepth++;
        }
        return maxDepth;
    }
}

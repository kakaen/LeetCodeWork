package Top100.链表.二叉树相关;

import 代码随想录.二叉树理论.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class 完全二叉树的节点个数222 {
    public static void main(String[] args) {
        完全二叉树的节点个数222 test = new 完全二叉树的节点个数222();

    }
    public int countNodes(TreeNode root){
        if (root==null) return 0;
        return countNodes(root.left)+countNodes(root.right)+1;
    }
    //采用
    public int countNodes2(TreeNode root){
        int res=0;
        Deque<TreeNode> stack=new LinkedList<>();
        if (root==null) return 0;
        stack.addLast(root);
        while (!stack.isEmpty()){
            int count=stack.size();
            res+=count;
            for (int i=0;i<count;i++){
                TreeNode node = stack.pollFirst();
                if (node.left!=null) stack.addLast(node.left);
                if (node.right!=null) stack.addLast(node.right);
            }
        }
        return res;
    }
}

package Top100.二叉树相关.自顶向下DFS;

import 代码随想录.二叉树理论.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class 二叉树的最小深度111 {
    public static void main(String[] args) {

    }
}
class Solution111{
    public int minDepth(TreeNode root){
       //找到第一个叶子节点
        int minDepth=0;
        if (root==null) return 0;
        Deque<TreeNode> deque=new LinkedList<>();
        deque.addLast(root);
        while (!deque.isEmpty()){
            int count=deque.size();
            for (int i=0;i<count;i++){
                TreeNode node=deque.pollFirst();
                if (node.left==null&&node.right==null) return minDepth+1;
                if (node.left!=null) deque.addLast(node.left);
                if (node.right!=null) deque.addLast(node.right);
            }
            minDepth++;
        }
        return minDepth;
    }
    public int minDepth2(TreeNode root){
        if (root==null) return 0;
        if (root.left==null&&root.right==null) return 1;
        int minDepth=Integer.MAX_VALUE;
        if (root.left!=null){
            minDepth=Math.min(minDepth,minDepth(root.left));
        }
        if (root.right!=null){
            minDepth=Math.min(minDepth,minDepth(root.right));
        }
        return minDepth+1;
    }
}

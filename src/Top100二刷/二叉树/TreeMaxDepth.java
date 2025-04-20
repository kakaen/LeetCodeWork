package Top100二刷.二叉树;

import java.util.LinkedList;
import java.util.Queue;

import 代码随想录.二叉树理论.TreeNode;

public class TreeMaxDepth {
    public int maxDepth(TreeNode root){
        if (root==null) {
            return 0;
        }
        int leftDepth=maxDepth(root.left);
        int rightDepth=maxDepth(root.right);
        return Math.max(leftDepth, rightDepth)+1;
    }
    
    public int maxDepth2(TreeNode root){
        int maxDepth=0;
        if(root==null) return maxDepth;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int count=queue.size();
            maxDepth++;
            for(int i=0;i<count;i++){
                TreeNode node = queue.poll();
                if(node.left==null) queue.offer(node.left);
                if(node.right==null) queue.offer(node.right);
            }
        }
        return maxDepth;
    }
}

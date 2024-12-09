package 代码随想录.二叉树理论;

import sun.reflect.generics.tree.Tree;

import java.util.Deque;
import java.util.LinkedList;

public class 二叉树的最小深度111 {
    public static void main(String[] args) {

    }
}
class Solution111{
    //DFS遍历，深度优先遍历的方式
    public int dept=0;
    public int minDepth(TreeNode root){
        if (root==null) return 0;
        if (root.left==null&&root.right==null) return 1;
        int m1=minDepth(root.left);
        int m2=minDepth(root.right);
        return 0;
    }
    //BFS广度优先遍历的方式
    public int minDepth2(TreeNode root){
        Deque<TreeNode> deque=new LinkedList<>(); //队列
        if (root!=null) deque.offerLast(root);
        int dept=0;
        while (!deque.isEmpty()){
            int count=deque.size();
            dept++;
            for (int i=0;i<count;i++){
                TreeNode node = deque.pollFirst();
                if (node.left==null&&node.right==null) return dept;
                if (node.left!=null) deque.offerLast(node.left);
                if (node.right!=null) deque.offerLast(node.right);
            }
        }
        return dept;
    }
}

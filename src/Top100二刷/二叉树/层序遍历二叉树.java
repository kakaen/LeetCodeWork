package Top100二刷.二叉树;

import java.util.*;

public class 层序遍历二叉树 {
    public static void main(String[] args) {

    }
    public List<List<Integer>> levelOrder(TreeNode root){
        Deque<TreeNode> deque=new LinkedList<>();
        List<List<Integer>> res=new ArrayList<>();
        if (root==null) return res;
        deque.push(root);
        while (!deque.isEmpty()){
            int count=deque.size();
            List<Integer> levelList=new ArrayList<>();
            for (int i=0;i<count;i++){
                TreeNode node = deque.pollFirst();
                levelList.add(node.val);
                if(node.left!=null) deque.addLast(node.left);
                if(node.right!=null) deque.addLast(node.right);
            }
            res.add(levelList);
        }
        return res;
    }

    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val){this.val=val;}
    }
}

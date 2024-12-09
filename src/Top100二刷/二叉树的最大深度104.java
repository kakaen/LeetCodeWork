package Top100二刷;

import 代码随想录.二叉树理论.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class 二叉树的最大深度104 {
    public static void main(String[] args) {
        二叉树的最大深度104 test = new 二叉树的最大深度104();
//        test.maxDepth()
    }
    //使用递归方法来实现
    public int maxDepth(TreeNode root){
        if (root==null) return 0;
        return Math.max(maxDepth(root.left)+1,maxDepth(root.right)+1);
        //计算二叉树的最大深度
    }
    //使用非递归的方法来实现,使用层序遍历来实现
    public int maxDepth2(TreeNode root){
       Deque<TreeNode> stack=new ArrayDeque<>();
       int maxDepth=0;
       if (root==null) return 0;
       stack.push(root);
       while (!stack.isEmpty()){
           int count=stack.size(); //获取当前层的元素个数
           for (int i=0;i<count;i++){
               TreeNode node = stack.poll();
               if(node.left!=null) stack.add(node.left);
               if (node.right!=null) stack.add(node.right);
           }
           maxDepth++;
       }
       return maxDepth;
    }
    public int maxDepth3(TreeNode root){
        return 0;
    }
}

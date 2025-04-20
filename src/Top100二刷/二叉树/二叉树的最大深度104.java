package Top100二刷.二叉树;

import 代码随想录.二叉树理论.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class 二叉树的最大深度104 {
    public int maxDepth(TreeNode root) {
        //方法一：使用递归的方式
        if(root==null) return 0;
        //计算左子树的深度
        int leftDepth=maxDepth(root.left);
        int rightDepth=maxDepth(root.right);
        return Math.max(leftDepth,rightDepth)+1;
    }
    //方法二：使用迭代的方式
    public int maxDepth2(TreeNode root){
        //使用层序遍历的方法
        int depth=0;
        if (root==null) return depth;
        Deque<TreeNode> deque=new ArrayDeque<>();
        deque.add(root);
        while (!deque.isEmpty()){
            int count=deque.size(); //记录当前层有多少个节点
            for (int i=0;i<count;i++){
                TreeNode node = deque.pollFirst();
                if (node.left!=null) deque.addLast(node.left);
                if (node.right!=null) deque.addLast(node.right);
            }
            depth++;
        }
        return depth;
    }
}

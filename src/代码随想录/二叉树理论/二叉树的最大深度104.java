package 代码随想录.二叉树理论;

import sun.reflect.generics.tree.Tree;

import java.util.Deque;
import java.util.LinkedList;

public class 二叉树的最大深度104 {
    public static void main(String[] args) {

    }
}
class Soution104{
    //使用递归的做法，实现。本质是使用后序遍历来实现的
    public int maxDepth(TreeNode root){
        if (root==null) return 0;
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }
    //方法二，使用BFS层序遍历来实现，借助栈来实现，每遍历一层depth加一
    public int maxDepth2(TreeNode root){
        int depth=0;
        Deque<TreeNode> deque=new LinkedList<>(); //创建队列
        if (root!=null) deque.offerLast(root);
        while (!deque.isEmpty()){
            int count=deque.size();
            depth++;
            for (int i=0;i<count;i++){
                TreeNode node = deque.pollFirst();
                if (node.left!=null) deque.offerLast(node.left);
                if(node.right!=null) deque.offerLast(node.right);
            }
        }
        return depth;
    }
}

package Top100.二叉树相关;

import sun.reflect.generics.tree.Tree;
import 代码随想录.二叉树理论.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class 二叉树的最大深度104 {
    public static void main(String[] args) {

    }
    public int maxDepth(TreeNode root){
        //从根节点到最远叶子节点的最长路径上的节点数
        return dfs(root);
    }
    //使用递归
    public int dfs(TreeNode node){
        if (node==null) return 0;
        return Math.max(dfs(node.left),dfs(node.right))+1;
    }
    //使用迭代法，层序遍历
    public int maxDepth2(TreeNode root){
        Deque<TreeNode> deque=new LinkedList<>();
        int level=0;
        if (root==null) return 0;
        deque.addLast(root);
        while (!deque.isEmpty()){
            int size=deque.size();
            TreeNode node=null;
            for (int i=0;i<size;i++){
                node=deque.pollFirst();
                if (node.left!=null) deque.addLast(node.left);
                if (node.right!=null) deque.addLast(node.right);
            }
            level++;
        }
        return level;
    }
}

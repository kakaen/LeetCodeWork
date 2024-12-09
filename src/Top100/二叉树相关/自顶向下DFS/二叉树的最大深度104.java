package Top100.二叉树相关.自顶向下DFS;

import 代码随想录.二叉树理论.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class 二叉树的最大深度104 {
    public static void main(String[] args) {

    }
}
class Solution104{
    public int maxDepth(TreeNode root){
        //使用层序遍历
        int maxDepth=0;
        if (root==null) return maxDepth;
        Deque<TreeNode> deque=new LinkedList<>();
        deque.addLast(root);
        while (!deque.isEmpty()){
            int count=deque.size(); //计算总的节点个数
            for (int i=0;i<count;i++){
                TreeNode node = deque.pollFirst();
                if (node.left!=null) deque.addLast(node.left);
                if (node.right!=null) deque.addLast(node.right);
            }
            maxDepth++;
        }
        return maxDepth;
    }
    //方法二：使用递归的方式实现
    public int depth=0;
    public int maxDepth2(TreeNode root){
        if (root==null) return depth;
        return Math.max(maxDepth2(root.left)+1,maxDepth2(root.right)+1);

    }

}

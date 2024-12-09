package Top100.链表.二叉树相关;

import sun.reflect.generics.tree.Tree;
import 代码随想录.二叉树理论.TreeNode;

public class 求根节点到叶节点数字之和129 {
    private int ans=0;
    public int sumNumbers(TreeNode root){
        if (root==null) return ans;
        int count=root.val;
        backTracking(root,count);
        return ans;
    }
    public void backTracking(TreeNode node,int count){
        if (node.left==null&&node.right==null){
            ans+=count;
            return;
        }
        if (node.left!=null){
            count=node.left.val+count*10;
            backTracking(node.left,count);
            count=(count-node.left.val)/10;
        }
        if (node.right!=null){
            count=node.right.val+count*10;
            backTracking(node.right,count);
            count=(count-node.right.val)/10;
        }
    }
}

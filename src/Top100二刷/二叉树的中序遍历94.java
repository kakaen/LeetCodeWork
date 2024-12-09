package Top100二刷;

import 代码随想录.二叉树理论.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class 二叉树的中序遍历94 {
    public List<Integer> inorderTraversal2(TreeNode root) {
        Deque<TreeNode> stack=new ArrayDeque<>(); //定义栈
        List<Integer> res=new ArrayList<>();
        while (root!=null||!stack.isEmpty()){
            while (root!=null){
                stack.push(root);
                root=root.left;
            }
            TreeNode node=stack.poll();
            res.add(node.val); //这个是遍历中序中的节点值。
            root=node.right; //然后遍历右子树的值。
        }
        return res;
    }
    //遍历中序节点
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        inorderTraversal(root);
        return res;
    }

    public void dfs(TreeNode node,List<Integer> res){
        if (node==null) return;
        dfs(node.left,res);//遍历左子树
        res.add(node.val);
        dfs(node.right,res);
    }
}

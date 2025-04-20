package Top100二刷.二叉树;

import 代码随想录.二叉树理论.TreeNode;

import java.util.*;

public class 二叉树的中序遍历94 {
    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> res=new ArrayList<>();
        if (root==null) return res;
        //使用迭代的方式来实现，需要借助栈
        Stack<TreeNode> stack=new Stack<>();
        while (root!=null||!stack.isEmpty()){
            while (root!=null){
                stack.push(root);
                root=root.left;
            }
            //遍历到当前节点不存在的
            root = stack.pop();
            res.add(root.val);
            root=root.right;
        }
        return res;
    }

    public List<Integer> inorderTraversal2(TreeNode root){
        Deque<TreeNode> stack=new LinkedList<>();
        List<Integer> res=new ArrayList<>();
        while (root!=null||!stack.isEmpty()){
            while (root!=null){
                stack.push(root);
                root=root.left;
            }
            root=stack.poll();
            res.add(root.val);
            root=root.right;

        }
        return res;
    }


    //使用递归的方式来实现
    public void dfs(TreeNode node,List<Integer> res){
        if (node==null) return;
        dfs(node.left,res);
        res.add(node.val);
        dfs(node.right,res);
    }
}

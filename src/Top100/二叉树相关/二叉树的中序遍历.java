package Top100.二叉树相关;

import 代码随想录.二叉树理论.TreeNode;

import java.util.*;

public class 二叉树的中序遍历 {
    public static void main(String[] args) {

    }
}

class Solution94{
    public List<Integer> result=new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root){
        inorder(root);
        return result;
    }
    //递归实现
    public void inorder(TreeNode node){
        if (node==null) return;
        if(node.left!=null) inorder(node.left);
        result.add(node.val);
        if (node.right!=null) inorder(node.right);
    }
    //迭代实现
    public List<Integer> inorderTraversal2(TreeNode root){
        List<Integer> result=new ArrayList<>();
        Deque<TreeNode> stack=new LinkedList<>();
        //如果root不为空或者栈的不为空
        while (root!=null&&!stack.isEmpty()){
            while (root!=null){
                stack.push(root);
                root=root.left;
            }
            root=stack.pop();
            result.add(root.val);
            root=root.right;
        }
        return result;
    }
    public List<Integer> inorderTraversal3(TreeNode root){
        List<Integer> res=new ArrayList<>();
        Deque<TreeNode> stack=new LinkedList<>();
        while (root!=null&&!stack.isEmpty()){
            while (root!=null){
                stack.push(root);
            }
            root=stack.pop();
            res.add(root.val);
            root=root.right;
        }
        return res;
    }
}

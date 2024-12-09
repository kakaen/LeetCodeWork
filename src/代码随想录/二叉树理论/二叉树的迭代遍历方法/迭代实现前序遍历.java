package 代码随想录.二叉树理论.二叉树的迭代遍历方法;

import sun.reflect.generics.tree.Tree;
import 代码随想录.二叉树理论.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 迭代实现前序遍历 {
    public static void main(String[] args) {

    }
}
class Solution144_2{
    public List<Integer> preorderTraversal(TreeNode root){
        List<Integer> result=new ArrayList<>();
        if (root==null) return result;
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode curNode = stack.pop();
            result.add(curNode.val);
            if (curNode.right!=null) stack.push(curNode.right);
            if (curNode.left!=null) stack.push(curNode.left);
        }
        return result;
    }
}


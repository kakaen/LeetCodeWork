package 代码随想录.二叉树理论.二叉树的迭代遍历方法;

import sun.reflect.generics.tree.Tree;
import 代码随想录.二叉树理论.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class 迭代实现后序遍历 {
    public static void main(String[] args) {

    }
}
class Solution145_2{
    public List<Integer> postorderTraversal(TreeNode root){
        List<Integer> result=new ArrayList<>();
        if (root==null) return result;
        LinkedList<TreeNode> stack=new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode cur = stack.pop();
            result.add(cur.val);
            if (cur.right!=null) stack.push(cur.right);
            if (cur.left!=null) stack.push(cur.left);
        }
        Collections.reverse(result);
        return result;
    }
}

package 代码随想录.二叉树理论.二叉树的遍历方式;


import 代码随想录.二叉树理论.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class 前序遍历方式 {
    public static void main(String[] args) {

    }
}
class Solution144{

    public List<Integer> preorderTraversal(TreeNode root){
        List<Integer> result=new ArrayList<>();
        preOrder(root,result);
        return result;
    }
    public void preOrder(TreeNode node,List<Integer> result){
        if (node==null) return;
        //将当前元素入栈
        result.add(node.val);
        preOrder(node.left,result);
        preOrder(node.right,result);

    }
}

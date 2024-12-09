package 代码随想录.二叉树理论.二叉树的遍历方式;

import 代码随想录.二叉树理论.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class 二叉树的中序遍历 {
    public static void main(String[] args) {

    }
}
class Solution94{
    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> result=new ArrayList<>();
        inOrder(root,result);
        return result;
    }

    private void inOrder(TreeNode root, List<Integer> result) {
     if (root==null) return;
     inOrder(root.left,result);
     result.add(root.val);
     inOrder(root.right,result);
    }
}

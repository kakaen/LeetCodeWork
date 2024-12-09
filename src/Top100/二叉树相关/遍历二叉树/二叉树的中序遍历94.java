package Top100.二叉树相关.遍历二叉树;

import sun.reflect.generics.tree.Tree;
import 代码随想录.二叉树理论.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class 二叉树的中序遍历94 {
    public static void main(String[] args) {

    }
}
class Solution94{
    //使用递归的方式来实现
    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> result=new ArrayList<>();
        dfs(root,result);
        return result;
    }
    public void dfs(TreeNode root,List<Integer> resut){
        //递归的结束边界
        if (root==null) return;

        if (root.left!=null) dfs(root.left,resut);
        resut.add(root.val);
        if (root.right!=null) dfs(root.right,resut);
    }
    public List<Integer> inorderTraversal2(TreeNode root){
        List<Integer> result=new ArrayList<>();
        Deque<TreeNode> satck=new LinkedList<>();
        while (root!=null||!satck.isEmpty()){
            while (root!=null){

                satck.push(root);
                root=root.left;
            }
            root=satck.pop();
            result.add(root.val);
            root=root.right;
        }
        return result;
    }
    public List<Integer> inorderTraversal3(TreeNode root){
        List<Integer> result=new ArrayList<>();
        Deque<TreeNode> stack= new LinkedList<>();
        while (root!=null||!stack.isEmpty()){
            while (root!=null){
                stack.push(root);
                root=root.left;
            }
            root = stack.pop();
            result.add(root.val);
            root=root.right;
        }
        return result;
    }
}
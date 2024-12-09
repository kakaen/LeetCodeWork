package Top100.二叉树相关.遍历二叉树;

import sun.reflect.generics.tree.Tree;
import 代码随想录.二叉树理论.TreeNode;
import 代码随想录.链表.ListNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class 二叉树的前序遍历144 {
    public static void main(String[] args) {

    }
}
class Solution144{
    public List<Integer> preorderTraversal(TreeNode root){
        List<Integer> result=new ArrayList<>();
        dfs(root,result);
        return result;
    }
    public void dfs(TreeNode node,List<Integer> result){
        if (node==null) return;
        result.add(node.val);
        dfs(node.left,result);
        dfs(node.right,result);
    }
    //迭代法进行遍历
    public List<Integer> preorderTraversal2(TreeNode root){
        List<Integer> result=new ArrayList<>();
        Deque<TreeNode> stack=new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()){
            //访问首节点
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.right!=null) stack.push(node.right);
            if (node.left!=null) stack.push(node.left);
        }
        return result;
    }
    //前序遍历的方式
    public List<Integer> preorderTraversal3(TreeNode root){
        //创建一个stack
        Deque<TreeNode> stack=new LinkedList<>();
        //创建放置结果
        List<Integer> result=new ArrayList<>();
        while (root!=null||!stack.isEmpty()){
            while (root!=null){
                result.add(root.val);
                stack.push(root);
            }
            TreeNode node = stack.pop();
            root=node.right;
        }
        return result;
    }
}

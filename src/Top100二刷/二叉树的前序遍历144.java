package Top100二刷;

import 代码随想录.二叉树理论.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class 二叉树的前序遍历144 {

    public List<Integer> preorderTraversal2(TreeNode root){
        List<Integer> res=new ArrayList<>();
        Deque<TreeNode> stack=new ArrayDeque<>(); //栈元素
        while (root!=null||!stack.isEmpty()){
            while (root!=null){
                stack.push(root);
                res.add(root.val);
                root=root.left;
            }
            TreeNode node=stack.poll();
            root=node.right;
        }
        return res;
    }
    public List<Integer> preorderTraversal(TreeNode root){

        List<Integer> res=new ArrayList<>();
        preorderDfs(root,res);
        return res;
    }
    public void preorderDfs(TreeNode root,List<Integer> res){
        if (root==null) return;
        res.add(root.val);
        preorderDfs(root.left,res);
        preorderDfs(root.right,res);
    }
}

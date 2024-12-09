package Top100二刷;

import 代码随想录.二叉树理论.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class 二叉树的后续遍历145 {
    //使用栈的方式,后续遍历我们需要增加一个指针来判断该节点是否已经遍历了左子树和右子树
    public List<Integer> postorderTraversal2(TreeNode root){
        List<Integer> res=new ArrayList<>();
        Deque<TreeNode> stack=new ArrayDeque<>();
        TreeNode prev=null;
        while (root!=null||!stack.isEmpty()){
            while (root!=null){
                stack.push(root);
                root=root.left;
            }
            //从栈中弹出元素，并判断该元素是否已经遍历过左右子树
            TreeNode node=stack.poll();
            if (root.right==null||root.right==prev){
                res.add(node.val);
                prev=node;
            }else{
                stack.push(node);//右子树还没有遍历，加入到站中
                root=node.right;
            }
        }
        return res;
    }
    public List<Integer> postorderTraversal(TreeNode root){
        List<Integer> res=new ArrayList<>();
        postorderDfs(root,res);
        return res;
    }
    public void postorderDfs(TreeNode root,List<Integer> res){
        if (root==null) return;
        postorderDfs(root.left,res);
        postorderDfs(root.right,res);
        res.add(root.val);
    }
}

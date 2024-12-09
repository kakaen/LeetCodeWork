package Top100.二叉树相关;

import sun.reflect.generics.tree.Tree;
import 代码随想录.二叉树理论.TreeNode;

import java.util.*;

public class 验证二叉搜索树98 {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(2);
        TreeNode left=new TreeNode(1);
        TreeNode right=new TreeNode(3);
        root.left=left;
        root.right=right;
        Solution98 solution98 = new Solution98();
        solution98.isValidBST(root);
    }
}
class Solution98{
    //中序遍历实现
    public boolean isValidBST(TreeNode root){
        List<Integer> result=new ArrayList<>();
        //进行遍历
        Deque<TreeNode> stack=new LinkedList<>();
        while (root!=null||!stack.isEmpty()){
            while (root!=null){
                stack.push(root);
                root=root.left;
            }
            root=stack.pop();
            result.add(root.val);
            root=root.right;
        }
        System.out.println(result.toString());
        for (int i=0;i<result.size()-1;i++){
            if (result.get(i)>result.get(i+1)) return false;
        }
        return true;
    }
    //优化中序遍历
    public boolean isVaidBST2(TreeNode root){
        Deque<TreeNode> stack=new LinkedList<>();
        TreeNode preNode=null;
        while (root!=null||!stack.isEmpty()){
            while (root!=null){
                stack.push(root);
                root=root.left;
            }
            //当前的node
            root=stack.pop();
            if (preNode==null){
                preNode=root;
            }else if (preNode.val>=root.val){
                return false;
            }
            preNode=root;
            stack.push(root.right);
        }
        return true;
    }
    //使用递归法进行判断
    //如果该二叉树的左子树不为空，则左子树上所有的节点都小于
    public boolean isValidBST2(TreeNode root){
        return helper(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    public boolean helper(TreeNode node,long low,long high){
        if (node==null) return true;
        if (node.val>=high||node.val<=low) return false;
        return helper(node.left,low,node.val)&&helper(node.right,node.val,high);
    }
}

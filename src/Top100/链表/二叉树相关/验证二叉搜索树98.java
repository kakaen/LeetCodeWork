package Top100.链表.二叉树相关;

import 代码随想录.二叉树理论.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class 验证二叉搜索树98 {
    public static void main(String[] args) {
        验证二叉搜索树98 test = new 验证二叉搜索树98();
        TreeNode root=new TreeNode(1);
        TreeNode n0=new TreeNode(0);
        TreeNode n48=new TreeNode(48);
        TreeNode n12=new TreeNode(12);
        TreeNode n49=new TreeNode(49);
        n48.left=n12;
        n48.right=n49;
        root.left=n0;
        root.right=n48;
        System.out.println(test.isValidBST(root));
    }
    //使用中序遍历的方式来判断是否满足二叉搜索树
    public boolean isValidBST(TreeNode root){
        Deque<TreeNode> stack=new LinkedList<>();
        List<Integer> list=new ArrayList<>();
        while (root!=null||!stack.isEmpty()){
            while (root!=null){
                stack.push(root);
                root=root.left;
            }
            TreeNode node = stack.poll();
            list.add(node.val);
            root=node.right;
        }
        if (list.size()==1) return true;
        for (int i=1;i<list.size();i++){
            if (list.get(i)<=list.get(i-1)) return false;
        }
        return true;
    }
    //采用递归的方式来实现二叉搜索树的搜索
    public boolean isValidBST2(TreeNode root){
        //设计一个递归函数，helper(root,lower,upper)，
        // 考虑以root为根的子树，判断子树中所有节点的值是否都在(l,r)的范围内
        return helper(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    public boolean helper(TreeNode root,long lower,long upper){
        if (root==null) return true;
        if (root.val<=lower||root.val>=upper) return false;
        return helper(root.left,lower,root.val)&&helper(root.right,root.val,upper);
    }

}

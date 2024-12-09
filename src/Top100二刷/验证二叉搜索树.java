package Top100二刷;

import 代码随想录.二叉树理论.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class 验证二叉搜索树 {
    //使用递归的方式来实现
    public boolean isValidBST(TreeNode root) {
        return func(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    public boolean func(TreeNode root,long low,long up){
        if (root==null) return true;
        if (root.val<=low||root.val>=up) return false;
        return func(root.left,low,root.val)&&func(root.right, root.val, up);
    }
    //使用遍历的方式来实现，我们采用中序遍历二叉树来判断当前元素是否满足
    public boolean isValidBST2(TreeNode root){
        long pre=Long.MIN_VALUE;
        Deque<TreeNode> stack=new ArrayDeque<>();
        while (root!=null||!stack.isEmpty()){
            while (root!=null){
                stack.push(root);
                root=root.left;
            }
            //弹出要遍历的节点，判断是否大于前一个元素
            root = stack.poll();
            if (root.val<=pre) return false;
            pre=root.val;
            root=root.right;
        }
        return true;
    }
}

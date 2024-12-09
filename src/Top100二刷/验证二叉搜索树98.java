package Top100二刷;

import 代码随想录.二叉树理论.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class 验证二叉搜索树98 {
    public boolean isValidBST(TreeNode root){
        //节点的左子树只包含小于当前节点的数
        //节点的右子树只包含大于当前节点的数
        //左子树的下一个子树依然是左子树
        return BST(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    //判断当前节点是否为搜索树，搜索数的上下界我们可以判断
    public boolean BST(TreeNode node,int lower,int upper){
        if (node==null) return true;
        if (node.val<lower||node.val>upper) return false;
        //判断该节点的左子树是否符合搜索树
        return BST(node,lower,node.val)&&BST(node, node.val, upper);
    }
    //采用中序遍历来遍历二叉树，判断是否为搜索树
    public boolean isValidBST2(TreeNode root){
        long pre=Long.MIN_VALUE;
        //采用中序遍历的方式，如果中序遍历的方式不是数组递增的顺序则返回false
        Deque<TreeNode> stack=new ArrayDeque<>();
        while (root!=null||!stack.isEmpty()){
            while (root!=null){
                stack.push(root);
                root=root.left;
            }
            //如果root等于null
            TreeNode node = stack.poll(); //弹出要遍历的元素
            //进行遍历node节点，查看当前打印的值是否大于之前的值。

            if (node.val<=pre){
                return false;
            }else{
                pre=node.val;
            }
            if (node.right!=null) stack.push(node.right);
            root=node.right;
        }
        return true;
    }
}

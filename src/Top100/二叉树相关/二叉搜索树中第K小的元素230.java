package Top100.二叉树相关;

import 代码随想录.二叉树理论.TreeNode;

import java.util.Stack;

public class 二叉搜索树中第K小的元素230 {
    public static void main(String[] args) {

    }
}
class Solution230 {
    public int kthSmallest(TreeNode root, int k) {
        //二叉搜索树中查找第k小的元素
        //二叉搜索树的左子树小于节点，右子树大于节点数
        //前序遍历找到第k个元素
        Stack<TreeNode> stack =new Stack<>();
        while (root!=null||!stack.isEmpty()){
            while (root!=null){
                stack.push(root);
                root=root.left;
            }
            //当前访问到null节点
            TreeNode node = stack.pop();
            k--;
            if (k==0) return node.val;
            stack.push(node.right);
        }
        return 0;
    }
    //优化算法，频繁查找第k小的数时。
}


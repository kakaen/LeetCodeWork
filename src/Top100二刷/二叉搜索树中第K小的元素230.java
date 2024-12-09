package Top100二刷;

import 代码随想录.二叉树理论.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class 二叉搜索树中第K小的元素230 {
    public int kthSmallest(TreeNode root, int k) {
        //设计第K小的元素查找,采用中序遍历就是升序查找
        Deque<TreeNode> stack=new ArrayDeque<>();
        while (root!=null||!stack.isEmpty()){
            while (root!=null){
                stack.push(root);
                root=root.left;
            }
            root=stack.poll(); //要访问的节点元素
            k--;
            if (k==0) return root.val;
            root=root.right;
        }
        return 0;
    }
    //不需要频繁的查找第k小的值，如何进行优化算法
    public int KthSmallest2(TreeNode root,int k){
        //记录每个节点为根节点的子树的节点数，如果node节点为根节点
        //如果node节点的左子树的节点数小于k-left-1,则第k小的元素一定在node右子树中
        return 0;
    }
}

package Top100.链表.二叉树相关;

import 代码随想录.二叉树理论.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class 二叉搜索树中第K小的元素230 {
    public static void main(String[] args) {
        二叉搜索树中第K小的元素230 test = new 二叉搜索树中第K小的元素230();
        TreeNode root=new TreeNode(1);
        TreeNode n0=new TreeNode(0);
        TreeNode n48=new TreeNode(48);
        TreeNode n12=new TreeNode(12);
        TreeNode n49=new TreeNode(49);
        n48.left=n12;
        n48.right=n49;
        root.left=n0;
        root.right=n48;
        System.out.println(test.kthSmallest(root, 4));
    }
    public int kthSmallest(TreeNode root,int k){
        //设计一个查找二叉树中第k小的元素
        Deque<TreeNode> deque=new LinkedList<>();
        while (root!=null||!deque.isEmpty()){
            while (root!=null){
                deque.push(root);
                root=root.left;
            }
            //弹出栈顶元素访问
            TreeNode node = deque.pop();
            k--;
            if (k==0) return node.val;
            root=node.right;
        }
        return 0;
    }
}

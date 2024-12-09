package Top100.链表.二叉树相关;

import 代码随想录.二叉树理论.TreeNode;

import java.util.*;

public class 二叉搜索树的最小绝对值差 {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        TreeNode n0=new TreeNode(0);
        TreeNode n48=new TreeNode(48);
        TreeNode n12=new TreeNode(12);
        TreeNode n49=new TreeNode(49);
        n48.left=n12;
        n48.right=n49;
        root.left=n0;
        root.right=n48;
        TreeNode root1=new TreeNode(2);
        TreeNode n1=new TreeNode(1);
        root1.left=n1;
        二叉搜索树的最小绝对值差 test = new 二叉搜索树的最小绝对值差();
        test.getMinimumDifference2(root);
        test.getMinimumDifference2(root1);

    }
    public int getMinimumDifference(TreeNode root){
        //二茶树的什么遍历是搜索树的节点顺序？
        if (root==null) return 0;
        Deque<TreeNode> deque=new LinkedList<>();
        List<Integer> list=new ArrayList<>();
        while (root!=null||!deque.isEmpty()){
            while (root!=null){
                deque.push(root);
                root=root.left;
            }
            TreeNode node = deque.pop();
            list.add(node.val);
            root=node.right;
        }
        int res=Integer.MAX_VALUE;
        System.out.println(list.toString());
        for (int i=1;i<list.size();i++){
            res=Math.min(res, Math.abs(list.get(i)-list.get(i-1)));
        }
        return res;
    }
    public int getMinimumDifference2(TreeNode root){
       //使用中序遍历，存储节点值
        List<Integer> res=new ArrayList<>();
        Deque<TreeNode> deque=new LinkedList<>();
        deque.push(root);
        while (root!=null||!deque.isEmpty()){
            while (root!=null){
                deque.push(root);
                root=root.left;
            }
            TreeNode node = deque.pop();
            res.add(node.val);
            root=node.right;
        }
        System.out.println(res.toString());
        int minDifference=0;
        return 0;
    }


}

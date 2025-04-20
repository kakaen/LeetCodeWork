package Top100二刷.二叉树;

import 代码随想录.二叉树理论.TreeNode;

import java.util.Arrays;

public class 将有序数组转换为二叉搜索树108 {
    public TreeNode sortedArrayToBST(int[] nums){
        //nums已经有序，如何将其转为平衡二叉搜索树
        return func(nums,0,nums.length-1);
    }
    public TreeNode sort(int[] nums){
        Arrays.sort(nums);
        return dfs(nums,0,nums.length-1);
    }
    public TreeNode dfs(int[] nums,int left,int right){
        if (left>right) return null;
        int mid=left+(right-left)/2;
        //构造根节点
        TreeNode root=new TreeNode(nums[mid]);
        //构造左子树
        root.left=dfs(nums,left,mid-1);
        root.right=dfs(nums,mid+1,right);
        return root;
    }
    //递归的方式来实现，将元素分为
    public TreeNode func(int[] nums,int left,int right){
        if (left>right) return null;
        int mid=left+(right-left)/2;
        //构造根节点
        TreeNode root=new TreeNode(nums[mid]);
        //构造左子树的根节点
        TreeNode leftNode=func(nums,left,mid-1);
        //构造右子树的根节点
        TreeNode rightNode=func(nums,mid+1,right);
        root.left=leftNode;
        root.right=rightNode;
        return root;
    }

//    class TreeNode{
//        int val;
//        TreeNode left;
//        TreeNode right;
//        TreeNode(){}
//        TreeNode(int val){this.val=val;}
//        TreeNode(int val,TreeNode left,TreeNode right){
//            this.val=val;
//            this.left=left;
//            this.right=right;
//        }
//    }
}

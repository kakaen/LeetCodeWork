package Top100二刷;

import 代码随想录.二叉树理论.TreeNode;

public class 将有序数组转换为二叉搜索树 {
    public TreeNode sortedArrayToBST(int[] nums) {

        return func(nums,0,nums.length-1);
    }
    //采用递归的方式来实现，
    public TreeNode func(int[] nums,int left,int right){
        if (left>right) return null;
        int mid=left+(right-left)/2;
        //构造根节点
        TreeNode root=new TreeNode(nums[mid]);
        root.left=func(nums,left,mid-1);
        root.right=func(nums,mid+1,right);
        return root;
    }
}

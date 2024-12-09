package Top100二刷;

import 代码随想录.二叉树理论.TreeNode;

public class 将有序数组转换为二叉搜索树108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        //整数数组nums，将其转为一颗平衡二叉树
        //nums数组已经按照升序排列，二叉树的中序遍历
        //我们每次选择中间数字作为二叉搜索树的根节点，
        // 这样分给左右子树的数字
        //平衡二叉树的左子树小于根节点的值，右子树的值大于
        //平衡二叉树的左右子树的差值必须小于1
        //使用递归的方式构建
        return BST(nums,0,nums.length-1);

    }
    public TreeNode BST(int[] nums,int left,int right){
        if (left>right) return null;
        //取[left,right]的中间值
        int mid=left+(right-left)/2;
        TreeNode node=new TreeNode(nums[mid]); //将中间节点作为根节点
        //递归的构造左子树和右子树
        node.left=BST(nums,left,mid-1);
        node.right=BST(nums,mid+1,right);
        return node;

    }
}

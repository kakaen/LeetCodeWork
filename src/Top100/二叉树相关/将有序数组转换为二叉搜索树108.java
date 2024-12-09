package Top100.二叉树相关;

import 代码随想录.二叉树理论.TreeNode;

public class 将有序数组转换为二叉搜索树108 {
    public static void main(String[] args) {

    }
}
class Solution108{
    public TreeNode sortedArrayToBST(int[] nums){
        int n=nums.length;
        return dfs(nums,0,n-1);
    }
    public TreeNode dfs(int[] nums,int start,int end){
        if (start>end) return null;
        //以升序数组的中间节点作为根节点
        int index=start+(end-start)/2;
        TreeNode root=new TreeNode(nums[index]);
        root.left=dfs(nums,start,index-1);
        root.right=dfs(nums,index+1,end);
        return root;
    }
}

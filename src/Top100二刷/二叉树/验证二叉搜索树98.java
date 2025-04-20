package Top100二刷.二叉树;

import 代码随想录.二叉树理论.TreeNode;

public class 验证二叉搜索树98 {
    public boolean isValidBST(TreeNode root){
        //当前节点必须有一个范围
        int minCount=Integer.MIN_VALUE;
        int maxCount=Integer.MAX_VALUE;
        //我们去使用中序遍历来遍历当前的二叉树

        return false;
    }
    //递归判断node节点是否为二叉搜索树
    public boolean DFS(TreeNode node,int min,int max){
        if (node==null) return true;
        if (node.val>max){
            return false;
        }
        return true;
    }
}

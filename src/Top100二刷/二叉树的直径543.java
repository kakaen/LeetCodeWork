package Top100二刷;

import 代码随想录.二叉树理论.TreeNode;

public class 二叉树的直径543 {
    public int ans=1;
    public int diameterOfBinaryTree(TreeNode root){
        //就最大直径，任意两个节点之间的最长路径
        //直径的最大值取决于当前节点的左右子树的最大值之和
        //首先求出每个节点的左右子树的最大深度值，然后进行相加
        ans=1;
        Depth(root);
        return ans-1;
    }
    //计算每个节点为根节点对应的最大深度值
    public int Depth(TreeNode node){
        if (node==null) return 0;
        int L=Depth(node.left); //左子树为根节点的子树的长度
        int R=Depth(node.right); //右子树为根节点的子树的长度
        ans=Math.max(ans,L+R+1); //计算node节点的左右子树长度和
        return Math.max(L,R)+1; //返回以该节点为根节点的长度
    }
}

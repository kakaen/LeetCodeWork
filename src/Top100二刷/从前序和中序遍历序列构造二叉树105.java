package Top100二刷;

import 代码随想录.二叉树理论.TreeNode;

import java.util.Map;

public class 从前序和中序遍历序列构造二叉树105 {
    public Map<Integer,Integer> indexMap; //键为根节点，值为中序遍历中的下标
    public TreeNode buildTree(int[] preorder, int[] inorder){
        int n=preorder.length;
        for (int i=0;i<n;i++){
            indexMap.put(inorder[i],i); //建立根节点和中序遍历下标的映射关系
        }
        return dfs(preorder,inorder,0,n-1,0,n-1);
    }
    public TreeNode dfs(int[] preorder,int[] inorder,int preLeft,int preRight,int inLeft,int inRight){
        if (preLeft>preRight) return null;
        int rootVal=preorder[preLeft];
        TreeNode root=new TreeNode(rootVal);
        int rootIndex=indexMap.get(rootVal); //在中序遍历中的下标
        int leftSize=rootIndex-inLeft; //左子树的节点数
        //递归构造根节点的左子树和右子树
        root.left=dfs(preorder,inorder,preLeft+1,preLeft+leftSize,inLeft,rootIndex-1);
        root.right=dfs(preorder,inorder,preLeft+leftSize+1,preRight,rootIndex+1,inRight);
        return root;
    }
}

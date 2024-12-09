package Top100.二叉树相关;

import 代码随想录.二叉树理论.TreeNode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 从前序与中序遍历序列构造二叉树105 {
   public TreeNode buildTree(int[] preorder,int[] inorder){
       //递归的进行二叉树的建立
       for (int i=0;i<inorder.length;i++){
           indexMap.put(inorder[i],i);
       }
       return dfs(preorder, inorder, 0, preorder.length, 0, inorder.length);
   }
   public Map<Integer,Integer> indexMap=new HashMap<>();
   public TreeNode dfs(int[] preorder,int[] inorder,int pre_left,int pre_right,int in_left,int in_right){
       if (pre_left>pre_right){
           return null;
       }
       //首先创建根节点
       TreeNode root=new TreeNode(preorder[pre_left]);
       //查找根节点在中序遍历中的下标，从而得出相关的左子树，和右子树
       int rootIndex=indexMap.get(preorder[pre_left]);
       //计算左子树的节点数量
       int left_size=rootIndex-in_left;
       //递归的构造左子树
       root.left=dfs(preorder,inorder,pre_left+1,pre_left+left_size,
               in_left,rootIndex-1);
       //递归的构造右子树
       root.right=dfs(preorder,inorder,pre_left+left_size+1,pre_right,
               rootIndex+1,in_right);
       return root;
   }
}

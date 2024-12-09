package Top100.链表.二叉树相关;

import 代码随想录.二叉树理论.TreeNode;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class 从前序与中序遍历序列构造二叉树105 {
    private Map<Integer,Integer> indexMap;
    public TreeNode buildTree(int[] preorder,int[] inorder){
        TreeNode root=new TreeNode(preorder[0]);
        //采用分支点方法，构造左子树
        return null;
    }
    public TreeNode myBuildTree(int[] preorder,int[] inorder,
                                int preorder_left,int preorder_right,
                                int inorder_left,int inorder_right){
        if (preorder_left>preorder_right){
            return null;
        }
        return null;
    }
    public TreeNode buildTreew(int[] preorder,int[] inorder){
        int n=preorder.length;
        //构造哈希映射
        indexMap=new HashMap<>();
        for (int i=0;i<n;i++){
            indexMap.put(inorder[i],i); //记录中序遍历中，数字和下标的映射
        }
        return null;

    }
}

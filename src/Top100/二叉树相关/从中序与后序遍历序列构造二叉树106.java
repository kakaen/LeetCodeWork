package Top100.二叉树相关;

import 代码随想录.二叉树理论.TreeNode;
import 代码随想录.链表.ListNode;

import java.util.HashMap;
import java.util.Map;

public class 从中序与后序遍历序列构造二叉树106 {
    public TreeNode buildTree(int[] inorder,int[] postorder){
        for (int i=0;i<inorder.length;i++){
            indexMap.put(inorder[i],i);
        }
        return dfs(inorder,postorder,0,inorder.length,0,postorder.length);
    }
    public Map<Integer,Integer> indexMap=new HashMap<>();
    public TreeNode dfs(int[] inorder,int[] postorder,int in_left,int in_right,int post_left,int post_right){
        if (post_right<post_left){
            return null;
        }
        //后序遍历的最后一个节点就是要构造的根节点的值
        //构造当前子树的根节点，
        TreeNode root=new TreeNode(postorder[post_right]);
        //在中序遍历中查找根节点对应的下标
        int rootIndex=indexMap.get(postorder[post_right]);
        //获取到左子树的节点数量
        int left_size=rootIndex-in_left;
        //递归构造左子树
        root.left=dfs(inorder,postorder,in_left,rootIndex-1,post_left,post_left+left_size-1);
        //递归构造右子树
        root.right=dfs(inorder,postorder,rootIndex+1,in_right,post_left+left_size,post_right-1);
        return root;
    }
}

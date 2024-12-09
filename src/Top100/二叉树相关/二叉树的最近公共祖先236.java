package Top100.二叉树相关;

import 代码随想录.二叉树理论.TreeNode;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class 二叉树的最近公共祖先236 {
    //存储父节点，使用哈希表存储所有节点的父节点
    public TreeNode lowestCommonAncestor(TreeNode root,TreeNode p,TreeNode q){
        //创建hash表存储每个节点的父节点
        Map<TreeNode,TreeNode> map=new HashMap<>();
        map.put(root,root);
        setMap(root,map);
        while (p!=null){

        }
        return null;
    }
    public void setMap(TreeNode root,Map<TreeNode,TreeNode> map){
        if (root==null){
            return;
        }
        if (root.left!=null){
            map.put(root.left,root);
            setMap(root.left,map);
        }
        if (root.right!=null){
            map.put(root.right,root);
            setMap(root.right,map);
        }
    }
}

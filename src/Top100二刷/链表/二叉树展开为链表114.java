package Top100二刷.链表;

import 代码随想录.二叉树理论.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 二叉树展开为链表114 {
    public void flatten(TreeNode root) {
        //先序遍历的顺序一致
        List<TreeNode> list=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        while (root!=null||!stack.isEmpty()){
            while (root!=null){
                list.add(root);
                stack.push(root);
                root=root.left;
            }
            root=stack.pop();
            root=root.right;
        }
        //得到了顺序的
        root=list.get(0);
        root.left=null;
        TreeNode cur=root;
        for (int i=0;i<list.size();i++){
            TreeNode node=list.get(i);
            node.left=null;
            node.right=null;
            cur.right=node;
            cur=cur.right;
        }
        return;
    }
    public void flatten2(TreeNode root){
        List<TreeNode> list=new ArrayList<>();
        preorderTraversal(root,list);
        for (int i=1;i<list.size();i++){
            TreeNode pre=list.get(i-1),cur=list.get(i);
            pre.left=null;
            pre.right=cur;
        }
        return;
    }
    //寻找前驱节点，寻找当前节点的前驱节点
    public void flatten3(TreeNode root){
        TreeNode cur=root;
        while (cur!=null){
            //寻找当前节点的前驱节点，右子树
            if(cur.left!=null){
                TreeNode next=cur.left;
                TreeNode predecessor=next;
                while (predecessor.right!=null){
                    predecessor=predecessor.right;
                }
                predecessor.right=cur.right;
                cur.left=null;
                cur.right=next;
            }
            cur=cur.right;
        }
    }
    public void preorderTraversal(TreeNode root,List<TreeNode> list){
        if(root==null) return;
        preorderTraversal(root.left,list);
        list.add(root);
        preorderTraversal(root.right,list);
    }
}

package Top100.链表.二叉树相关.遍历二叉树;

import jdk.internal.dynalink.linker.LinkerServices;
import org.omg.PortableInterceptor.INACTIVE;
import 代码随想录.二叉树理论.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class 二叉树的前序遍历144 {
    public static void main(String[] args) {
        二叉树的前序遍历144 test = new 二叉树的前序遍历144();
        TreeNode n3=new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5=new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);
        TreeNode root=new TreeNode(2);
        root.left=n3;root.right=n4;
        n3.left=n5;n5.right=n6;
        n4.left=n7;n4.right=n8;
        test.preorderTraversal(root);
    }
    public List<Integer> preorderTraversal(TreeNode root){
        List<Integer> res=new ArrayList<>();
        dfs(root,res);
        return res;
    }
    //递归进行遍历，
    public void dfs(TreeNode root,List<Integer> res){
        if (root==null) return;
        res.add(root.val);
        if (root.left!=null) dfs(root.left,res);
        if (root.right!=null) dfs(root.right,res);
    }
    //迭代实现，借助栈,
    public List<Integer> preorderTraversal2(TreeNode root){
        List<Integer> res=new ArrayList<>();
        if (root==null) return res;
        Deque<TreeNode> deque=new LinkedList<>();
        //如果节点不为空或者栈不为空
        while (root!=null||!deque.isEmpty()){
            while (root!=null){
                res.add(root.val);
                deque.push(root);
                root=root.left;
            }
            root=deque.pop().right;
        }
        return res;
    }
}

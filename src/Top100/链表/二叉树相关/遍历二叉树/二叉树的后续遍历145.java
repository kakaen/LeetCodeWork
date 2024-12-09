package Top100.链表.二叉树相关.遍历二叉树;

import com.sun.corba.se.spi.ior.IdentifiableFactory;
import 代码随想录.二叉树理论.TreeNode;
import 代码随想录.链表.ListNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class 二叉树的后续遍历145 {
    //使用递归调用实现
    public List<Integer> postorderTraversal(TreeNode root){
        List<Integer> res=new ArrayList<>();
        dfs(root,res);
        return res;
    }
    public void dfs(TreeNode root,List<Integer> list){
        if (root==null) return;
        dfs(root.left,list);
        dfs(root.right,list);
        list.add(root.val);
    }
    //使用迭代的方式来实现
    public List<Integer> postorderTraversal2(TreeNode root){
        List<Integer> res=new ArrayList<>();
        Deque<TreeNode> deque=new LinkedList<>();

        return res;
    }
}

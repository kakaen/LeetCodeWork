package Top100.链表.二叉树相关;

import 代码随想录.二叉树理论.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class 二叉树展开为链表114 {
    public void flatten(TreeNode root){
        if (root==null) return;
        Deque<TreeNode> stack=new LinkedList<>();
        List<Integer> list=new ArrayList<>();
        TreeNode q=root;
        while (q!=null||!stack.isEmpty()){
            while (q!=null){
                list.add(q.val);
                stack.push(q);
                q=q.left;
            }
            q = stack.pop().right;
        }
        if (list.size()==0||list.size()==1) return;
        q=root;
        for (int i=1;i<list.size();i++){
            q.left=null;
            q.right=new TreeNode(list.get(i));
            q=q.right;
        }
    }
    public void flatten2(TreeNode root){
        //第一步找到root左子树的最右下节点
        TreeNode leftDown=null;
        Deque<TreeNode> stack=new LinkedList<>();
        TreeNode p=root;
        while (p!=null||!stack.isEmpty()){
           
        }
    }
}

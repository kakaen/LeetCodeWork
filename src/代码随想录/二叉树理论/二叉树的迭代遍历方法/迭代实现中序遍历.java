package 代码随想录.二叉树理论.二叉树的迭代遍历方法;

import sun.reflect.generics.tree.Tree;
import 代码随想录.二叉树理论.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 迭代实现中序遍历 {
    public static void main(String[] args) {

    }
}
class Solution94_2 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        if (root==null) return result;
        LinkedList<TreeNode> stack=new LinkedList<>();
        //处理顺序和访问的节点不一样，因此需要借助指针的遍历来帮助节点
        TreeNode cur =root;
        while (cur!=null||!stack.isEmpty()){
            if (cur != null) {
                stack.push(cur);
                cur=cur.left;
            }else{
                cur = stack.pop();
                result.add(cur.val);
                cur=cur.right;
            }
        }


        return result;
    }
    //中序遍历，
    public List<Integer> inorderTraversal2(TreeNode root){
        List<Integer> result=new ArrayList<>();
        LinkedList<TreeNode> stack=new LinkedList<>();

        TreeNode cur=root; //用一个指针进行遍历指向最低层节点
        while (cur!=null||!stack.isEmpty()){
            if (cur!=null){
                stack.push(cur);
                cur=cur.left;
            }else {
                //没有left节点了
                cur = stack.pop();
                result.add(cur.val);
                cur=cur.right;
            }
        }
        return result;
    }
}

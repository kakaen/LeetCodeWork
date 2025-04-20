package Top100二刷.二叉树;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import 代码随想录.二叉树理论.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class 对称二叉树101 {
    //方法三：迭代的方法解决对称二叉树
    public boolean isSymmetric3(TreeNode root){
        if (root==null) return true;
        Deque<TreeNode> deque=new LinkedList<>();
        deque.addFirst(root);
        deque.addLast(root);
        while (!deque.isEmpty()){
            TreeNode lNode=deque.pollFirst();
            TreeNode rNode=deque.pollLast();
            if (lNode==null&&rNode==null) continue;
            if (lNode==null||rNode==null||lNode.val!= rNode.val) return false;
            deque.addFirst(lNode.left);
            deque.addLast(rNode.right);

            deque.addFirst(lNode.right);
            deque.addLast(rNode.left);
        }
        return true;
    }
    //方法二：迭代的方法解决对称二叉树的问题
    public boolean isSymmetric2(TreeNode root){
        if (root==null) return true;
        //双端队列来存储节点
        Deque<TreeNode> deque=new ArrayDeque<>();
        deque.addFirst(root);
        deque.addLast(root);
        while (!deque.isEmpty()){
            TreeNode leftNode=deque.pollFirst();
            TreeNode rightNode=deque.pollLast();
            if (leftNode.val!=rightNode.val) return false;
            //判断左右子节点是否为空
            if (leftNode.left==null&&rightNode.right!=null||
                    leftNode.left!=null&&rightNode.right==null) return false;
            if (leftNode.right==null&&rightNode.left!=null||
            leftNode.right!=null&&rightNode.left==null) return false;
            if (leftNode.left!=null&&rightNode.right!=null){
                deque.addFirst(leftNode.left);
                deque.addLast(rightNode.right);
            }
           if (leftNode.right!=null&&rightNode.left!=null){
               deque.addFirst(leftNode.right);
               deque.addLast(rightNode.left);
           }
        }

        return true;
    }
    public boolean isSymmetric(TreeNode root){
        //检查它是否轴对称，轴对称是对每一个都对称
        if (root==null) return true;
        return function(root.left,root.right);
    }
    public boolean function(TreeNode leftNode,TreeNode rightNode){
        if (leftNode==null&&rightNode==null) return true;
        if (leftNode==null||rightNode==null) return false;
        //然后判断这俩的
        boolean flag1=function(leftNode.left,rightNode.right);
        boolean flag2=function(leftNode.right,rightNode.left);
        boolean flag3=leftNode.val==rightNode.val;
        return flag1&&flag2&&flag3;
    }
}

package 代码随想录.二叉树理论.二叉树的层序遍历;

import 代码随想录.二叉树理论.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class 二叉树的层序遍历102 {
    public static void main(String[] args) {

    }
}
class Solution102{
    public List<List<Integer>> resultList=new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root){
        //对列的先进先出
        Deque<TreeNode> queue=new ArrayDeque<>();

        if (root==null) return resultList;
        return resultList;
    }
    //BFS--递归的方式，广度优先遍历
    public void func01(TreeNode node,Integer deep){
        if (node==null) return;
        deep++;
        if (resultList.size()<deep){

        }

    }
}

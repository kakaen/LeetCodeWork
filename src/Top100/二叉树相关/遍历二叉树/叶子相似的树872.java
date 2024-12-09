package Top100.二叉树相关.遍历二叉树;

import org.omg.PortableInterceptor.INACTIVE;
import 代码随想录.二叉树理论.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class 叶子相似的树872 {
    public static void main(String[] args) {
        TreeNode root1=new TreeNode(1);
        TreeNode node1=new TreeNode(2);
        TreeNode noderight=new TreeNode(200);
        root1.left=node1;
        root1.right=noderight;
        TreeNode root2=new TreeNode(1);
        TreeNode node1_1=new TreeNode(2);
        TreeNode noderight_2=new TreeNode(200);
        root2.left=node1_1;
        root2.right=noderight_2;
        Solution872 solution872 = new Solution872();
        boolean flag=solution872.leafSimilar(root1,root2);
    }
}
class Solution872{
    public boolean leafSimilar(TreeNode root1, TreeNode root2){
        List<Integer> res1=new ArrayList<>();
        List<Integer> res2=new ArrayList<>();
        func(root1,res1);
        func(root2,res2);
        if (res1.size()!=res2.size()) return false;
        for (int i=0;i<res1.size();i++){
            if (res1.get(i).intValue()!=res2.get(i).intValue()) return false;
        }
        System.out.println(res1.toString());
        System.out.println(res2.toString());
        return true;
    }
    public void func(TreeNode root,List<Integer> res){
        //获取叶子节点的顺序
        Deque<TreeNode> stack=new LinkedList<>();
        while (root!=null||!stack.isEmpty()){
            while (root!=null){
                stack.push(root);
                root=root.left;
            }
            root=stack.pop();
            if (root.left==null&&root.right==null) res.add(root.val);
            root=root.right;

        }
    }
}

package Top100二刷.二叉树;

import 代码随想录.二叉树理论.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 二叉树的所有路径257 {
    public static void main(String[] args) {
//        StringBuilder builder=new StringBuilder();
//        builder.append("kkka");
//        System.out.println(builder.toString());
//        builder.append("->hhh");
//        System.out.println(builder.toString());
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res=new ArrayList<>();
        List<String> path=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        StringBuilder builder=new StringBuilder();
        dfs(root,res,path);
        return res;
    }
    public void dfs(TreeNode node,List<String> ans,List<String> path){
        if (node==null){
            return;
        }
        //将节点的值加入到path路径中
        path.add(String.valueOf(node.val));
        if (node.left==node.right){
            //表示它是个叶子节点,因此将
            ans.add(String.join("->",path));
        }else{
            dfs(node.left,ans,path);
            dfs(node.right,ans,path);
        }
        path.remove(path.size()-1); //恢复现场
    }
}

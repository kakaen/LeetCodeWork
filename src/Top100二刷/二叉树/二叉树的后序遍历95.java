package Top100二刷.二叉树;

import netscape.security.UserTarget;
import 代码随想录.二叉树理论.TreeNode;
import 代码随想录.链表.ListNode;

import java.util.*;

public class 二叉树的后序遍历95 {
    public List<Integer> postorderTraversal(TreeNode root){
        List<Integer> res=new ArrayList<>();
        Deque<TreeNode> stack=new LinkedList<>();
        TreeNode pre=null;
        while (root!=null||!stack.isEmpty()){
            while (root!=null){
                stack.push(root);
                root=root.left;
            }
            //此时root的左子树一定是访问完的，但是要判断右子树是否存在或是否已经访问过
            root=stack.poll();
            if (root.right==null||root.right==pre){
                res.add(root.val);
                pre=root;
                root=null;
            }else{
                stack.push(root);
                root=root.right;
            }
        }
        return res;
    }
}

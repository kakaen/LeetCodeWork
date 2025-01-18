package Top100二刷.图论;

import java.util.*;

public class 克隆图133 {
    public Node cloneGraph(Node node) {
        //那就是对一个图的遍历呗

        Node newNode = DFS(node);
        return newNode;
    }
    public HashMap<Node,Node> visited=new HashMap<>();
    public Node DFS(Node node){
        if (node==null){
            return node;
        }
        //判断当前节点是否已经被访问过
        if (visited.containsKey(node)){
            return visited.get(node);
        }
        //当前节点没有被访问过
        Node cloneNode = new Node(node.val, new ArrayList<>());
        visited.put(node,cloneNode);

        //遍历该节点的邻居节点列表
        for (Node neb: node.neighbors){
            visited.get(node).neighbors.add(DFS(neb));
        }
        return cloneNode;
    }
    public Node BFS(Node node){
        if (node==null) return node;
        Deque<Node> deque=new ArrayDeque<>();
        deque.add(node);
        //先创建复制当前头节点,这里的neibo还没有完善
        visited.put(node,new Node(node.val,new ArrayList<>()));

        //广度优先遍历
        while (!deque.isEmpty()){
            //取出队列的头节点
            Node n = deque.pollFirst();
            for (Node neignbor:n.neighbors){
                if (!visited.containsKey(neignbor)){
                    //如果没有访问过，就创建
                    visited.put(neignbor,new Node(neignbor.val,new ArrayList<>()));
                    //将邻居节点加入到队列
                    deque.addLast(neignbor);
                }
                //更新当前节点的邻居列表
                visited.get(n).neighbors.add(visited.get(neignbor));
            }
        }
        return visited.get(node);
    }

}

/**
 * node节点的值
 * 以及该node节点相邻的所有node节点
 */
class Node {
    public int val; //node节点的值
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
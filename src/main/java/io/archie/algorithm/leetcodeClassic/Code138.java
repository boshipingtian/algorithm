package io.archie.algorithm.leetcodeClassic;

import io.archie.algorithm.helper.Node;

import java.util.HashMap;
import java.util.Map;

public class Code138 {

    Map<Node, Node> nodeMap = new HashMap<>();

    public static void main(String[] args) {
        Node n7 = new Node(7);
        Node n13 = new Node(13);
        Node n11 = new Node(11);
        Node n10 = new Node(10);
        Node n1 = new Node(1);

        n7.next = n13;
        n7.random = null;

        n13.next = n11;
        n13.random = n7;

        n11.next = n10;
        n11.random = n1;

        n10.next = n1;
        n10.random = n11;

        n1.next = null;
        n1.random = n7;

        Code138 code138 = new Code138();
        Node node = code138.copyRandomList(n7);
        System.out.println("node" + node);
    }

    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }
        // 核心方法，如果使用原始head从哈希表中获取不到，就新建一个
        // 使用原始head节点作为key，新数据作为value
        if (!nodeMap.containsKey(head)) {
            Node node = new Node(head.val);
            nodeMap.put(head, node);
        }
        // 之后直接从哈希表中获取数据
        Node node = nodeMap.get(head);
        // 然后依次递归next节点
        node.next = copyRandomList(head.next);
        // next节点都递归完成后，就可以填充random节点了
        // 这里先判断了一下，防止空指针
        if(head.random != null && !nodeMap.containsKey(head.random)){
            Node randomNode = new Node(head.random.val);
            nodeMap.put(head.random, randomNode);
        }
        // 直接从哈希表中获取
        node.random =  nodeMap.get(head.random);
        return node;
    }
}

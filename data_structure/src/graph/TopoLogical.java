package graph;

import java.util.Stack;

public class TopoLogical {
    private Stack<Integer> order;

    public TopoLogical(Digraph G){
        DirectedCycle cycle=new DirectedCycle(G);
        if (!cycle.hasCycle()){
            DepthFirstOrder depthFirstOrder=new DepthFirstOrder(G);
            order=depthFirstOrder.reversePost();
        }
    }
    private boolean isCycle(){
        return order==null;
    }

    public Stack<Integer> order(){
        return order;
    }

    public static void main(String[] args) {
        Digraph G=new Digraph(6);
        G.addEdge(0,2);
        G.addEdge(0,3);
        G.addEdge(2,4);
        G.addEdge(3,4);
        G.addEdge(4,5);
        G.addEdge(1,3);

        TopoLogical topo=new TopoLogical(G);
        Stack<Integer> order = topo.order();
        StringBuilder sb=new StringBuilder();
        int size=order.size();
        for (int i = 0; i < size; i++) {
            sb.append(order.pop()+"->");
        }
//        for (Integer v : order) {
//            sb.append(v+"->");
//        }
        String res=sb.toString();
        int index=res.lastIndexOf("->");
        res=res.substring(0,index);
        System.out.println(res);
    }
}

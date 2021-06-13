package graph;
//加权无向边
public class Edge implements Comparable<Edge>{
    private final int v;//顶点一
    private final int w;//顶点二
    private final double weight;//当前边的权重

    //通过顶点v和w，以及权重weight值构造一个边对象
    public Edge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }
    public double weight(){
        return weight;
    }
    public int either(){
        return v;
    }
    public int other(int vertex){
        if (vertex==v){
            return w;
        }else {
            return v;
        }
    }

    @Override
    public int compareTo(Edge that) {
        int cmp;
        if (this.weight()>that.weight()){
            //如果当前边的权重大于参数边that的权重，返回1
            cmp=1;
        }else if(this.weight()<that.weight()){
            //如果当前边的权重小于参数边that的权重，返回-1
            cmp=-1;
        }else{
            //如果当前边的权重等于参数边that的权重，返回0
            cmp=0;
        }
        return cmp;
    }
}

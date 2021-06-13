package uf;
//并查集算法优化
public class UF_Tree {
    private int[] eleAndGroup;
    private int count;
    public UF_Tree(int N){
        this.count=N;
        this.eleAndGroup=new int[N];
        for (int i = 0; i < eleAndGroup.length; i++) {
            eleAndGroup[i]=i;
        }
    }
    public int count(){
        return this.count;
    }
    public boolean connected(int p,int q){
        return find(p)==find(q);
    }
    public int find(int p){
        while (true){
            if (p==eleAndGroup[p]){
               return p;
            }
            p=eleAndGroup[p];
        }
    }
    public void union(int p,int q){
        int pRoot=find(p);
        int qRoot=find(q);
        if (pRoot==qRoot){
            return;
        }
        eleAndGroup[pRoot]=qRoot;
        count--;
    }
}

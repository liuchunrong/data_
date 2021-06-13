package uf;
//对UF_Tree的进一步改进
public class UF_Tree_Weighted {
    private int[] eleAndGroup;
    private int[] sz;
    private int count;
    public UF_Tree_Weighted(int N){
        this.count=N;
        this.eleAndGroup=new int[N];
        this.sz=new int[N];
        for (int i = 0; i < eleAndGroup.length; i++) {
            eleAndGroup[i]=i;
        }
        for (int i = 0; i < sz.length; i++) {
            sz[i]=1;
        }
    }
    public int count(){
        return count;
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
        if (sz[p]<sz[q]){
            eleAndGroup[pRoot]=qRoot;
            sz[qRoot]+=sz[pRoot];
        }else {
            eleAndGroup[qRoot]=pRoot;
            sz[pRoot]+=sz[qRoot];
        }
        count--;
    }
}

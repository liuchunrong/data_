package priority;
//最小索引优先队列
public class IndexMinPriorityQueue<T extends Comparable<T>> {
    private T[] items;
    private int[] pq;
    private int[] qp;
    private int N;
    public IndexMinPriorityQueue(int capacity){
        items = (T[]) new Comparable[capacity + 1];
        pq = new int[capacity + 1];
        qp = new int[capacity + 1];
        N = 0;
        for (int i = 0; i < qp.length; i++) {
            //默认情况下，qp逆序中不保存任何索引
            qp[i] = -1;
        }
    }
    //获取队列中元素的个数
    public int size() {
        return N;
    }

    //判断队列是否为空
    public boolean isEmpty() {
        return N == 0;
    }

    //判断堆中索引i处的元素是否小于索引j处的元素
    private boolean less(int i, int j) {
        //先通过pq找出items中的索引，然后再找出items中的元素进行对比
        return items[pq[i]].compareTo(items[pq[j]]) < 0;
    }

    //交换堆中i索引和j索引处的值
    private void exch(int i, int j) {
        //先交换pq数组中的值
        int tmp = pq[i];
        pq[i] = pq[j];
        pq[j] = tmp;

        //更新qp数组中的值
        qp[pq[i]] = i;
        qp[pq[j]] = j;
    }

    //判断k对应的元素是否存在
    public boolean contains(int k) {
        //默认情况下，qp的所有元素都为-1，如果某个位置插入了数据，则不为-1
        return qp[k] != -1;
    }

    //最小元素关联的索引
    public int minIndex() {
        //pq的索引1处，存放的是最小元素在items中的索引
        return pq[1];
    }


    //往队列中插入一个元素,并关联索引i
    public void insert(int i, T t) {
        //如果索引i处已经存在了元素，则不让插入
        if (contains(i)) {
            throw new RuntimeException("该索引已经存在");
        }
        //个数+1
        N++;
        //把元素存放到items数组中
        items[i] = t;
        //使用pq存放i这个索引
        pq[N] = i;
        //在qp的i索引处存放N
        qp[i] = N;
        //上浮items[pq[N]],让pq堆有序
        swim(N);
    }

    //删除队列中最小的元素,并返回该元素关联的索引
    public int delMin() {
        //找到items中最小元素的索引
        int minIndex = pq[1];
        //交换pq中索引1处的值和N处的值
        exch(1, N);
        //删除qp中索引pq[N]处的值
        qp[pq[N]] = -1;
        //删除pq中索引N处的值
        pq[N] = -1;
        //删除items中的最小元素
        items[minIndex] = null;
        //元素数量-1
        N--;
        //对pq[1]做下沉，让堆有序
        sink(1);
        return minIndex;
    }

    //删除索引i关联的元素
    public void delete(int i) {
        //找出i在pq中的索引
        int k = qp[i];
        //把pq中索引k处的值和索引N处的值交换
        exch(k, N);
        //删除qp中索引pq[N]处的值
        qp[pq[N]] = -1;
        //删除pq中索引N处的值
        pq[N] = -1;
        //删除items中索引i处的值
        items[i] = null;
        //元素数量-1
        N--;
        //对pq[k]做下沉，让堆有序
        sink(k);
        //对pq[k]做上浮，让堆有序
        swim(k);
    }

    //把与索引i关联的元素修改为为t
    public void changeItem(int i, T t) {
        //修改items数组中索引i处的值为t
        items[i] = t;
        //找到i在pq中的位置
        int k = qp[i];
        //对pq[k]做下沉，让堆有序
        sink(k);
        //对pq[k]做上浮，让堆有序
        swim(k);
    }


    //使用上浮算法，使索引k处的元素能在堆中处于一个正确的位置
    private void swim(int k) {
        //如果已经到了根结点，则结束上浮
        while (k > 1) {
            //比较当前结点和父结点，如果当前结点比父结点小，则交换位置
            if (less(k, k / 2)) {
                exch(k, k / 2);
            }
            k = k / 2;
        }
    }

    //使用下沉算法，使索引k处的元素能在堆中处于一个正确的位置
    private void sink(int k) {
        //如果当前结点已经没有子结点了，则结束下沉
        while (2 * k <= N) {
            //找出子结点中的较小值
            int min = 2 * k;
            if (2 * k + 1 <= N && less(2 * k + 1, 2 * k)) {
                min = 2 * k + 1;
            }
            //如果当前结点的值比子结点中的较小值小，则结束下沉
            if (less(k, min)) {
                break;
            }
            exch(k, min);
            k = min;
        }
    }

    public static void main(String[] args) {
        String[] arr = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        IndexMinPriorityQueue<String> indexMinPQ = new IndexMinPriorityQueue<>(20);
        //插入
        for (int i = 0; i < arr.length; i++) {
            indexMinPQ.insert(i,arr[i]);
        }

//        System.out.println(indexMinPQ.size());
        //获取最小值的索引
//        System.out.println(indexMinPQ.minIndex());

        //测试修改
        indexMinPQ.changeItem(0,"Z");
        int minIndex=-1;
        while(!indexMinPQ.isEmpty()){
            minIndex = indexMinPQ.delMin();
            System.out.print(minIndex+",");
        }

    }


}

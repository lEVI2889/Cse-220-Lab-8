//Task 1
public class MinHeap {
    private static int elem_num;
    private static int[] heap;
    public MinHeap(int capacity) {
        this.elem_num = 1;
        this.heap = new int[capacity+1];
    }
    public static int parent(int i) {
        return (i/2);
    }
    public static int left(int i) {
        return (2*i);
    }
    public static int right(int i) {
        return (2*i + 1);
    }
    void Sort(){
        int temp = elem_num;
        for (int j = elem_num-1; j >= 2; j--) {
            swap(1, j);
            elem_num--;
            Sink(1);
        }
        elem_num = temp;
    }
    static void Insert(int n){
        if(elem_num == heap.length){
            System.out.println("Heap is full");
            return;
        }
        else{
            heap[elem_num] = n;
            Swim(elem_num);
            elem_num++;
        }
    }
    static void Swim(int idx){
        if(idx>1 && heap[parent(idx)]>heap[idx]){
            swap(parent(idx), idx);
            Swim(parent(idx));
        }
    }
    static void Sink(int idx){
        int temp = idx;
        if(left(idx)< elem_num && heap[idx]>heap[left(idx)]){
            temp = left(idx);
        }
        if(right(idx)< elem_num && heap[idx]>heap[right(idx)]){
            temp = right(idx);
        }
        if(temp != idx){
            swap(idx, temp);
            Sink(temp);
        }
    }
    static int ExtractMin(){
        if(elem_num <= 1){
            System.out.println("Heap is empty");
            return -1;
        }
        int min = heap[1];
        heap[1] = heap[elem_num-1];
        elem_num--;
        Sink(1);
        return min;
    }
    static void swap(int i, int j){
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
}

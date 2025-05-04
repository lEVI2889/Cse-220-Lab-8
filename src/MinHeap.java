//Task 1
public class MinHeap {
    private int elem_num;
    private int[] heap;
    public MinHeap(int capacity) {
        this.elem_num = 1;
        this.heap = new int[capacity+1];
    }
    public int parent(int i) {
        return (i/2);
    }
    public int left(int i) {
        return (2*i);
    }
    public int right(int i) {
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
    void Insert(int n){
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
    void Swim(int idx){
        if(idx>1 && heap[parent(idx)]>heap[idx]){
            swap(parent(idx), idx);
            Swim(parent(idx));
        }
    }
    void Sink(int idx){
        int temp = idx;
        if(left(idx)< elem_num && heap[temp]>heap[left(idx)]){
            temp = left(idx);
        }
        if(right(idx)< elem_num && heap[temp]>heap[right(idx)]){
            temp = right(idx);
        }
        if(temp != idx){
            swap(idx, temp);
            Sink(temp);
        }
    }
    int ExtractMin(){
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
    void swap(int i, int j){
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
}

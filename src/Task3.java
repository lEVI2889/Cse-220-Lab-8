import java.util.*;
public class Task3 {
    static void finalKaj(MinHeap heap, int m){
        int[] output = new int[m];
        for (int i = 0; i < output.length; i++) {
            output[i] = heap.ExtractMin();
        }
        for (int i = 0; i < output.length; i++) {
            System.out.print(output[i] + " ");
        }
    }
    static void heapZeroer(MinHeap heap, int m){
        for (int i = 0; i < m; i++) {
            heap.Insert(0);
        }
    }
    static void mainKaj(MinHeap heap, int[] arr, int m){
        for(int i = 0; i < arr.length; i++){
            int smallest = heap.ExtractMin();
            smallest += arr[i];
            heap.Insert(smallest);
        }
    }
    public static void main(String[] args){
        Scanner task = new Scanner(System.in);
        System.out.println("Enter the value of m: ");
        int m = task.nextInt();
        int [] tasks = {2, 4, 7, 1, 6};
        MinHeap minHeap = new MinHeap(m);
        heapZeroer(minHeap, m);
        mainKaj(minHeap, tasks, m);
        finalKaj(minHeap, m);
    }
}

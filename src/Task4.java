import java.util.*;
public class Task4 {
    static void output(MaxHeap heap, int[] output, int k) {
        for (int i = 0; i < k; i++) {
            output[i] = heap.ExtractMax();
        }
    }
    static void heapcreator(int[] nums, MaxHeap heap) {
        for (int i = 0; i < nums.length; i++) {
            heap.Insert(nums[i]);
        }
    }
    public static void main(String[] args) {
        Scanner task = new Scanner(System.in);
        System.out.println("Enter the value of k: ");
        int k = task.nextInt();
        int[] nums = {4, 10, 2, 8, 6, 7};
        int[] output = new int[k];
        MaxHeap heap = new MaxHeap(nums.length);
        heapcreator(nums, heap);
        output(heap, output, k);
        System.out.print("[ ");
        for (int i = 0; i < output.length; i++) {
            System.out.print(output[i] + " ");
        }
        System.out.print("]");
    }
}

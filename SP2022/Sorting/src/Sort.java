import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public final class Sort {
    int[] a;
    int size;
    
    public Sort() {
        Scanner sc = new Scanner(System.in);
        Random rd = new Random();
        System.out.print("Input size of array: ");
        size = Integer.parseInt(sc.nextLine());
        a = new int[size];
        for (int i = 0; i < size; i++) {
            a[i] = sc.nextInt();
        }
        display();
    }
    
    void quickSort(int start, int end) {
        int pivot = start;
        int up = end, down = start, t;
        while (up > down) {
            while (up >= down && a[down] <= a[pivot]) down++;
            while (up >= down && a[up] > a[pivot]) up--;
            if (up > down) {
                t = a[up];
                a[up] = a[down];
                a[down] = t;
            }
        }
        t = a[start];
        a[start] = a[up];
        a[up] = t;
        display();
        if (start <= up-1) quickSort(start, up-1);
        if (up+1 <= end) quickSort(up+1, end);
    }
    
    void quickSort() {
        quickSort(0, size-1);
    }
       
    void display() {
        for (int i = 0; i < size; i++) {
            if (i == size - 1) System.out.println(a[i]);
            else System.out.print(a[i] + ", ");
        }
    }
    
    private void mergeSort(int start, int end) {
        int tmp;
        if (start == end) return;
        if (start == end + 1) {
            if (a[start] > a[end]) {
                tmp = a[start];
                a[start] = a[end];
                a[end] = tmp;
            }
            return;
        }
        int m = (start + end) / 2;
        mergeSort(start, m);
        mergeSort(m+1, end);
        int i = start, j = m+1;
        int[] b = new int[end - start + 1];
        int k = 0;
        while (i <= m && j <= end) {
            if (a[i] < a[j]) b[k++] = a[i++];
            else b[k++] = a[j++];
        }
        while (i <= m) b[k++] = a[i++];
        while (j <= end) b[k++] = a[j++];
        for (int l = start; l <= end; l++) {
            a[l] = b[l - start];
        }
    }
    
    void mergeSort() {
        mergeSort(0, size-1);
    }
    
    private void radixSort(int start, int end) {
        int exp = 1;
        int[] c = new int[size];
        int max = a[start];
        
        for (int i = start + 1; i < end+1; i++) {
            if (max < a[i]) max = a[i];
        }
        while (max / exp != 0) {
            int[] b = new int[10];
            Arrays.fill(b, 0);
            for (int i = start; i < end+1; i++) {
                b[a[i] / exp % 10]++;
            }
            for (int i = 1; i < 10; i++) {
                b[i] += b[i-1];
            }
            for (int i = end; i >= start; i--) {
                c[--b[a[i]/exp%10]] = a[i];
            }
            System.arraycopy(c, start, a, start, end+1);
            exp *= 10;
        }
    }
    
    void radixSort() {
        radixSort(0, size-1);
    }
    
    private void heap(int size) {
        for (int i = 1; i < size; i++) {
            int x = a[i];
            int s = i;
            while (s > 0 && x > a[(s-1)/2]) {
                a[s] = a[(s-1)/2];
                s = (s - 1)/2;
            }
            a[s] = x;
        }
    }
    
    void heapSort() {
        heap(size);
        for (int i = size - 1; i > 0; i--) {
            int tmp = a[i];
            a[i] = a[0];           
            int s = 0, t = 2*s+1;
            if (t + 1 < i && a[t] < a[t+1]) ++t;
            while (t < i && tmp < a[t]) {
                a[s] = a[t];
                s = t;
                t = 2*t+1;
                if (t + 1 < i && a[t] < a[t+1]) ++t;
            }
            a[s] = tmp;
        }
    }
}

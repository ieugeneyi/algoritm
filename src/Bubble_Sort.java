import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bubble_Sort {
    /**
     * 거품 정렬
     * 두개의 인접한 원소를 비교하여 정렬하는 방식
     * 비교 정렬, 제자리 정렬, stable 정렬
     * 시간복잡도는 O(N²) / best case는 이미 정렬되어있을 때 O(N)
     * 각 라운드를 진행할 때마다 뒤에서부터 한개씩 정렬된다.
     * 총 라운드는 배열크기 - 1
     * 각 라운드별 비교 횟수는 배열크기 - 라운드 횟수
     */

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(reader.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(reader.readLine());
        }
        bubble_sort(arr, arr.length);
        for (int val : arr){
            sb.append(val).append('\n');
        }
        System.out.println(sb);
    }

    private static void bubble_sort(int[] a, int size){
        for (int i = 1; i < size; i++){

            for (int j = 0; j < size - i; j++){
                if (a[j] > a[j + 1]){
                    swap(a, j, j + 1);
                }
            }
        }
    }

    private static void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}

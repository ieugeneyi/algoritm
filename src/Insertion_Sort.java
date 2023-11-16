import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Insertion_Sort {
    /**
     * 삽입 정렬
     * 현재 비교하고자 하는 target과 그 이전의 원소들과 비교하며 자리를 swap하는 정렬 방법
     * 비교 정렬, 제자리 정렬 (추가공간 필요 없음), stable 하다.
     * 첫번째 target은 두번째 원소부터 시작한다. 현재 타겟과 그 이전의 원소를 비교.
     *시간복잡도는 O(N²) / best case는 이미 정렬되어있을 때 O(N)
     */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(reader.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(reader.readLine());
        }
        insertion_sort(arr, arr.length);
        for (int val : arr){
            sb.append(val).append('\n');
        }
        System.out.println(sb);
    }

    private static void insertion_sort(int[] a, int size){
        for (int i = 1; i < size; i++){
            int target = a[i];

            int j = i - 1;
            while (j >= 0 && target < a[j]){
                a[j + 1] = a[j];
                j--;
            }

            a[j + 1] = target;
        }
    }
}

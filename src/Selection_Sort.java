import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Selection_Sort {
    /**
     * 선택정렬
     * 현재 위치에 들어갈 데이터를 찾아 선택하는 알고리즘.
     * 주어진 리스트에서 최소값을 찾는다. 최소값을 맨앞자리 값과 교환한다. 맨앞자리를 제외한 나머지 중 최솟값을 찾아 교환하는 방법을 반복한다.
     * 시간복잡도가 O(N²)
     * stable 하지 않다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(reader.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(reader.readLine());
        }
        selection_sort(arr, arr.length);
        for (int val : arr){
            sb.append(val).append('\n');
        }
        System.out.println(sb);

    }

    public static void selection_sort(int[] a, int size){

        for (int i = 0; i < size - 1; i++){
            int min_index = i;

            for(int j = i + 1; j < size; j++){
                if (a[j] < a[min_index]){
                    min_index = j;
                }
            }

            swap(a, min_index, i);
        }
    }

    public static void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }




}

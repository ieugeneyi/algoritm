public class Quick_Sort {
    /**
     * 퀵 정렬
     * 하나의 리스트를 피벗(pivot)을 기준으로 두 개의 부분 리스트로 나누어
     * 하나는 피벗보다 작은 값들의 부분 리스트, 하나는 피벗보다 큰 값들의 부분 리스트로 정렬한 다음
     * 각 부분 리스트에 대해 다시 위처럼 재귀적으로 수행하여 정렬하는 방법
     * merge sort와 다른 점은 피벗의 값에 따라 부분 리스트의 크기가 비균등하게 나뉠 수 있다는 점.
     * 비교 정렬, 정렬의 대상이 되는 데이터 외에 추가 공간 필요 없음. 제자리 정렬.
     */

    /**
     * 중간 피벗 선택 방식.
     * @param a
     * @param lo 현재 부분 배열의 왼쪽
     * @param hi 현재 부분 배열의 오른쪽
     */
    private static void m_pivot_sort(int[] a, int lo, int hi) {
        if (lo >= hi) {
            return;
        }

        int pivot = partition(a, lo, hi);

        m_pivot_sort(a, lo, pivot);
        m_pivot_sort(a, pivot+1, hi);

    }

    /**
     * pivot을 기준으로 파티션을 나누기 위한 약한 정렬 메소드
     *
     * @param a
     * @param left 현재 배열의 가장 왼쪽 부분
     * @param right 현재 배열의 가장 오른쪽 부분
     * @return 최종적으로 위치한 피벗의 위치(hi)를 반환
     */
    private static int partition(int[] a, int left, int right){
        int lo = left - 1;
        int hi = right + 1;
        int pivot = a[(left + right) / 2];

        while(true) {
            do{
                lo++;
            } while (a[lo] < pivot);

            do{
                hi--;
            } while (a[hi] > pivot && lo <= hi);

            if (lo >= hi){
                return hi;
            }

            swap(a, lo, hi);
        }


    }

    private static void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}

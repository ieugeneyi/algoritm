public class Merge_Sort {
    /**
     * 합병 정렬
     * 주어진 리스트를 절반으로 분할하여 부분리스트로 나눈다 (Divide : 분할)
     * 해당 부분리스트의 길이가 1이 아니라면 1번 과정을 되풀이한다.
     * 인접한 부분리스트끼리 정렬하여 합친다 (Conquer :정복)
     * 항상 두 부분리스트로 쪼개어 들어가기 때문에 최악의 경우에도 O(NlogN)
     * 안정 정렬이다.
     * 정렬 과정에서 추가적인 보조 배열 공간을 사용하기 때문에 메모리 사용량이 많다.
     * 보조 배열에서 원본 배열로 복사하는 과정은 매우 많은 시간을 소요하기 때문에 데이터가 많을 경우 상대적으로 시간이 많이 소요된다.
     */

    private static int[] sorted; // 합치는 과정에서 정렬하여 원소를 담을 임시배열

    public static void merge_sort(int[] a){
        sorted = new int[a.length];
        merge_sort(a, 0, a.length - 1);
        sorted = null;
    }

    //bottom-up  방식
    public static void merge_sort(int[] a, int left, int right){

        for (int size = 1; size <= right; size += size){
            /*
             * 두 부분 리스트를 순서대로 병합해준다.
             * 예를들어 현재 부분리스트의 크기가 1 일때
             * 왼쪽 부분리스트 (low~mid)와 오른쪽 부분리스트 (mid+1~high)를 생각하면
             * 왼쪽 부분리스트는 low = mid = 0 이고,
             * 오른쪽 부분리스트는 mid + 1 부터 low + (2*size) - 1 = 1 이 된다.
             * 이때 high가 배열의 인덱스를 넘어갈 수 있으므로 right와 둘 중 작은 값이 병합되도록 해야한다.
             */
            for(int l = 0; l <= right - size; l += (2 * size)){
                int low = l;
                int mid = l + size - 1;
                int high = Math.min(l + (2*size) - 1, right);
                merge(a, low, mid, high);
            }

        }
    }

    /**
     * @param a      정렬할 배열
     * @param left   배열의 시작점
     * @param mid    배열의 중간점
     * @param right  배열의 끝점
     */
    private static void merge(int[] a, int left, int mid, int right){
        int l = left; //왼쪽 부분리스트 시작점
        int r = mid + 1; //오른쪽 부분리스트 시작점
        int idx = left; //채워넣을 배열의 인덱스

        while( l <= mid && r <= right){
            if (a[l] <= a[r]){
                sorted[idx] = a[l];
                idx++;
                l++;
            }
            else{
                sorted[idx] = a[r];
                idx++;
                r++;
            }
        }

        /*
         * 왼쪽 부분 리스트가 먼저 모두 새 배열에 채워졌을 경우
         *  = 오른쪽 부분 리스트가 아직 남아있을 경우
         * 오른쪽 부분리스트의 나머지 원소들을 새 배열에 채워준다.
         */
        if (l > mid){
            while (r <= right){
                sorted[idx] = a[r];
                idx++;
                r++;
            }
        }
        /*
         * 오른쪽 부분 리스트가 먼저 모두 새 배열에 채워졌을 경우
         *  = 왼쪽 부분 리스트 원소가 아직 남아있을 경우
         *  왼쪽 부분리스트의 나머지 원소들을 새 배열에 채워준다.
         */
        else{
            while (l <= mid){
                sorted[idx] = a[l];
                idx++;
                l++;
            }

        }

        /*
         * 정렬된 새 배열을 기존의 배열에 복사하여 옮겨준다.
         */
        for (int i=left; i<=right; i++){
            a[i] = sorted[i];
        }

    }
}

public class Heap_Sort {
    /**
     * Heap 자료구조 기반
     * Heap : 최솟값 또는 최댓값을 빠르게 찾아내기 위해 완전 이진 트리 형태로 만들어진 자료구조.
     * 부모노드는 자식노드보다 항상 우선순위, 형제간 우선순위는 고려되지 않음.
     * 반 정렬 상태, 약한 힙 (weak heap)
     * 배열로 구현
     */

    public static void heapsort(int[] arr){
        int size = arr.length;

        if (size < 2){
            return;
        }

        //가장 마지막 노드의 부모 인덱스
        int parentIdx = getParent(size - 1);

        //max heap 만들기
        for (int i = parentIdx; i >= 0; i--){
            heapify(arr, i, size - 1);
        }

        //정렬
        for (int i = size - 1; i > 0; i--){
            /*
             * root인 0번째 인덱스와 i번째 인덱스의 값을 교환해준 뒤
             * 0 ~ (i-1) 까지의 부분트리에 대해 max heap을 만족하도록 재구성한다.
             */
            swap(arr, 0, i);
            heapify(arr, 0, i-1);
        }
    }

    private static int getParent(int child){
        return (child-1)/2;
    }

    private static void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    //최대 heap을 만드는 함수
    private static void heapify(int[] a, int parentIdx, int lastIdx){
        /*
         * 현재 트리에서 부모 노드의 자식노드 인덱스를 각각 구해준다.
         * 현재 부모 인덱스를 가장 큰 값을 갖고 있다고 가정한다.
         */
        int leftChildIdx = 2 * parentIdx + 1;
        int rightChildIx = 2 * parentIdx + 2;
        int largestIdx = parentIdx;

        /*
         * left child node 와 비교
         * 자식 노드 인덱스가 끝의 원소 인덱스를 넘어가지 않으면서
         * 현재 가장 큰 인덱스보다 왼쪽 자식노드의 값이 더 클 경우
         * 가장 큰 인덱스를 가리키는 largestIdx를 왼쪽 자식노드 인덱스로 바꿔준다.
         */
        if (leftChildIdx <= lastIdx && a[largestIdx] < a[leftChildIdx]) {
            largestIdx = leftChildIdx;
        }

        /*
         * right child node 와 비교
         * 자식 노드 인덱스가 끝의 원소 인덱스를 넘어가지 않으면서
         * 현재 가장 큰 인덱스보다 오른쪽 자식노드의 값이 더 클 경우
         * 가장 큰 인덱스를 가리키는 largestIdx를 오른쪽 자식노드 인덱스로 바꿔준다.
         */
        if (rightChildIx <= lastIdx && a[largestIdx] < a[rightChildIx]){
            largestIdx = rightChildIx;
        }

        /*
         * largestIdx와 부모노드가 같지 않다는 것은
         * 위 자식노드 비교 과정에서 현재 부모노드보다 큰 노드가 존재한다는 뜻이다.
         * 그럴 경우 해당 자식 노드와 부모 노드를 교환해주고,
         * 교환된 자식 노드를 부모노드로 삼은 서브트리를 검사하도록 재귀 호출 한다.
         */
        if (largestIdx != parentIdx){
            swap(a, largestIdx, parentIdx);
            heapify(a, largestIdx, lastIdx);
        }
    }

    //heapify 재귀함수 사용 X
    private static void heapify_no_recursion(int[] a, int parentIdx, int lastIdx){
        int leftChildIdx;
        int rightChildIdx;
        int largestIdx;

        /*
         * 현재 부모 인덱스의 자식 노드 인덱스가
         * 마지막 인덱스를 넘지 않을 때 까지 반복한다.
         * 이때 왼쪽 자식 노드를 기준으로 해야한다.
         */
        while ((parentIdx * 2) + 1 <= lastIdx){
            leftChildIdx = (parentIdx * 2) + 1;
            rightChildIdx = (parentIdx * 2) + 2;
            largestIdx = parentIdx;

            /*
             * left child node와 비교
             * 범위는 while 에서 검사했기 때문에 할 필요 없음.
             */
            if (a[leftChildIdx] > a[largestIdx]){
                largestIdx = leftChildIdx;
            }

            /*
             * right child node 와 비교
             * 범위검사 필요
             */
            if (rightChildIdx <= lastIdx && a[rightChildIdx] > a[largestIdx]){
                largestIdx = rightChildIdx;
            }

            if (parentIdx != largestIdx){
                swap(a, parentIdx, largestIdx);
                parentIdx = largestIdx;
            }
            else{
                return;
            }
        }
    }
}

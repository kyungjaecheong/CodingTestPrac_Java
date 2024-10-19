import java.io.IOException;

/**
 * Day6 - 필수 문제
 * 오늘도 서준이는 최소 힙 기반 힙 정렬 수업 조교를 하고 있다.
 * 아빠가 수업한 내용을 학생들이 잘 이해했는지 문제를 통해서 확인해보자.
 * N개의 서로 다른 양의 정수가 저장된 배열 A가 있다.
 * 힙 정렬로 배열 A를 오름차순 정렬할 경우
 * 배열 A의 원소가 K 번 교환된 직후의 배열 A를 출력해 보자.
 * ---
 * 크기가 N인 배열에 대한 힙 정렬 의사 코드는 다음과 같다.
 * -
 * heap_sort(A[1..n]) { # A[1..n]을 정렬한다.
 *     build_min_heap(A, n);
 *     for i <- n downto 2 {
 *         A[1] <-> A[i];  # 원소 교환
 *         heapify(A, 1, i - 1);
 *     }
 * }
 * build_min_heap(A[], n) {
 *     for i <- ⌊n / 2⌋ downto 1
 *         heapify(A, i, n)
 * }
 * # A[k]를 루트로 하는 트리를 최소 힙 성질을 만족하도록 수정한다.
 * # A[k]의 두 자식을 루트로 하는 서브 트리는 최소 힙 성질을 만족하고 있다.
 * # n은 배열 A의 전체 크기이며 최대 인덱스를 나타낸다.
 * heapify(A[], k, n) {
 *     left <- 2k; right <- 2k + 1;
 *     if (right ≤ n) then {
 *         if (A[left] < A[right]) then smaller <- left;
 *                                 else smaller <- right;
 *     }
 *     else if (left ≤ n) then smaller <- left;
 *     else return;
 *     # 최소 힙 성질을 만족하지 못하는 경우 재귀적으로 수정한다.
 *     if (A[smaller] < A[k]) then {
 *         A[k] <-> A[smaller];
 *         heapify(A, smaller, n);
 *     }
 * }
 * ---
 * 첫째 줄에 배열 A의 크기 N(5 ≤ N ≤ 500,000), 교환 횟수 K(1 ≤ K ≤ 10^8)가 주어진다.
 * 다음 줄에 서로 다른 배열 A의 원소 A1, A2, ..., AN이 주어진다. (1 ≤ Ai ≤ 10^9)
 * ---
 * 배열 A에 K 번 교환이 발생한 직후의 배열 A를 한 줄에 출력한다.
 * 교환 횟수가 K 보다 작으면 -1을 출력한다.
 */
public class OnBoardingDay6_1 {

    // 제출용
    public static void main(String[] args) throws IOException {
        int N = getPosInt();
        int K = getPosInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = getPosInt();
        }

        boolean sorted = heapSort(A, N, K);

        if (!sorted) {
            System.out.println("-1");
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < N; i++) {
                sb.append(A[i]);

                if (i != N-1) {
                    sb.append(" ");
                }
            }
            System.out.println(sb);
        }
    }

    private static boolean heapSort(int[] arr, int n, int k) {
        int swapCount = 0;

        swapCount = buildMinHeap(arr, n, k, swapCount);
        if (swapCount == k) {
            return true;
        }

        for (int i = n - 1; i >= 1; i--) {
            swap(arr, 0, i);
            swapCount++;
            if (swapCount == k) {
                return true;
            }
            swapCount = heapify(arr, 0, i, k, swapCount);
            if (swapCount == k) {
                return true;
            }
        }
        return false;
    }

    private static int buildMinHeap(int[] arr, int n, int k, int swapCount) {
        int parentsNum = (n / 2) - 1;

        for (int i = parentsNum; i >= 0; i--) {
            swapCount = heapify(arr, i, n, k, swapCount);
            if (swapCount == k) {
                return swapCount;
            }
        }
        return swapCount;
    }

    private static int heapify(int[] arr, int i, int n, int k, int swapCount) {
        int leftIdx = 2 * i + 1;
        int rightIdx = 2 * i + 2;
        int smallestIdx = i;

        if (leftIdx < n && arr[leftIdx] < arr[smallestIdx]) {
            smallestIdx = leftIdx;
        }
        if (rightIdx < n && arr[rightIdx] < arr[smallestIdx]) {
            smallestIdx = rightIdx;
        }

        if (smallestIdx != i) {
            swap(arr, i, smallestIdx);
            swapCount++;
            if (swapCount == k) {
                return swapCount;
            }
            return heapify(arr, smallestIdx, n, k, swapCount);
        }
        return swapCount;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static int getPosInt() throws IOException {
        int curInt = 0;
        int cursor;

        while (true) {
            cursor = System.in.read();
            if (cursor == -1
                || cursor == ' '
                || cursor == '\n') break;

            curInt *= 10;
            curInt += (cursor - '0');
        }
        return curInt;
    }


    /* test Code - 리팩토링
    public static void main(String[] args) {
        int[] nk1 = {5, 2};
        int[] a1 = {2, 5, 1, 4, 3}; // 1 3 2 4 5
        testCode(nk1, a1);

        int[] nk2 = {5, 10};
        int[] a2 = {2, 5, 1, 4, 3}; // -1
        testCode(nk2, a2);
    }

    private static void testCode(int[] nk, int[] arr) {
        int n = nk[0];
        int k = nk[1];
        System.out.println("Before : " + Arrays.toString(arr));

        boolean sorted = heapSort(arr, n, k);

        if (!sorted) {
            System.out.println("-1");
        } else {
            System.out.println("After : " + Arrays.toString(arr));
        }
    }

    private static boolean heapSort(int[] arr, int n, int k) {
        int swapCount = 0;

        swapCount = buildMinHeap(arr, n, k, swapCount);
        if (swapCount == k) {
            return true;
        }

        for (int i = n - 1; i >= 1; i--) {
            swap(arr, 0, i);
            swapCount++;
            if (swapCount == k) {
                return true;
            }
            swapCount = heapify(arr, 0, i, k, swapCount);
            if (swapCount == k) {
                return true;
            }
        }

        return false;
    }

    private static int buildMinHeap(int[] arr, int n, int k, int swapCount) {
        int parentNums = (n / 2) - 1;
        for (int i = parentNums; i >= 0; i--) {
            swapCount = heapify(arr, i, n, k, swapCount);
            if (swapCount == k) {
                return swapCount;
            }
        }
        return swapCount;
    }

    private static int heapify(int[] arr, int i, int n, int k, int swapCount) {
        int leftIdx = 2 * i + 1;
        int rightIdx = 2 * i + 2;
        int smallIdx = i;

        if (leftIdx < n && arr[leftIdx] < arr[smallIdx]) {
            smallIdx = leftIdx;
        }

        if (rightIdx < n && arr[rightIdx] < arr[smallIdx]) {
            smallIdx = rightIdx;
        }

        if (smallIdx != i) {
            swap(arr, i, smallIdx);
            swapCount++;
            if (swapCount == k) {
                return swapCount;
            }
            return heapify(arr, smallIdx, n, k, swapCount);
        }
        return swapCount;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
     */

    /* 테스트 코드 2
    private static int swapCnt = 0;
    private static int K;

    public static void main(String[] args) {
        int[] nk1 = {5, 2};
        K = nk1[1];
        int[] a1 = {2, 5, 1, 4, 3}; // 1 3 2 4 5
        System.out.println(Arrays.toString(a1));
        heapSort(a1);

        if (swapCnt < K) {
            System.out.println("-1");
        } else {
            System.out.println(Arrays.toString(a1));
        }

        swapCnt = 0;
        int[] nk2 = {5, 10};
        K = nk2[1];
        int[] a2 = {2, 5, 1, 4, 3}; // -1
        System.out.println(Arrays.toString(a2));
        heapSort(a2);

        if (swapCnt < K) {
            System.out.println("-1");
        } else {
            System.out.println(Arrays.toString(a2));
        }
    }

    private static void heapSort(int[] arr) {
        int n = arr.length;

        if (buildMinHeap(arr, n)) {
            return;
        }

        for (int i = n - 1; i >= 1; i--) {
            swap(arr, 0, i);
            if (swapCnt == K) {
                return;
            }
            heapify(arr, 0, i);
        }
    }

    private static boolean buildMinHeap(int[] arr, int n) {
        for (int i = (n / 2) - 1; i >= 0; i--) {
            heapify(arr, i, n);
            if (swapCnt == K) {
                return true;
            }
        }
        return false;
    }

    private static void heapify(int[] arr, int k, int n) {
        int left = 2 * k + 1;
        int right = 2 * k + 2;
        int smallest = k;

        if (left < n && arr[left] < arr[smallest]) {
            smallest = left;
        }

        if (right < n && arr[right] < arr[smallest]) {
            smallest = right;
        }

        if (smallest != k) {
            swap(arr, k, smallest);
            if (swapCnt == K) {
                return;
            }
            heapify(arr, smallest, n);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        swapCnt++;
    }
     */

    /* 테스트 코드 1
    public static void main(String[] args) {
        int[] nk1 = {5, 2};
        int[] a1 = {0, 2, 5, 1, 4, 3}; // 1 3 2 4 5
        System.out.println(Arrays.toString(a1));
        heapSort(a1);

        int[] nk2 = {5, 10};
        int[] a2 = {0, 2, 5, 1, 4, 3}; // 2 5 1 4 3
        System.out.println(Arrays.toString(a2));
        heapSort(a2);
    }
    private static void heapSort(int[] arr) {
        int n = arr.length-1;
        buildMinHeap(arr, n);
        for (int i = n; i >= 2; i--) {
            int temp = arr[1];
            arr[1] = arr[i];
            arr[i] = temp;
            heapify(arr, 1, i - 1);
        }

        System.out.println(Arrays.toString(arr));
    }

    private static void buildMinHeap(int[] arr, int n) {
        for (int i = n/2; i >= 1; i--) {
            heapify(arr, i, n);
        }
    }

    private static void heapify(int[] arr, int k, int n) {
        int left = 2 * k;
        int right = 2 * k + 1;
        int smaller = k;

        if (right <= n) {
            if (arr[left] < arr[right]) {
                smaller = left;
            } else {
                smaller = right;
            }
        } else if (left <= n) {
            smaller = left;
        } else return;

        if (arr[smaller] < arr[k]) {
            int temp = arr[k];
            arr[k] = arr[smaller];
            arr[smaller] = temp;
            heapify(arr, smaller, n);
        }
    }
     */

}

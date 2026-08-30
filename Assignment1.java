public class DSASheetSolutions {

    /*
     * -------------------------------------------------------------
     * SECTION 3: TIME COMPLEXITY
     * -------------------------------------------------------------
     *
     * Problem TC-1: Linear Search Time Complexity
     * Array: {8, 61, 2, 3, 4, 0}
     *
     * 1. Best Case: O(1)
     *    - If we search for 8, it's at index 0. We find it in the first check.
     *
     * 2. Worst Case: O(N)
     *    - If we search for 0 (last element) or 5 (not in the array),
     *      we have to loop through all N elements.
     *
     * 3. Average Case: O(N)
     *    - On average, the element is somewhere in the middle, taking roughly
     *      N/2 comparisons, which is O(N).
     *
     * -------------------------------------------------------------
     * SECTION 4: SPACE COMPLEXITY
     * -------------------------------------------------------------
     *
     * Problem SC-1: Linear Search Space Complexity
     * - Auxiliary Space: O(1)
     * - Reason: We only use a simple loop index variable 'i'. No extra memory/array needed.
     */
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }


    /*
     * -------------------------------------------------------------
     * Problem TC-2: Iterative Binary Search Complexity
     * Sorted Array: {0, 2, 3, 4, 8, 61}, Target = 4
     *
     * 1. Step-by-step trace for target 4:
     *    - Step 1: low = 0, high = 5 -> mid = (0 + 5)/2 = 2.
     *              arr[2] = 3. Since 4 > 3, we move right -> low = 3, high = 5.
     *    - Step 2: low = 3, high = 5 -> mid = (3 + 5)/2 = 4.
     *              arr[4] = 8. Since 4 < 8, we move left -> low = 3, high = 3.
     *    - Step 3: low = 3, high = 3 -> mid = 3.
     *              arr[3] = 4. Match found at index 3.
     *
     * 2. Mathematical derivation for Worst Case:
     *    - Array size reduces by half every iteration: N, N/2, N/4, ..., N/(2^k).
     *    - Search stops when N / (2^k) = 1 => 2^k = N => k = log2(N).
     *    - Time Complexity = O(log N).
     *
     * Problem SC-2: Binary Search Space Complexity
     * - Auxiliary Space: O(1)
     * - Reason: Iterative binary search only stores 3 pointers (low, high, mid).
     */
    public static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }


    /*
     * -------------------------------------------------------------
     * Problem TC-3: Merge Sort Time Complexity
     * Array: {8, 61, 2, 3, 4, 0}
     *
     * 1. Division / Split Tree:
     *
     *                    [8, 61, 2, 3, 4, 0]
     *                     /                \
     *               [8, 61, 2]           [3, 4, 0]
     *                /      \             /      \
     *              [8]    [61, 2]       [3]     [4, 0]
     *                      /   \                /   \
     *                    [61]  [2]            [4]   [0]
     *
     * 2. Recurrence Relation & Tree Method:
     *    - Recurrence: T(N) = 2T(N/2) + O(N)
     *    - Height of tree: log2(N)
     *    - Work at each level: O(N) for merging
     *    - Total Time Complexity = O(N log N) for Best, Worst, and Average cases.
     *
     * Problem SC-3: Merge Sort Space Complexity
     * 1. Auxiliary Space: O(N)
     *    - Explanation: When merging two halves, we have to create temporary arrays
     *      to hold the split elements before copying them back in sorted order.
     *
     * 2. Comparison with In-Place Sorting:
     *    - Insertion Sort: Operates in-place -> O(1) auxiliary space.
     *    - Quick Sort: In-place array modification, requires only O(log N) recursion stack.
     *    - Merge Sort takes more memory (O(N)) compared to Insertion/Quick Sort.
     */
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        for (int i = 0; i < n1; i++) {
            leftArr[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArr[j] = arr[mid + 1 + j];
        }

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }


    public static void main(String[] args) {
        int[] arr1 = {8, 61, 2, 3, 4, 0};
        int[] sortedArr = {0, 2, 3, 4, 8, 61};

        // Linear search test
        System.out.println("Linear Search for 8: " + linearSearch(arr1, 8));

        // Binary search test
        System.out.println("Binary Search for 4: " + binarySearch(sortedArr, 4));

        // Merge sort test
        mergeSort(arr1, 0, arr1.length - 1);
        System.out.print("Sorted array: ");
        for (int x : arr1) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}
// Sorts by dividing an array into halves
public class Sorts {

    //
    // MERGE SORT
    //
    /* How does it work?
        Merge sort works by using the divide and conquer strategy. 
        NOTE: Solution here implements recursively though it can be done iteravely.

        1. Divide our array in half repeatedly, starting with the left side, eventually
        breaking it into individual parts. 
        2. Once they've been separated, we then compare each array and start
        to merge our arrays back together until we get a full sorted array.
        3. The same steps is completed for the right initial half of our array, which 
        then fully combines into a sorted array. 

        Drawbacks:
        Have to create/use another data structure. Sort isn't done inplace 
        
        APPLICATIONS:
            1. For sorting linkedlists in O(n * logn) https://www.geeksforgeeks.org/merge-sort-for-linked-list/
            2. Inversion Count Problem
            3. External Sorting

    */
    // Mergesort average & worst case run-time is O(n * logn)
    public static int[] mergeSort(int[] arr) {
        return mergeSortHelper(arr, 0, arr.length - 1);
    }

    // Helper method that calls itself
    private static int[] mergeSortHelper(int[] arr, int l, int r) {
        if (arr.length == 1) {
            return arr;
        }
        
        int n = arr.length;
        
        // Why use n / 2? 
        // In odd lengthed arrays, always gets us the middle index number [0, 1, 2] = 1
        // In even number arrays, always gives us half + 1 index [0, 1, 2, 3] = 2
        int mid = n / 2;
        
        int[] a1 = new int[mid];
        int[] a2 = new int[n - mid];
        
        // Create copy from 0 to mid
        for (int i = 0; i < mid; i++) {
            a1[i] = arr[i];
        }
        
        // Create copy from mid to end of array
        for (int i = mid; i < n; i++) {
            a2[i - mid] = arr[i];
        }
        
        a1 = mergeSortHelper(a1, 0, mid);
        a2 = mergeSortHelper(a2, mid + 1, r);
        
        return merge(arr, a1, a2);
    }


    // Combine merges
    private static int[] merge(int[] arr, int[] left, int[] right) {
        int leftPointer = 0;
        int rightPointer = 0;
        int leftLength = left.length;
        int rightLength = right.length;

        int[] sortedArr = new int[arr.length];

        while (leftPointer < leftLength && rightPointer < rightLength) {
            if (left[leftPointer] > right[rightPointer]) { 
                sortedArr[leftPointer + rightPointer] = right[rightPointer];
                rightPointer++;
            } else {
                sortedArr[leftPointer + rightPointer] = left[leftPointer];
                leftPointer++;
            }
        }

        // Iterate through the remainder of each array
        while (leftPointer < leftLength) {
            sortedArr[leftPointer + rightPointer] = left[leftPointer];
            leftPointer++;
        }

        while (rightPointer < rightLength) {
            sortedArr[leftPointer + rightPointer] = right[rightPointer];
            rightPointer++;
        }
        return sortedArr;
    }

    // 
    // Bubblesort 
    // 

    /*  How does it work?
        "Bubbles" numbers up through a data structure by comparing the value ahead with our current value.
    
        The first loop is in reference to how many values are in our array. This makes sure we cover every variable.
        The second loop is to continually swap up our value up the array.

        O(n^2) runtime

        Applications:
        1. No extra data structures needed to sort
    */

    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            // Want to stop at the value before the last value
            for (int j = 0; j < arr.length - 1; i++) {
                    // Perform swap
                    if (arr[j] < arr[j + 1]) {
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
            }
        }
    }

    //
    // Selection Sort
    //
    /*
        How does it work?
        Find the smallest child and swap it with the front element. Repeat
    */

    public static int[] selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int initial = i;
            int minI= i;

            // Check if there is a smaller number
            for (int j = i + 1; j < arr.length; j++) {
                // Check if our current min is larger
                // than the current value
                // Update our min
                if (arr[minI] > arr[j]) {
                    minI = j;
                }
            }
            // Swap
            if (minI != i) {
                int temp = arr[minI];
                arr[minI] = arr[initial];
                arr[initial] = temp;
            }
        }
        return arr;
    }

    //
    // Quick Sort (Using Hoare Partition)
    //

    /*
        How does it work?
        1. Pick a pivot point
        2. Move it to the end by swapping
        3. Parition
            3a. Create two pointers, one which starts at the most left element and one that begins at the most right element but before our pivot
            3b. Left pointer will find the first number that is larger than our pivot
            3c. Right pointer will find first number that is smaller than our pivot 
            3d. Swap left and right pointers 
            3e. Continue doing until left pointer is larger than right pointer
            3f. Swap left with pivot 
            By this point all numbers left of our pivot should be smaller and all items on the right should be larger 
        4. Recurse
    */
    public static int[] quickSort(int[] arr) {
        return quickSortHelper(arr, 0, arr.length - 1);
     }
     
    public static int[] quickSortHelper(int[] arr, int low, int high) {
        int pivot = partition(arr, low, high);

        // Below implementation depends on how you choose your pivot
        // Recurse left as long as our left is smaller than our pivot
        if (low < pivot - 1) {
            quickSortHelper(arr, low, pivot - 1);
        }
        
        System.out.println("Right");
        // Recurse right as long as our pivot is smaller than our right
        if (pivot < high) {
            quickSortHelper(arr, pivot, high);
        }
        return arr;
    }

    public static int partition(int[] arr, int left, int right) {
        // Create our pivot index
        int pivot = arr[left + (right - left) / 2];
        
        while (left <= right) {

            // Want to find first number larger than pivot
            while (arr[left] < pivot) {
                left++;
            }

            // Want to find first number smaller than pivot
            while (arr[right] > pivot) {
                right--;
            }

            // Swap
            if (left <= right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                
                System.out.println(left);
                System.out.println(right);
                
                left++;
                right--;
            }

        }

        return left;
    }
}


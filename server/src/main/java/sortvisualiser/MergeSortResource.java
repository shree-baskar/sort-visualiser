package sortvisualiser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import jakarta.ws.rs.Path;

@Path("mergesort")
public class MergeSortResource implements SortResource {
    @Override
    public List<int[]> sort(int[] nums) {
        List<int[]> steps = new ArrayList<>();
        steps.add(nums.clone());
        mergeSort(nums, 0, nums.length - 1, steps);
        return steps;
    }

    private void mergeSort(int[] nums, int start, int end, List<int[]> steps) {
        if (start >= end) return;
        int mid = start + ((end - start) / 2);
        mergeSort(nums, start, mid, steps);
        mergeSort(nums, mid + 1, end, steps);
        merge(nums, start, mid, end);
        steps.add(nums.clone());
    }

    private void merge(int[] nums, int start, int mid, int end) {
        int[] leftArr = Arrays.copyOfRange(nums, start, mid + 1);
        int[] rightArr = Arrays.copyOfRange(nums, mid + 1, end + 1);

        int left = 0, right = 0, curr = start;
        while (left < leftArr.length && right < rightArr.length) {
            if (leftArr[left] <= rightArr[right]) {
                nums[curr++] = leftArr[left++];
            } else {
                nums[curr++] = rightArr[right++];
            }
        }

        while (left < leftArr.length) nums[curr++] = leftArr[left++];
        while (right < rightArr.length) nums[curr++] = rightArr[right++];
    }
}

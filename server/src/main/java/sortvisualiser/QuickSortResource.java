package sortvisualiser;

import java.util.ArrayList;
import java.util.List;

public abstract class QuickSortResource implements SortResource {
    @Override
    public List<int[]> sort(int[] nums) {
        if (nums.length == 0) return new ArrayList<>();

        List<int[]> steps = new ArrayList<>();
        quickSort(nums, 0, nums.length - 1, steps);
        return steps;
    }

    private int partition(int[] nums, int low, int high, List<int[]> steps) {
        int pivotPos = pivot(nums, low, high);
        swap(nums, low, pivotPos);
        int pivot = nums[low];
        
        int i = low + 1;
        for (int j = low + 1; j <= high; j++) {
            if (nums[j] <= pivot) {
                swap(nums, i, j);
                i++;
                if (nums[i-1] != nums[j]) steps.add(nums.clone());
            }
        }
        swap(nums, i - 1, low);
        if (nums[i-1] != nums[low]) steps.add(nums.clone());
        return i - 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void quickSort(int[] nums, int start, int end, List<int[]> steps) {
        if (start >= end) return;

        int pivot = partition(nums, start, end, steps);
        quickSort(nums, start, pivot - 1, steps);
        quickSort(nums, pivot + 1, end, steps);
    }

    protected abstract int pivot(int[] nums, int low, int high);
}

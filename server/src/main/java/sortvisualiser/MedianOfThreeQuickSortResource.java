package sortvisualiser;

import jakarta.ws.rs.Path;

@Path("mo3quicksort")
public class MedianOfThreeQuickSortResource extends QuickSortResource {
    protected int pivot(int[] nums, int low, int high) {
        int mid = low + (high - low) / 2;
        if (nums[low] > nums[high] != nums[low] > nums[mid]) return low;
        if (nums[high] > nums[low] != nums[high] > nums[mid]) return high;
        return mid;
    }
}

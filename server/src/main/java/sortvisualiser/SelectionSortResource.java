package sortvisualiser;

import java.util.ArrayList;
import java.util.List;

import jakarta.ws.rs.Path;

@Path("selectionsort")
public class SelectionSortResource implements SortResource {
    @Override
    public List<int[]> sort(int[] nums) {
        if (nums.length == 0) return new ArrayList<>();

        List<int[]> steps = new ArrayList<>();
        steps.add(nums.clone());
        for (int i = 0; i < nums.length; i++) {
            int minIndex = i;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] < nums[minIndex]) minIndex = j;
            }
            swap(nums, minIndex, i);
            steps.add(nums.clone());
        }

        return steps;
    }

    private void swap(int[] nums, int i1, int i2) {
        assert(i1 < nums.length && i2 < nums.length);
        int temp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = temp;
    }
}

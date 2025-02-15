package sortvisualiser;

import java.util.ArrayList;
import java.util.List;

import jakarta.ws.rs.Path;

@Path("insertionsort")
public class InsertionSortResource implements SortResource {
    @Override
    public List<int[]> sort(int[] nums) {
        if (nums.length == 0) return new ArrayList<>();

        List<int[]> steps = new ArrayList<>();
        steps.add(nums.clone());

        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            int j = i - 1;
            for (; j >= 0 && nums[j] > curr; j--) {
                swap(nums, j, j + 1);
                steps.add(nums.clone());
            }
        }

        return steps;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

package sortvisualiser;

import jakarta.ws.rs.Path;
import java.util.ArrayList;
import java.util.List;

@Path("bubblesort")
public class BubbleSortResource implements SortResource {
    @Override
    public List<int[]> sort(int[] nums) {
        List<int[]> steps = new ArrayList<>();
        steps.add(nums.clone());

        for (int i = 0; i < nums.length; i++) {
            boolean swapped = false;
            for (int j = 0; j < nums.length - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    swapped = true;
                    steps.add(nums.clone());
                }
            }
            
            if (!swapped) break;
        }

        return steps;
    }
    
}

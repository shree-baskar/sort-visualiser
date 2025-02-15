package sortvisualiser;

import jakarta.ws.rs.Path;

@Path("randomquicksort")
public class RandomisedQuickSortResource extends QuickSortResource {
    @Override
    protected int pivot(int[] nums, int low, int high) {
        return (int)(Math.random() * (high - low)) + low;
    }
}
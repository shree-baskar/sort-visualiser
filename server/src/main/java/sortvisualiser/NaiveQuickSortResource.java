package sortvisualiser;

import jakarta.ws.rs.Path;

@Path("naivequicksort")
public class NaiveQuickSortResource extends QuickSortResource {
    @Override
    protected int pivot(int[] nums, int low, int high) {
        return low;
    }
}

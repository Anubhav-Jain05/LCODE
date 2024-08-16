import java.util.List;

public class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        // Initialize min and max using the first array
        int minVal = arrays.get(0).get(0);
        int maxVal = arrays.get(0).get(arrays.get(0).size() - 1);
        int maxDistance = 0;

        // Iterate through the remaining arrays
        for (int i = 1; i < arrays.size(); i++) {
            List<Integer> array = arrays.get(i);
            int currentMin = array.get(0);
            int currentMax = array.get(array.size() - 1);

            // Calculate potential distances and update maxDistance
            maxDistance = Math.max(maxDistance, Math.abs(currentMax - minVal));
            maxDistance = Math.max(maxDistance, Math.abs(maxVal - currentMin));

            // Update minVal and maxVal
            minVal = Math.min(minVal, currentMin);
            maxVal = Math.max(maxVal, currentMax);
        }

        return maxDistance;
    }
}

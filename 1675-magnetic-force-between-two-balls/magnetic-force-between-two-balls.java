class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        
        int left = 1; // minimum possible distance
        int right = position[position.length - 1] - position[0]; // maximum possible distance
        int result = 0;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canPlaceBalls(position, m, mid)) {
                result = mid;
                left = mid + 1; // try for a larger minimum distance
            } else {
                right = mid - 1; // try for a smaller minimum distance
            }
        }
        
        return result;
    }
    
    private boolean canPlaceBalls(int[] position, int m, int minDist) {
        int count = 1; // place the first ball
        int lastPos = position[0]; // the position of the last placed ball
        
        for (int i = 1; i < position.length; i++) {
            if (position[i] - lastPos >= minDist) {
                count++;
                lastPos = position[i];
                if (count == m) {
                    return true;
                }
            }
        }
        
        return false;
    }
}
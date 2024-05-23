class Solution {
      public  int beautifulSubsets(int[] nums, int k) {
        List<List<Integer>> allSubsets = new ArrayList<>();
        generateSubsets(nums, 0, new ArrayList<>(), allSubsets);

        int count = 0;
        for (List<Integer> subset : allSubsets) {
            if (isBeautiful(subset, k)) {
                count++;
            }
        }
        return count - 1;  // Exclude the empty subset
    }

    private  void generateSubsets(int[] nums, int index, List<Integer> current, List<List<Integer>> allSubsets) {
        if (index == nums.length) {
            allSubsets.add(new ArrayList<>(current));
            return;
        }

        // Include the current element
        current.add(nums[index]);
        generateSubsets(nums, index + 1, current, allSubsets);

        // Exclude the current element
        current.remove(current.size() - 1);
        generateSubsets(nums, index + 1, current, allSubsets);
    }

    private  boolean isBeautiful(List<Integer> subset, int k) {
        int size = subset.size();
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (Math.abs(subset.get(i) - subset.get(j)) == k) {
                    return false;
                }
            }
        }
        return true;
    }
}
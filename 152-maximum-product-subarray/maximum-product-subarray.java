class Solution {
    public int maxProduct(int[] nums) {
         if (nums == null || nums.length == 0) return 0;

        int maxProd = nums[0], minProd = nums[0], result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];

            // If the current number is negative, swap maxProd and minProd
            if (num < 0) {
                int temp = maxProd;
                maxProd = minProd;
                minProd = temp;
            }

            // Update max and min products
            maxProd = Math.max(num, maxProd * num);
            minProd = Math.min(num, minProd * num);

            // Update result
            result = Math.max(result, maxProd);
        }

        return result;
    }
}
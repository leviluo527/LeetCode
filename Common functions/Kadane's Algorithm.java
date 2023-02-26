class Kadane{
    public int maxSubArray(int[] nums) {
        if(nums==null || nums.length==0) {
            return 0;
        }
        int globalMax = Integer.MIN_VALUE;
        int localMax = 0;
        
        for(int i = 0; i < nums.length; ++i) {
            localMax = Math.max(localMax + nums[i], nums[i]);
            globalMax = Math.max(globalMax, localMax);
        }
        
        return globalMax;
    }
}

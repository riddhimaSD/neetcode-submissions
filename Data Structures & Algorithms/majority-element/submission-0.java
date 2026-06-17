class Solution {
    public int majorityElement(int[] nums) {
        int votes = 0;
        int candidate = nums[0];
        for(int i = 0;i<nums.length;i++){
            if(votes==0) candidate = nums[i];
            if(nums[i]==candidate) votes++;
            else{
                votes--;
            }
        }
        return candidate;
    }
}
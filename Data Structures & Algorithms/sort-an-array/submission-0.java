class Solution {
    public int partition(int[] nums,int low,int high){
        int pivot = nums[high];

        int i = low;
        for(;low<high;low++){
            if(nums[low]<=pivot){
                int temp = nums[low];
                nums[low] = nums[i];
                nums[i] = temp;
                i++;
            }
        }
        nums[high] = nums[i];
        nums[i] = pivot;
        return i;
    }
    public void quickSort(int[] nums,int low,int high){
        if(low<high){
            int pivot = partition(nums,low,high);
            quickSort(nums,low,pivot-1);
            quickSort(nums,pivot+1,high);
        }    
    }
    public int[] sortArray(int[] nums) {
        quickSort(nums,0,nums.length-1);
        return nums;
    }
}
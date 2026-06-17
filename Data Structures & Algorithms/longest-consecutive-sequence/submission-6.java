class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int ans = 0;
        for(int num:nums){
            set.add(num);
        }

        for(int num:nums){
            if(!set.contains(num-1)){
                int count = 1;
                while(set.contains(num+1)){
                    count++;
                    num++;
                }
                ans = Math.max(ans,count);
            }
        }
        return ans;
    }
}


// class Solution {
//     public int longestConsecutive(int[] nums) {
//         PriorityQueue<Integer> pq = new PriorityQueue<>();
//         for(int i=0;i<nums.length;i++){
//             pq.add(nums[i]);
//         }
//         int max = 0;
//         int temp = 0;
//         if(nums.length!=0){
//             temp=1;
//             max=1;
//         }
//         while(pq.size()>1){
//             int element = pq.poll();
//             if(pq.peek()-element==0){
//                 continue;
//             }
//             if(pq.peek()-element!=1){
//                 temp=1;
//             }
//             else{
//                 temp++;
//             }
//             max = Math.max(max,temp);
//         }
//         return max;
//     }
// }

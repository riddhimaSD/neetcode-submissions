class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer key = entry.getKey();     
            Integer value = entry.getValue(); 
            pq.add(new int[]{(int)(key),(int)(value)});
            if(pq.size()>k) pq.poll();
        }

        int[] ans = new int[k];

        for(int i=0;i<k;i++) {
            ans[i] = pq.poll()[0];
        }

        return ans;
    }
}

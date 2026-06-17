class Solution {
    class Student {
        int num;
        int freq;

        Student(int num, int freq) {
            this.num = num;
            this.freq = freq;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Student> pq = new PriorityQueue<>(
            (a, b) -> b.freq - a.freq  // higher marks first
        );

        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer key = entry.getKey();     // Get the key
            Integer value = entry.getValue(); 
            pq.add(new Student((int)(key),(int)(value)));
        }

        int[] ans = new int[k];

        for(int i=0;i<k;i++) {
            Student s = pq.poll();
            ans[i] = s.num;
        }

        return ans;
    }
}

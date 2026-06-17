class MyHashMap {
    List<int[]>[] bucket;
    private int size = 1000;
    public MyHashMap() {
        bucket = new ArrayList[size];
        for(int i = 0;i<size;i++){
            bucket[i] = new ArrayList<>();
        }
    }
    private int hash(int key){
        return key%size;
    }
    
    public void put(int key, int value) {
        int idx = hash(key);
        for(int[] num : bucket[idx]){
            if(num[0] == key){
                num[1] = value;
                return;
            }
}
        bucket[idx].add(new int[]{key,value});
    }
    
    public int get(int key) {
        int idx = hash(key);

        for(int[] num:bucket[idx]){
            int k = num[0];
            int v = num[1];
            if(k==key){
                return v;
            }
        }
        return -1;
    }
    
    public void remove(int key) {
        int idx = hash(key);
        int val = get(key);
        if(val==-1) return;
        bucket[idx].removeIf(x -> Arrays.equals(x, new int[]{key,val}));
    }
}

// //array of size 10^6+1
// class MyHashMap {

//     int[] set;
//     public MyHashMap() {
//         set = new int[1000001];
//         Arrays.fill(set,-1);
//     }
    
//     public void put(int key, int value) {
//         set[key] = value;
//     }
    
//     public int get(int key) {
//         return set[key];
//     }
    
//     public void remove(int key) {
//         set[key] = -1;
//     }
// }

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
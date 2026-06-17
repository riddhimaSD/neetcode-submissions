//buckets
class MyHashSet {
    List<Integer>[] bucket;
    int size = 1000;
    public MyHashSet() {
        bucket = new ArrayList[size];
        for(int i = 0;i<size;i++){
            bucket[i] = new ArrayList<>();
        }
    }
    private int hash(int key){
        return key % size;
    }
    
    public void add(int key) {
        int idx = hash(key);

        for(int num : bucket[idx]){
            if(num == key){
                return;
            }
        }

        bucket[idx].add(key);
    }
    
    public void remove(int key) {
        int idx = hash(key);
        bucket[idx].remove(Integer.valueOf(key));
    }
    
    public boolean contains(int key) {
        int idx = hash(key);

        for(int num : bucket[idx]){
            if(num == key){
                return true;
            }
        }

        return false;
    }
}

// //boolean Array
// class MyHashSet {
//     boolean[] set;
//     public MyHashSet() {
//         set = new boolean[1000001];
//     }
    
//     public void add(int key) {
//         set[key] = true;
//     }
    
//     public void remove(int key) {
//         set[key] = false;
//     }
    
//     public boolean contains(int key) {
//         return set[key];
//     }
// }

// //ArrayList
// class MyHashSet {

//     List<Integer> set;
//     public MyHashSet() {
//         set = new ArrayList<>();
//     }
    
//     public void add(int key) {
//         if(contains(key)) return;
//         set.add(key);
//     }
    
//     public void remove(int key) {
//         for(int i = 0;i<set.size();i++){
//             if(set.get(i)==key){
//                 set.remove(i);
//                 return;
//             } 
//         }
//     }
    
//     public boolean contains(int key) {
//         for(int i = 0;i<set.size();i++){
//             if(set.get(i)==key){
//                 return true;
//             } 
//         }
//         return false;
//     }
// }

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
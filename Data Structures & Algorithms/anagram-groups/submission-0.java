class Solution {
    public int[] giveFreq(String s){
        int[] ans = new int[26];
        for(int i = 0;i<s.length();i++){
            ans[(s.charAt(i)-97)]++;
        }
        return ans;
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        for(int i=0;i<strs.length;i++){
            if(strs[i]==null){
                continue;
            }
            int[] freq = giveFreq(strs[i]);
            List<String> row = new ArrayList<>();
            row.add(strs[i]);
            for(int j=i+1;j<strs.length;j++){
                if(strs[j]==null || strs[i].length()!=strs[j].length()){
                    continue;
                }
                int[] freq2 = giveFreq(strs[j]);
                if(Arrays.equals(freq,freq2)){
                    row.add(strs[j]);
                    strs[j]=null;    
                }
            }
            ans.add(row);    
        }
        return ans;
    }
    
}

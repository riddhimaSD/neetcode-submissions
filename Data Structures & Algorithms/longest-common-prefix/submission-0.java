//Verically
class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();

        for(int i = 0;i<strs[0].length();i++){
            char ch = strs[0].charAt(i);
            for(String str:strs){
                if(i>=str.length() || ch!=str.charAt(i)) return sb.toString();
            }
            sb.append(ch);
        }
        return sb.toString();
    }
}
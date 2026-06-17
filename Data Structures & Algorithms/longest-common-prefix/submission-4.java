//Horizontally
class Solution {
    public String longestCommonPrefix(String[] strs) {
        int len = Integer.MAX_VALUE;

        String s = strs[0];
        for(int i = 0;i<strs.length;i++){
            String t = strs[i];
            int j = 0;
            for(;j<s.length() && j<t.length();j++){
                if(t.charAt(j)!=s.charAt(j)) break;
            }
            len = Math.min(len,j);
        }
        return s.substring(0,len);
    }
}

// //Verically
// class Solution {
//     public String longestCommonPrefix(String[] strs) {
//         StringBuilder sb = new StringBuilder();

//         for(int i = 0;i<strs[0].length();i++){
//             char ch = strs[0].charAt(i);
//             for(String str:strs){
//                 if(i>=str.length() || ch!=str.charAt(i)) return sb.toString();
//             }
//             sb.append(ch);
//         }
//         return sb.toString();
//     }
// }
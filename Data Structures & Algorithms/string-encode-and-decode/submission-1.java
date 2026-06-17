class Solution {
    List<Integer> len = new ArrayList<>();
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str:strs){
            sb.append(str);
            len.add(sb.length());
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> strs = new ArrayList<>();
        int i = 0;
        for(int num:len){
            strs.add(str.substring(i,num));
            i = num;
        }
        return strs;
    }
}

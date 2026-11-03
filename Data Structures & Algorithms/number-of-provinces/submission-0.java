class Solution {
    public void dfs(int[][] isCon,boolean[] vis,int node,int n){
        vis[node] = true;

        for(int i = 0;i<n;i++){
            if(!vis[i] && isCon[node][i]==1){
                dfs(isCon,vis,i,n);
            }
        }
    }
    public int findCircleNum(int[][] isCon) {
        int n = isCon.length;
        boolean[] vis = new boolean[n];

        int province = 0;

        for(int i = 0;i<n;i++){
            for(int j = i;j<n;j++){
                if(!vis[j] && isCon[i][j]==1){
                    province++;
                    dfs(isCon,vis,j,n);
                }
            }
        }
        return province;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int fresh = 0;
        
        Queue<int[]> q = new LinkedList<>();

        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j]==1) fresh++;
                else if(grid[i][j]==2) q.offer(new int[]{i,j,0});
            }
        }

        int[] drow = {-1,0,1,0};
        int[] dcol = {0,1,0,-1};

        int ans = 0;

        while(!q.isEmpty()){
            int[] pair = q.poll();
            int row = pair[0];
            int col = pair[1];
            ans = pair[2];

            for(int i = 0;i<4;i++){
                int r = row+drow[i];
                int c = col+dcol[i];

                if(r>=0 && c>=0 && r<grid.length && c<grid[0].length && grid[r][c]==1){
                    fresh--;
                    grid[r][c]=2;
                    q.offer(new int[]{r,c,ans+1});
                }
            }
        }

        if(fresh!=0) return -1;
        return ans;
    }
}

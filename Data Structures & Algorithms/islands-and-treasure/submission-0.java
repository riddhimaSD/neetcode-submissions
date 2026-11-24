class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();

        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j]==0) q.offer(new int[]{i,j});
            }
        }

        int[] drow = {-1,0,1,0};
        int[] dcol = {0,1,0,-1};

        int dist = 0;

        while(!q.isEmpty()){
            int size = q.size();
            dist++;
            for(int k = 0;k<size;k++){
                int[] pair = q.poll();
                int row = pair[0];
                int col = pair[1];

                for(int i = 0;i<4;i++){
                    int r = row + drow[i];
                    int c = col + dcol[i];

                    if(r>=0 && c>=0 && r<grid.length && c<grid[0].length && grid[r][c]!=-1 && grid[r][c]==Integer.MAX_VALUE){
                        grid[r][c] = dist;
                        q.offer(new int[]{r,c});
                    }
                }
            }            
        }
    }
}

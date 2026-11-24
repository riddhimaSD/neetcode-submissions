class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = heights.length;
        int m = heights[0].length;

        Queue<int[]> pac = new LinkedList<>();
        Queue<int[]> ant = new LinkedList<>();

        int[][] vis_p = new int[n][m];
        int[][] vis_a = new int[n][m];

        //pacific
        for(int i = 0;i<n;i++){
            pac.offer(new int[]{i,0});
            ant.offer(new int[]{i,m-1});
        }
        for(int j = 0;j<m;j++){
            pac.offer(new int[]{0,j});
            ant.offer(new int[]{n-1,j});
        }

        int[] drow = {-1,0,1,0};
        int[] dcol = {0,1,0,-1};

        while(!pac.isEmpty()){
            int[] pair = pac.poll();
            int row = pair[0];
            int col = pair[1];

            vis_p[row][col] = 1;

            for(int i = 0;i<4;i++){
                int r = row +drow[i];
                int c = col +dcol[i];

                if(r>=0 && r<n && c>=0 && c<m && heights[r][c]>=heights[row][col] && vis_p[r][c]==0){
                    pac.offer(new int[]{r,c});
                }
            }
        }


        while(!ant.isEmpty()){
            int[] pair = ant.poll();
            int row = pair[0];
            int col = pair[1];

            vis_a[row][col] = 1;

            for(int i = 0;i<4;i++){
                int r = row +drow[i];
                int c = col +dcol[i];

                if(r>=0 && r<n && c>=0 && c<m && heights[r][c]>=heights[row][col] && vis_a[r][c]==0){
                    ant.offer(new int[]{r,c});
                }
            }
        }

        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(vis_p[i][j]==1 && vis_a[i][j]==1){
                    ans.add(List.of(i,j));
                }
            }
        }


        return ans;
    }
}

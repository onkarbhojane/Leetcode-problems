class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        boolean[][] visi=new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++) Arrays.fill(visi[i],false);
        // for(int i=0;i<grid.length;i++){
        //     for(int j=0;j<grid[0].length;j++){
        //         if(i==0 || j==0 || i==grid.length-1 || j==grid[0].length-1){
        //             if(grid[i][j]==1) DFS(grid,visi,i,j,-1);
        //         }
        //     }
        // }
        int ans=0;
        for(int i=0;i<grid.length;i++){
            System.out.println(Arrays.toString(grid[i]));
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1 && !visi[i][j]){
                    ans=Math.max(find(grid,visi,i,j),ans);
                }
            }
        }
        return ans;
    }
    public int find(int[][] grid,boolean[][] visi,int i,int j){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]==0) return 0;
        if(visi[i][j]) return 0;
        visi[i][j]=true;
        return find(grid,visi,i+1,j)+find(grid,visi,i-1,j)+find(grid,visi,i,j+1)+find(grid,visi,i,j-1)+1;
    }
    public void DFS(int[][] grid,boolean[][] visi,int i,int j,int p){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]==0) return;
        if(visi[i][j]) return;
        grid[i][j]=p;
        visi[i][j]=true;
        DFS(grid,visi,i+1,j,p);
        DFS(grid,visi,i-1,j,p);
        DFS(grid,visi,i,j+1,p);
        DFS(grid,visi,i,j-1,p);
    }
}
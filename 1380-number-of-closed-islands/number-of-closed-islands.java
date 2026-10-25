class Solution {
    public int closedIsland(int[][] grid) {
        boolean[][] visi=new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++) Arrays.fill(visi[i],false);
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(i==0 || j==0 || i==grid.length-1 || j==grid[0].length-1){
                    if(grid[i][j]==0) DFS(grid,visi,i,j,-1);
                }
            }
        }
        // for(int i=0;i<grid.length;i++){
        //     System.out.println(Arrays.toString(grid[i]));
        // }
        int ans=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==0 && !visi[i][j]){
                    ans++;
                    DFS(grid,visi,i,j,ans+1);
                }
            }
        }
        return ans;
    }
    public void DFS(int[][] grid,boolean[][] visi,int i,int j,int p){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]==1) return;
        if(visi[i][j]) return;
        grid[i][j]=p;
        visi[i][j]=true;
        DFS(grid,visi,i+1,j,p);
        DFS(grid,visi,i-1,j,p);
        DFS(grid,visi,i,j+1,p);
        DFS(grid,visi,i,j-1,p);
    }
}
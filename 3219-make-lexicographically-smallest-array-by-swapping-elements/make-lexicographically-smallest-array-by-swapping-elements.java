class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int[][] arr=new int[nums.length][2];
        for(int i=0;i<nums.length;i++){
            arr[i][0]=nums[i];
            arr[i][1]=i;
        }
        int[] ans=new int[nums.length];
        for(int i=0;i<nums.length;i++) ans[i]=nums[i];
        Arrays.sort(arr,(a,b)-> a[0]-b[0]);
        int l=0;
        ArrayList<ArrayList<int[]>> arr1=new ArrayList<>();
        ArrayList<int[]> arr2=new ArrayList<>();
        arr2.add(new int[]{arr[0][0],arr[0][1]});
        for(int i=1;i<nums.length;i++){
            if(arr[i][0]-arr[i-1][0]<=limit) arr2.add(new int[]{arr[i][0],arr[i][1]});
            else{
                System.out.println(i);
                arr1.add(new ArrayList<>(arr2));
                arr2.clear();
                arr2.add(arr[i]);
            }
        }
        if(arr2.size()>0) arr1.add(new ArrayList<>(arr2));
        System.out.println(arr1);
        for(int i=0;i<arr1.size();i++){
            ArrayList<Integer> temp=new ArrayList<>();
            for(int j=0;j<arr1.get(i).size();j++) temp.add(arr1.get(i).get(j)[1]);
            Collections.sort(temp);
            for(int j=0;j<arr1.get(i).size();j++){
                ans[temp.get(j)]=arr1.get(i).get(j)[0];
            }
        }
        System.out.println(Arrays.toString(ans));
        return ans;
    }
}
class Solution {
    public int threeSumMulti(int[] arr, int target) {
        Arrays.sort(arr);
        int ans=0;
        int m=1000000007;
        for(int i=0;i<arr.length;i++){
            int newTar=target-arr[i];
            
            HashMap<Integer,Integer> map=new HashMap<>();
            
            for(int j=i+1;j<arr.length;j++){
                int count=map.getOrDefault(newTar-arr[j],0);
                
                ans=(ans%m+count%m)%m;
                
                map.put(arr[j],map.getOrDefault(arr[j],0)+1);
            }
        }
        
        return ans;
    }
}
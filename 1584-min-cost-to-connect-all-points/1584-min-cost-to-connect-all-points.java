class Solution {
    int findParent(int[] parent,int u){
        if(u==parent[u]) return u;
        return parent[u]=findParent(parent,parent[u]);
    }
    public int minCostConnectPoints(int[][] points) {
        int n=points.length;
        int[][] arr=new int[n*n][3];
        for(int i=0,k=0;i<n;i++){
            for(int j=0;j<n;j++,k++){
                arr[k][0]=i;
                arr[k][1]=j;
                arr[k][2]=Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1]);
            }
        }
        int[] parent=new int[n];
        int[] size=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
            size[i]=1;
        }
        Arrays.sort(arr,(a,b)->{
            return a[2]-b[2];
        });
        
        int count=0;
        int ans=0;
        int idx=0;
        while(count<n-1 && idx<arr.length){
            int p1=findParent(parent,arr[idx][0]);
            int p2=findParent(parent,arr[idx][1]);
            int w=arr[idx][2];
            idx++;
            
            if(p1==p2) continue;
            if(size[p1]>size[p2]){
                parent[p2]=p1;
                size[p1]+=size[p2];
            }
            else{
                parent[p1]=p2;
                size[p2]+=size[p1];
            }
            ans+=w;
            count++;
        }
        return ans;
    }
}
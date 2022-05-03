class Solution {
    public int minimumCardPickup(int[] cards) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int ans=(int)1e8;
        for(int i=0;i<cards.length;i++){
            if(map.containsKey(cards[i])){
                int len=i-map.get(cards[i])+1;
                ans=Math.min(ans,len);
            }
            map.put(cards[i],i);
        }
        
        return ans>=(int)1e8?-1:ans;
    }
}
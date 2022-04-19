class Solution {
    class Pair implements Comparable<Pair>{
        int f;
        char c;
        public Pair(char c,int f){
            this.c=c;
            this.f=f;
        }
        public int compareTo(Pair p){
            return p.f-this.f;
        }
    }
    public String reorganizeString(String s) {
        int[] freq=new int[26];
        
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        for(int i=0;i<s.length();i++){
            freq[s.charAt(i)-'a']++;
        }
        
        for(int i=0;i<26;i++){
            if(freq[i]>0){
                pq.add(new Pair((char)('a'+i),freq[i]));
            }
        }
        
        StringBuilder sb=new StringBuilder();
        
        Pair p1=pq.remove();
        sb.append(p1.c);
        p1.f--;
        while(pq.size()>0){
            Pair p2=pq.remove();
            sb.append(p2.c);
            p2.f--;
            if(p1.f>0){
                pq.add(p1);
            }
            p1=p2;
        }
        if(sb.length()!=s.length()){
            return "";
        }
        return sb.toString();
        
    }
}
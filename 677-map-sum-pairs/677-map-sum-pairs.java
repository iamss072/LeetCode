class MapSum {
    Node root;
    class Node{
        Node[] children;
        boolean isEnd;
        int sum,cont;
        public Node(){
            children=new Node[26];
            isEnd=false;
            sum=0;
            cont=0;
        }
    }
    public MapSum() {
        root=new Node();
    }
    
    public void insert(String key, int val) {
        mod_insert(key,0,val,root);
    }
    private int mod_insert(String key,int idx,int val,Node root){
        
        if(idx==key.length()){
            if(root.isEnd==true){
                root.sum=root.sum-root.cont+val;
                int p=root.cont;
                root.cont=val;
                return p;
            }
            else{
                root.sum=root.sum+val;
                root.cont=val;
                root.isEnd=true;
                return 0;
            }
        }
        
        int v=key.charAt(idx)-'a';
        if(root.children[v]==null){
            root.children[v]=new Node();
        }
        
        int ret=mod_insert(key,idx+1,val,root.children[v]);
        root.sum=root.sum-ret+val;
        
        return ret;
    }
    
    public int sum(String prefix) {
        return mod_sum(prefix,0,root);
    }
    private int mod_sum(String s,int idx,Node root){
        
        if(root==null) return 0;
        if(idx==s.length()) return root.sum;
        return mod_sum(s,idx+1,root.children[s.charAt(idx)-'a']);
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
class MyHashSet {
    class Node{
        int key,val;
        Node next=null;
        public Node(int key){
            this.key=key;
        }
    }
    class NodeList{
        Node head;
        int length;
        public NodeList(){
            this.head=null;
            this.length=0;
        }
    }
    NodeList[] buckets;
    int size;
    
    private void rehash(){
        NodeList[] tbuckets=buckets;
        
        initbuckets(2*buckets.length);
        for(NodeList nl:buckets){
            Node ptr=nl.head;
            while(ptr!=null){
                add(ptr.key);
            }
            ptr=ptr.next;
        }
    }
    private void initbuckets(int n){
        buckets=new NodeList[n];
        for(int i=0;i<n;i++){
            buckets[i]=new NodeList();
        }
    }
    private int hashfn(int key){
        return Math.abs(Integer.hashCode(key))%buckets.length;
    }
    
    public MyHashSet() {
        this.size=0;
        initbuckets(10);
    }
    
    public void add(int key) {
        Node[] nodes=prevCurr(key);
        Node prev=nodes[0];
        Node curr=nodes[1];
        if(curr!=null){
            return;
        }
        if(prev==null && curr==null){
            setHead(key);
        }
        else{
            prev.next=new Node(key);
        }
        int bi=hashfn(key);
        buckets[bi].length++;
        this.size++;
        
        double lambda=(buckets[bi].length*1.0)/this.size;
        if(lambda>1.5){
            rehash();
        }
    }
    
    public void remove(int key) {
        Node[] nodes=prevCurr(key);
        Node prev=nodes[0];
        Node curr=nodes[1];
        
        if(curr==null) return;
        if(prev==null){
            removeHead(key);
        }
        else{
            prev.next=curr.next;
        }
        int bi=hashfn(key);
        buckets[bi].length--;
        this.size--;
    }
    
    public boolean contains(int key) {
        Node[] nodes=prevCurr(key);
        Node prev=nodes[0];
        Node curr=nodes[1];
        
        if(curr==null) return false;
        return true;
    }
    private void setHead(int key){
        int bi=hashfn(key);
        buckets[bi].head=new Node(key);
    }
    private void removeHead(int key){
        int bi=hashfn(key);
        Node pres=buckets[bi].head;
        buckets[bi].head=buckets[bi].head.next;
        pres.next=null;
    }
    private Node[] prevCurr(int key){
        int bi=hashfn(key);
        
        Node prev=null;
        Node curr=buckets[bi].head;
        
        while(curr!=null && curr.key!=key){
            prev=curr;
            curr=curr.next;
        }
        
        return new Node[]{prev,curr};
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
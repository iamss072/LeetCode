class MyHashMap {
    class Node{
        int key,val;
        Node next=null;
        public Node(int key,int val){
            this.key=key;
            this.val=val;
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
    public MyHashMap() {
        initbuckets(10);
        this.size=0;
    }
    private void rehash(){
        NodeList[] tbuckets=buckets;
        
        initbuckets(2*buckets.length);
        for(NodeList nl:buckets){
            Node ptr=nl.head;
            while(ptr!=null){
                put(ptr.key,ptr.val);
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
    
    public void put(int key, int value) {
        Node[] nodes=prevCurr(key);
        Node prev=nodes[0];
        Node curr=nodes[1];
        if(curr!=null){
            curr.val=value;
            return;
        }
        if(prev==null && curr==null){
            setHead(key,value);
        }
        else{
            prev.next=new Node(key,value);
        }
        int bi=hashfn(key);
        buckets[bi].length++;
        this.size++;
        
        double lambda=(buckets[bi].length*1.0)/this.size;
        if(lambda>1.5){
            rehash();
        }
    }
    
    
    public int get(int key) {
        Node[] nodes=prevCurr(key);
        Node prev=nodes[0];
        Node curr=nodes[1];
        
        if(curr!=null) return curr.val;
        else return -1;
        
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
    private void setHead(int key,int value){
        int bi=hashfn(key);
        buckets[bi].head=new Node(key,value);
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
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
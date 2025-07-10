package estructura;

public class List {
    private Node first;
    private Node last;
    private int size;
    
    public Node getFirst(){
        return this.first;
    }
    
    public void setFirst(Node data){
        this.first = data;
    }
    
    public Node getLast(){
        return this.last;
    }
    
    public void setLast(Node data){
        this.last = data;
    }
    
    public int size(){
        return this.size;
    }
    
    public void setSize(int size_){
        this.size = size_;
    }
    
    public List(){
        this.first = null;
        this.last = null;
        this.size = 0;
    }
    
    public boolean empty(){
        return (size == 0);
    }
    
    public void push_front(Node data){
        Node n = first;
        setFirst(data);
        data.setNext(n);
        if(size()==0){
            last = first;
        }
        this.size++;
    }
    
    public void push_back(Node data){
        if(empty()){
            first = last = data;
        }else{
            last.setNext(data);
            last = data;
        }
        this.size++;
    }
    
    public void printList() {
    Node current = first;
    while (current != null) {
        System.out.print(current.getData() + " ");
        current = current.getNext();
        }
        System.out.println("");
    }
}


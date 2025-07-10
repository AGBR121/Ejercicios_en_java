package estructura;

public class Node<T> {
    private T value;
    private Node<T> next;
    
    public Node(){
        this.value = null;
        this.next = null;
    }
    
    public Node(T data) {
        this.value = data;
        this.next = null;
    }
    
    public T getData(){
        return value;
    }
    
    public void setData(T data){
        this.value = data;
    }
    
    public Node<T> getNext(){
        return next;
    }
    
    public void setNext(Node<T> node){
        this.next = node;
    }
    
}

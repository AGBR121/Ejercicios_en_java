package estructura;

public class List<T extends Comparable<T>> {
    private Node<T> first;
    private Node<T> last;
    private int size;

    public List() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    public boolean empty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public Node<T> getFirst() {
        return first;
    }

    public Node<T> getLast() {
        return last;
    }

    public void push_front(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.setNext(first);
        first = newNode;

        if (size == 0) {
            last = newNode;
        }

        size++;
    }

    public void push_back(T data) {
        Node<T> newNode = new Node<>(data);

        if (empty()) {
            first = last = newNode;
        } else {
            last.setNext(newNode);
            last = newNode;
        }

        size++;
    }

    public void pop_front() {
        if (empty()) return;
        Node<T> temp = first;
        first = first.getNext();
        temp.setNext(null);  
        size--;

        if (size == 0) {
            last = null;
        }
    }

    public void pop_back() {
        if (empty()) return;

        if (first == last) {
            first = last = null;
        } else {
            Node<T> current = first;
            while (current.getNext() != last) {
                current = current.getNext();
            }
            current.setNext(null);
            last = current;
        }

        size--;
    }

    public T at(int position) {
        if (position < 0 || position >= size) {
            throw new IndexOutOfBoundsException("Indice fuera de rango: " + position);
        }

        Node<T> current = first;
        for (int i = 0; i < position; i++) {
            current = current.getNext();
        }

        return current.getData();
    }
    
    public int find(T value){
        Node<T> temp = this.first;
        int position = 0;
        while(temp!= null){
            if(temp.getData() == value){
                return position;
            }
            temp = temp.getNext();
            position++;
        }
        return -1;
    }
    
    public void insert(int position, T value){
        if (position < 0) {
            throw new IndexOutOfBoundsException("Indice fuera de rango: " + position);
        }
        if(position ==0){
            push_front(value);
        }else if(position == size-1){
            push_back(value);
        }else{
            Node<T> current = first;
            for(int i = 0; i<position-1; i++){
                current = current.getNext();
            }
            Node <T> newNode = new Node<T>(value);
            newNode.setNext(current.getNext());
            current.setNext(newNode);
            this.size++;
        }
    }
    
    public void remove(int position){
        if (position < 0) {
            throw new IndexOutOfBoundsException("Indice fuera de rango: " + position);
        }
        if(position == 0){
            pop_front();
        }else if(position == size-1){
            pop_back();
        }else{
            Node<T> current = first;
            for(int i = 0; i<position; i++){
                current = current.getNext();
            }
            current.setNext(current.getNext());
            this.size--;
        }
    }
    
    private Node<T> merge(Node<T> izquierda, Node<T> derecha) {
        Node<T> nodoInicio = new Node<>(); // Nodo temporal para construir la lista ordenada
        Node<T> actual = nodoInicio;

        while (izquierda != null && derecha != null) {
            if (izquierda.getData().compareTo(derecha.getData()) <= 0) {
                actual.setNext(izquierda);
                izquierda = izquierda.getNext();
                } else {
                actual.setNext(derecha);
                derecha = derecha.getNext();
            }
            actual = actual.getNext();
        }

        if (izquierda != null) {
            actual.setNext(izquierda);
        } else {
            actual.setNext(derecha);
        }

        return nodoInicio.getNext(); // Retorna la cabeza de la lista ordenada
    }

    
    private Node<T> getMiddle(Node<T> head) {
    if (head == null) return head;

    Node<T> slow = head;
    Node<T> fast = head.getNext();

    while (fast != null && fast.getNext() != null) {
        slow = slow.getNext();
        fast = fast.getNext().getNext();
    }

    return slow;
}

    
    private Node<T> mergeSortRecursive(Node<T> head) {
    if (head == null || head.getNext() == null) {
        return head;
    }

    Node<T> middle = getMiddle(head);
    Node<T> nextToMiddle = middle.getNext();
    middle.setNext(null); // Divide la lista en dos

    Node<T> left = mergeSortRecursive(head);
    Node<T> right = mergeSortRecursive(nextToMiddle);

    return merge(left, right);
}

    
    public void sort() {
    first = mergeSortRecursive(first);
    
    // Actualizar last al final del ordenamiento
    last = first;
    if (last != null) {
        while (last.getNext() != null) {
            last = last.getNext();
        }
    }
    
    
}


    public void printList() {
        Node<T> current = first;
        while (current != null) {
            System.out.print(current.getData() + " ");
            current = current.getNext();
        }
        System.out.println();
    }
}

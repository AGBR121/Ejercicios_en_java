package estructura;

public class List<T> {
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

    public Node<T> at(int position) {
        if (position < 0 || position >= size) {
            throw new IndexOutOfBoundsException("Indice fuera de rango: " + position);
        }

        Node<T> current = first;
        for (int i = 0; i < position; i++) {
            current = current.getNext();
        }

        return current;
    }

    public T getDataAt(int position) {
        return at(position).getData();
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

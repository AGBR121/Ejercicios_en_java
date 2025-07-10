package estructura;

public class Main {

    public static void main(String[] args) {
        List numbers = new List();
        for(int i=1; i<11; i++){
            numbers.push_back(new Node(i));
        }
        numbers.printList();
        System.out.println(numbers.size());
    }
    
}

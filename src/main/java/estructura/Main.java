package estructura;

public class Main {

    public static void main(String[] args) {
        List numbers = new List();
        for(int i=1; i<11; i++){
            numbers.push_back(new Node(i));
        }
        numbers.push_back(new Node(1));
        numbers.printList();
        numbers.pop_back();
        numbers.printList();
        numbers.pop_front();
        numbers.printList();
        System.out.println(numbers.at(8));
    }
    
}

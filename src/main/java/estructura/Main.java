package estructura;

public class Main {

    public static void main(String[] args) {
        List numbers = new List();
        for(int i=1; i<11; i++){
            numbers.push_back(i);
        }
        numbers.push_back(1);
        numbers.printList();
        numbers.pop_back();
        numbers.printList();
        numbers.pop_front();
        numbers.printList();
        System.out.println(numbers.at(8));
        System.out.println(numbers.at(0));
        
        numbers.remove(0);
        System.out.println(numbers.at(0));
        numbers.insert(4, 33);
        numbers.printList();
        numbers.insert(4, 42);
        numbers.printList();
        numbers.sort();
        numbers.printList();
    }
    
}

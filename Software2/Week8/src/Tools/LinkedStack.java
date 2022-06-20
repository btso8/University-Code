package codinguniwork.software2.week8.src.tools;

public class LinkedStack<T> implements IStack<T>{

    class Node {
        T data;
        Node next;

        Node(T data){
            this.data = data;
            this.next = null;
        }

        Node(T data, Node tail){
            this.data = data;
            this.next = tail;
        }
    }

    Node top;

    public LinkedStack(){
        top = null;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public boolean push(T value) {
        top = new Node(value, top);
        return true;
    }

    @Override
    public T peek() {
        if(top == null){
            return null;
        }
        return top.data;
    }

    @Override
    public T pop() {
        if(top == null){
            return null;
        }
        T value = peek();
        top = top.next;
        return value;
    }

    public static void main(String[] args) {
        IStack<Integer> stack = new LinkedStack<>();
        stack.push(3);
        stack.push(2);
        stack.push(5);
        int product = 1;
        while(!stack.isEmpty()){
            Integer element = stack.pop();
            product *= element;
        }
        System.out.println("product is: " + product);
        product = -1;
        while(!stack.isEmpty()){
            Integer element = stack.pop();
            product *= element;
        }
        System.out.println("product is: " + product);
        System.out.println("pop empty is: " + stack.pop());
    }

    

    
}

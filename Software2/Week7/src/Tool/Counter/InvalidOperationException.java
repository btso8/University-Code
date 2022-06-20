package codinguniwork.software2.week7.src.tool.counter;

public class InvalidOperationException extends Exception{

    public static final int UNDECLARED_OPERATION = 0;
    public static final int DECREMENT_OPERATION = 1;
    public static final int INCREMENT_OPERATION = 2;

    private int operation;

    public InvalidOperationException(String message){
        super(message);
        operation = UNDECLARED_OPERATION;
    }

    public InvalidOperationException(int operation){
        super();
        this.operation = operation;
    }

    public InvalidOperationException(String message, int operation){
        super(message);
        this.operation = operation;
    }

    public int getOperation(){
        return operation;
    }

}
package University-Code.Software2.Week9.src.Tools;

public abstract class Edge<T> {
    T source;
    T target;
    Double cost;

    public Edge(T source, T target){
        this.source = source;
        this.target = target;
        cost = 1.0;
    }

    public Edge(T source, T target, Double cost){
        this.source = source;
        this.target = target;
        this.cost = cost;
    }

    public T getSource(){
        return source;
    }

    public T getTarget(){
        return target;
    }

    public Double getCost(){
        return cost;
    }
}

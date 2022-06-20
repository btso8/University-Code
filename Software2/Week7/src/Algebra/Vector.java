package codinguniwork.software2.week7.src.algebra;
public class Vector {

    private double[] vector;

    public Vector(double[] data){
        vector = data.clone();
    }

    public int size(){
        return vector.length;
    }

    @Override
    public String toString(){
        StringBuffer output = new StringBuffer("[");
        for(int i = 0; i < vector.length - 1; i++){
            output.append(vector[i] + ", ");
        }
        output.append(vector[vector.length - 1] + "]");
        return output.toString();
    }

    public double get(int index){
        if(index < 0 || index >= vector.length){
            throw new InvalidDimensionException(Integer.toString(index));
        }
        return vector[index];
    }

    public double set(int index, double value){
        if(index < 0 || index >= vector.length){
            throw new InvalidDimensionException(Integer.toString(index));
        }

        double old = vector[index];
        vector[index] = value;
        return old;
    }

    public Vector scalarProduct(double scalar){
        double[] data = new double[size()];
        for (int i = 0; i < data.length; i++) {
            data[i] = scalar * get(i);
        }
        return new Vector(data);
    }

    public Vector add(Vector other) throws IncompatibleDimensionException{
        if (other.size() != this.size()){
            throw new IncompatibleDimensionException(Integer.toString(other.size()));
        } 
        double[] data = new double[size()];
        for (int i = 0; i < data.length; i++) {
            data[i] = other.get(i) + this.get(i);
        }
        return new Vector(data);
    }

    @Override
    public boolean equals(Object other){
        if(this == other){
            return true;
        }
        if(!(other instanceof Vector)){
            return false;
        }
        Vector v = (Vector) other;
        if(this.size() != v.size()){
            return false;
        }
        for (int i = 0; i < vector.length; i++) {
                if(v.get(i) != this.get(i)){
                    return false;
                }
        }
        return true;
    }


    public static void main(String[] args) {
        double[] data = {1, 2, 3, 4};
        Vector v = new Vector(data);
        System.out.println(v);
        Vector v2 = new Vector(data);
        System.out.println(" ==? " + (v == v2) + ", equals()? " + v.equals(v2));
        System.out.println("null ==? " + (v ==null) + ", equals()? " + v.equals(null));
        Vector v3 = new Vector(new double[]{5,1,3,2});

        try{
            v2 = v.add(v3);
        }catch(IncompatibleDimensionException ex){
            System.out.println("cannot perform vector addition as the dimension are not compatible");
            ex.printStackTrace();
        }
        System.out.println(v2.get(5));
    }
}

public class ArrayPointer implements Cloneable{
    private int loc;
    private final int capacity;

    public ArrayPointer(int loc, int capacity){
        this.loc = loc;
        this.capacity = capacity;
    }

    public ArrayPointer(int capacity){
        this(0,capacity);
    }

    public int getLoc() {
        return loc;
    }

    public void setLoc(int loc) {
        this.loc = loc;
    }

    public void advancePointer(){
        if(this.loc == this.capacity-1)
            this.loc = 0;
        this.loc++;
    }

    public ArrayPointer clone(){
    return new ArrayPointer(this.loc);
    }
}

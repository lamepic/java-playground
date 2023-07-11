package oop.ipair;

public class IPair {
    private int x;
    private int y;

    IPair(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString(){
        return "(" + this.x + ", " + this.y + ")";
    }

    @Override
    public boolean equals(Object other){
        if(other == null) return false;
        if(!(other instanceof IPair)) return false;
        if(other == this) return true;

        IPair ob = (IPair) other;
        return ob.x == this.x && ob.y == this.y;
    }

}

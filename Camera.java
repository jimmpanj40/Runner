public class Camera {
    private double x;
    private double y;


    public Camera(){
        this.x=0;
        this.y=0;
    }
    public Camera(double x, double y){
        this.x=x;
        this.y=y;
    }
    public double hero_x(){
        return x;
    }
    public double hero_y(){
        return y;
    }

    @Override
    public String toString() {
        return "("+x+","+y+")";
    }
}

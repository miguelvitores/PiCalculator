package PiCalculator;

import java.awt.geom.Point2D;


public class Point extends Point2D{
    private double x;
    private double y;

    public Point() {
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public double getX() {
        return this.x;
    }

    @Override
    public double getY() {
        return this.x;
    }
    
    public void setX(double x){
        this.x = x;
    }
    
    public void setY(double y){
        this.y = y;
    }

    @Override
    public void setLocation(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    public boolean isInsideCircle(double radio){
        if ( (this.x-radio)*(this.x-radio) + (this.y-radio)*(this.y-radio) < radio*radio )
            return true;
        else
            return false;
    }
    
    
}

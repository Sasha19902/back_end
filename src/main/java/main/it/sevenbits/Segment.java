package main.it.sevenbits;

public class Segment {

    private Point2D firstPoint;
    private Point2D secondPoint;

    public Segment(Point2D firstPoint, Point2D secondPoint) {
        this.firstPoint = firstPoint;
        this.secondPoint = secondPoint;
    }

    public Point2D getFirstPoint() {
        return firstPoint;
    }

    public void setFirstPoint(Point2D firstPoint) {
        this.firstPoint = firstPoint;
    }

    public Point2D getSecondPoint() {
        return secondPoint;
    }

    public void setSecondPoint(Point2D secondPoint) {
        this.secondPoint = secondPoint;
    }

    public double length() {
        double firstSub = secondPoint.getX() - firstPoint.getX();
        double secondSub = secondPoint.getY() - firstPoint.getY();

        return Math.sqrt(firstSub * firstSub + secondSub * secondSub);
    }
}

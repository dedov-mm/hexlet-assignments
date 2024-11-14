package exercise;

import exercise.
// BEGIN
public class Segment {
    private Point beginPoint;
    private Point endPoint;
    private Point midPoint;

    public Segment(Point beginPoint, Point endPoint) {
        this.beginPoint = beginPoint;
        this.endPoint = endPoint;
    }

    public Point getBeginPoint() {
        return beginPoint;
    }

    public Point getEndPoint() {
        return endPoint;
    }

    public Point getMidPoint() {

        return midPoint(((beginPoint.getX() + beginPoint.getY())/2), ((endPoint.getX() + endPoint.getY())/2);
    }
}
// END

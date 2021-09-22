package controller;


public class Pointer{


  private int x1 = 0;
  private int y1 = 0;
  private int x2 = 0;
  private int y2 = 0;


  public void startCoordinates(int x, int y){
    x1 = x;
    y1 = y;
  }

  public void endCoordinates(int x, int y){
    x2 = x;
    y2 = y;
  }

  public int getX1() {
    return x1;
  }

/*  public int getX2() {
    return x2;
  }*/

  public int getY1() {
    return y1;
  }

/*  public int getY2() {
    return y2;
  }*/

  public int getHeight(){
    int h = Math.abs(x1-y2);
    return h;
  }

  public int getWidth(){
    int w = Math.abs(x1-x2);
    return w;
  }



}

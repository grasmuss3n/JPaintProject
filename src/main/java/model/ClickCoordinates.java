package model;

public class ClickCoordinates {
  /**Code Created and Written by Gianna Rasmussen
   * a class that stores the start and end coordinates
   * A new one is made every time the mouse is pressed
   */

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

    check();
  }


  //solves the issue of when mouse is clicked bottom right to upper left
  private void check(){
    if(x1 > x2){
      int x = x1;
      x1 = x2;
      x2 = x;
    }

    if(y1 > y2){
      int y = y1;
      y1 = y2;
      y2 = y;
    }


  }

  public int getX1() {
    return x1;
  }


  public int getY1() {
    return y1;
  }

  public int getX2() {
    return x2;
  }


  public int getY2() {
    return y2;
  }

  //getWidth and getWidth are important for the drawing phase.
  public int getHeight(){
    return Math.abs(y1-y2);
  }

  public int getWidth(){
    return Math.abs(x1-x2);
  }



}

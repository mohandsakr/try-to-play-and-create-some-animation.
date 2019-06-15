/*
 *  
 draw circle using draw line  function 
 using Parametric form
The equation can be written in parametric form using the trigonometric functions sine and cosine as

    x = a + r cos ⁡ t , {\displaystyle x=a+r\,\cos t,\,} x=a+r\,\cos t,\,
    y = b + r sin ⁡ t {\displaystyle y=b+r\,\sin t\,} y = b+r\,\sin t\,
 
 by sakr 
 *  
 *  
 */
package drawline;

/**
 *
 * @author sakr
 */
import java.awt.*;
import java.util.TimerTask;
import javax.swing.*;
 import java.util.Timer;
public class DrawCircle extends JPanel {


static int angle;
static int radius;
static int center_X_point;
static int center_Y_point;
static int start_X;
static int start_Y;
  int x1,y1,x2,y2;

 DrawCircle(int a,int b,int c ,int d){  //constructor intlize the values of points
	x1=a;
	y1=b;
	x2=c;
	y2=d; 
 }


 @Override
   public void paintComponent(Graphics g) {
      // fill the shape with  color
     g.setColor(Color.blue);

        //draw line with two points 
     g.drawLine(x1, y1, x2, y2);
     
     // if the circle completed then clear the panel ;
     if(angle==360){
                g.clearRect(0, 0, 500, 500);
                angle=0;
     }
 
  }
 
 /* git the x value on the diamter of the circle. +
  *

	Parametric form
	The equation can be written in parametric form using the trigonometric functions sine and cosine as

    x = a + r cos ⁡( t ) 

  */
 public static  int xValue(int radius,int CenterX, int angle){

     double radianangle=(angle*Math.PI)/180;
     double leftHs=radius*Math.cos((radianangle));
        return (int)( CenterX+leftHs);
 
 
 }

 /*
git the y value using the formula   

Parametric form
	The equation can be written in parametric form using the trigonometric functions sine and cosine as
  y = b + r sin ⁡(t )



 */
 public static  int yValue(int radius,int CenterY, int angle){
     double radianangle=(angle*Math.PI)/180;
     double leftHs=radius*Math.sin((radianangle));
return (int)(CenterY+leftHs);
 }
 
  public static void main(String[] args) {
       angle=0; // set the angle on start with 0
       radius=200; // set radius
       center_X_point=250; //define the center x point.
       center_Y_point=250; //define the center y point.

       start_X=xValue(radius,center_X_point,angle); // git the currnet x  using the current pramters
       start_Y=yValue(radius, center_Y_point, angle);  //// git the currnet y  using the current pramters
       
    JFrame frame = new JFrame("Draw Circle");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setBackground(Color.white);
    frame.setSize(500, 500);
  Timer timer=new Timer();
   TimerTask task = new TimerTask() {
         
         @Override
         public void run() {
             ++angle;  
           int x1,y1,x2,y2;
             x1=start_X;
             y1=start_Y;
             x2=xValue(radius,center_X_point, angle);
             y2=yValue(radius, center_Y_point, angle);
            DrawCircle  panel = new DrawCircle(x1,y1,x2,y2);
                 System.out.println(x1+" "+y1);  // output the current points 
                 System.out.println(x2+" "+y2); // output the current points
                 System.out.println("angle is "+angle);// output the current  angle 
                 /*make new start x = the last point to draw from to connect the lines */
                 start_X=x2;
                             /*make new start y = the last point to draw from to connect the lines */

                 start_Y=y2;
            frame.add(panel);
            frame.setVisible(true);
             
           
             
         }
     };
     
    timer.scheduleAtFixedRate(task, 20, 20);  //schedule the   task for repeated fixed-rate execution, beginning after the specified delay
    

    
  }
  }

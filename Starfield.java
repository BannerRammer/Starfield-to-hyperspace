import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Starfield extends PApplet {

float speed;
Star[] stars = new Star[1000];


public void setup() {
  
  for (int i = 0; i  < stars.length; i++) {
    stars[i] = new Star();
  }
}

public void draw() {
  speed = map(mouseX, 0, width, 0, 20);
  background(0);
  translate(width/2, height/2);
  for (int i = 0; i  < stars.length; i++) {
    stars[i].update();
    stars[i].show();
  }
  
}
class Star {
   float x;
   float y;
   float z; 
   
   float pz;
   
Star() {
  x = random(-width, width);
  y = random(-height, height);
  z = random(width);
  pz = z;
}
  
  public void update() {
    z = z -speed;
    if (z < 1) {
     z = width;
      x = random(-width, width);
      y = random(-height, height);
      pz = z;
   }
 }


public void show() {
  fill(255);
  noStroke();
  
  float sx = map(x / z, 0, 1, 0, width);
  float sy = map(y / z, 0, 1, 0, height);
  
  float r = map(z, 0, width, 16, 0);
  ellipse(sx, sy, r, r);
  

  float px = map(x / pz, 0, 1, 0, width);
   float py = map(y / pz, 0, 1, 0, height);

  
  stroke(255);
  line(px, py, sx, sy);
  

 }

}
  public void settings() {  size(800, 800); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Starfield" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}

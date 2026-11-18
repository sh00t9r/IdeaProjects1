package ru.samsa;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

import java.util.Random;

public class Tier {

    int x, y, d, hy;
    int width, height;
    Random r = new Random();
    int speed;
    int jumpHeight;
    final int maxHeightOfJump = 200;
    boolean jump, ispointrecived;

    int frameCounter;
    Texture trubatexture, Trubatexture;

    public Tier(int x, int y) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.width = width;
        this.height = height;
        frameCounter = 0;
        trubatexture = new Texture("truba.png");
        Trubatexture = new Texture("flipped_truba.png");
        d = r.nextInt(350,500);
        hy = d+y+250;
    }

    void move() {
        x -=1;
        if (x<0){
            x = 2550;
            ispointrecived = true;
        }
    }

    void draw(Batch batch) {
        batch.draw(trubatexture, x,y,100,250);
        batch.draw(Trubatexture, x, hy , 100, 250);
    }
    public boolean needAddPoint(Bird bird) {
        return false;
    }

    void dispose() {
        trubatexture.dispose();
    }
    public boolean ispointreal(Bird bird){
     if(!ispointrecived && x+width<=bird.x){
         ispointrecived = true;
         return true;

     }
     return false;
    }
    public boolean ishit(Bird bird){
        int gapy = d/2+ this.y+this.height;

        if ((bird.x<=this.x+this.width && bird.x+bird.width>=this.x && bird.y<gapy) || (bird.x<=this.x+this.width && bird.x+bird.width>=this.x && bird.y>gapy)){
           return true;
          }
        else {
            return false;
        }
    }

}

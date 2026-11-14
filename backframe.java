package ru.samsa;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

public class backframe {
    int texture1X;
    int speed = 2;
    public  static int with_scr = 1577, heigh_scr = 985;
    Texture texture;

     backframe() {
        texture1X = 0;
        texture = new Texture("game_bg.png");
    }
    void draw(Batch batch) {
        batch.draw(texture, texture1X, 0,with_scr ,heigh_scr);
        batch.draw(texture, texture1X+with_scr, 0,with_scr ,heigh_scr);
    }
    void move(){
        texture1X -=1;
        if (texture1X< -with_scr ){
            texture1X = 0;
        }
    }

}

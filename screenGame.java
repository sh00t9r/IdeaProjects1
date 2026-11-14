package ru.samsa;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.Random;

public class screenGame implements Screen {

    MyGdxgame myGdxGame;
    Bird bird;
    pointcounter pointCounter;
    backframe Backframe;
    Tier tiers[];
    boolean lose;
    int pts = 0;


    screenGame(MyGdxgame myGdxGame) {
        Random r = new Random();
        lose = false;
        this.myGdxGame = myGdxGame;
        bird = new Bird(0, 400, 5, 150, 120);
        tiers = new Tier[10];
        for (int i = 0; i < tiers.length; i++) {
            tiers[i] = new Tier(i * 250 + 50, -200 + r.nextInt(50, 150));
        }
    }


    @Override
    public void show() {
        pointCounter = new pointcounter(500, 700);
        Backframe = new backframe();
    }

    @Override
    public void render(float delta) {
        if (Gdx.input.justTouched()) {
            bird.onClick();
        }

        bird.fly();
        for (Tier t : tiers) {
            t.move();
        }

        ScreenUtils.clear(0.5F, 0.7F, 0.4F, 1);

        myGdxGame.camera.update();
        myGdxGame.batch.setProjectionMatrix(myGdxGame.camera.combined);

        myGdxGame.batch.begin();
        Backframe.draw(myGdxGame.batch);
        bird.draw(myGdxGame.batch);
        for (Tier t : tiers) {
            t.draw(myGdxGame.batch);
        }
        for (Tier tier : tiers) {
            //bird.x, bird.y, bird.width, bird.height 100, 574 ;
//            int y2 = tier.y+574+tier.d;
//            if (bird.y>tier.y+574 && bird.y+bird.height<y2){
//                lose = false;
            if(tier.ispointreal(bird)) {
                pts += 1;

            }

        }
        Backframe.move();

        pointCounter.draw(myGdxGame.batch, pts);
        myGdxGame.batch.end();
    }


    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void hide() {
    }

    @Override
    public void dispose() {
        bird.dispose();
    }
}


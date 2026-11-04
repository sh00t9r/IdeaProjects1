package ru.samsa;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxgame extends Game {

    public static final int SCR_WIDTH = 1280;
    public static final int SCR_HEIGHT = 720;

    public SpriteBatch batch;
    public OrthographicCamera camera;

    screenGame screenGame;

    @Override
    public void create() {
        batch = new SpriteBatch();

        camera = new OrthographicCamera();
        camera.setToOrtho(false, SCR_WIDTH, SCR_HEIGHT);

        screenGame = new screenGame(this);
        setScreen(screenGame);
    }

    @Override
    public void dispose() {
        screenGame.dispose();
        batch.dispose();
    }
}

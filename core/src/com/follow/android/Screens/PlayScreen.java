package com.follow.android.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.follow.android.Background.StraightTube;
import com.follow.android.Characters.Player;
import com.follow.android.FollowMain;
import com.follow.android.Others.Score;

public class PlayScreen implements Screen {

    FollowMain main;

    private OrthographicCamera gamecam;
    private Viewport gameport;

    private Score score;
    private Player player;
    private StraightTube tube;

    public PlayScreen(FollowMain main) {
        this.main = main;

        gamecam = new OrthographicCamera();
        gameport = new FitViewport(FollowMain.WIDTH, FollowMain.HEIGHT, gamecam);

        score = new Score(main.batch);

        player = new Player(gameport);
        tube = new StraightTube(player);

        Gdx.gl.glClearColor(0, 0, 1, 1);
    }

    public void update(float dt) {
        player.update(dt);
        tube.update(dt);
        gamecam.update();
    }

    @Override
    public void render(float delta) {
        update(delta);

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        score.render(main.batch);

        main.batch.setProjectionMatrix(gamecam.projection);
        main.batch.begin();
        tube.render(gamecam);
        player.render(gamecam);
        main.batch.end();
    }

    @Override
    public void dispose() {
        main.batch.dispose();
    }

    @Override
    public void resize(int width, int height) {
        gameport.update(width, height);
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
    public void show() {

    }
}

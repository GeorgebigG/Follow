package com.follow.android.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.follow.android.Background.Cross;
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
    private Cross cross;

    public PlayScreen(FollowMain main) {
        this.main = main;

        gamecam = new OrthographicCamera();
        gameport = new FitViewport(FollowMain.WIDTH, FollowMain.HEIGHT, gamecam);

        score = new Score(main.batch);

        player = new Player(gameport);
        tube = new StraightTube(player);
        cross = new Cross(player, tube);

        Gdx.gl.glClearColor(0, 0, 1, 1);
    }

    public void update(float dt) {
        player.update(dt);
        tube.update(dt);
        cross.update(dt);

        gamecam.position.y = player.position.y + gamecam.viewportHeight / 2 - player.position.radius * 2;

        Vector3 point = new Vector3(player.position.x, player.position.y, 0);
        Vector3 axis = new Vector3(0, 0, 1f);

        if (Gdx.input.isKeyPressed(Input.Keys.R))
            gamecam.rotateAround(point, axis, 1);
        else if (Gdx.input.isKeyPressed(Input.Keys.L))
            gamecam.rotateAround(point, axis, -1);

        if (Gdx.input.isKeyPressed(Input.Keys.PLUS) || Gdx.input.isKeyPressed(Input.Keys.EQUALS))
            gamecam.zoom -= 0.02f;
        else if (Gdx.input.isKeyPressed(Input.Keys.MINUS))
            gamecam.zoom += 0.02f;

        gamecam.update();
    }

    @Override
    public void render(float delta) {
        update(delta);

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        main.batch.setProjectionMatrix(gamecam.projection);
        main.batch.begin();
        player.renderer.setProjectionMatrix(gamecam.combined);
        tube.render(main.batch);
        cross.render(gamecam);
        player.render(gamecam);
        main.batch.end();


        score.render(main.batch);
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

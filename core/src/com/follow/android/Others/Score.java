package com.follow.android.Others;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.follow.android.FollowMain;

public class Score {

    private Stage stage;
    private Viewport viewport;

    private int score;
    private Label scoreLabel;

    public Score(SpriteBatch batch) {
        score = 0;

        viewport = new FitViewport(FollowMain.WIDTH / 2, FollowMain.HEIGHT / 2, new OrthographicCamera());
        stage = new Stage(viewport, batch);

        Table table = new Table();
        table.top();
        table.setFillParent(true);

        scoreLabel = new Label("" + score, new Label.LabelStyle(new BitmapFont(), Color.WHITE));

        table.add(scoreLabel).expandX().center().padTop(10);

        stage.addActor(table);
    }

    public void render(SpriteBatch batch) {
        batch.setProjectionMatrix(stage.getCamera().projection);
        stage.draw();
    }
}

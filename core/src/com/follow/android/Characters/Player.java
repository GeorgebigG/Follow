package com.follow.android.Characters;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.viewport.Viewport;

public class Player {

    public Circle position;
    public ShapeRenderer renderer;
    public Viewport viewport;

    public Player(Viewport viewport) {
        int width = 30;

        this.position = new Circle(0, -viewport.getWorldHeight() / 2 + width * 2, width);
        renderer = new ShapeRenderer();
        this.viewport = viewport;
    }

    public void update(float dt) {

    }

    public void render(OrthographicCamera camera) {
        renderer.setProjectionMatrix(camera.combined);
        renderer.begin(ShapeRenderer.ShapeType.Filled);

        renderer.setColor(Color.GOLD);
        renderer.circle(position.x, position.y, position.radius);

        renderer.end();
    }
}

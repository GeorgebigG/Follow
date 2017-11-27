package com.follow.android.Characters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
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

    private static int speed;

    public static int getSpeed() {
        return speed;
    }

    public Player(Viewport viewport) {
        int radius = 30;

        speed = 3;
        this.position = new Circle(0, -viewport.getWorldHeight() / 2 + radius * 2, radius);
        renderer = new ShapeRenderer();
        this.viewport = viewport;
    }

    public void update(float dt) {
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT))
            position.x += 3;

        else if (Gdx.input.isKeyPressed(Input.Keys.LEFT))
            position.x -= 3;

        if (Gdx.input.isKeyPressed(Input.Keys.UP))
            position.y += speed;

        else if (Gdx.input.isKeyPressed(Input.Keys.DOWN))
            position.y -= speed;
    }

    public void render(OrthographicCamera camera) {
        renderer.setProjectionMatrix(camera.combined);
        renderer.begin(ShapeRenderer.ShapeType.Filled);

        renderer.setColor(Color.GOLD);
        renderer.circle(position.x, position.y, position.radius);

        renderer.end();
    }
}

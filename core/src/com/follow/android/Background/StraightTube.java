package com.follow.android.Background;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.follow.android.Characters.Player;

public class StraightTube {

    Player player;
    Rectangle position;

    public StraightTube(Player player) {
        this.player = player;
        position = new Rectangle(player.position.x - player.position.radius - 10,
                player.position.y - player.position.radius * 2, player.position.radius * 2 + 20,
                player.viewport.getWorldHeight());
    }

    public void update(float dt) {

    }

    public void render(OrthographicCamera camera) {
        player.renderer.setProjectionMatrix(camera.combined);
        player.renderer.begin(ShapeRenderer.ShapeType.Filled);
        player.renderer.setColor(Color.CORAL);
        player.renderer.rect(position.x, position.y, position.width, position.height);
        player.renderer.setColor(Color.GREEN);
        player.renderer.rect(position.x - 10, position.y, 10, position.height);
        player.renderer.setColor(Color.GREEN);
        player.renderer.rect(position.x + position.width, position.y, 10, position.height);
        player.renderer.end();
    }
}

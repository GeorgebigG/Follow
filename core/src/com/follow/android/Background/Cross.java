package com.follow.android.Background;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.follow.android.Characters.Player;

public class Cross {

    private StraightTube tube;
    private Player player;
    public Rectangle position1, position2;
    private ShapeRenderer rotated;

    public Cross(Player player, StraightTube tube) {
        this.player = player;
        position1 = new Rectangle(tube.position.x, tube.position.y + tube.position.height,
                tube.position.width, tube.position.height);

        position2 = new Rectangle(tube.position.x + tube.position.width / 2,
                (float) (position1.y + Math.sqrt(Math.pow(position1.width, 2) - Math.pow(position1.width / 2, 2))),
                position1.width, position1.height);

        this.tube = tube;
        rotated = new ShapeRenderer();
    }

    public void update(float dt) {
        position1.y = tube.position.y + tube.position.height;
        position2.y = (float) (position1.y + Math.sqrt(Math.pow(position1.width, 2) - Math.pow(position1.width / 2, 2)));
    }

    public void render(OrthographicCamera camera) {
        rotated.setProjectionMatrix(camera.combined);
        rotated.begin(ShapeRenderer.ShapeType.Filled);

        // FIRST
        rotated.setColor(Color.CORAL);
        rotated.rect(position1.x, position1.y, 0, 0, position1.width, position1.height, 1f, 1f, 60);
        rotated.setColor(Color.GREEN);
        rotated.rect(position1.x - 6, position1.y - 8, 0, 0, 10, position1.height, 1f, 1f, 60);
        rotated.setColor(Color.GREEN);
        rotated.rect(position1.x + position1.width / 2, position2.y, 0, 0, 10, position1.height, 1f, 1f, 60);

        //SECOND
        rotated.setColor(Color.CORAL);
        rotated.rect(position2.x, position2.y, 0, 0, position2.width, position2.height, 1f, 1f, 300);
        rotated.setColor(Color.GREEN);
        rotated.rect(position1.x + position2.width, position1.y, 0, 0, 10, position1.height, 1f, 1f, 300);
        rotated.setColor(Color.GREEN);
        rotated.rect(position1.x + position1.width / 2 - 4, position2.y + 8, 0, 0, 10, position1.height, 1f, 1f, 300);

        // Fill the blanks
        rotated.setColor(Color.CORAL);
        rotated.triangle(position1.x, position1.y, position2.x, position2.y, position1.x + position2.width, position1.y);

        rotated.end();
    }
}

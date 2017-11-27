package com.follow.android.Background;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;
import com.follow.android.Characters.Player;

public class Cross {

    enum Direction {
        LEFT,
        RIGHT,
        NEITHER;
    }

    private StraightTube tube;
    private Player player;
    public Rectangle position1, position2;
    private ShapeRenderer rotated;

    private Circle middle;

    private Direction direction;

    public Cross(Player player, StraightTube tube) {
        this.player = player;
        position1 = new Rectangle(tube.position.x, tube.position.y + tube.position.height,
                tube.position.width, tube.position.height);

        position2 = new Rectangle(tube.position.x + tube.position.width / 2,
                (float) (position1.y + Math.sqrt(Math.pow(position1.width, 2) - Math.pow(position1.width / 2, 2))),
                position1.width, position1.height);

        this.tube = tube;
        rotated = new ShapeRenderer();

        middle = new Circle(tube.position.x + tube.position.width / 2,
                position1.y + (float) Math.sqrt(Math.pow(position1.width, 2) - Math.pow(position1.width / 2, 2)) / 2,
                        10);

        direction = Direction.NEITHER;
    }

    public void update(float dt) {
        position1.y = tube.position.y + tube.position.height;
        position2.y = (float) (position1.y + Math.sqrt(Math.pow(position1.width, 2) - Math.pow(position1.width / 2, 2)));

//        System.out.println("y: " + (int) player.position.y + ", y1: " + (int) middle.y);
        if (!player.stop) {
            for (int i = 0; i < Player.getSpeed(); i++)
                if ((int) player.position.y + i == (int) middle.y) {
                    player.stop = true;
                    if (Gdx.input.isKeyPressed(Input.Keys.LEFT))
                        direction = Direction.LEFT;
                    else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT))
                        direction = Direction.RIGHT;
                    else {
                        // TODO: change it:
                        System.exit(0);
                        //temp
                    }
                    break;
                }
        }
    }

    public void render(OrthographicCamera camera) {
        rotated.setProjectionMatrix(camera.combined);
        rotated.begin(ShapeRenderer.ShapeType.Filled);

        // FIRST
        rotated.setColor(Color.CORAL);
        rotated.rect(position1.x, position1.y, 0, 0, position1.width, position1.height, 1f, 1f,
                (direction == Direction.NEITHER) ? 60 : (direction == Direction.LEFT) ? 0 : 120);
        rotated.setColor(Color.GREEN);
        rotated.rect(position1.x - 6, position1.y - 8, 0, 0, 10, position1.height, 1f, 1f,
                (direction == Direction.NEITHER) ? 60 : (direction == Direction.LEFT) ? 0 : 120);
        rotated.setColor(Color.GREEN);
        rotated.rect(position1.x + position1.width / 2, position2.y, 0, 0, 10, position1.height, 1f, 1f,
                (direction == Direction.NEITHER) ? 60 : (direction == Direction.LEFT) ? 0 : 120);

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

        //temp
        rotated.setColor(Color.WHITE);
        rotated.circle(middle.x, middle.y, middle.radius);

        rotated.end();
    }
}

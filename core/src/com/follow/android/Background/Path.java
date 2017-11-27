package com.follow.android.Background;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g3d.particles.values.LineSpawnShapeValue;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.follow.android.Characters.Player;

import java.util.ArrayList;

/**
 * Created by George on 11/26/2017.
 */

public class Path {

    public static ArrayList<Line>    path;
    private Cross                       cross;
    private StraightTube                currentTube;
    private Player                      player;
    private ShapeRenderer               renderer;

    enum Line {
        STRAIGHT,
        ROTATED;

        public float x, y, x2, y2, angle;

        public Line set(float x, float y, float x2, float y2, int angle) {
            Line line;
            if (angle == 0)
                line = STRAIGHT;
            else
                line = ROTATED;

            line.x = x;
            line.y = y;
            line.x2 = x2;
            line.y2 = y2;
            line.angle = angle;

            return line;
        }
    }

    public Path() {
        path = new ArrayList<Line>();
        renderer = new ShapeRenderer();
    }

    public ArrayList<Line> findPath(Cross cross, StraightTube currentTube, Player player) {
        this.cross = cross;
        this.currentTube = currentTube;
        this.player = player;

        path.clear();

        path.add(Line.STRAIGHT.set(player.position.x, player.position.y, currentTube.position.x + currentTube.position.width / 2,
                currentTube.position.y + currentTube.position.height, 0));

//        path.add(Line.STRAIGHT.set(currentTube.position.x + currentTube.position.width / 2, cross.position1.y + (cross.position2.y - cross.position1.y) / 2,
//                cross.position1.x + cross.position1.width / 2, cross.position1.y + cross.position1.height, 0));

        return path;
    }

    public void update(float dt) {

    }

    public void render(OrthographicCamera camera) {
        renderer.setProjectionMatrix(camera.combined);
        renderer.begin(ShapeRenderer.ShapeType.Filled);
        renderer.setColor(Color.FOREST);
        for (Line line : path)
            renderer.line(line.x, line.y, line.x2, line.y2);
        renderer.end();
    }
}

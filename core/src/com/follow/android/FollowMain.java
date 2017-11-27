package com.follow.android;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.follow.android.Screens.PlayScreen;

public class FollowMain extends Game {
	public SpriteBatch batch;

	public static final int WIDTH = 500;
	public static final int HEIGHT = 800;

	@Override
	public void create () {
		batch = new SpriteBatch();
		setScreen(new PlayScreen(this));
	}
}

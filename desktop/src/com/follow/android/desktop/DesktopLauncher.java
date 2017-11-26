package com.follow.android.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.follow.android.FollowMain;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = FollowMain.WIDTH;
		config.height = FollowMain.HEIGHT;
		config.samples = 6;
		new LwjglApplication(new FollowMain(), config);
	}
}

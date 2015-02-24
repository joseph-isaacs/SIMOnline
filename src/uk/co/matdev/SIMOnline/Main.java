package uk.co.matdev.SIMOnline;

import org.lwjgl.opengl.Display;
import org.newdawn.slick.*;
import uk.co.matdev.SIMOnline.core.ObjectManager;
import uk.co.matdev.SIMOnline.core.BattleManager;

public class Main extends BasicGame {
    public static int WIDTH = 1000;
    public static int HEIGHT = 1000;
    public static final boolean FULLSCREEN = false;
    public static int MAX_FRAMERATE = 60;

    private ObjectManager oM;

    public static final String TITLE = "Slimes Invade Moscow";

    public Main(String name) {
        super(name);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        oM = new ObjectManager();
        oM.addObject(new BattleManager());
    }

    @Override
    public void update(GameContainer gameContainer, int i) throws SlickException {

    }

    @Override
    public void render(GameContainer gameContainer, org.newdawn.slick.Graphics graphics) throws SlickException {
        oM.render(graphics);
    }

    public static void main(String args[]) throws SlickException {
        Display.setResizable(true);

        AppGameContainer app = new AppGameContainer(new Main(TITLE));

        app.setVSync(true);
        app.setDisplayMode(WIDTH, HEIGHT, FULLSCREEN);
        app.setTargetFrameRate(MAX_FRAMERATE);
        app.start();
    }



}

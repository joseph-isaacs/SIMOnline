package uk.co.matdev.SIMOnline;

import org.lwjgl.opengl.Display;
import org.newdawn.slick.*;
import uk.co.matdev.SIMOnline.core.SIMGraphics;
import uk.co.matdev.SIMOnline.core.ObjectManager;
import uk.co.matdev.SIMOnline.core.battle.BattleManager;
import uk.co.matdev.SIMOnline.maths.Rectangle2d;

public class Main extends BasicGame {
    public static int WIDTH = 1920;
    public static int HEIGHT = 1080;
    public static final boolean FULLSCREEN = true;
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


    private int counter = 0;
    @Override
    public void update(GameContainer gameContainer, int i) throws SlickException {
        counter += i;
       if (counter >= 100){
            counter = 0;
            oM.doUpdate();
        }
       // oM.doUpdate();
    }

    @Override
    public void render(GameContainer gameContainer, org.newdawn.slick.Graphics graphics) throws SlickException {
        SIMGraphics drawer = new SIMGraphics(graphics, new Rectangle2d<Integer>(50,50, WIDTH-100, HEIGHT-100));
        oM.draw(drawer);
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

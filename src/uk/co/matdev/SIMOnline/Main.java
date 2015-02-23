package uk.co.matdev.SIMOnline;





import org.lwjgl.opengl.Display;
import org.newdawn.slick.*;
import uk.co.matdev.SIMOnline.core.ObjectManager;


public class Main extends BasicGame {
    public static int WIDTH = 1200;
    public static int HEIGHT = 1000;
    public static final boolean FULLSCREEN = false;

    private ObjectManager oM = new ObjectManager();

    public static final String TITLE = "SlickTiled Testing Canvas";

    public Main(String name) {
        super(name);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {

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

        AppGameContainer app = new AppGameContainer(new Main("Hello"));

        app.setVSync(true);
        app.setDisplayMode(1100, 1100, false);
        app.setTargetFrameRate(100);
        app.start();
    }



}

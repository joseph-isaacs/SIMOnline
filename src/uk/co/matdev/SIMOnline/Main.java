package uk.co.matdev.SIMOnline;





import org.lwjgl.opengl.Display;
import org.newdawn.slick.*;
import org.newdawn.slick.Color;
import uk.co.matdev.SIMOnline.core.ObjectMangager;


public class Main extends BasicGame {
    public static int WIDTH = 1200;
    public static int HEIGHT = 1000;
    public static final boolean FULLSCREEN = false;

    private ObjectMangager om = new ObjectMangager();

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
        om.render(graphics);
    }

    public static void main(String args[]) throws SlickException {
        Display.setResizable(true);

        AppGameContainer app = new AppGameContainer(new Main("Hello"));

        app.setDisplayMode(800, 600, false);
        app.start();
    }



}

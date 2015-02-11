package uk.co.matdev.SIMOnline;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;



//import org.lwjgl.opengl.Display;
import org.newdawn.slick.CanvasGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Main extends StateBasedGame {
    public static int WIDTH = 800;
    public static int HEIGHT = 600;
    public static final boolean FULLSCREEN = false;

    public static final String TITLE = "SlickTiled Testing Canvas";

    public Main(String name) {
        super(name);
    }

    public static void main(String args[]) {
        try {
            Main game = new Main(TITLE);
            CanvasGameContainer container = new CanvasGameContainer(game);

            Frame frame = new Frame(TITLE);
            frame.setLayout(new GridLayout(1,2));

            if(!FULLSCREEN) {
                frame.setSize(WIDTH,HEIGHT);
            } else {
                frame.setExtendedState(Frame.MAXIMIZED_BOTH);
                frame.setUndecorated(true);
                frame.setResizable(false);
                //frame.setSize(Display.getWidth(), Display.getHeight());
            }

            frame.add(container);
            frame.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    //TODO: save stuff?
                    //Display.destroy();

                    System.out.println("Exiting " + TITLE + "...");
                    System.exit(0);
                }
            });
            frame.setVisible(true);
            Graphics g = container.getGraphics();
            g.drawString("hello", WIDTH/2, HEIGHT/2);
            container.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initStatesList(GameContainer gameContainer) throws SlickException {

    }
}

package uk.co.matdev.SIMOnline;

import org.lwjgl.opengl.Display;
import org.newdawn.slick.*;
import uk.co.matdev.SIMOnline.core.SIMGraphics;
import uk.co.matdev.SIMOnline.core.ObjectManager;
import uk.co.matdev.SIMOnline.core.battle.BattleManager;
import uk.co.matdev.SIMOnline.core.battle.units.MilitiaRussianUnit;
import uk.co.matdev.SIMOnline.core.battle.units.NormalSlimeUnit;
import uk.co.matdev.SIMOnline.core.battle.units.endUnit;
import uk.co.matdev.SIMOnline.maths.Rectangle2d;
import uk.co.matdev.SIMOnline.maths.SIMRandom;
import uk.co.matdev.SIMOnline.maths.Vector2d;

public class Main extends BasicGame {
    public static int WIDTH = 1400;
    public static int HEIGHT = 1100;
    public static final boolean FULLSCREEN = false;
    public static int MAX_FRAMERATE = 60;

    private ObjectManager oM;
    private BattleManager bM;


    public static final String TITLE = "Slimes Invade Moscow";

    public Main(String name) {
        super(name);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        oM = new ObjectManager();
        bM = new BattleManager();
        oM.addObject(bM);
    }


    private int counter = 0;
    @Override
    public void update(GameContainer gameContainer, int i) throws SlickException {
        counter += i;
       if (counter >= 1000/30){
            counter = 0;
            oM.doUpdate();
        }
       // oM.doUpdate();
        Input in = gameContainer.getInput();

        if(in.isKeyDown(Input.KEY_E)) {
            for (int j = 0; j < 100; j++) {
                bM.spawnUnit(new MilitiaRussianUnit(new Vector2d<Integer> (1,0)),new Vector2d<Integer> (1, SIMRandom.range(0,50)));
            }

        }else if(in.isKeyDown(Input.KEY_R)) {
            bM.spawnUnit(new NormalSlimeUnit(new Vector2d<Integer> (-1,0)),new Vector2d<Integer> (78, SIMRandom.range(0,50)));
        }

    }

    @Override
    public void render(GameContainer gameContainer, org.newdawn.slick.Graphics graphics) throws SlickException {
        SIMGraphics drawer = new SIMGraphics(graphics, new Rectangle2d<Integer>(50,50, WIDTH-100, HEIGHT-100));


        oM.draw(drawer);
    }

    public static void main(String args[]) throws SlickException {
        Display.setResizable(true);

        AppGameContainer app = new AppGameContainer(new Main(TITLE));

      //  app.setVSync(true);
        app.setDisplayMode(WIDTH, HEIGHT, FULLSCREEN);
        app.setTargetFrameRate(MAX_FRAMERATE);
        app.start();
    }



}

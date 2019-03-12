import java.awt.*;
import java.awt.image.BufferStrategy;


public class Main extends Canvas implements Runnable {

    public static final int WIDTH = 960, HEIGHT = 640;
    private Thread thread;
    private boolean running = false;

//init
    private Handler handler;
    private Menu menu;


    public static SCREEN gameScreen = SCREEN.Menu;

    public Main(){
        //init
        handler = new Handler();

        //instance
        new Window(WIDTH,HEIGHT,"Dice Games",this);
        menu = new Menu(this, handler);
        this.addMouseListener(menu); //VERY IMPORTANT


    }

    public synchronized void start(){
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop(){
        try{
            thread.join();
            running = false;
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public void run(){
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while(running){
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta >= 1){
                tick();
                delta--;
            }
            if(running)
                render();
            frames++;
            if(System.currentTimeMillis() - timer > 1000){
                timer += 1000;
                //System.out.println("FPS: "+ frames);
                frames = 0;
            }
        }
        stop();

    }

    public void tick(){
        handler.tick();
        //all the ifs for SCREEN
        if(gameScreen == SCREEN.Menu||gameScreen == SCREEN.HighLow){
            menu.tick();
        }

    }

    public void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();

        g.setColor(Color.black);
        g.fillRect(0,0,WIDTH,HEIGHT);

        handler.render(g);
        //all the ifs for SCREEN
        if(gameScreen == SCREEN.Menu||gameScreen == SCREEN.HighLow){
            menu.render(g);
        }

        g.dispose();
        bs.show();

    }

    public static void main(String args[]){
        new Main();

    }



}

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

enum Game{
	PLAYING, GAME_OVER
}

public class GamePanel extends JPanel implements Runnable{

    static int mode;
	static final int GAME_WIDTH = 1000;
	static final int GAME_HEIGHT = (int)(GAME_WIDTH * (0.5555));
	static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH,GAME_HEIGHT);
	static final int BALL_DIAMETER = 20;
	static final int PADDLE_WIDTH = 25;
	static final int PADDLE_HEIGHT = 100;
	static int maxScore = 1;
	Thread gameThread;
	Image image;
	Graphics graphics;
	Random random;
	Paddle paddle1;
    Paddle paddle2;
    AIPaddle paddle3;
	Ball ball;
	Score score;
	Game state = Game.PLAYING;
	
	GamePanel(int mode){
        this.mode = mode;
		newPaddles();
		newBall();
		score = new Score(GAME_WIDTH,GAME_HEIGHT);
		this.setFocusable(true);
		this.addKeyListener(new AL());
		this.setPreferredSize(SCREEN_SIZE);
		
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	public void newBall() {
		random = new Random();
		ball = new Ball((GAME_WIDTH/2)-(BALL_DIAMETER/2),random.nextInt(GAME_HEIGHT-BALL_DIAMETER),BALL_DIAMETER,BALL_DIAMETER);
	}
	public void newPaddles() {
        paddle1 = new Paddle(0,(GAME_HEIGHT/2)-(PADDLE_HEIGHT/2),PADDLE_WIDTH,PADDLE_HEIGHT,1);
        if(mode==2){
            paddle2 = new Paddle(GAME_WIDTH-PADDLE_WIDTH,(GAME_HEIGHT/2)-(PADDLE_HEIGHT/2),PADDLE_WIDTH,PADDLE_HEIGHT,2);
        }
        else{
            paddle3 = new AIPaddle(GAME_WIDTH-PADDLE_WIDTH,(GAME_HEIGHT/2)-(PADDLE_HEIGHT/2),PADDLE_WIDTH,PADDLE_HEIGHT);
        }
	}
	public void paint(Graphics g) {
		image = createImage(getWidth(),getHeight());
		graphics = image.getGraphics();
		draw(graphics);
		g.drawImage(image,0,0,this);
	}
	public void draw(Graphics g) {
		if (state == Game.PLAYING) {
			paddle1.draw(g);
			if (mode == 2) {
				paddle2.draw(g);
			} else {
				paddle3.draw(g);
			}
			ball.draw(g);
			score.draw(g);
		//End Game
		} else if (state == Game.GAME_OVER){
			g.setColor(Color.white);
			g.setFont(new Font("Arial", Font.PLAIN,50));
			g.drawString("GAME OVER!",350,GAME_HEIGHT/2);
			if (score.player1 > score.player2){
				g.drawString("Player 1 WIN!",350,400);
				g.drawString("P1 Score = "+Integer.toString(score.player1),350,450);
				g.drawString("P2 Score = "+Integer.toString(score.player2),350,500);
			} else if (score.player1 < score.player2){
				g.drawString("Player 2 WIN!",350,400);
				g.drawString("P2 Score = "+Integer.toString(score.player2),350,450);
				g.drawString("P1 Score = "+Integer.toString(score.player1),350,500);
			}
		}
	Toolkit.getDefaultToolkit().sync();

	}
	public void move() {
        paddle1.move();
        if(mode==2){
            paddle2.move();
        }
        else{
            paddle3.move(ball.x, ball.y,GAME_WIDTH,PADDLE_HEIGHT);
        }
		ball.move();
	}
	public void checkCollision() {
		
		//bounce ball off top & bottom window edges
		if(ball.y <=0) {
			ball.setYDirection(-ball.yVelocity);
		}
		if(ball.y >= GAME_HEIGHT-BALL_DIAMETER) {
			ball.setYDirection(-ball.yVelocity);
		}
		//bounce ball off paddles
		if(ball.intersects(paddle1)) {
			ball.xVelocity = Math.abs(ball.xVelocity);
			ball.xVelocity++; //optional for more difficulty
			if(ball.yVelocity>0)
				ball.yVelocity++; //optional for more difficulty
			else
				ball.yVelocity--;
			ball.setXDirection(ball.xVelocity);
			ball.setYDirection(ball.yVelocity);
		}
        if(mode==2){
            if(ball.intersects(paddle2)) {
                ball.xVelocity = Math.abs(ball.xVelocity);
                ball.xVelocity++; //optional for more difficulty
                if(ball.yVelocity>0)
                    ball.yVelocity++; //optional for more difficulty
                else
                    ball.yVelocity--;
                ball.setXDirection(-ball.xVelocity);
                ball.setYDirection(ball.yVelocity);
            }
        }
        else{
            if(ball.intersects(paddle3)) {
                ball.xVelocity = Math.abs(ball.xVelocity);
                ball.xVelocity++; //optional for more difficulty
                if(ball.yVelocity>0)
                    ball.yVelocity++; //optional for more difficulty
                else
                    ball.yVelocity--;
                ball.setXDirection(-ball.xVelocity);
                ball.setYDirection(ball.yVelocity);
            }
        }
		//stops paddles at window edges
		if(paddle1.y<=0)
			paddle1.y=0;
		if(paddle1.y >= (GAME_HEIGHT-PADDLE_HEIGHT))
            paddle1.y = GAME_HEIGHT-PADDLE_HEIGHT;
        if(mode==2){
            if(paddle2.y<=0)
                paddle2.y=0;
            if(paddle2.y >= (GAME_HEIGHT-PADDLE_HEIGHT))
                paddle2.y = GAME_HEIGHT-PADDLE_HEIGHT;
        }
        else{
            if(paddle3.y<=0)
                paddle3.y=0;
            if(paddle3.y >= (GAME_HEIGHT-PADDLE_HEIGHT))
                paddle3.y = GAME_HEIGHT-PADDLE_HEIGHT;
        }
		//give a player 1 point and creates new paddles & ball
		if(ball.x <=0) {
			score.player2++;
			newPaddles();
			newBall();
			System.out.println("Player 2: "+score.player2);
		}
		if(ball.x >= GAME_WIDTH-BALL_DIAMETER) {
			score.player1++;
			newPaddles();
			newBall();
			System.out.println("Player 1: "+score.player1);
		}
    }

	//End Score
    public void checkScore(){
		if (score.player1 >= maxScore || score.player2 >= maxScore){
			state = Game.GAME_OVER;
		}
	}

	public static void setScore(int mScore){
		maxScore = mScore;
	}

	public void run() {
		//game loop
		long lastTime = System.nanoTime();
		double amountOfTicks =60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		while(true) {
			long now = System.nanoTime();
			delta += (now -lastTime)/ns;
			lastTime = now;
			if(delta >=1) {
				if (state == Game.PLAYING) {
					move();
				}
				checkCollision();
				checkScore();
				repaint();
				delta--;
			}
		}
	}
	public class AL extends KeyAdapter{
		public void keyPressed(KeyEvent e) {
			paddle1.keyPressed(e);
            if(mode==2){
                paddle2.keyPressed(e);
            }
		}
		public void keyReleased(KeyEvent e) {
			paddle1.keyReleased(e);
			if(mode==2){
                paddle2.keyReleased(e);
            }
		}
	}
}
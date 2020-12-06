import java.awt.*;
import java.awt.event.*;

public class AIPaddle extends Rectangle{

    int yVelocity;
    static int speed = 10;
	
	AIPaddle(int x, int y, int PADDLE_WIDTH, int PADDLE_HEIGHT){
		super(x,y,PADDLE_WIDTH,PADDLE_HEIGHT);
    }
    
    public static void setDifficulty(String Dif){
		if (Dif == "Easy") {
            speed=5;
        } 
        else if(Dif == "Medium"){
            speed=10;
        }
        else {
            speed=20;
        }
	}

	public void move(int bx, int by, int game_width, int PADDLE_HEIGHT) {
        if(by>(y+(PADDLE_HEIGHT / 2)+20)){
            y= y + speed;
        }
        else if(by<(y+(PADDLE_HEIGHT / 2)-20)){
            y= y - speed;
        }
        else if((by>(y+(PADDLE_HEIGHT / 2)+10))&&(by<=(y+(PADDLE_HEIGHT / 2)+20))){
            y= y + (speed/2);
        }
        else if((by<(y+(PADDLE_HEIGHT / 2)-10))&&(by>=(y+(PADDLE_HEIGHT / 2)-20))){
            y= y - (speed/2);
        }
        else
            y=y;
	}
	public void draw(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(x, y, width, height);
	}
}
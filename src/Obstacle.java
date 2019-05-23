import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * The sprites of obstacles.
 *
 */
public class Obstacle extends Sprite {

	/**
	 * Instance variable that stores the width of the obstacle, as the width gets temporarily set to 0 every time it goes off the screen.
	 */
	private int tempWidth;

	/**
	 * Constructs a hidden obstacle with an image.
	 * @param img the obstacle image
	 * @param n the obstacle name
	 */
	public Obstacle(BufferedImage img, String n) {
		super(img);
		tempWidth = img.getWidth();
		setName(n);
		setX(-100);
		setY(BOARD_HEIGHT / 2);
		setSpeed(4);
	}
	
	/**
	 * If the player fails the game, resets the obstacle speed and sets the obstacles's position to be off the screen.
	 */
	public void failGame() {
		super.failGame();
		setSpeed(4);
		setX(-100);
	}
	
	/**
	 * Renders the obstacle, moving its location from right to left a number of pixels each tick. 
	 */
	@Override
	public void render(Graphics g) {
//		System.out.println(getGameState());
		if(getGameState()) {
			g.drawRect(getX(), getY(), getWidth(), getHeight());
			g.drawImage(getImg(), (int) getX(), getY(), null);
			modifyX(-getSpeed());
			decrementTimer();
		}
	}
	
	/**
	 * Sets the obstacle location to the far right and resets the obstacle width so collision detection works.
	 */
	public void reset() {
		setX(BOARD_WIDTH);
		setWidth(tempWidth);
	}
	
}

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

public class Main {
	public static void main(String[] args) {
	    int x = 60;
	    int y = 40;
	    
	    Board board = new Board(x, y);
	    final Snake snake = new Snake(15, 15);
	    board.setSnake(snake);
	    snake.setBoard(board);
	    
	    GamePanel panel = new GamePanel(board);
        panel.addKeyListener(new KeyAdapter() {
            @Override 
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                Direction dir = snake.getDirection();

                switch (key) {
                    case KeyEvent.VK_UP:
                        if (dir == Direction.DOWN) break;
                        snake.setDirection(Direction.UP);
                        break;
                    case KeyEvent.VK_DOWN:
                        if (dir == Direction.UP) break;
                        snake.setDirection(Direction.DOWN);
                        break;
                    case KeyEvent.VK_LEFT:
                        if (dir == Direction.RIGHT) break;
                        snake.setDirection(Direction.LEFT);
                        break;
                    case KeyEvent.VK_RIGHT:
                        if (dir == Direction.LEFT) break;
                        snake.setDirection(Direction.RIGHT);
                        break;
                    default:
                }
            }
        });
        panel.setFocusable(true);
        panel.setSize(x * 11, y * 11);
	    
	    JFrame f = new JFrame();
	    f.setTitle("Snake");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    // f.setSize(panel.getSize().width, panel.getSize().height);
        f.setSize(1000, 1000);
	    f.add(panel);
	    f.setVisible(true);
	    
	    board.generateApple();
	    
	    while (!snake.hasCrashed()) {
	        try {
                Thread.sleep(100);
            } catch (InterruptedException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
	        
	        snake.move();
	        panel.repaint();
	    }
	}
}

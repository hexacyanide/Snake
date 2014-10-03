import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class GamePanel extends JPanel {
    private static final long serialVersionUID = -2026461808345592152L;
    private Board board;

    public GamePanel(Board board) {
        this.board = board;
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        this.board.render();
        
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, this.getSize().width, this.getSize().height);
        
        for (int i = 0; i < this.board.getNumRows(); i++) {
            for (int j = 0; j < this.board.getNumCols(); j++) {
                Cell cell = this.board.getCell(i, j);
                if (cell == null) {
                    drawTile(g, null, i, j);
                    continue;
                }
                
                drawTile(g, cell.getType(), i, j);
            }
        }
    }
    
    private void drawTile(Graphics g, TileType type, int x, int y) {
        int xPos = x * 10;
        int yPos = y * 10;
        
        if (type == null) {
            g.setColor(Color.GRAY);
            g.fillRect(xPos, yPos, 10, 10);
            return;
        }
        
        switch (type) {
            case SNAKE:
                g.setColor(Color.GREEN);
                g.fillRect(xPos, yPos, 10, 10);
                break;
            case APPLE:
                g.setColor(Color.RED);
                g.fillOval(xPos, yPos, 10, 10);
                break;
            default:
        }
    }
}

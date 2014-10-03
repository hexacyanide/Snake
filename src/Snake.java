import java.util.*;

public class Snake {
    private LinkedList<Cell> cells = new LinkedList<>();
    private Direction direction;
    private boolean grow = false;
    private Board board;
	
	public Snake(int x, int y) {
	    Cell head = new Cell(x, y, TileType.SNAKE);
		this.cells.addFirst(head);
		this.direction = Direction.UP;
	}
	
	public void setBoard(Board board) {
	    this.board = board;
	}
	
	public Cell getHead() {
		return this.cells.getFirst();
	}
	
	public Cell getTail() {
	    return this.cells.getLast();
	}
	
	public void grow() {
	    this.grow = true;
	}
	
	public void move() {
	    Cell head = this.getHead();
	    int x = head.getX();
	    int y = head.getY();
	    
	    switch (this.direction) {
    	    case UP:
    	        y--;
    	        break;
    	    case DOWN:
    	        y++;
    	        break;
            case LEFT:
                x--;
                break;
            case RIGHT:
                x++;
                break;
	        default:
	    }
	    
        Cell exist = this.board.getCell(x, y);
        if (exist != null && exist.getType() == TileType.APPLE) {
            this.grow();
            this.board.generateApple();
        }
	    
	    Cell prepend = new Cell(x, y, TileType.SNAKE);
	    cells.addFirst(prepend);
	    
	    if (this.grow) {
	        this.grow = false;
	        return;
	    }
	    
	    cells.removeLast();
	}
	
	public boolean hasCrashed() {
        Cell head = this.getHead();
        int x = head.getX();
        int y = head.getY();
        
        switch (this.direction) {
            case UP:
                y--;
                break;
            case DOWN:
                y++;
                break;
            case LEFT:
                x--;
                break;
            case RIGHT:
                x++;
                break;
            default:
        }
        
        return !this.board.hasCell(x, y);
	}
	
	public Direction getDirection() {
	    return this.direction;
	}
	
	public void setDirection(Direction direction) {
	    this.direction = direction;
	}
	
	public void draw(Board board) {
	    for (Cell cell : this.cells) {
	        board.setCell(cell);
	    }
	}
}

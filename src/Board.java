import java.util.Random;

public class Board {
    private Cell[][] cells;
    private final int rows;
    private final int cols;
    private Snake snake;
    
    public Board(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.cells = new Cell[rows][cols];
    }
    
    public int getNumRows() {
        return this.rows;
    }
    
    public int getNumCols() {
        return this.cols;
    }
    
    public void setSnake(Snake snake) {
        this.snake = snake;
    }
    
    public boolean hasCell(int row, int col) {
        if (row >= this.rows || col >= this.cols) {
            return false;
        }
        
        return true;
    }
    
    public Cell getCell(int row, int col) {
        if (row >= this.rows || col >= this.cols) {
            return null;
        }
        
        return this.cells[row][col];
    }
    
    public boolean setCell(Cell cell) {
        int col = cell.getX();
        int row = cell.getY();
        
        if (row >= this.rows || col >= this.cols) {
            return false;
        }
        
        this.cells[col][row] = cell;
        return true;
    }
    
    public boolean setCell(int row, int col, Cell cell) {
        if (row >= this.rows || col >= this.cols) {
            return false;
        }
        
        this.cells[row][col] = cell;
        return true;
    }
    
    public void generateApple() {
        Random ran = new Random();
        int r = ran.nextInt(this.rows); 
        int c = ran.nextInt(this.cols);
    
        this.setCell(new Cell(r, c, TileType.APPLE));
    }   
    
    public void render() {
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                Cell cell = this.cells[i][j];
                if (cell == null || cell.getType() != TileType.SNAKE) continue;
                this.cells[i][j] = null;
            }
        }
        
        if (this.snake != null) {
            this.snake.draw(this);
        }
    }
}

// sudoku game

class SudokuBoard {

	int[][] board;
	int innerDimension = 3;

	public SudokuBoard(int[][] board){
		this.board = board;
	}

	public void print(){
		for(int i=0; i<board.length; i++){
			if(i % innerDimension == 0){
				System.out.println(" ");
			}
			for(int j=0; j<board.length; j++){
				if(j % innerDimension == 0){
					System.out.print(" ");
				}
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

	public boolean solve(int row, int col){
		if(row == board.length){
			col++;
			if(col == board.length){
				return true;
			}
			row = 0;
		}

		if(board[row][col] != 0){
			return solve(row+1, col);
		}

		for(int num=1; num<=board.length; num++){
			if(isValid(row, col, num)){
				board[row][col] = num;
				if(solve(row+1, col)){
					return true;
				}
				board[row][col] = 0;
			}
		}

		return false;
	}

	public boolean isValid(int row, int col, int num){
		for(int i=0; i<board.length; i++){
			if(board[i][col] == num){
				return false;
			}
		}

		for(int i=0; i<board.length; i++){
			if(board[row][i] == num){
				return false;
			}
		}

		int startRow = (row / innerDimension) *innerDimension;
		int startcol = (col / innerDimension) *innerDimension;

		for(int i=startRow; i<startRow+innerDimension; i++){
			for(int j=startcol; j<startcol+innerDimension; j++){
				if(board[i][j] == num){
					return false;
				}
			}
		}

		return true;
	}
	
}

public class sudokuBoard {

	public static void main(String[] args) {
		
		int[][] board = {
			{5,3,0,0,7,0,0,0,0},
			{6,0,0,1,9,5,0,0,0},
			{0,9,8,0,0,0,0,6,0},
			{8,0,0,0,6,0,0,0,3},
			{4,0,0,8,0,3,0,0,1},
			{7,0,0,0,2,0,0,0,6},
			{0,6,0,0,0,0,2,8,0},
			{0,0,0,4,1,9,0,0,5},
			{0,0,0,0,8,0,0,7,9}
		};
		SudokuBoard sudokuBoard = new SudokuBoard(board);
		sudokuBoard.print();
		System.out.println("---------------------------");
		sudokuBoard.solve(0,0);
		sudokuBoard.print();
	}
}

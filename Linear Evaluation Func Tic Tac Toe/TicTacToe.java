/**
 * Learns to play Tic Tac Toe using linear machine learning algorithm
 * Plays against opponent with same function, but with pre-configured weights
 * Updates weights with LMS 
 * 
 * @author Roxanne Yang
 *
 */

public class TicTacToe {
	/**
	 * takes in a board state, finds the move to make
	 * @param w: the weights for current player
	 * @param board: the board state before the move
	 * @param turn: = 1 for learning algorithm, turn = 2 for pre-configured algorithm
	 * @return board state after making the move
	 */
	private static int[] Play(double[] w, int[][] board, int turn) {
		double high = -1;
		int[] bestBoard = new int[2];
		// generate all possible next steps
		// calculate weight for all next steps
		// return board for highest score
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[i][j] == 0) {
					board[i][j] = turn;
					double score = Score(w, board, turn);
					if (score > high) {
						high = score;
						bestBoard = new int[] {i, j};
					}
					board[i][j] = 0;
				}
			}
		}
		//System.out.println(high);
		return bestBoard;
	}
	
	/**
	 * find the variables x1, x2, x3, x4, and additional x5, x6. x[0] is not used
	 * @param board
	 * @param turn
	 * @return
	 */
	private static int[] FindX(int[][] board, int turn) {
		int[] x = new int[7];
		// horizontal & vertical
		for (int i = 0; i < 3; i++) {
			x[Count(board[i][0], board[i][1], board[i][2], turn)]++;
			x[Count(board[0][i], board[1][i], board[2][i], turn)]++;
		}
		// diagonal
		x[Count(board[0][0], board[1][1], board[2][2], turn)]++;
		x[Count(board[0][2], board[1][1], board[2][0], turn)]++;
		
		return x;
	}
	
	/**
	 * find the score for input board state
	 * @param w: the weights for current player
	 * @param board: the board state before the move
	 * @param turn: = 1 for learning algorithm, turn = 2 for pre-configured algorithm
	 * @return the score based on board condition and weights
	 */
	private static double Score(double[] w, int[][] board, int turn) {
		int[] x = FindX(board, turn);
		
		// one party already won
		if (x[5] > 0) return 1;
		if (x[6] > 0) return -1;
		
		return x[1] * w[0] + x[2] * w[1] + x[3] * w[2] + x[4] * w[3];
	}
	
	/**
	 * 
	 * @param l: left
	 * @param m: middle
	 * @param r: right
	 * @param turn
	 * @return the situation number:
	 * 				0 stands for no notable points
	 * 				1 stands for only turn has 1 on the line (no opponent)
	 * 				2 stands for only opponent has 1 on the line
	 * 				3 stands for only turn has 2 on the line
	 * 				4 stands for only opponent has 2 on the line
	 * 				5 stands for turn has 3 on the line
	 * 				6 stands for opponent has 3 on the line
	 */
	private static int Count(int l, int m, int r, int turn) {
		// find turn's numbers
		if (l != 3 - turn && m != 3 - turn && r != 3 - turn) {
			int match = ToInt(l == turn) + ToInt(m == turn) + ToInt(r == turn);
			if (match == 1) {
				return 1;
			} else if (match == 2) {
				return 3;
			} else if (match == 3) {
				return 5;
			}
		} else if (l != turn && m != turn && r != turn) {
			int match = ToInt(l == 3 - turn) + ToInt(m == 3 - turn) + ToInt(r == 3 - turn);
			if (match == 1) {
				return 2;
			} else if (match == 2) {
				return 4;
			} else if (match == 3) {
				return 6;
			}
		}
		return 0;	
	}
	
	/**
	 * Converts a boolean to an integer
	 * @param val
	 * @return
	 */
	private static int ToInt(boolean val) {
		return val ? 1 : 0;
	}
	
	/**
	 * Plays a whole round until one player wins or board is full
	 * @param weights: weight of player 1 (machine learning player) & player 2 (constant player)
	 * @return an array of all board states
	 */
	private static int[][][] PlayGame(double[][] weights) {
		int[][][] sequence = new int[9][3][3];
		
		int[][] board = new int[3][3];
		board[0] = new int[] {0, 0, 0};
		board[1] = new int[] {0, 0, 0};
		board[2] = new int[] {0, 0, 0};
		
		int turn = 1;
		int count = 0;
		int[] move;
		do {
			move = Play(weights[turn - 1], board, turn);
			
			board[move[0]][move[1]] = turn;
			
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					//System.out.print(board[i][j] + " ");
					sequence[count][i][j] = board[i][j];
				}
				//System.out.println();
			}
			
			//System.out.println();
			
			count++;
			turn = 3 - turn;
			// when Score == 1, current player won
		} while (count < 9 && Score(weights[2 - turn], board, 3 - turn) != 1);
		
		return sequence;
	}
	
	/**
	 * turns the board state into a string
	 * @param board
	 * @return
	 */
	private static String ToString(int[][] board) {
		return "" + board[0][0] + board[0][1] + board[0][2] + board[1][0] + board[1][1] + board[1][2] + board[2][0] + board[2][1] + board[2][2];
	}
	
	/**
	 * update weights based on the value using LMS
	 * @param board
	 * @param actualScore
	 * @param w
	 * @return
	 */
	private static double[] UpdateWeights(int[][] board, double actualScore, double[] w) {
		// set a n (small value)
		double n = 0.001;
		// find score
		double calculatedScore = Score(w, board, 1);
		double scoreDiff = actualScore - calculatedScore;
		// find x1, x2, x3, x4
		int[] x = FindX(board, 1);
		// update w
		w[0] += n * scoreDiff * x[1];
		w[1] += n * scoreDiff * x[2];
		w[2] += n * scoreDiff * x[3];
		w[3] += n * scoreDiff * x[4];
		
		return w;
	}
	
	public static void main(String[] args) {
		double[] w1 = new double[] {0.1, -0.1, 0.1, -0.1};
		double[] w2 = new double[] {0.1, -0.1, 0.1, -0.1};	// initial assignment of weights

		int wins = 0; 
		double[] win = new double[2000];
		
		for (int round = 0; round < 5000; round++) {
			int[][][] sequence = PlayGame(new double[][] {w1, w2});
			
			// find last move index
			int lastMove = 8;
			while (ToString(sequence[lastMove]).equals("000000000")) {
				lastMove--;
			}
			// find score of the move. Possible values: 0, 1, -1
			double score = Score(w1, sequence[lastMove], 1);
			
			if (score == 1) {
				wins++;
			}
			win[round] = (double)wins / (round + 1);
		
			// update score
			for (int i = 0; i < lastMove; i++) {
				w1 = UpdateWeights(sequence[i], score, w1);
				//System.out.println("new weights: " + w1[0] + " " + w1[1] + " " + w1[2] + " " + w1[3]);
			}
		}
				
	}
}

import java.util.Random;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SingleNeuronLearning {
	double[] w = new double[3];
	double n;
	
	/**
	 * Constructor
	 * Initialize weights
	 */
	public SingleNeuronLearning(double n) {
		Random r = new Random();
		for (int i = 0; i < 3; i++) {
			// Random # between -0.1 and 0.1
			w[i] = (r.nextDouble() - 0.5) / 5;
		}
		this.n = n;
	}
	
	/**
	 * Uses target value to classify the data (x1, x2). If a set falls on the line, treat it as true
	 * @param x1
	 * @param x2
	 * @return classification true or false
	 */
	private boolean tClassify(double x1, double x2) {
		return -2 + x1 + 2 * x2 >= 0;
	}
	
	/**
	 * Uses current weights to classify the data (x1, x2). If a set falls on the line, treat it as true
	 * @param x1
	 * @param x2
	 * @return classification true or false
	 */
	private boolean oClassify(double x1, double x2) {
		return w[0] + w[1] * x1 + w[2] * x2 >= 0;
	}

	/**
	 * Generates training data: x[0] to x[2] stores x values
	 * Only consider -50 <= x1, x2 <= 50
	 * @return
	 */
	private double[] generateTrainingData() {
		Random r = new Random();
		double[] x = new double[3];
		x[0] = 1;
		for (int i = 1; i < 3; i++) {
			x[i] = r.nextInt(101) - 50;
		}
		
		return x;
	}
	
	/**
	 * Parses the boolean classification to int classification
	 * @param b
	 * @return
	 */
	private static int boolToInt(boolean b) {
		return b ? 1 : -1;
	}
	
	/**
	 * Update weight with fixed learning rate
	 * @param x
	 * @return whether any update happened
	 */
	private boolean fixUpdateWeights(double[] x) {
		int diffWeights = boolToInt(tClassify(x[1], x[2])) - boolToInt(oClassify(x[1], x[2]));
		w[0] += n * diffWeights;
		w[1] += n * diffWeights * x[1];
		w[2] += n * diffWeights * x[2];
		
		return diffWeights != 0;
	}
	
	/**
	 * Update weight with decreasing learning rate
	 * @param x
	 * @param i
	 */
	private void decUpdateWeights(double[] x, int i) {
		double nn = n / (i + 1);
		w[0] += nn * (boolToInt(tClassify(x[1], x[2])) - boolToInt(oClassify(x[1], x[2])));
		w[1] += nn * (boolToInt(tClassify(x[1], x[2])) - boolToInt(oClassify(x[1], x[2]))) * x[1];
		w[2] += nn * (boolToInt(tClassify(x[1], x[2])) - boolToInt(oClassify(x[1], x[2]))) * x[2];
	}
	
	/**
	 * Update weight in batch with fixed learning rate
	 * @param x
	 * @return whether any update was made
	 */
	private boolean batchUpdateWeights(double[][] x) {
		// delta w = n * sum ((t - o) * x(i))
		double dw0 = 0, dw1 = 0, dw2 = 0;
		for (int i = 0; i < x.length; i++) {
			double diff = boolToInt(tClassify(x[i][1], x[i][2])) - boolToInt(oClassify(x[i][1], x[i][2]));
			dw0 += diff;
			dw1 += diff * x[i][1];
			dw2 += diff * x[i][2];
		}
		w[0] += n * dw0;
		w[1] += n * dw1;
		w[2] += n * dw2;
		
		return dw0 == 0 && dw1 == 0 && dw2 == 0;
	}
	
	/**
	 * Get value of weights
	 * @return
	 */
	public double[] getW() {
		return w;
	}
	
	/**
	 * Write all relevant point and line info to csv file
	 * @param x1
	 * @param x2
	 * @param c
	 * @param w
	 * @throws IOException
	 */
	private static void writeToFile(String x1, String x2, String c, double[] w) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter("src/neuron.csv"));
		x1 = x1.substring(0, x1.length() - 1);
		x2 = x2.substring(0, x2.length() - 1);
		c = c.substring(0, c.length() - 1);
		bw.write(x1);
		bw.newLine();
		bw.write(x2);
		bw.newLine();
		bw.write(c);
		bw.newLine();
		bw.write(w[0] + "," + w[1] + "," + w[2]);
		bw.close();
	}
	
	/**
	 * Incremental fixed rate learning
	 * @param rate
	 * @param iteration
	 * @throws IOException
	 */
	public static void IncFixLearning(double rate, int iteration) throws IOException {
		String x1 = ""; String x2 = ""; String c = "";
		// Instantiate, incremental learning and fixed learning rate
		SingleNeuronLearning incfix = new SingleNeuronLearning(rate);
		for (int i = 0; i < iteration; i++) {
			// Generate one training data
			double[] x = incfix.generateTrainingData();
			// Train
			incfix.fixUpdateWeights(x);
			x1 += x[1] + ",";
			x2 += x[2] + ",";
			c += boolToInt(incfix.tClassify(x[1], x[2])) + ",";
		}
		// Plot in MATLAB
		// Write to file
		writeToFile(x1, x2, c, incfix.getW());
	}
	
	/**
	 * Incremental decaying rate learning
	 * @param rate
	 * @param iteration
	 * @throws IOException
	 */
	public static void IncDecLearning(double rate, int iteration) throws IOException {
		String x1 = ""; String x2 = ""; String c = "";
		// Instantiate, incremental learning and decayed learning rate
		SingleNeuronLearning incdec = new SingleNeuronLearning(rate);
		for (int i = 0; i < iteration; i++) {
			// Generate one training data
			double[] x = incdec.generateTrainingData();
			// Training
			incdec.decUpdateWeights(x, i);
			x1 += x[1] + ",";
			x2 += x[2] + ",";
			c+= boolToInt(incdec.tClassify(x[1], x[2])) + ",";
		}
		// Write to file
		writeToFile(x1, x2, c, incdec.getW());
	}
	
	public static void IncLearningTillConverge(double rate, int trainingSets) throws IOException {
		// Instantiate, incremental learning and decayed learning rate
		SingleNeuronLearning inc = new SingleNeuronLearning(rate);
		// Generate all training data at once
		double[][] x = new double[trainingSets][3];
		for (int i = 0; i < trainingSets; i++) {
			// Generate one training data
			x[i] = inc.generateTrainingData();
		}
		// Training
		long startTime = System.nanoTime();
		
		int validNum = 0;
		int count = 0;
		do {
			if (!inc.fixUpdateWeights(x[count % trainingSets])) {
				validNum++;
			}
			else {
				validNum = 0;
			}
			count++;
		} while (validNum < trainingSets);
		
		long endTime = System.nanoTime();

		long duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
		
		System.out.println("Incremental training: " + count + " iterations till convergence. " 
				+ duration + " miliseconds.");
		
		String x1 = "", x2 = "", c = "";
		for (double[] xx : x) {
			x1 += xx[1] + ",";
			x2 += xx[2] + ",";
			c += boolToInt(inc.tClassify(xx[1], xx[2])) + ",";
		}
		writeToFile(x1, x2, c, inc.getW());
	}
	
	/**
	 * Performs batch learning until the weights converge
	 * @param rate
	 * @param trainingSets
	 * @throws IOException
	 */
	public static void BatchLearningTillConverge(double rate, int trainingSets) throws IOException {
		// Instantiate, incremental learning and decayed learning rate
		SingleNeuronLearning batch = new SingleNeuronLearning(rate);
		// Generate all training data at once
		double[][] x = new double[trainingSets][3];
		for (int i = 0; i < trainingSets; i++) {
			// Generate one training data
			x[i] = batch.generateTrainingData();
		}
		// Training
		long startTime = System.nanoTime();
		
		boolean keepTraining = true;
		int count = 0;
		do {
			keepTraining = !batch.batchUpdateWeights(x);
			count++;
		} while (keepTraining);
		
		long endTime = System.nanoTime();

		long duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
		
		System.out.println("Batch training: " + count + " iterations till convergence. " 
				+ duration + " milliseconds.");
		
		String x1 = "", x2 = "", c = "";
		for (double[] xx : x) {
			x1 += xx[1] + ",";
			x2 += xx[2] + ",";
			c += boolToInt(batch.tClassify(xx[1], xx[2])) + ",";
		}
		writeToFile(x1, x2, c, batch.getW());
	}
	
	public static void main(String[] args) throws IOException {
		//IncFixLearning(0.2, 100);
		//IncDecLearning(0.2, 100);
		//IncLearningTillConverge(0.1, 100);
		BatchLearningTillConverge(0.1, 100);
	}
}

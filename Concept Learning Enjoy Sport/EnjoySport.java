import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

// This is not right. Getting rid of all "less specific" things in general is getting rid of the correct one

/**
 * Uses Find-S and Candidate-Elimination Algorithms to solve the concept learning problem of Enjoy Sport
 * Compares the number of random training examples used to converge to target concept
 * 
 * Output:
 * Average random training example using Find-S Algorithm to converge to target over 20 trials is: 25.0
 * Average random training example using Candidate Eliminantion Algorithm to converge to target over 20 trials is: 27.5
 * 
 * Note: The Candidate-Elimination Algorithm used in this program removes all G hypothesis that's more specific than other G's
 * 
 * @author Roxanne Yang
 *
 */
public class EnjoySport {
	// Target concept: (Sunny, Warm, ?, ?, ?, ?)
	// Use -1 for ?, -2 for Ø
	private static int[] target = new int[] {0, 0, -1, -1, -1, -1};
	// Store all concepts (arrays?)
	private static String[] sky = new String[] { "sunny", "cloudy", "rainy" };
	private static String[] airtemp = new String[] { "warm", "cool" };
	private static String[] wind = new String[] { "strong", "weak" };
	private static String[] water = new String[] { "warm", "cool" };
	private static String[] humidity = new String[] { "normal", "high" };
	private static String[] forecast = new String[] { "same", "change" };

	/**
	 * Random instance generator
	 * @return array of 6 integers for indices of the concept arrays
	 */
	private static int[] GenerateInstance() {
		int[] instance = new int[6];
		int s = (int)(Math.random() * 3);
		instance[0] = s;
		for (int i = 1; i < 6; i++) {
			s = (int)(Math.random() * 2);
			instance[i] = s;
		}
		
		return instance;
	}
	
	/**
	 * Compares instance with target concept (Sunny, Warm, ?, ?, ?, ?)
	 * @param instance: to check for
	 * @return boolean representing whether it's a positive or negative instance
	 */
	private static boolean GetResult(int[] instance) {
		if (instance[0] != 0)
			return false;
		if (instance[1] != 0)
			return false;
		return true;
	}
	
	/**
	 * Compare the current hypothesis with the target
	 * @param h: hypothesis being checked
	 * @return: boolean indicating whether the hypothesis is identical to target
	 */
	private static boolean CheckHypothesis(int[] h) {
		for (int i = 0; i < 6; i++) {
			if (h[i] != target[i]) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Returns the corresponding selection
	 * @param arr
	 * @param ind
	 * @return
	 */
	private static String Value(String[] arr, int ind) {
		if (ind == -2)
			return "Ø";
		if (ind == -1)
			return "?";
		else return arr[ind];
	}
	
	/**
	 * Returns the hypothesis in English form
	 * @param h
	 * @return
	 */
	private static String ToString(int[] h) {
		StringBuilder sb = new StringBuilder("<");
		sb.append(Value(sky, h[0]));
		sb.append(',');
		sb.append(Value(airtemp, h[1]));
		sb.append(',');
		sb.append(Value(humidity, h[2]));
		sb.append(',');
		sb.append(Value(wind,h[3]));
		sb.append(',');
		sb.append(Value(water,h[4]));
		sb.append(',');
		sb.append(Value(forecast,h[5]));
		sb.append('>');
		return sb.toString();
	}
	
	// Implement Find-S
	/**
	 * 
	 */
	private static int FindS() {
		// Initialize hypothesis to all Ø's
		int[] h = new int[6];
		Arrays.fill(h, -2);
		
		int n = 0; 
		while (!CheckHypothesis(h)) {
			// Generate an instance
			int[] instance = GenerateInstance();
			boolean val = GetResult(instance);
			//System.out.println("training example: " + ToString(instance) + " " + val);
			// Learn the instance (update hypothesis) for positive instances
			if (val) {
				for (int i = 0; i < 6; i++) {
					if (h[i] == -2) {
						// Update from Ø to a number
						h[i] = instance[i];
					}
					if (h[i] != -1 && h[i] != instance[i]) {
						// Update from a number to ?
						h[i] = -1;
					}
				}
			}
			n++;
			//System.out.println("hypothesis: " + ToString(h));
		}
		return n;
	}
	
	/**
	 * Determines if instance is satisfied by hypothesis
	 * @param in
	 * @param hy
	 * @return
	 */
	private static boolean Satisfy(int[] in, int[] hy) {
		for (int i = 0; i < 6; i++) {
			if (hy[i] == -2)
				return false;
			if (hy[i] != -1 && hy[i] != in[i])
				return false;
		}
		return true;
	}
	
	/**
	 * Determines if g is at least as general as some of S
	 * @param g
	 * @param S
	 * @return
	 */
	private static boolean MoreOrAsGeneral(int[] g, ArrayList<int[]> S) {
		for (int[] s : S) {
			boolean good = true;
			for (int i = 0; i < 6; i++) {
				if (g[i] != -1 && s[i] != -2 && g[i] != s[i]) {
					good = false;
				}
			}
			if (good)
				return true;
		}
		
		return false;
	}
	
	private static int GetAlls(int[] h) {
		int result = 0;
		for (int i = 0; i < 6; i++) {
			if (h[i] == -1)
				result++;	
		}
		return result;
	}
	
	/**
	 * Implement candidate-elimination
	 * @return
	 */
	private static int CandidateElimination() {
		
		// Initialize 2 hypothesis, S & G
		ArrayList<int[]> S = new ArrayList<int[]>();
		ArrayList<int[]> G = new ArrayList<int[]>();
		S.add(new int[] { -2, -2, -2, -2, -2, -2 });
		G.add(new int[] { -1, -1, -1, -1, -1, -1 });
		
		int n = 0;
		// While S & G are not both of length 1 and identical
		while (S.size() != 1 || G.size() != 1 || !Arrays.equals(S.get(0), G.get(0))) {
			// Generate an instance
			int[] instance = GenerateInstance();
			boolean val = GetResult(instance);
			
			System.out.println("training example: " + ToString(instance) + " " + val);
			
			// Learn the instance (update hypothesis)
			if (val) {
				// Positive instance
				// Remove any G that's incompatible
				for (int g = 0; g < G.size(); g++) {
					if (!Satisfy(instance, G.get(g))) {
						G.remove(g);
					}
				}
				// Expand S
				for (int s = 0; s < S.size(); s++) {
					for (int i = 0; i < 6; i++) {
						if (S.get(s)[i] == -2) {
							S.get(s)[i] = instance[i];
						}
						if (S.get(s)[i] != -1 && S.get(s)[i] != instance[i]) {
							S.get(s)[i] = -1;
						}
					}
				}
			} else {
				// Negative instance
				// Remove any S that's incompatible
				for (int s = 0; s < S.size(); s++) {
					for (int i = 0; i < 6; i++) {
						if (Satisfy(instance, S.get(s))) {
							S.remove(s);
						}
					}
				}
				// Narrow G
				int g = 0; 
				
				ArrayList<int[]> newG = new ArrayList<int[]>();
				while (g < G.size()) {
					if (Satisfy(instance, G.get(g))) {
						for (int i = 0; i < 6; i++) {
							// Try narrowing down each attribute
						
							if (G.get(g)[i] == -1) {
								
								if (i > 0) {
									int[] proposed = Arrays.copyOf(G.get(g), 6);
									proposed[i] = 1 - instance[i];
									// Only keep hypothesis that are at least as general as some of S
									if (MoreOrAsGeneral(proposed, S)) {
										newG.add(proposed);
									}
								} else {
									for (int j = 0; j < 3; j++) {
										
										if (j != instance[i]) {
											int[] proposed = Arrays.copyOf(G.get(g), 6);
											proposed[i] = j;
											if (MoreOrAsGeneral(proposed, S)) {
												newG.add(proposed);
											}
										}
									}
								}
							}
						}
						
					} else {
						newG.add(G.get(g));
					}
					g++;
				}
				
				G = new ArrayList<int[]>();
				for (int[] h : newG) {
					// If h is not more specific than other hypothesis in new G, add it
					boolean addIt = true;
					for (int[] ref : newG) {
						// All the >=0's ref has, G is the same
						if (GetAlls(h) < GetAlls(ref)) {
							boolean bad = true;
							for (int i = 0; i < 6; i++) {
								if (ref[i] >= 0 && h[i] != ref[i]) {
									bad = false;
								}
							}
							if (bad)
								addIt = false;
						}
					}
					
					if (addIt) {
						G.add(h);
					}
				}
			}
			
			
			for (int[] g : G) {
				System.out.println("hypothesis G: " + ToString(g));
			}
			for (int[] s : S) {
				System.out.println("hypothesis S: " + ToString(s));
			}
			
			
			n++;
		}
		
		return n;
	}
	
	public static void main(String[] args) {
		
		int tot = 0;
		for (int i = 0; i < 20; i++) {
			tot += FindS();
		}
		System.out.println("Average random training example using Find-S Algorithm "
				+ "to converge to target over 20 trials is: " + (tot / 20.0));

		int tot2 = 0;
		for (int i = 0; i < 20; i++) {
			tot2 += CandidateElimination();
		}
		System.out.println("Average random training example using Candidate Eliminantion Algorithm "
				+ "to converge to target over 20 trials is: " + (tot2 / 20.0));
		
	}
}

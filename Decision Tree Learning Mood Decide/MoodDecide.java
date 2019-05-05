/**
 * Decision Tree Learning:
 * Uses ID3 to classify whether I am in a good mood on a given day
 * @author Roxanne Yang
 *
 */

import java.io.File;
import java.util.Scanner;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.HashMap;

public class MoodDecide {

	// HashMap key: attr name, val: index
	private HashMap<String, Integer> attrNum = new HashMap<String, Integer>(); 
	// attrDefs[x] stores a whole attribute. Each attribute starts with attr name, followed by possible values
	private ArrayList<ArrayList<String>> attrDefs = new ArrayList<ArrayList<String>>();
	// training[x] stores a training example. First n values is (in sequence) values of attr, last value is classification
	private ArrayList<ArrayList<String>> training = new ArrayList<ArrayList<String>>();
	// validation[x] stores a validation example.
	private ArrayList<ArrayList<String>> validation = new ArrayList<ArrayList<String>>();
	// Stores the root of the decision tree
	private Node root = null;
	// Stores the overall more likely classification
	private boolean moreLikelyClassification;
	
	/**
	 * Constructor
	 * @param dataFile: the file to read data from
	 * @throws Exception 
	 */
	public MoodDecide(String dataFile, boolean trainAndValidate) throws Exception {
		readData(dataFile, trainAndValidate);

		int pos = findPositive(training);
		int neg = findNegative(training);
		moreLikelyClassification = pos >= neg;
	}
	
	/**
	 * Read the # of attributes available
	 * Read the possible values for each attribute
	 * Read the training data
	 * @param dataFile: the file to read data from
	 * @throws Exception 
	 */
	private void readData(String dataFile, boolean trainAndValidate) throws Exception {
		Scanner scanner = new Scanner(new File(dataFile));
		int lineNum = -1;
		int attrs = -1;
    	int data = -1;
		
    	while (scanner.hasNextLine())
    	{
    		lineNum++;
    	    String line = scanner.nextLine();
    	    String[] fields = line.split(",");
    		if (lineNum == 0) {
    			// Gets rid of potential "﻿" at the beginning
    			fields[0] = fields[0].replaceAll("﻿", "");
    			attrs = Integer.parseInt(fields[0]);
    		} else if (lineNum <= attrs) {
    			// Add to HashMap
    			attrNum.put(fields[0], lineNum - 1);
    			// Read attributes
    			ArrayList<String> currentAttr = new ArrayList<String>();
    			for (String field : fields) {
    				currentAttr.add(field);
    			}
    			attrDefs.add(currentAttr);
    		} else if (lineNum == attrs + 1) {
    			data = Integer.parseInt(fields[0]);
    		} else if (lineNum > attrs + 2) { // Ignore line with all attribute names
    			// Read training example
    			ArrayList<String> currentTrain = new ArrayList<String>();
    			for (int i = 0; i < fields.length; i++) {
    				// Error checking: last one (classification) must be "TRUE" or "FALSE"
    				if (i == fields.length - 1 && !fields[i].equals("TRUE") && !fields[i].equals("FALSE")) {
    					scanner.close();
    					throw new Exception("Classification must be either TRUE or FALSE.");
    				}
    				// Error checking: all attribute values must be legal
    				if (i < fields.length - 1 && attrDefs.get(i).indexOf(fields[i]) <= 0) {
    					scanner.close();
    					throw new Exception("Illegal value " + fields[i] + " for attribute " + attrDefs.get(i).get(0) + ".");
    				}
    				currentTrain.add(fields[i]);
    			}
    			if (lineNum - attrs - 2 <= (data + 1) * 2 / 3 || !trainAndValidate) {
    				training.add(currentTrain);
				} else {
					validation.add(currentTrain);
				}
    		}
    	}
    	
    	scanner.close();
	}
	
	/**
	 * Given the current node (and therefore the path of conditions), return the set of all training data that satisfy the conditions
	 * @param node
	 * @return the set of all training data that satisfy the conditions
	 */
	private ArrayList<ArrayList<String>> findSatisfiedTrainingData(Node node) {
		Node ptr = node;
		@SuppressWarnings("unchecked")
		ArrayList<ArrayList<String>> satisfied = (ArrayList<ArrayList<String>>)training.clone();
		while (ptr != root) {
			// Rule out training examples
			String val = ptr.getVal();
			// Trace up
			ptr = ptr.getParent();
			String att = ptr.getAttr();
			int attNum = attrNum.get(att);
			Iterator<ArrayList<String>> itr = satisfied.iterator();
			while (itr.hasNext()) 
	        { 
				ArrayList<String> train = itr.next(); 
				
				if (!train.get(attNum).equals(val)) {
					itr.remove(); 
				}
	        } 
		}
		
		return satisfied;
	}
	
	/** 
	 * Find the number of positive training examples in data
	 * @param data
	 * @return
	 */
	private int findPositive(ArrayList<ArrayList<String>> data) {
		int pos = 0;

		for (ArrayList<String> d : data) {
			if (d.get(d.size() - 1).equals("TRUE")) {
				pos++;
			} 
		}
		
		return pos;
	}
	
	/** 
	 * Find the number of negative training examples in data
	 * @param data
	 * @return
	 */
	private int findNegative(ArrayList<ArrayList<String>> data) {
		int neg = 0;

		for (ArrayList<String> d : data) {
			if (d.get(d.size() - 1).equals("FALSE")) {
				neg++;
			} 
		}
		
		return neg;
	}
		
	/**
	 * Finds all the unused attributes given the tree up to node
	 * @param node
	 * @return the list of indices for the attributes
	 */
	private ArrayList<Integer> findUnusedAttrs(Node node) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < attrDefs.size(); i++) {
			result.add(i);
		}
		
		Node ptr = node;
		
		while (ptr != root) {
			ptr = ptr.getParent();
			String attr = ptr.getAttr();
			result.remove(attrNum.get(attr));
		}
		
		return result;
	}
	
	/**
	 * Calculates entropy given the number of positive and negative examples
	 * @param pos
	 * @param neg
	 * @return
	 */
	private double calculateEntropy(int pos, int neg) {
		if (pos + neg == 0) {
			return 0;
		}
		
		double pp = (double)pos / (pos + neg);
		double pn = (double)neg / (pos + neg);
		double term1, term2;
		if (pp != 0) {
			term1 = -pp * Math.log(pp) / Math.log(2);
		} else {
			term1 = 0;
		}
		if (pn != 0) {
			term2 = -pn * Math.log(pn) / Math.log(2);
		} else {
			term2 = 0;
		}
		
		return term1 + term2;
	}
	
	/**
	 * Recursively learns the decision tree node
	 * @param node
	 */
	private void learnThisNode(Node node) {
		ArrayList<ArrayList<String>> satisfied = findSatisfiedTrainingData(node);
		int pos = findPositive(satisfied);
		int neg = findNegative(satisfied);
		
		ArrayList<Integer> unused = findUnusedAttrs(node);
		
		// B.C. All examples are one classification, or no examples, or all attributes are used
		// Base Case 1: There are no examples matching the conditions
		if (satisfied.isEmpty()) {
			// Set the node as the majority classification. If 50/50, set it as positive
			node.setAttr(moreLikelyClassification ? "TRUE" : "FALSE");
		}
		// Base Case 2: All satisfied have same classification. Set node to be the unanimous classification
		else if (pos == satisfied.size()) {
			node.setAttr("TRUE");
		}
		else if (neg == satisfied.size()) {
			node.setAttr("FALSE");
		}
		// Base Case 3: All attributes have been used. Set node to be majority satisfied classification
		else if (unused.size() == 0) {
			node.setAttr((pos >= neg) ? "TRUE" : "FALSE");
		}
		// Not Base Case. Do Main Logic.
		else {
			// Find original entropy
			double entropy = calculateEntropy(pos, neg);
			
			// For each unused attribute, calculate information gain.
			double bestIG = 0;
			int indexOfBestIG = -1;
			for (int attrIndex : unused) {
				double entropyAfterSplit = 0;
				for (int i = 1; i < attrDefs.get(attrIndex).size(); i++) {
					String val = attrDefs.get(attrIndex).get(i);
					// Finds the section with the iterated val
					@SuppressWarnings("unchecked")
					ArrayList<ArrayList<String>> section = (ArrayList<ArrayList<String>>)satisfied.clone();
					Iterator<ArrayList<String>> itr = section.iterator();
					while (itr.hasNext()) 
			        { 
						ArrayList<String> train = itr.next(); 
						
						if (!train.get(attrIndex).equals(val)) {
							itr.remove(); 
						}
			        } 
					// Calculate the entropy of the section
					int p = findPositive(section);
					int n = findNegative(section);
					double e = calculateEntropy(p, n);
					// Add the weighted entropy to entropy after split
					entropyAfterSplit += e * ((double)section.size() / satisfied.size());
				}
				// Calculate the information gain
				double informationGain = entropy - entropyAfterSplit;
				if (informationGain > bestIG) {
					bestIG = informationGain;
					indexOfBestIG = attrIndex;
				}
			}
			
			// There is an attribute that will make the entropy lower
			if (indexOfBestIG > -1) {
				// Save the learned node into the tree
				node.setAttr(attrDefs.get(indexOfBestIG).get(0));
				// Create an ArrayList of children
				ArrayList<Node> children = new ArrayList<Node>();
				for (int i = 1; i < attrDefs.get(indexOfBestIG).size(); i++) {
					String val = attrDefs.get(indexOfBestIG).get(i);
					children.add(new Node(val, node));
				}
				node.setChildren(children);
				
				// Recurse
				for (Node child : children) {
					learnThisNode(child);
				}
			}
		}
	}

	/**
	 * Learns the decision tree. Calls recursive method learnThisNode
	 * @return
	 */
	public Node learnDecisionTree() {	
		root = new Node("", null);
		learnThisNode(root);
		return root;
	}
	
	/**
	 * Reads an example, with the attributes in the same order, with or without actual classification attached, classify the example
	 * @param example
	 * @return
	 */
	private boolean classifyExample(ArrayList<String> example) {
		// Go from root, follow the decision tree
		Node ptr = root;
		String attr = ptr.getAttr();
		
		while (!attr.equals("TRUE") && !attr.equals("FALSE")) {
			String val = example.get(attrNum.get(attr));
			ArrayList<Node> children = ptr.getChildren();
			for (Node child : children) {
				if (child.getVal().equals(val)) {
					ptr = child;
				}
			}
			attr = ptr.getAttr();
		}
		
		return attr.equals("TRUE");
	}
	
	/**
	 * Finds the accuracy with the current decision tree
	 * @return
	 */
	private double findAccuracyWithValidationSet() {
		int accurate = 0;
		for (ArrayList<String> v : validation) {
			// Classify v using the decision tree
			boolean treeC = classifyExample(v);
			boolean realC = v.get(v.size() - 1).equals("TRUE");
			if (treeC == realC) {
				accurate++;
			}
		}
		
		return (double)accurate / validation.size();
	}
	
	/**
	 * Returns the node, replaced by the leaf node, that yields the most increase in accuracy
	 * @param accuracy
	 * @return
	 */
	private Node[] findBestNodeToReplace(double accuracy) {
		double increasedAccuracy = 0;
		Node prune = null; 
		Node replace = null;
		// In each iteration, go through all non-leaf nodes (by modifying node, and modifying back)
		ArrayList<Node> nonLeaf = new ArrayList<Node>();
		for (Node c : root.getChildren()) {
			if (c.getChildren() != null) {
				nonLeaf.add(c);
			}
		}
		
		while (!nonLeaf.isEmpty()) {			
			// Pop the first one in the list
			Node n = nonLeaf.remove(0);
			
			// First try positive
			Node leaf = new Node(n.getVal(), n.getParent());
			leaf.setAttr("TRUE");
			
			n.getParent().replaceChild(n, leaf);
			double tAccuracy = findAccuracyWithValidationSet();
			// Then try negative
			leaf.setAttr("FALSE");
			double fAccuracy = findAccuracyWithValidationSet();
			// Change back
			n.getParent().replaceChild(leaf, n);
			// Determine if either is the best accuracy so far
			if (tAccuracy - accuracy > increasedAccuracy) {
				increasedAccuracy = tAccuracy - accuracy;
				leaf.setAttr("TRUE");
				prune = n;
				replace = leaf;
			}
			if (fAccuracy - accuracy > increasedAccuracy) {
				increasedAccuracy = fAccuracy - accuracy;
				leaf.setAttr("FALSE");
				prune = n;
				replace = leaf;
			}
			// Then add all its children
			for (Node c : n.getChildren()) {
				if (c.getChildren() != null) {
					nonLeaf.add(c);
				}
			}
		}
		
		return new Node[] { prune, replace };
	}
	
	/**
	 * Performs post-pruning with the validation set
	 * @return
	 */
	public Node postPruneWithValidationSet() {
		// Find accuracy
		double accuracy = findAccuracyWithValidationSet();

		// Try replacing the root with a single "TRUE" or "FALSE"
		Node temp = root;
		root = new Node("", null);
		root.setAttr("TRUE");
		double allTAccuracy = findAccuracyWithValidationSet();
		root.setAttr("FALSE");
		double allFAccuracy = findAccuracyWithValidationSet();
		
		if (allTAccuracy > accuracy || allFAccuracy > accuracy) {
			root.setAttr(allTAccuracy > allFAccuracy ? "TRUE" : "FALSE");
			return root;
		}
		
		// Change root back if single T/F isn't more effective than decision tree
		root = temp;
		
		// Debug
		System.out.println("Changing root to a decision doesn't increase accuracy. Examine other non-leaf nodes");
		// End Debug
		
		// Iterate all other non-leaf nodes
		// At each iteration, find the node that results in the most increase in accuracy and prune it
		Node[] replace;
		do {
			replace = findBestNodeToReplace(accuracy);
			
			if (replace[0] != null) {
				// Debug
				System.out.println("Node to be replaced: " + replace[0].getVal() + " " + replace[0].getAttr());
				System.out.println("Node that replaces it: " + replace[1].getAttr());
				// End Debug
				
				// Perform replacing
				replace[0].getParent().replaceChild(replace[0], replace[1]);
				// Update accuracy
				accuracy = findAccuracyWithValidationSet();
			}
		} while (replace[0] != null);
		// Iterate until no increase in accuracy is found, or there's nothing left in the tree to prune
		
		return root;
	}
	
	/**
	 * Calculates the pessimistic accuracy for the given node
	 * @param node
	 * @return
	 */
	private double calcPessimisticAccuracy(Node node) {
		int accurate = 0;
		
		// Find accuracy
		ArrayList<ArrayList<String>> satisfied = findSatisfiedTrainingData(node);
		
		// Avoid NaN
		if (satisfied.size() == 0) {
			return 0;
		}
		
		for (ArrayList<String> v : satisfied) {
			// Classify v using the decision tree
			boolean treeC = classifyExample(v);
			boolean realC = v.get(v.size() - 1).equals("TRUE");
			if (treeC == realC) {
				accurate++;
			}
		}
		
		double accuracy = (double)accurate / satisfied.size();
		
		// Find standard error
		double stderr = Math.sqrt(accuracy * (1 - accuracy) / satisfied.size());

		return (accuracy - 1.96 * stderr);
	}
	
	/**
	 * Returns the number of training data that satisfies the node
	 * @param node
	 * @return
	 */
	private int countSatisfiedTrainingData(Node node) {
		return findSatisfiedTrainingData(node).size();
	}

	/**
	 * Performs post pruning by using pessimistic estimate of training data.
	 * From bottom up, for each non-leaf node, 
	 * prune if the post-prune accuracy on that node is better than the combined accuracy of children
	 * @return
	 */
	public Node postPruneByPessimisticEstimate() {
		// Build a list of BFS, but without popping
		ArrayList<Node> nonLeaf = new ArrayList<Node>();
		for (Node c : root.getChildren()) {
			if (c.getChildren() != null) {
				nonLeaf.add(c);
			}
		}
		int i = 0;
		while (i < nonLeaf.size()) {
			for (Node c : nonLeaf.get(i).getChildren()) {
				if (c.getChildren() != null) {
					nonLeaf.add(c);
				}
			}
			i++;
		}
				
		// Pop each one from the back
		while (nonLeaf.size() > 0) {
			Node n = nonLeaf.remove(nonLeaf.size() - 1);
			
			// Calculate accuracy and perform pruning (calcPessimisticAccuracy)
			// Find weighted accuracy of children
			double wAccuracy = 0;
			for (Node c : n.getChildren()) {

				double a = calcPessimisticAccuracy(c);

				wAccuracy += a * countSatisfiedTrainingData(c) / countSatisfiedTrainingData(n);
			}

			// Replaces the node n with true and false, and find pessimistic accuracy
			// First try positive
			Node leaf = new Node(n.getVal(), n.getParent());
			leaf.setAttr("TRUE");
			
			n.getParent().replaceChild(n, leaf);
			double tAccuracy = calcPessimisticAccuracy(leaf);
			// Then try negative
			leaf.setAttr("FALSE");
			double fAccuracy = calcPessimisticAccuracy(leaf);
			// Change back
			n.getParent().replaceChild(leaf, n);
			
			// Determine if either is the best accuracy so far
			if (tAccuracy > wAccuracy) {
				wAccuracy = tAccuracy;
				leaf.setAttr("TRUE");
				// Replace
				n.getParent().replaceChild(n, leaf);
			}
			if (fAccuracy > wAccuracy) {
				leaf.setAttr("FALSE");
				// Replace
				n.getParent().replaceChild(n, leaf);
			}
		}
		
		return root;
	}
	
	/**
	 * Learns and prunes the data in fileName with 1/3 of data as validation set
	 * @param fileName
	 * @return
	 * @throws Exception
	 */
	public static Node learnAndPruneWithValidationSet(String fileName) throws Exception {
		MoodDecide md = new MoodDecide(fileName, true);
    	Node root = md.learnDecisionTree();
    	System.out.println(root);
    	root = md.postPruneWithValidationSet();
    	System.out.println(root);
    	
    	return root;
	}
	
	/**
	 * Learns and prunes the data in fileName using pessimistic estimate. 95% confidence level.
	 * @param fileName
	 * @return
	 * @throws Exception
	 */
	public static Node learnAndPruneByPessimisticEstimate(String fileName) throws Exception {
		MoodDecide md = new MoodDecide(fileName, false);
		Node root = md.learnDecisionTree();
		System.out.println(root);
		root = md.postPruneByPessimisticEstimate();
		System.out.println(root);
		
		return root;
	}
	
    public static void main(String[] args) throws Exception {    
    	System.out.println("Validation set approach:");
    	learnAndPruneWithValidationSet("src/PlayTennis.csv");
    	
    	System.out.println("Pessimistic Estimate appraoch:");
    	learnAndPruneByPessimisticEstimate("src/PlayTennis.csv");
    }
}

/**
 * 
 * Helper Node class that represent and print the decision tree
 * @author Roxanne Yang
 *
 */
class Node {
	// Fields: attr, could be attribute or classification
	// Fields: val, the value of the parent attribute
	private String attr;
	private String val;
	private ArrayList<Node> children = null;
	private Node parent;
	
	public Node(String val, Node parent) {
		this.val = val;
		this.parent = parent;
	}
	
	public String getAttr() {
		return attr;
	}
	
	public void setAttr(String attr) {
		this.attr = attr;
	}
	
	public String getVal() {
		return val;
	}
	
	public Node getParent() {
		return parent;
	}
	
	public void setChildren(ArrayList<Node> children) {
		this.children = children;
	}
	
	public ArrayList<Node> getChildren() {
		return children;
	}
	
	/**
	 * Prints the tree out in a string. Attributes and results are capitalized, while values are not
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append(val + "->" + attr.toUpperCase() + " ");
		if (children != null) {
			sb.append('[');
			for (Node child : children) {
				sb.append(child.toString());
			}
			sb.append("] ");
		}
		
		return sb.toString();
	}

	/**
	 * Replaces the old child with the new one
	 * @param oldNode
	 * @param newNode
	 */
	public void replaceChild(Node oldNode, Node newNode) {
		// Find index of old node
		int index = children.indexOf(oldNode);
		children.remove(index);
		children.add(index, newNode);
	}
}

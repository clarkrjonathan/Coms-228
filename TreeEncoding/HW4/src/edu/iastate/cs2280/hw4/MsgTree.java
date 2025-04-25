package edu.iastate.cs2280.hw4;


/**
 * Class to build an encoding tree based off of a string description
 * 
 * Encoding tree is a binary tree with payload chars only at the leafs
 * For a given char in a leaf, its encoding is defined as the path to it with left being 0 and right being 1
 * 
 * Uses a nonrecursive method of construction
 * @author Jonathan Clark
 *
 */
public class MsgTree {
	
	public char payloadChar;
	public MsgTree left;
	public MsgTree right;
	
	
	/**
	 * Takes in an encoding substring and returns the index of the last char of the left hand node
	 * Assumes the encoding starts with the parent nodes identifier ie all entries should start with ^
	 * @param encodingString
	 * @return
	 */
	//TODO make private and not static
	public static int nodeStringEnd(String encodingString) {
		encodingString = encodingString.substring(1);
		int leafCount = 0;
		int internalCount = 0;
		
		while(leafCount <= internalCount) {
			
			if(encodingString.charAt(leafCount + internalCount) == '^') {
				internalCount++;
			} else {
				leafCount++;
			}
			
		}
		
		return leafCount + internalCount;
	}
	
	/**
	 * Private constructor that acts as a place holder until we can fill its references
	 */
	private MsgTree() {
		left = null;
		right = null;
	}
	
	/**
	 * Builds the encoding tree iteratively
	 * Traversal is similar to preorder but starting from the right as it made more visual sense to me
	 * 
	 * Takes an encoding string, pushes it to a stack and breaks out the top of the stack into left and right
	 * nodes until we have reached a char
	 * 
	 * For every split of the rightmost encoding string, a new empty tree is pushed and the previous top
	 * element of the stack is linked as its parent
	 * @param encodingString
	 */
	public MsgTree(String encodingString) {
		
		Stack<String> encodingStack = new Stack();
		encodingStack.push(encodingString);
		
		//tree stack
		Stack<MsgTree> treeStack = new Stack();
		
		MsgTree root = new MsgTree();
		treeStack.push(root);
		
		String currNode;
		
		int leftNodeEnd;
		
		boolean firstIteration = true;
		
		while(!encodingStack.isEmpty()) {
			//first we take rightmost nodes encoding
			currNode = encodingStack.pop();
			
			//If our length is greater than 1 we haven't reached a leaf
			if(currNode.length() > 1) {
				//since we haven't reached a leaf we are at a node and should append this to the stack
				//this node in the tree is empty until we have worked back to fill it in
				if(firstIteration) {
					treeStack.push(root);
					firstIteration = false;
				} else {
					MsgTree nextNode = new MsgTree();
					if(treeStack.peek().right == null) {
						treeStack.peek().right = nextNode;
					} else {
						treeStack.pop().left = nextNode;
					}
					
					treeStack.push(nextNode);
				}
				
				
				//now we split the encoding of this node to left and right
				leftNodeEnd = nodeStringEnd(currNode);
				
				//push left half of node encoding
				encodingStack.push(currNode.substring(1,leftNodeEnd + 1));
				
				//push right half of node encoding
				encodingStack.push(currNode.substring(leftNodeEnd + 1));
				
			} else if (treeStack.peek().right == null) {
				//if the next node is a leaf
				//AND if right child of the top of tree stack hasn't been defined
				//assign leaf node to right
				treeStack.peek().right = new MsgTree(currNode.charAt(0));
			} else {
				//this means our left hand child is unassigned so we assign the leaf and pop the tree
				//need to make sure the size of the stack is larger than one otherwise we will lose our whole tree
				treeStack.pop().left = new MsgTree(currNode.charAt(0));
				
			}
			
			
		}
		
		this.left = root.left;
		this.right = root.right;
		
	}
	
	// Constructor for a single node with null children
	public MsgTree(char payloadChar) {
		left = null;
		right = null;
		this.payloadChar = payloadChar;
	}
	
	/**
	 * Recursive method that traces encoding to root
	 * @param encoding
	 * @return
	 */
	public char getChar(String encoding) {
		//breakout case
		if(encoding.length() == 0) {
			try {
				return payloadChar;
			} catch (Error e){
				//invalid encoding (too short)
				throw new IllegalArgumentException();
			}
		}
		
		
		char root;
		if (encoding.charAt(0) == '0') {
			root = left.getChar(encoding.substring(1));
		} else if(encoding.charAt(0) == '1'){
			root = right.getChar(encoding.substring(1));
		} else {
			throw new IllegalArgumentException();
		}
		
		return root;
	}



	/**
	 * Prints characters along with their code in preorder traversal recursively
	 * @param root - the node we are currently on
	 * @param code - encoding to current node, "" for root
	 */
	public static void printCodes(MsgTree root, String code) {

		//breakout case
		if(root.left == null) {
			
			//reached a leaf and can print it and its code
			char c = root.payloadChar;
			if(c == '\n') {
				System.out.println("   \\n" + "      " + code);
			} else if (c == ' ') {
				System.out.println("    " + "       " + code);
			} else {
				System.out.println("   " + root.payloadChar + "       " + code);
			}
			
			return;
		}
		
		//keep moving in tree
		printCodes(root.left, code + "0");
		printCodes(root.right, code + "1");
		
	}
	
	//Recursive method if wanted for grading purposes
	
	// Constructor building the tree from a string
	//assume the first char is the left node and the second is the right node
	//meaning when we recursively call the next constructor we will strip the first char from the string
//	public MsgTree(String encodingString) {
//		//need to create a stack with nodes to be added, when a node is added it is popped
//		
//		//A node is complete when the leafs (chars) are greater than the nodes(^)
//		//We can then assume the right hand side is just what is left over in the node
//		int leftNodeEnd = nodeStringEnd(encodingString);
//		
//		if(leftNodeEnd > 1) {
//			left = new MsgTree(encodingString.substring(1,leftNodeEnd + 1));
//		} else {
//			left = new MsgTree(encodingString.charAt(1));
//		}
//		
//		if((encodingString.length() - 1) - leftNodeEnd > 1) {
//			right = new MsgTree(encodingString.substring(leftNodeEnd + 1));
//		} else {
//			right = new MsgTree(encodingString.charAt(leftNodeEnd + 1));
//		}
//
//	}



}



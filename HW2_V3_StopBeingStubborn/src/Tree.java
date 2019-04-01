import java.util.ArrayList;

public class Tree {

	private Node root; 

	public Tree()
	{
		root = null; 
	}

	public boolean insert(int x) {
		
		if (root == null){
			root = new Node(); 
			root.addKey(x);
			return true; 
		}
		
		Node possibleNode = root.search(x); 
		if (possibleNode.keys.contains(x))
			return false; 
		else {
			possibleNode.addKey(x);
			return true; 
		}
	}

	public int size(int x) {
		
		int size = 0; 

		Node possibleNode = root.search(x); 
		if (possibleNode.keys.contains(x))
			size = possibleNode.subTreeSize;		
		
		return size; 
	}

	class Node {

		private ArrayList<Integer> keys;
		private ArrayList<Node> children;

		private int subTreeSize; 
		private Node parent; 
		
		public Node() {
			keys = new ArrayList<Integer>();
			children = new ArrayList<Node>(); 
			
			parent = null; 
			subTreeSize = 0; 
		}

		public void addKey(int x) {
			keys.add(x); 
			sortValues(); 
			subTreeSize++; 
			
			Node currentNode = this; 
			while (currentNode.parent != null) {
				currentNode.parent.subTreeSize++; 
				currentNode = currentNode.parent; 
			}
				
			if (this.keys.size() > 2)
				split(this); 
		}
		
		//Sorts values via insertion sort - will have max 3 values so not 
		//to concerned about time efficiency in this implementation 
		public void sortValues() {
			for (int j = 1; j < keys.size(); j++ ) {
				int key = keys.get(j); 
				int i = j -1; 
				
				while (i >= 0 && keys.get(i) > key) {
					keys.set(i + 1,  keys.get(i)); 
					i = i - 1; 
					keys.set(i + 1 , key);
				}
			}
		}

		//Insertion sort to sort the children into ascending order based on data they hold
		public void sortChildren() {

			for (int j = 1; j < children.size(); j++) {
				Node key = children.get(j); 
				int i = j - 1; 

				while (i >= 0 && children.get(i).keys.get(0) > key.keys.get(0)) {
					children.set(i + 1, children.get(i)); 
					i = i - 1; 
				}

				children.set(i + 1, key); 
			}
		}

		
		public void addChild(Node n) {
			children.add(n); 
			sortChildren(); 
			
			subTreeSize += n.subTreeSize; 
		}

		public void removeChild(Node n) {
			children.remove(n); 
			sortChildren();
			
			subTreeSize -= n.subTreeSize; 
		}

		public void disappear() {
			keys.clear(); 
			children.clear(); 
			this.parent = null; 
			subTreeSize = 0; 
		}

		public Node search(int x) {

			//is leaf or contains value
			if (this.children.size() == 0 || this.keys.contains(x))
				return this; 

			//is intermediate node
			else {
				int i = 0; 
				while (i < this.keys.size() && x > this.keys.get(i))
					i++; 
				return this.children.get(i).search(x); 
			}	
		}
		
		private void split(Node n) {
			ArrayList<Integer> data = n.keys;
			int promotee = n.keys.get(1);

			Node newLgNode = new Node();
			Node newSmNode = new Node();

			newLgNode.addKey(data.get(2));
			newSmNode.addKey(data.get(0));
			n.removeKey(promotee); 

			//n is the root
			if (n.parent == null) {
				Node newRoot = new Node(); 
				root = newRoot; 
				n.parent = newRoot; 
				n.parent.addChild(n); 
			}


			if (n.children.size() == 4) 
				assignChildren(n, newSmNode, newLgNode);
			
			n.parent.removeChild(n); 
			n.parent.addChild(newLgNode); 
			n.parent.addChild(newSmNode); 
			for (Node child : n.parent.children)
				child.parent = n.parent; 
			
			n.parent.addKey(promotee);	

			n.disappear(); 
		}
		
		private void removeKey(Integer x) {
			keys.remove(x); 
			sortValues(); 
			subTreeSize--; 
			
			Node currentNode = this; 
			while (currentNode.parent != null) {
				currentNode.parent.subTreeSize--; 
				currentNode = currentNode.parent; 
			}
			
		}

		private void assignChildren(Node original, Node small, Node big) {
			small.addChild(original.children.get(0)); 
			small.addChild(original.children.get(1));
			big.addChild(original.children.get(2));
			big.addChild(original.children.get(3));

			for (Node child : small.children)
				child.parent = small; 

			for (Node child : big.children)
				child.parent = big; 
		}
	}
}

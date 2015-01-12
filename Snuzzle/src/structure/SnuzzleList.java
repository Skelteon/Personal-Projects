package structure;

import java.awt.Color;

/**
 * Cell datastructure of the Snuzzle. Manages the Snuzzle's nodes and values.
 * 
 * @author Skelteon (sk)
 * @version 01/02/2015 sk
 */
public class SnuzzleList {
	/**
	 * The length of this SnuzzleList
	 */
	private int length;
	
	/**
	 * The combined value of this SnuzzleList's nodes.
	 */
	private int value;
	
	/**
	 * The head of the Snuzzle.
	 */
	private SnuzzleNode head;
	
	/**
	 * The tail of the Snuzzle.
	 */
	private SnuzzleNode tail;
	
	
	/**
	 * Constructs a new SnuzzleList.
	 */
	public SnuzzleList() {
		SnuzzleNode first = new SnuzzleNode();
		this.length = 1;
		this.value = first.color.getValue();
		this.head = first;
		this.tail = first;
	}
	
	
	/**
	 * Returns the total value of this Snuzzle.
	 * 
	 * @return The total value of this Snuzzle.
	 */
	public int getValue() {
		return this.value;
	}
	
	/**
	 * Add a new node to the head of the Snuzzle.
	 * 
	 * @param node Node to be added to head of Snuzzle.
	 */
	public void addToHead(SnuzzleNode node) {
		this.head.prev = node;
		node.next = this.head;
		this.head = node;
		this.value += node.color.getValue();
		this.length++;
	}
	
	/**
	 * Add a new node to the tail of the Snuzzle.
	 * 
	 * @param node Node to be added to tail of Snuzzle.
	 */
	public void addToTail(SnuzzleNode node) {
		this.tail.next = node;
		node.prev = this.tail;
		this.tail = node;
		this.value += node.color.getValue();
		this.length++;
	}
	
	/**
	 * Method called in order to combine at either the tail or head. Returns true if
	 * combining is successful, false if otherwise.
	 * 
	 * @param the_end The end at which to combine.
	 * 
	 * @return True if combination is successful, false if otherwise.
	 */
	public boolean shift(End the_end) {
		if (this.length >= 5) {
			switch(the_end) {
				case HEAD:
					return shiftHead();
				case TAIL:
					return shiftTail();
			}
		}
		return false;
	}
	
	/**
	 * Attempts to combine the 5 front-most nodes, if possible. Returns true if
	 * successful, false if otherwise.
	 * 
	 * @return True if combination is successful, false if otherwise.
	 */
	private boolean shiftHead() {
		int i = 4;
		SnuzzleNode curr = this.head.next;
		while (i > 0) {
			if(curr.color != curr.prev.color) {
				return false;
			}
			i--;
			curr = curr.next;
			
		}
		this.head = curr.next;
		curr.next = null;
		this.addToHead(new SnuzzleNode(curr.color.upgrade(), curr.dir, curr.x, curr.y));
		return true;
	}
	
	/**
	 * Attempts to combine the 5 back-most nodes, if possible. Returns true if 
	 * successful, false if otherwise.
	 * 
	 * @return True if combination is successful, false if otherwise.
	 */
	private boolean shiftTail() {
		int i = 4;
		SnuzzleNode curr = this.tail.prev;
		while (i > 0) {
			if(curr.color != curr.next.color) {
				return false;
			}
			i--;
			curr = curr.prev;
		}
		this.tail = curr.prev;
		curr.prev = null;
		this.addToTail(new SnuzzleNode(curr.color.upgrade(), tail.prev.dir, curr.x, curr.y));
		return true;
	}
	
	
	
	/**
	 * A private Node class for the SnuzzleList.
	 * 
	 * @author sk
	 */
	private class SnuzzleNode {	
		/**
		 * This Node's Color
		 */
		private SColor color;
		
		/**
		 * The Direction of this Node's next move (where the next node in the Snuzzle is)
		 */
		private Direction dir;
		
		/**
		 * The x-coordinate of the Node.
		 */
		private int x;
		
		/**
		 * The y-coordinate of the Node.
		 */
		private int y;
		
		/**
		 * The next Node in the List.
		 */
		private SnuzzleNode next;
		
		/**
		 * The previous Node in the List.
		 */
		private SnuzzleNode prev;
		
		
		/**
		 * Constructs and initializes a new SnuzzleNode with the given parameters.
		 * 
		 * @param the_color The Color this Node is to have.
		 * @param the_dir The Direction this Node will be facing.
		 * @param the_x The x-coordinate this Node will be created with.
		 * @param the_y The y-coordinate this Node will be created with.
		 */
		private SnuzzleNode(SColor the_color, Direction the_dir, int the_x, int the_y) {
			this.color = the_color;			
			this.dir = the_dir;
			this.x = the_x;
			this.y = the_y;
			this.next = null;
			this.prev = null;
		}
		
	
		/**
		 * A zero-argument-constructor for a new SnuzzleNode. Default is Blue, facing 
		 * down.
		 */
		private SnuzzleNode() {
			this(SColor.BLUE, Direction.DOWN, 0, 0);
		}
	}
}

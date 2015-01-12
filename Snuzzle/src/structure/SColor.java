package structure;

/**
 * The SColor class serves as an enum for determining the value of a block on the 
 * Snuzzle. It will also serve as a more convenient way of translating to different
 * color schemes.
 * 
 * @author Skelteon (sk)
 * @version 01/02/2015 sk
 */
public enum SColor {
	BLUE(1),
	INDIGO(5),
	GREEN(25),
	YELLOW(125),
	ORANGE(650),
	RED(3250),
	PURPLE(16250);
	
	/**
	 * The numerical value associated with the Color.
	 */
	int value;
	
	/**
	 * Constructs a new SColor enum with the given parameters.
	 * 
	 * @param the_value The value the SColor will have.
	 */
	private SColor(int the_value) {
		this.value = the_value;
	}
	
	/**
	 * Returns the value of the SColor.
	 * 
	 * @return The value of the SColor.
	 */
	public int getValue() {
		return this.value;
	}
	
	/**
	 * Returns the next color above this one.
	 * 
	 * @return The next color above this one.
	 */
	public SColor upgrade() {
		switch (this) {
			case BLUE:
				return INDIGO;
			case INDIGO:
				return GREEN;
			case GREEN:
				return YELLOW;
			case YELLOW:
				return ORANGE;
			case ORANGE:
				return RED;
			case RED:
				return PURPLE;
			default:
				return null;
		}	
	}
}

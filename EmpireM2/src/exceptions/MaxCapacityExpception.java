package exceptions;

@SuppressWarnings("serial")
public class MaxCapacityExpception extends Exception{
	public MaxCapacityExpception() {
		
	}

	public MaxCapacityExpception(String s) {
		super(s);
		
	}

}

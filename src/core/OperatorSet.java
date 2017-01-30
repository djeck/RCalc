package core;

import java.util.ArrayList;

/**
 * This interface and implemented classes implements some operations
 * @author djeck
 */
public interface OperatorSet {
	/**
	 * @param operation, String of the OperatorSet (like "+" or "log")
	 * @return true if the class can resolve operation
	 */
	public boolean can(String operation);
	
	/**
	 * @param operation, String of the OperatorSet (like "+" or "log")
	 * @return number of arguments to give to compute
	 */
	public int getArgumentsNumber(String operation);
	
	/**
	 * @param operation, String of the OperatorSet (like "+" or "log")
	 * @param args Array of arguments (stack), number of arguments is given by get ArgumentsNumber
	 * @return
	 */
	public Double compute(String operation, ArrayList<Double> args);
	
	/**
	 * Print help on operation
	 * @param operation, String of the OperatorSet (like "+" or "log")
	 */
	public void help(String operation);
}

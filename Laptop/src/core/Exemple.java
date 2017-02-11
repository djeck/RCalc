package core;

import java.util.ArrayList;

public class Exemple implements OperatorSet{

	/**
	 * @return true if your class implements this functionality
	 */
	@Override
	public boolean can(String operation) {
		/*
		if(operation.equals("op1"))
			return true;
		if(operation.equals("op2"))
			return true;
		...
		*/
		return false;
	}

	/**
	 * @return number of argument expected by the operation
	 */
	@Override
	public int getArgumentsNumber(String operation) {
		/*
		if(operation.equals("op1"))
			return 1;
		if(operation.equals("op2"))
			return 2;
		 */
		return 0;
	}

	/**
	 * @param operation operation to perform
	 * @param args arguments
	 * @return result or nan if error
	 */
	@Override
	public Double compute(String operation, ArrayList<Double> args) {
		/*
		if(args.size()<getArgumentsNumber(operation)) {
			System.out.println("ERROR: "+operation+" bad number of arguments");
			return Double.NaN;
		}
		else if(operation.equals("op1")) {
			return op1(args.get(0));
		}
		else if(operation.equals("op2")) {
			return op2(args.get(0), args.get(1));
		}
		else {
			System.out.println("ERROR: In exemple librairy there is no function "+operation);
			return Double.NaN;
		}
		*/
		return Double.NaN;
	}

	@Override
	public void help(String operation) {
		/*
		if(operation.equals("op1")) {
			System.out.println("What op1 does");
			System.out.println("ex: exemple of op1");
		}
		else if(operation.equals("op2")) {
			System.out.println("What op2 does");
			System.out.println("ex: exemple of op2");
		}
		*/
	}

}

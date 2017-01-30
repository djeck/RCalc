package core;

import java.util.ArrayList;

public class Stack {
	ArrayList<Double> stack;
	ArrayList<OperatorSet> OperatorSets;
	
	public Stack() {
		stack = new ArrayList<Double>();
		OperatorSets = new ArrayList<OperatorSet>();
	}
	public boolean handle(String command) {
		String input[];
		boolean done = true; // by default we can handle it
		
		input = command.split(" ");
		for(int i=0; i<input.length; i++) { // test each split
			if(input[i].equals("stack") || input[i].equals("s")) { // print stack
				printStack();
			} else if(input[i].equals("clear") || input[i].equals("clr")) { // clear stack
				stack.clear();
			} else if(input[i].equals("inv")) { // inverse two data in stack
				if(stack.size()>1) {
					Double a = stack.get(stack.size()-1);
					stack.remove(a);
					Double b = stack.get(stack.size()-1);
					stack.remove(b);
					stack.add(a);
					stack.add(b);
				}
			} else if(input[i].equals("help") || input[i].equals("?")) { // help command
				if(i<input.length-1) { // help on command ...
					i++;
					boolean found = false;
					for(int z=0; z<OperatorSets.size() && !found; z++) {
						if(OperatorSets.get(z).can(input[i])) {
							found = true;
							OperatorSets.get(z).help(input[i]);
						}
					}
					if(!found)
						System.out.println("Not command "+input[i]+" found");
				} else { // general help
					System.out.println("This soft use reverse polish notation, put your variables on stack before using it.");
					System.out.println("Ex:\n\"5 6 7\" will put 5 then 6 then 7 on stack");
					System.out.println("\"+\" will add two last values added on stack so 6+7 and will put the result on stack");
					System.out.println("stack now is: 5 then 13, if you do \"-\" the stack would be -8 (5-13)\n");
					System.out.println("You can print the stack using \"s\" or \"stack\"");
					System.out.println("Use help <cmd>, with <cmd> a command");
				}
			} else if(isNumeric(input[i])) { // add numeric value to stack
				stack.add(Double.parseDouble(input[i]));
			} else { // OperatorSet
				
				done = false; // by default no OperatorSet match
				for(int z=0; z<OperatorSets.size() && !done; z++) { // search for class implementing the OperatorSet
					if(OperatorSets.get(z).can(input[i])) { // OperatorSet found in class
						done = true; // match
						if(OperatorSets.get(z).getArgumentsNumber(input[i])>stack.size()) { // bad argument
							System.out.println("Not enough values on stack for "+input[i]+" expected "+OperatorSets.get(z).getArgumentsNumber(input[i]));
						} else {
							ArrayList<Double> part = new ArrayList<Double>();
							for(int y=0; y<OperatorSets.get(z).getArgumentsNumber(input[i]); y++) {
								part.add(stack.get(stack.size()-1));
								stack.remove(stack.size()-1);
							}
							stack.add(OperatorSets.get(z).compute(input[i], part));
						}
					}
				}
			} // OperatorSet
		} // test each split
		return done;
	}
	
	/**
	 * @return last value on stack
	 */
	public Double currentValue() {
		if(stack.size()>0)
			return stack.get(stack.size()-1);
		else
			return 0E0;
	}
	
	/**
	 * Test if String can be converted to numeric value (Double)
	 * @param str, string to test
	 * @return true if car be parsed
	 */
	public static boolean isNumeric(String str)  
	{  
	  try  
	  {  
	    Double.parseDouble(str);  
	  }  
	  catch(NumberFormatException nfe)  
	  {  
	    return false;  
	  }  
	  return true;  
	}
	
	/**
	 * register a new set of operator
	 * @param OperatorSet, set of OperatorSet to register
	 */
	public void addOperatorSet(OperatorSet OperatorSet) {
		this.OperatorSets.add(OperatorSet);
	}
	
	/**
	 * Print all values on stack
	 */
	public void printStack() {
		for(int z=0; z<stack.size();z++) {
			System.out.println("- - - - -");
			System.out.println(z+" |  "+stack.get(z));
		}
		System.out.println("- - - - -");
	}
}

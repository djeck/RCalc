package core;

import java.util.ArrayList;

public class Trigonometric implements OperatorSet {
	@Override
	public boolean can(String operation) {
		if(operation.equals("cos"))
			return true;
		if(operation.equals("sin"))
			return true;
		if(operation.equals("tan"))
			return true;
		if(operation.equals("acos"))
			return true;
		if(operation.equals("asin"))
			return true;
		if(operation.equals("atan"))
			return true;
		if(operation.equals("cosh"))
			return true;
		if(operation.equals("sinh"))
			return true;
		if(operation.equals("tanh"))
			return true;
		if(operation.equals("acosh") || operation.equals("argcosh"))
			return true;
		if(operation.equals("asinh") || operation.equals("argsinh"))
			return true;
		if(operation.equals("atanh") || operation.equals("argtanh"))
			return true;
		return false;
	}

	@Override
	public int getArgumentsNumber(String operation) {
		if(operation.equals("cos"))
			return 1;
		if(operation.equals("sin"))
			return 1;
		if(operation.equals("tan"))
			return 1;
		if(operation.equals("acos"))
			return 1;
		if(operation.equals("asin"))
			return 1;
		if(operation.equals("atan"))
			return 1;
		if(operation.equals("cosh"))
			return 1;
		if(operation.equals("sinh"))
			return 1;
		if(operation.equals("tanh"))
			return 1;
		if(operation.equals("acosh") || operation.equals("argcosh"))
			return 1;
		if(operation.equals("asinh") || operation.equals("argsinh"))
			return 1;
		if(operation.equals("atanh") || operation.equals("argtanh"))
			return 1;
		return 0;
	}

	@Override
	public Double compute(String operation, ArrayList<Double> args) {
		if(args.size()<getArgumentsNumber(operation)) {
			System.out.println("ERROR: "+operation+" bad number of arguments");
			return Double.NaN;
		}
		else if(operation.equals("cos")) {
			return this.cosinus(args.get(0));
		}
		else if(operation.equals("sin")) {
			return this.sinus(args.get(0));
		}
		else if(operation.equals("tan")) {
			return this.tangente(args.get(0));
		}
		else if(operation.equals("acos")) {
			return this.argumentCosinus(args.get(0));
		}
		else if(operation.equals("asin")) {
			return this.argumentSinus(args.get(0));
		}
		else if(operation.equals("atan")) {
			return this.argumentTangente(args.get(0));
		}
		else if(operation.equals("cosh")) {
			return this.cosinusHyperbolic(args.get(0));
		}
		else if(operation.equals("sinh")) {
			return this.sinusHyperbolic(args.get(0));
		}
		else if(operation.equals("tanh")) {
			return this.tangenteHyperbolic(args.get(0));
		}
		else if(operation.equals("acosh") || operation.equals("argcosh")) {
			return this.argumentCosinusHyperbolic(args.get(0));
		}
		else if(operation.equals("asinh") || operation.equals("argsinh")) {
			return this.argumentSinusHyperbolic(args.get(0));
		}
		else if(operation.equals("atanh") || operation.equals("argtanh")) {
			return this.argumentTangenteHyperbolic(args.get(0));
		}
		else {
			System.out.println("ERROR: In trigonometric librairy there is no function "+operation);
			return Double.NaN;
		}
	}

	@Override
	public void help(String operation) {
		if(operation.equals("cos")) {
			System.out.println("Cosinus of two numbers");
			System.out.println("ex: pi cos returns -1");
		}
		else if(operation.equals("sin")) {
			System.out.println("Sinus of two numbers");
			System.out.println("ex: pi/2 cos returns 1");
		}
	}
	
	private Double cosinus(Double arg0) {
		return Math.cos(arg0);
	}
	private Double sinus(Double arg0) {
		return Math.sin(arg0);
	}
	private Double tangente(Double arg0) {
		return Math.tan(arg0);
	}
	private Double argumentCosinus(Double arg0) {
		return Math.acos(arg0);
	}
	private Double argumentSinus(Double arg0) {
		return Math.asin(arg0);
	}
	private Double argumentTangente(Double arg0) {
		return Math.atan(arg0);
	}
	private Double cosinusHyperbolic(Double arg0) {
		return Math.cosh(arg0);
	}
	private Double sinusHyperbolic(Double arg0) {
		return Math.sinh(arg0);
	}
	private Double tangenteHyperbolic(Double arg0) {
		return Math.tanh(arg0);
	}
	private Double argumentCosinusHyperbolic(Double arg0) {
		return Math.log(arg0 + Math.sqrt(arg0*arg0 - 1));
	}
	private Double argumentSinusHyperbolic(Double arg0) {
		return Math.log(arg0 + Math.sqrt(arg0*arg0 + 1));
	}
	private Double argumentTangenteHyperbolic(Double arg0) {
		return 0.5*Math.log((1+arg0)/(1-arg0));
	}
	
}

package com.example.djeck.rcalc.core;

/**
 * Created by djeck on 09/02/17.
 */
import android.widget.TextView;

import java.util.ArrayList;

public class Standard implements OperatorSet {
    private TextView mTextView;

    public Standard(TextView textView) {
        mTextView = textView;
    }

    @Override
    public boolean can(String operation) {
        if(operation.equals("+"))
            return true;
        if(operation.equals("-"))
            return true;
        if(operation.equals("*"))
            return true;
        if(operation.equals("/"))
            return true;
        if(operation.equals("pi"))
            return true;
        if(operation.equals("e"))
            return true;
        if(operation.equals("ans"))
            return true;
        if(operation.equals("sqrt"))
            return true;
        if(operation.equals("pow"))
            return true;
        if(operation.equals("mod") || operation.equals("%"))
            return true;
        if(operation.equals("exp"))
            return true;
        if(operation.equals("ln"))
            return true;
        if(operation.equals("log") || operation.equals("log10"))
            return true;
        if(operation.equals("log2"))
            return true;
        return false;
    }

    @Override
    public int getArgumentsNumber(String operation) {
        if(operation.equals("+"))
            return 2;
        if(operation.equals("-"))
            return 2;
        if(operation.equals("*"))
            return 2;
        if(operation.equals("/"))
            return 2;
        if(operation.equals("pi"))
            return 0;
        if(operation.equals("e"))
            return 0;
        if(operation.equals("ans"))
            return 0;
        if(operation.equals("sqrt"))
            return 1;
        if(operation.equals("pow"))
            return 2;
        if(operation.equals("mod") || operation.equals("%"))
            return 2;
        if(operation.equals("exp"))
            return 1;
        if(operation.equals("ln"))
            return 1;
        if(operation.equals("log") || operation.equals("log10"))
            return 1;
        if(operation.equals("log2"))
            return 1;
        return 0;
    }

    @Override
    public Double compute(String operation, ArrayList<Double> args) {
        if(args.size()<getArgumentsNumber(operation)) {
            mTextView.setText("ERROR: "+operation+" bad number of arguments");
            return Double.NaN;
        }
        else if(operation.equals("+")) {
            return this.plus(args.get(1), args.get(0));
        }
        else if(operation.equals("-")) {
            return this.minus(args.get(1), args.get(0));
        }
        else if(operation.equals("*")) {
            return this.times(args.get(1), args.get(0));
        }
        else if(operation.equals("/")) {
            return this.divide(args.get(1), args.get(0));
        }
        else if(operation.equals("pi")) {
            //return 3.1415926535897932384626433832795028841971693993751058209749445923;
            return Math.PI;
        }
        else if(operation.equals("e")) {
            //return 2.718281828459045235360287471352662497757247093699959574966967627724;
            return Math.E;
        }
        else if(operation.equals("ans")) {
            return 42E0;
        }
        else if(operation.equals("sqrt")) {
            return squareRoot(args.get(0));
        }
        else if(operation.equals("pow")) {
            return power(args.get(1), args.get(0));
        }
        else if(operation.equals("mod") || operation.equals("%")) {
            return modulo(args.get(1), args.get(0));
        }
        else if(operation.equals("exp")) {
            return exponential(args.get(0));
        }
        else if(operation.equals("ln")) {
            return naturalLogarithm(args.get(0));
        }
        else if(operation.equals("log") || operation.equals("log10")) {
            return this.log10(args.get(0));
        }
        else if(operation.equals("log2")) {
            return this.log2(args.get(0));
        }
        else {
            mTextView.setText("ERROR: In standard librairy there is no function "+operation);
            return Double.NaN;
        }
    }

    @Override
    public void help(String operation) {
        if(operation.equals("+")) {
            mTextView.setText("Add two numbers\n");
            mTextView.append("ex: 5 4 + returns 9");
        }
        if(operation.equals("-")) {
            mTextView.setText("Soustract two numbers\n");
            mTextView.append("ex: 3 4 - returns -1");
        }
        if(operation.equals("*")) {
            mTextView.setText("Multiply two numbers");
        }
        if(operation.equals("/")) {
            mTextView.setText("Divide two numbers\n");
            mTextView.append("ex: 8 4 / returns 2");
        }
        if(operation.equals("pi")) {
            mTextView.setText("Constant");
        }
        if(operation.equals("e")) {
            mTextView.setText("Constant");
        }
        if(operation.equals("ans")) {
            mTextView.setText("The answer to life the universe and everything");
        }
        if(operation.equals("sqrt")) {
            mTextView.setText("Square root of a number");
        }
        if(operation.equals("pow")) {
            mTextView.setText("Power n of a number\n");
            mTextView.append("ex: 2 3 pow returns 8");
        }
        if(operation.equals("mod") || operation.equals("%")) {
            mTextView.setText("Modulo n of a number \n");
            mTextView.append("ex: 5 2 mod returns 1");
        }
    }

    private Double plus(Double arg0, Double arg1) {
        return arg0+arg1;
    }
    private Double minus(Double arg0, Double arg1) {
        return arg0-arg1;
    }
    private Double times(Double arg0, Double arg1) {
        return arg0*arg1;
    }
    private Double divide(Double arg0, Double arg1) {
        if(arg1==0E0 && arg0<0E0)
            return Double.NEGATIVE_INFINITY;
        else if(arg1==0E0 && arg0>0E0)
            return Double.POSITIVE_INFINITY;
        else if(arg1==0E0 && arg0==0E0)
            return Double.NaN;
        else
            return arg0/arg1;
    }
    private Double squareRoot(Double arg0) {
        return Math.sqrt(arg0);
    }
    private Double power(Double arg0, Double arg1) {
        return Math.pow(arg0, arg1);
    }
    private Double modulo(Double arg0, Double arg1) {
        return arg0%arg1;
    }
    private Double exponential(Double arg0) {
        return Math.exp(arg0);
    }
    private Double naturalLogarithm(Double arg0) {
        return Math.log(arg0);
    }
    private Double log10(Double arg0) {
        return Math.log10(arg0);
    }
    private Double log2(Double arg0) {
        return Math.log(arg0)/Math.log(2);
    }
}

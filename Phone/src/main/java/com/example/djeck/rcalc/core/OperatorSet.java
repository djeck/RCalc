package com.example.djeck.rcalc.core;

/**
 * Created by djeck on 09/02/17.
 */

import android.widget.TextView;

import java.util.ArrayList;

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

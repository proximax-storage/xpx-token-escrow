package io.proximax.escrow.util;

public class NumUtils {

	public static double round4Dec(double val) {	
		return (double) Math.round(val * 10000)/10000;
	}
	
	public static double round6Dec(double val) {	
		return (double) Math.round(val * 1000000)/1000000;
	}

}

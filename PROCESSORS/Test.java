package com.study.PROCESSORS;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author william
 */

public class Test {

	public static void main( String[] args ) {

		/* Command: sudo pacman -S --search apple && pacman -Syy && clear */

		Scanner scn = new Scanner( System.in );

		String[] input = new String[ 10 ];

		for (
				int i = 0;
				i < 10;
				i++
		) {

			input[ i ] = scn.next();

		}

		System.out.print( Arrays.toString( input ) );

	}
}
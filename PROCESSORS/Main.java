package com.study.PROCESSORS;

/*
 * *----------------------------------------------------------------*
 * |   Modifier			Class		Package		Subclass	World	|
 * +----------------------------------------------------------------+
 * |   public			Y			Y			Y			Y		|
 * |   protected		Y			Y			Y			N		|
 * |   no_modifier		Y			Y			N			N		|
 * |   private			Y			N			N			N		|
 * *----------------------------------------------------------------*
 * ..............................................July 15th, 2022.....
 */

import com.study.INPUT.BasicInput;
import com.study.OUTPUT.BasicOutput;
import com.study.STORAGE.BasicVariables;

import java.util.Vector;

/**
 * @author william
 */
public class Main {

	public static void main( String[] args ) {

		BasicOutput basicOutput = new BasicOutput();
		boolean exit = false;

		while ( ! exit ) {

			String userInputRaw = BasicInput.recorder(
					BasicVariables.BASIC_INPUT_RECORDER_TYPE_REGULAR
			);

			Vector<String> userInput = new Vector<>( 0 );


			basicOutput.greetings();

		}

	}
}
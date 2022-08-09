package com.study.processors;

import com.study.output.BasicOutput;
import com.study.storage.BasicVariables;

/**
 * @author william
 */

public class Test {

	public static void main( String[] args ) {

		System.out.println(
				BasicOutput.dyeing(
						true,
						BasicVariables.TERMINAL_COLOR_MAGENTA
				)
		);
		ProcessCommand.commandProcess();

	}
}
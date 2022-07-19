package com.study;

import org.jetbrains.annotations.NotNull;

import java.util.Scanner;

/**
 * @author william
 */

public class BasicInput {

	protected static final String CLASS_NAME = "BasicInput";

	private static final Scanner BASIC_SCANNER = new Scanner( System.in );

	protected static String recorder( @NotNull String typeOfInput ) {

		System.out.print( BasicOutput.dyeing(
				true,
				BasicVariables.BASIC_INPUT_RECORDER_TYPE_REGULAR.equalsIgnoreCase( typeOfInput )
						? BasicVariables.TERMINAL_COLOR_WHITE
						: BasicVariables.BASIC_INPUT_RECORDER_TYPE_ANSWER.equalsIgnoreCase( typeOfInput )
								? BasicVariables.TERMINAL_COLOR_BLUE
								: BasicVariables.BASIC_INPUT_RECORDER_TYPE_REPLY_LOCAL.equalsIgnoreCase( typeOfInput )
										? BasicVariables.TERMINAL_COLOR_GREEN
										: BasicVariables.BASIC_INPUT_RECORDER_TYPE_REPLY_REMOTE.equalsIgnoreCase( typeOfInput )
												? BasicVariables.TERMINAL_COLOR_CYAN
												: BasicVariables.TERMINAL_COLOR_RESET
		) );
		return BasicInput.BASIC_SCANNER.nextLine();
	}

	protected static String recorder(
			@NotNull String typeOfInput,
			@NotNull String initiator
	) {

		System.out.print( BasicOutput.dyeing(
				true,
				BasicVariables.BASIC_INPUT_RECORDER_TYPE_REGULAR.equalsIgnoreCase( typeOfInput )
						? BasicVariables.TERMINAL_COLOR_WHITE
						: BasicVariables.BASIC_INPUT_RECORDER_TYPE_ANSWER.equalsIgnoreCase( typeOfInput )
								? BasicVariables.TERMINAL_COLOR_BLUE
								: BasicVariables.BASIC_INPUT_RECORDER_TYPE_REPLY_LOCAL.equalsIgnoreCase( typeOfInput )
										? BasicVariables.TERMINAL_COLOR_GREEN
										: BasicVariables.BASIC_INPUT_RECORDER_TYPE_REPLY_REMOTE.equalsIgnoreCase( typeOfInput )
												? BasicVariables.TERMINAL_COLOR_CYAN
												: BasicVariables.TERMINAL_COLOR_RESET
		) + typeOfInput + "(" + initiator + "): " );
		return BasicInput.BASIC_SCANNER.nextLine();
	}
}

package com.study.processors;

import com.study.output.BasicOutput;
import com.study.storage.BasicVariables;
import org.jetbrains.annotations.NotNull;

import java.util.Scanner;

/**
 * @author william
 */
public class ProcessCommand {

	public static final @NotNull String CLASS_NAME = "ProcessCommand";

	private static final Scanner SCN = new Scanner( System.in );

	public static void commandProcess( String[] cmd ) {

	}

	public static void commandProcess() {

		String tmp = SCN.next().toUpperCase();

		// operations:
		if ( BasicVariables.CommandSet.HELP.toUpperCase().equals( tmp ) ) {
			BasicOutput.log(
					BasicVariables.BASIC_OUTPUT_LOG_TYPE_INFO,
					docAboutAndHelp()
			);
		} else {
			BasicOutput.log(
					BasicVariables.BASIC_OUTPUT_LOG_TYPE_WARN,
					BasicVariables.CommandSet.DOC_CMD_NOT_FOUND
			);
		}

	}

	private static String docAboutAndHelp() {
		return BasicVariables.CommandSet.DOC_ABOUT +
			   BasicVariables.CommandSet.DOC_HELP;
	}

	/**
	 * 	@Explaination The reason why do not I use :? is because once I add
	 * 	or remove some expression from it, it is going to
	 * 	be a massive work to do.
	 * 	Especially when writing {@code default} section.
	 */
	private static String docAboutAndHelp( String helpCmd ) {

		// TODO: Use ProcessIO.java instead

		final String INPUT = helpCmd.toUpperCase();

		return switch ( INPUT ) {
			case "ABOUT" -> BasicVariables.CommandSet.DOC_ABOUT;
			case "HELP" -> BasicVariables.CommandSet.DOC_HELP;
			default -> BasicVariables.CommandSet.DOC_CMD_NOT_FOUND;
		};

	}

}

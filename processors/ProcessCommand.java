package com.study.processors;

import com.study.storage.BasicVariables;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Scanner;

/**
 * @author william
 */
public class ProcessCommand {

	public static final @NotNull String CLASS_NAME = "ProcessCommand";

	private static final Scanner SCN = new Scanner( System.in );

	public static int onCreate( String[] userInput ) {

		for (
				int i = 0;
				i < userInput.length;
				i++
		) {

			String cmd_idx = userInput[ i ];

			int rtnCode = process( cmd_idx );

			if ( rtnCode != 0 ) {
				return rtnCode;
			}

		}

		return 0;

	}

	private static int process( String cmd ) {

		ProcessIO.ProcessOutput processOutput = new ProcessIO.ProcessOutput();

		if ( ! cmd.isEmpty() ) {

			if ( cmd.equalsIgnoreCase( BasicVariables.CommandSet.HELP ) ) {
				processOutput.onCreate(
						BasicVariables.BASIC_OUTPUT_LOG_TYPE_INFO,
						cmd_help_help()
				);

				return BasicVariables.ConsoleReturn.ERR_NONE;

			} else if ( cmd.equalsIgnoreCase( BasicVariables.CommandSet.EXIT ) ) {


			} else if ( cmd.equalsIgnoreCase( BasicVariables.CommandSet.TIME ) ) {
				processOutput.onCreate(
						BasicVariables.BASIC_OUTPUT_LOG_TYPE_INFO,
						cmd_time().toString()
				);
				return BasicVariables.ConsoleReturn.ERR_NONE;

			} else {
				processOutput.onCreate(
						BasicVariables.BASIC_OUTPUT_LOG_TYPE_ERROR,
						BasicVariables.CommandSet.CMD_NOT_FOUND
				);

				return BasicVariables.ConsoleReturn.ERR_ILLEGAL_INPUT;

			}

		}

		return BasicVariables.ConsoleReturn.ERR_ILLEGAL_INPUT_FINAL;

	}

	private static LocalDateTime cmd_time() {

		return LocalDateTime.now( ZoneOffset.ofHours( BasicVariables.TIME_ZONE_OFFSET_EAST_EIGHT ) );

	}

	private static String cmd_help_help() {

		return BasicVariables.CommandSet.DOC_ABOUT +
			   BasicVariables.CommandSet.DOC_HELP;

	}

	/**
	 * @Explaination The reason why do not I use :? is because once I add
	 * or remove some expression from it, it is going to
	 * be a massive work to do.
	 * Especially when writing {@code default} section.
	 */
	private static String cmd_help( String helpCmd ) {

		// TODO: Use ProcessIO.java instead

		final String INPUT = helpCmd.toUpperCase();

		return switch ( INPUT ) {
			case "ABOUT" -> BasicVariables.CommandSet.DOC_ABOUT;
			case "HELP" -> BasicVariables.CommandSet.DOC_HELP;
			default -> BasicVariables.CommandSet.CMD_NOT_FOUND;
		};

	}

}

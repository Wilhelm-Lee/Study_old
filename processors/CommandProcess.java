package com.study.processors;

import com.study.storage.BasicVariables;
import org.jetbrains.annotations.NotNull;

/**
 * @author william
 */
public class CommandProcess {

	public static final @NotNull String CLASS_NAME = "CommandProcess";

	void commandProcess( String[] cmd ) {

	}

	void commandProcess( String cmd ) {

	}

	public static String help() {
		return BasicVariables.DOC_ABOUT + BasicVariables.DOC_HELP;
	}

	/**
	 * 	@Explaination The reason why do not I use :? is because once I add
	 * 	or remove some expression from it, it is going to
	 * 	be a massive work to do.
	 * 	Especially when writing {@code default} section.
	 */
	public static String help( String cmdThatNeedsHelp ) {

		// TODO: Use BasicIOProcess.java instead

		String input = cmdThatNeedsHelp.toUpperCase();

		return switch ( input ) {
			case "ABOUT" -> BasicVariables.DOC_ABOUT;
			case "HELP" -> BasicVariables.DOC_HELP;
			default -> BasicVariables.DOC_CMD_NOT_FOUND;
		};

	}

}

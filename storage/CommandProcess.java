package com.study.storage;

import static com.study.storage.BasicVariables.ENDL;
import static com.study.storage.BasicVariables.TABULATION;

/**
 * @author william
 */
public class CommandProcess {

	public static final String DOC_ABOUT =
			"Project: " + BasicVariables.ABOUT_PROJECT_NAME + ENDL +
			"Version: " + BasicVariables.ABOUT_PROJECT_VERSION + ENDL +
			"Author: " + BasicVariables.ABOUT_PROJECT_AUTHOR_NAME + ENDL +
			"Github: " + BasicVariables.ABOUT_PROJECT_AUTHOR_GITHUB + ENDL;

	public static final String DOC_HELP =
			"Usage: <command> [...]" +
			ENDL +
			"Commands:" +
			ENDL +
			TABULATION +
			BasicVariables.HELP_HELP_CMD +
			BasicVariables.HELP_HELP_CMT +
			ENDL +
			TABULATION +
			BasicVariables.HELP_EXIT_CMD +
			BasicVariables.HELP_EXIT_CMT +
			ENDL // LAST WORKED HERE TODO: add +
			;

	public static void help() {

		System.out.println( DOC_ABOUT );
	}

}

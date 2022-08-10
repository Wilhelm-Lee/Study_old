package com.study.storage;

import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;

/**
 * @author william
 */

public class BasicVariables {

	/**
	 * Everything here must be {@code public}!!!<p>
	 * Everything here must be {@code static}!!!<p>
	 * Some variables would be used with adding a {@code SPACE} followed after itself as if you might or will
	 */

	public static final @NotNull String CLASS_NAME = "BasicVariables";

	public static final char COLON = ':';
	public static final char SEMICOLON = ';';
	public static final char PERIOD = '.';
	public static final char COMMA = ',';
	public static final char SPACE = ' ';
	public static final char SLASH = '/';
	public static final String ENDL = "\n";
	public static final String TABULATION = "\t";

	public static final String TARGET = "Target" + BasicVariables.SPACE;
	public static final String FILE_MANAGER_TARGET_TYPE_FILE_STRING = "File" + BasicVariables.SPACE;
	public static final String FILE_MANAGER_TARGET_TYPE_PATH_STRING = "Path" + BasicVariables.SPACE;
	public static final String FILE_MANAGER_OUTPUT_TEXT_TARGET_FILE_DOES_NOT_EXIST = "Target file does not exist" +
																					 BasicVariables.SPACE;
	public static final String FILE_MANAGER_OUTPUT_TEXT_TARGET_PATH_DOES_NOT_EXIST = "Target path does not exist" +
																					 BasicVariables.SPACE;
	public static final String FILE_MANAGER_OUTPUT_TEXT_HAD_ALREADY_EXISTED = BasicVariables.SPACE +
																			  "had already existed";
	public static final String FILE_MANAGER_OUTPUT_TEXT_FAILED_CAUSED_AND_CANCELED_BY_USER = BasicVariables.SPACE +
																							 "failed, caused & canceled by user";
	public static final String FILE_MANAGER_OUTPUT_TEXT_HOW_WOULD_YOU_LIKE_TO = "How would you like to" +
																				BasicVariables.SPACE;
	public static final String FILE_MANAGER_OUTPUT_TEXT_QUESTIONMARK_YN = BasicVariables.SPACE + "? y/n";
	public static final String FILE_MANAGER_OUTPUT_TEXT_Y = "Y";
	public static final String FILE_MANAGER_OUTPUT_TEXT_YES = "YES";
	public static final String FILE_MANAGER_OUTPUT_TEXT_N = "N";
	public static final String FILE_MANAGER_OUTPUT_TEXT_NO = "NO";
	public static final String FILE_MANAGER_ACTIONS_CREATING = "CREATING" + BasicVariables.SPACE;
	public static final String FILE_MANAGER_FILE_CREATING_SUCCESS = "File Creating Succeed" + BasicVariables.SPACE;
	public static final String FILE_MANAGER_FILE_CREATING_FAILED = "File Creating Failed" + BasicVariables.SPACE;
	public static final String LINUX_COMMAND_TOUCH = "touch", LINUX_COMMAND_MKDIR = "mkdir";
	public static final int META_YEAR = 1970;
	public static final LocalDateTime META_YEAR_LOCAL_DATE_TIME = LocalDateTime.of(
			// YEAR
			META_YEAR,
			// MONTH
			1,
			// DATE
			1,
			// HOUR
			0,
			// MINUTE
			0,
			// SECOND
			0,
			// NANO SECOND
			0
	);
	public static final int TIME_ZONE_OFFSET_EAST_EIGHT = 8;
	public static final String TERMINAL_COLOR_DEFAULT_CODE_BEFORE_COLOR_CONTENT = "\033[";
	public static final String TERMINAL_COLOR_DEFAULT_CODE_AFTER_COLOR_CONTENT = "m";
	public static final String BASIC_OUTPUT_LOG_FORMAT_FRONT = "Front";
	/*
	 * [ TABLE ColorArrangement ]
	 *
	 * *---------------------------------------------------------------------------------*
	 * |               COLOR    BELONG_TO        TYPE    NOTE                            |
	 * +---------------------------------------------------------------------------------+
	 * |                CYAN    -> Request       <OUT>                                   |
	 * |                BLUE    -> Info          <OUT>                                   |
	 * |              YELLOW    -> Warn          <OUT>                                   |
	 * |                 RED    -> Error         <OUT>                                   |
	 * |               White    -> Regular       <IN>                                    |
	 * |                Blue    -> Ans           <IN>                                    |
	 * |       GREEN(Ground)    -> Reply-Local   <IN>    Not Scheduled To Use Yet        |
	 * |           CYAN(Sky)    -> Reply-Remote  <IN>    Not Scheduled To Use Yet        |
	 * *---------------------------------------------------------------------------------*
	 * ...............................................................July 15th, 2022.....
	 */
	/**
	 * Hello are you happy people?    -- Droopy Dog (1943 - 1958)
	 */
	public static final String BASIC_OUTPUT_LOG_TYPE_REQUEST = "Request";
	public static final String BASIC_OUTPUT_LOG_TYPE_INFO = "Info";
	public static final String BASIC_OUTPUT_LOG_TYPE_WARN = "Warning";
	public static final String BASIC_OUTPUT_LOG_TYPE_ERROR = "Error";
	public static final String BASIC_INPUT_RECORDER_TYPE_REGULAR = "Regular";
	public static final String BASIC_INPUT_RECORDER_TYPE_ANSWER = "Answer";
	public static final String BASIC_INPUT_RECORDER_TYPE_REPLY_LOCAL = "Reply_Local";
	public static final String BASIC_INPUT_RECORDER_TYPE_REPLY_REMOTE = "Reply_Remote";
	public static final String BASIC_OUTPUT_LOG_FORMAT_COLOR_FRONT = "3";
	public static final String BASIC_OUTPUT_LOG_FORMAT_COLOR_BACK = "4";
	/**
	 * {@code TERMINAL_COLOR_RESET}: As what previous one was,
	 * for the sections of which the both which are {@code Front}|{@code Back} and {@code color}
	 */
	public static final char TERMINAL_COLOR_BLACK = '0';
	public static final char TERMINAL_COLOR_RED = '1';
	public static final char TERMINAL_COLOR_GREEN = '2';
	public static final char TERMINAL_COLOR_YELLOW = '3';
	public static final char TERMINAL_COLOR_BLUE = '4';
	public static final char TERMINAL_COLOR_MAGENTA = '5';
	public static final char TERMINAL_COLOR_CYAN = '6';
	public static final char TERMINAL_COLOR_WHITE = '7';
	public static final char TERMINAL_COLOR_RESET = '8';
	public static final int APPLICATIONS_TODOLIST_ITEM_URGENCY_LEVEL_NONE = 0;
	public static final int APPLICATIONS_TODOLIST_ITEM_URGENCY_LEVEL_NORMAL = 1;
	public static final int APPLICATIONS_TODOLIST_ITEM_URGENCY_LEVEL_IMPOTENT = 2;
	public static final int APPLICATIONS_TODOLIST_ITEM_URGENCY_LEVEL_URGENT = 3;
	public static final int APPLICATIONS_TODOLIST_ITEM_URGENCY_LEVEL_SERIOUS = 4;
	public static final int APPLICATIONS_TODOLIST_ITEM_URGENCY_LEVEL_IMMEDIATE = 5;

	public static final String USER_NAME = System.getProperty( "user.name" );
	public static final String HOME_PATH_STRING = "/home" + BasicVariables.SLASH + USER_NAME;
	public static final String DOCUMENTS_PATH_STRING = "/Documents";
	public static final String STUDY_PATH_STRING = HOME_PATH_STRING +
												   BasicVariables.DOCUMENTS_PATH_STRING +
												   "/StudyFiles";
	/**
	 * Starts from 1
	 */
	public static long applicationsTodoListItemIdLoadUp = 1;
	public static long timeLineIdLoadUp = 1;

	/**
	 * @author william
	 */
	public static class CommandSet {

		public static final @NotNull String CLASS_NAME = "CommandSet";

		/**
		 * -------------------------------------------
		 * Exit the programme
		 */
		public static final String EXIT = "EXIT";

		/**
		 * -------------------------------------------
		 * Print out local date & time
		 */
		public static final String TIME = "TIME";
		/**
		 * no flg: "DD dd MM, YY"
		 */
		public static final char TIME_F_EMPTY = '\0';
		/**
		 * Format date & time with yours
		 */
		public static final char TIME_F_f = 'f';
		/**
		 * format Simply/Shortly: "HH-mm-ss"
		 */
		public static final char TIME_F_s = 's';

		/*
		 * There's no need to type in all capitalization
		 */

		/**
		 * no flg: "DD dd MM, YY"
		 */
		public static final String TIME_FLAG_EMPTY = "\000";
		/**
		 * Format date & time with yours
		 */
		public static final String TIME_FLAG_FORMAT = "FORMAT";
		/**
		 * format Simply/Shortly: "HH-mm-ss"
		 */
		public static final String TIME_FLAG_SHORT = "SHORT";

		/**
		 * -------------------------------------------
		 * Run Help-Doc
		 */
		public static final String HELP = "HELP";
		/**
		 * Print help for HELP
		 */
		public static final String HELP_FLAG_HELP = HELP;
		/**
		 * Print help for EXIT
		 */
		public static final String HELP_FLAG_EXIT = EXIT;
		/**
		 * Print help for TIME
		 */
		public static final String HELP_FLAG_TIME = TIME;

		public static final String ABOUT_PROJECT_NAME = "Study";
		public static final String ABOUT_PROJECT_VERSION = "Aug9th2022_PROTOTYPE";
		public static final String ABOUT_PROJECT_AUTHOR_NAME = "William Michael";
		public static final String ABOUT_PROJECT_AUTHOR_GITHUB = "https://github.com/MichealWilliamLR/Study";
		public static final String DOC_ABOUT =
				"Project: " + ABOUT_PROJECT_NAME + ENDL +
				"Version: " + ABOUT_PROJECT_VERSION + ENDL +
				"Author: " + ABOUT_PROJECT_AUTHOR_NAME + ENDL +
				"Github: " + ABOUT_PROJECT_AUTHOR_GITHUB + ENDL;
		public static final String HELP_HELP_CMD = "{ h | help }";
		public static final String HELP_HELP_CMT = "Print this help";
		public static final String HELP_EXIT_CMD = "{ exit }";
		public static final String HELP_EXIT_CMT = "Exit Study";
		public static final String HELP_TIME_CMD = "{ time }";
		public static final String HELP_TIME_CMT = "Print out local date & time";
		public static final String DOC_HELP =
				"Usage: <command> [...]" + ENDL +
				"Commands:" + ENDL +
				TABULATION + HELP_HELP_CMD + TABULATION + HELP_HELP_CMT + ENDL +
				TABULATION + HELP_EXIT_CMD + TABULATION + HELP_EXIT_CMT + ENDL +
				TABULATION + HELP_TIME_CMD + TABULATION + HELP_TIME_CMT + ENDL;
		public static final String DOC_CMD_NOT_FOUND = "Illegal argument";
	}
}

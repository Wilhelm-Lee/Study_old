package com.michealwilliam;

import java.time.LocalDateTime;

public class BasicVariables {

	/*
	Everything here must be static!!!
	Some text would be used with adding a @SPACE follow after itself as if you might or will
	 */

	public static final char SPACE = ' ';
	public static final char ENDL = '\n';
	public static final char TABULATION = '\t';
	public static final String TARGET = "Target";
	public static final String FileManager_TARGET_TYPE_FILE = "File",
							   FileManager_TARGET_TYPE_PATH = "Path";
	public static final String FileManager_OUTPUT_TEXT_TARGET_FILE_DOES_NOT_EXIST = "Target file does not exist",
							   FileManager_OUTPUT_TEXT_TARGET_PATH_DOES_NOT_EXIST = "Target path does not exist",
							   FileManager_OUTPUT_TEXT_HAD_ALREADY_EXISTED = "had already existed",
							   FileManager_OUTPUT_TEXT_FAILED_CAUSED_AND_CANCELED_BY_USER = "failed, caused & canceled by user",
							   FileManager_OUTPUT_TEXT_HOW_WOULD_YOU_LIKE_TO = "How would you like to",
							   FileManager_OUTPUT_TEXT_QUESTIONMARK_YN = "? y/n",
							   FileManager_OUTPUT_TEXT_Y = "Y",
							   FileManager_OUTPUT_TEXT_YES = "YES",
							   FileManager_OUTPUT_TEXT_n = "N",
							   FileManager_OUTPUT_TEXT_no = "NO";
	public static final String FileManager_ACTIONS_CREATING = "CREATING";
	public static final String LINUX_COMMAND_TOUCH = "touch",
							   LINUX_COMMAND_MKDIR = "mkdir";
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
	public static final String TERMINAL_COLOR_DEFAULT_CODE_BEFORE_COLOR_CONTENT = "\033[",
							   TERMINAL_COLOR_DEFAULT_CODE_AFTER_COLOR_CONTENT = "m";
	public static final String BASIC_OUTPUT_LOG_FORMAT_FRONT = "Front";
	public static final String BASIC_OUTPUT_LOG_TYPE_REQUEST = "Request",                // CYAN
							   BASIC_OUTPUT_LOG_TYPE_INFO = "Info",                      // BLUE
							   BASIC_OUTPUT_LOG_TYPE_WARN = "Warning",                   // YELLOW
							   BASIC_OUTPUT_LOG_TYPE_ERROR = "Error";                    // RED
	public static final String BASIC_INPUT_RECORDER_TYPE_REGULAR = "Regular",            // White
							   BASIC_INPUT_RECORDER_TYPE_ANSWER = "Answer",              // Blue
							   BASIC_INPUT_RECORDER_TYPE_REPLY_LOCAL = "Reply_Local",    // GREEN(Ground for local)	// Not In Schedule To Use Yet
							   BASIC_INPUT_RECORDER_TYPE_REPLY_REMOTE = "Reply_Remote";  // CYAN(Sky for remote)	// Not In Schedule To Use Yet
	public static final String BASIC_OUTPUT_LOG_FORMAT_COLOR_FRONT = "3",
							   BASIC_OUTPUT_LOG_FORMAT_COLOR_BACK = "4";
	public static final char TERMINAL_COLOR_BLACK = '0',
						     TERMINAL_COLOR_RED = '1',
						     TERMINAL_COLOR_GREEN = '2',
							 TERMINAL_COLOR_YELLOW = '3',
							 TERMINAL_COLOR_BLUE = '4',
							 TERMINAL_COLOR_MAGENTA = '5',
							 TERMINAL_COLOR_CYAN = '6',
							 TERMINAL_COLOR_WHITE = '7',
							 TERMINAL_COLOR_RESET = '8';
	public static final int APPLICATIONS_TODOLIST_ITEM_URGENCY_LEVEL_NONE = 0,
							APPLICATIONS_TODOLIST_ITEM_URGENCY_LEVEL_NORMAL = 1,
							APPLICATIONS_TODOLIST_ITEM_URGENCY_LEVEL_IMPOTENT = 2,
							APPLICATIONS_TODOLIST_ITEM_URGENCY_LEVEL_URGENT = 3,
							APPLICATIONS_TODOLIST_ITEM_URGENCY_LEVEL_SERIOUS = 4,
							APPLICATIONS_TODOLIST_ITEM_URGENCY_LEVEL_IMMEDIATE = 5;
	/** Due to Settings.HOME_PATH is not a constant variable, cannot use final down there */
	public static String studyPath = Settings.homePath + "/Documents/StudyFiles";
	/** RESET: As what previous one was, for the sections of which the both which are ${Front|Back} and ${color} */
	public static long applicationsTodoListItemIdLoadUp = 1; // Starts from 1


}

package com.study;

import java.time.LocalDateTime;

/**
 * @author william
 */

public class BasicVariables {

	/**
	 * Everything here must be {@code public}!!!<p>
	 * Everything here must be {@code static}!!!<p>
	 * Some text would be used with adding a {@code SPACE} follow after itself as if you might or will
	 */

	public static final char DOT = '.';
	public static final char SPACE = ' ';
	public static final char SLASH = '/';
	public static final char ENDL = '\n';
	public static final char TABULATION = '\t';
	public static final String TARGET = "Target";
	public static final String FILE_MANAGER_TARGET_TYPE_FILE_STRING = "File",
			FILE_MANAGER_TARGET_TYPE_PATH_STRING = "Path";
	public static final String FILE_MANAGER_OUTPUT_TEXT_TARGET_FILE_DOES_NOT_EXIST = "Target file does not exist",
			FILE_MANAGER_OUTPUT_TEXT_TARGET_PATH_DOES_NOT_EXIST = "Target path does not exist",
			FILE_MANAGER_OUTPUT_TEXT_HAD_ALREADY_EXISTED = "had already existed",
			FILE_MANAGER_OUTPUT_TEXT_FAILED_CAUSED_AND_CANCELED_BY_USER = "failed, caused & canceled by user",
			FILE_MANAGER_OUTPUT_TEXT_HOW_WOULD_YOU_LIKE_TO = "How would you like to",
			FILE_MANAGER_OUTPUT_TEXT_QUESTIONMARK_YN = "? y/n",
			FILE_MANAGER_OUTPUT_TEXT_Y = "Y",
			FILE_MANAGER_OUTPUT_TEXT_YES = "YES",
			FILE_MANAGER_OUTPUT_TEXT_N = "N",
			FILE_MANAGER_OUTPUT_TEXT_NO = "NO";
	public static final String FILE_MANAGER_ACTIONS_CREATING = "CREATING";
	public static final String FILE_MANAGER_FILE_CREATING_SUCCESS = "File Creating Succeed";
	public static final String FILE_MANAGER_FILE_CREATING_FAILED = "File Creating Failed";
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
	public static final String TERMINAL_COLOR_DEFAULT_CODE_BEFORE_COLOR_CONTENT = "\033[",
			TERMINAL_COLOR_DEFAULT_CODE_AFTER_COLOR_CONTENT = "m";
	public static final String BASIC_OUTPUT_LOG_FORMAT_FRONT = "Front";
	/*
	 * *---------------------------------------------------------------------------------*
	 * |			   COLOR	BELONG_TO		TYPE	NOTE							 |
	 * +---------------------------------------------------------------------------------+
	 * | 				CYAN	-> Request		<OUT>									 |
	 * | 				BLUE	-> Info         <OUT>                                    |
	 * | 			  YELLOW	-> Warn         <OUT>                                    |
	 * | 				 RED	-> Error        <OUT>                                    |
	 * | 			   White	-> Regular      <IN>                                     |
	 * | 				Blue	-> Ans          <IN>                                     |
	 * | 	   GREEN(Ground)	-> Reply-Local	<IN>	Not Scheduled To Use Yet	 	 |
	 * | 		   CYAN(Sky)	-> Reply-Remote	<IN>	Not Scheduled To Use Yet	 	 |
	 * *---------------------------------------------------------------------------------*
	 * ...............................................................July 15th, 2022.....
	 */
	/** Are you happy people?	-- Droopy Dog (1943 - 1958) */
	public static final String BASIC_OUTPUT_LOG_TYPE_REQUEST = "Request",
			BASIC_OUTPUT_LOG_TYPE_INFO = "Info",
			BASIC_OUTPUT_LOG_TYPE_WARN = "Warning",
			BASIC_OUTPUT_LOG_TYPE_ERROR = "Error";
	public static final String BASIC_INPUT_RECORDER_TYPE_REGULAR = "Regular",
			BASIC_INPUT_RECORDER_TYPE_ANSWER = "Answer",
			BASIC_INPUT_RECORDER_TYPE_REPLY_LOCAL = "Reply_Local",
			BASIC_INPUT_RECORDER_TYPE_REPLY_REMOTE = "Reply_Remote";
	public static final String BASIC_OUTPUT_LOG_FORMAT_COLOR_FRONT = "3",
			BASIC_OUTPUT_LOG_FORMAT_COLOR_BACK = "4";
	/** {@code TERMINAL_COLOR_RESET}: As what previous one was,
	 *  for the sections of which the both which are {@code Front}|{@code Back} and {@code color} */
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
	public static final String USER_NAME = System.getProperty( "user.name" );
	public static final String HOME_PATH_STRING = "/home" + BasicVariables.SLASH + USER_NAME;
	public static final String DOCUMENTS_PATH_STRING = "/Documents";
	public static final String STUDY_PATH_STRING = HOME_PATH_STRING + BasicVariables.DOCUMENTS_PATH_STRING + "/StudyFiles";

	/**
	 * Starts from 1
	 */
	public static long applicationsTodoListItemIdLoadUp = 1;
	public static long timeLineIdLoadUp = 1;
}

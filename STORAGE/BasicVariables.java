package com.study.STORAGE;

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

	public static final char DOT = '.';
	public static final char SPACE = ' ';
	public static final char SLASH = '/';
	public static final char ENDL = '\n';
	public static final char TABULATION = '\t';
	public static final String TARGET = "Target" + BasicVariables.SPACE;
	public static final String FILE_MANAGER_TARGET_TYPE_FILE_STRING = "File" + BasicVariables.SPACE;
	public static final String FILE_MANAGER_TARGET_TYPE_PATH_STRING = "Path" + BasicVariables.SPACE;
	public static final String FILE_MANAGER_OUTPUT_TEXT_TARGET_FILE_DOES_NOT_EXIST = "Target file does not exist" +
																						BasicVariables.SPACE;
	public static final String FILE_MANAGER_OUTPUT_TEXT_TARGET_PATH_DOES_NOT_EXIST = "Target path does not exist" + BasicVariables.SPACE;
	public static final String FILE_MANAGER_OUTPUT_TEXT_HAD_ALREADY_EXISTED = BasicVariables.SPACE + "had already existed";
	public static final String FILE_MANAGER_OUTPUT_TEXT_FAILED_CAUSED_AND_CANCELED_BY_USER = BasicVariables.SPACE +
																								"failed, caused & canceled by user";
	public static final String FILE_MANAGER_OUTPUT_TEXT_HOW_WOULD_YOU_LIKE_TO = "How would you like to" + BasicVariables.SPACE;
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
	/**
	 * Hello are you happy people?	-- Droopy Dog (1943 - 1958)
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
	public static final String STUDY_PATH_STRING = HOME_PATH_STRING +
													  BasicVariables.DOCUMENTS_PATH_STRING +
													  "/StudyFiles";
	public static final String DOCUMENTS_PATH_STRING = "/Documents";
	/**
	 * Starts from 1
	 */
	public static long applicationsTodoListItemIdLoadUp = 1;
	public static long timeLineIdLoadUp = 1;
}

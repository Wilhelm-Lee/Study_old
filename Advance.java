package com.study;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Advance {

	public static final @NotNull String CLASS_NAME = "Advance";

	/**
	 * @author william
	 */
	public static class FileManager {

		public static final String CLASS_NAME = "FileManager";
		static Basic.BasicOutput basicOutput = new Basic.BasicOutput();

		public static class FileCreator {

			public static final String CLASS_NAME = "FileCreator";

			Scanner scn = new Scanner( System.in );
			List<String> cmd = new ArrayList<>( 0 );
			Runtime runtime;
			Process process;
			boolean isAllRight = true;

			private boolean ifAsk(
					@NotNull File targetObject
			) {

				FileManager.basicOutput.log(
						Basic.BasicVariables.BASIC_OUTPUT_LOG_TYPE_REQUEST,
						targetObject.isFile()
								? Basic.BasicVariables.FILE_MANAGER_OUTPUT_TEXT_HOW_WOULD_YOU_LIKE_TO +
								  /* Specific Action by @CLASS_NAME (down) */
								  Basic.BasicVariables.FILE_MANAGER_ACTIONS_CREATING +
								  Basic.BasicVariables.SPACE +
								  targetObject.getAbsoluteFile() +
								  Basic.BasicVariables.FILE_MANAGER_OUTPUT_TEXT_QUESTIONMARK_YN
								: Basic.BasicVariables.FILE_MANAGER_OUTPUT_TEXT_HOW_WOULD_YOU_LIKE_TO +
								  Basic.BasicVariables.FILE_MANAGER_ACTIONS_CREATING +
								  Basic.BasicVariables.SPACE +
								  targetObject.getAbsolutePath() +
								  Basic.BasicVariables.FILE_MANAGER_OUTPUT_TEXT_QUESTIONMARK_YN
				);

				return Basic.BasicVariables.FILE_MANAGER_OUTPUT_TEXT_Y.equalsIgnoreCase( scn.next() ) ||
					   Basic.BasicVariables.FILE_MANAGER_OUTPUT_TEXT_YES.equalsIgnoreCase( scn.next() );
			}

			private void creating(
					@NotNull File targetObject,
					@NotNull String targetType,
					boolean ifAskNeeded
			) {

				try {

					this.cmd.clear();

					if ( Basic.BasicVariables.FILE_MANAGER_TARGET_TYPE_FILE_STRING.equalsIgnoreCase( targetType ) ) {
						this.cmd.add( Basic.BasicVariables.LINUX_COMMAND_TOUCH );
						this.cmd.add( targetObject.getAbsolutePath() );
					} else {
						this.cmd.add( Basic.BasicVariables.LINUX_COMMAND_MKDIR );
						// the flag
						this.cmd.add( "-p" );
						this.cmd.add( targetObject.getAbsolutePath() );
					}

					// if not exists
					if ( !targetObject.exists() ) {
						// Then create it
						// Ask
						if ( ifAskNeeded ) {
							if ( ifAsk(	targetObject ) ) {
								runtime = Runtime.getRuntime();
								process = runtime.exec( this.cmd.toArray( new String[ cmd.size() ] ) );
							} else {
								requestDenied(
										targetObject,
										targetType
								);
							}
						} else {
							runtime = Runtime.getRuntime();
							process = runtime.exec( this.cmd.toArray( new String[ cmd.size() ] ) );
						}
					} else {
						FileManager.basicOutput.log(
								Basic.BasicVariables.BASIC_OUTPUT_LOG_TYPE_INFO,
								targetType.toUpperCase() +
								targetObject.getAbsoluteFile() +
								Basic.BasicVariables.FILE_MANAGER_OUTPUT_TEXT_HAD_ALREADY_EXISTED
						);
					}
				} catch ( IOException ioe ) {
					FileManager.basicOutput.log(
							Basic.BasicVariables.BASIC_OUTPUT_LOG_TYPE_ERROR,
							FileCreator.CLASS_NAME,
							ioe.getLocalizedMessage()
					);
				}
			}

			private void requestDenied(
					@NotNull File targetObject,
					String targetType
			) {

				FileManager.basicOutput.log(
						Basic.BasicVariables.BASIC_OUTPUT_LOG_TYPE_WARN,
						targetType +
						Basic.BasicVariables.SPACE +
						targetObject +
						Basic.BasicVariables.FILE_MANAGER_OUTPUT_TEXT_FAILED_CAUSED_AND_CANCELED_BY_USER
				);
			}

			private boolean checkExistence(
					@NotNull File targetObject,
					@NotNull String targetType
			) {

				return Basic.BasicVariables.FILE_MANAGER_TARGET_TYPE_FILE_STRING.equalsIgnoreCase( targetType )
						? targetObject.getAbsoluteFile().exists()
						: targetObject.exists();
			}

			public boolean onCreate( File targetFile, boolean ifAskNeeded ) {

				try {
					if ( !checkExistence(
							new File( targetFile.getParent() ),
							Basic.BasicVariables.FILE_MANAGER_TARGET_TYPE_PATH_STRING
					) ) {
						isAllRight = false;

						FileManager.basicOutput.log(
								Basic.BasicVariables.BASIC_OUTPUT_LOG_TYPE_WARN,
								Basic.BasicVariables.FILE_MANAGER_OUTPUT_TEXT_TARGET_PATH_DOES_NOT_EXIST
						);

						creating(
								new File( targetFile.getParent() ),
								Basic.BasicVariables.FILE_MANAGER_TARGET_TYPE_PATH_STRING,
								ifAskNeeded
						);
						// Retry
						onCreate( targetFile.getAbsoluteFile(), false );
						// Actually, it does not need to getAbsoluteFile(), just original targetFile would also be fine
					} else {
						isAllRight = true;
						FileManager.basicOutput.log(
								Basic.BasicVariables.BASIC_OUTPUT_LOG_TYPE_INFO,
								Basic.BasicVariables.TARGET +
								Basic.BasicVariables.FILE_MANAGER_TARGET_TYPE_PATH_STRING +
								new File( targetFile.getParent() ).getAbsoluteFile() +
								Basic.BasicVariables.FILE_MANAGER_OUTPUT_TEXT_HAD_ALREADY_EXISTED
						);
						// Judge whether the targetFile exists or not
						if ( !checkExistence(
								targetFile.getAbsoluteFile(),
								Basic.BasicVariables.FILE_MANAGER_TARGET_TYPE_FILE_STRING
						) ) {
							isAllRight = false;
							FileManager.basicOutput.log(
									Basic.BasicVariables.BASIC_OUTPUT_LOG_TYPE_WARN,
									Basic.BasicVariables.FILE_MANAGER_OUTPUT_TEXT_TARGET_FILE_DOES_NOT_EXIST
							);
							creating(
									targetFile.getAbsoluteFile(),
									Basic.BasicVariables.FILE_MANAGER_TARGET_TYPE_FILE_STRING,
									ifAskNeeded
							);
							// Retry
							onCreate( targetFile.getAbsoluteFile(), false );
						} else {
							// targetFile exists
							isAllRight = true;
							FileManager.basicOutput.log(
									Basic.BasicVariables.BASIC_OUTPUT_LOG_TYPE_INFO,
									Basic.BasicVariables.TARGET +
									Basic.BasicVariables.FILE_MANAGER_TARGET_TYPE_FILE_STRING +
									targetFile.getAbsoluteFile() +
									Basic.BasicVariables.FILE_MANAGER_OUTPUT_TEXT_HAD_ALREADY_EXISTED
							);
						}
					}
				} catch ( Exception e ) {

					/*
					  This case should not happen, because once
					  there were a File or Path does not exist,
					  preparation() would solve it by trying
					  recursively.
					  This is an exception-like reporting code
					  */

					FileManager.basicOutput.log(
							Basic.BasicVariables.BASIC_OUTPUT_LOG_TYPE_ERROR,
							FileCreator.CLASS_NAME,
							e.getLocalizedMessage()
					);
					return isAllRight = false;
				}
				return isAllRight = true;
			}
		}
	}

	/**
	 * @author william
	 */

	public static class Applications {


		public static final String CLASS_NAME = "Applications";

		static Basic.BasicOutput basicOutput = new Basic.BasicOutput();
		static FileManager.FileCreator fm = new FileManager.FileCreator();

		public static class TodoList
				extends Applications {

			public static final String CLASS_NAME = "TodoList";
			static TodoList todoList = new TodoList();
			/** Due to Settings.HOME_PATH is not a constant variable, cannot use final here */
			public String TODOLIST_FILE = "/TodoList.study";
			public final File TARGET_FILE = new File(
					Basic.BasicVariables.STUDY_PATH_STRING,
					TODOLIST_FILE
			);

			// S -?-> E
			public TodoList.@NotNull Item createScheduleS_E(
					String itemName,
					LocalDateTime itemTimeStampLocalDateTimeStart,
					LocalDateTime itemTimeStampLocalDateTimeEnd,
					int level
			) {

				TodoList.Item newItem = new TodoList.Item();

				newItem.id = Basic.BasicVariables.applicationsTodoListItemIdLoadUp + 1;
				newItem.itemName = itemName;
				newItem.itemDateTimeStartInSeconds = Basic.BasicFunctions.durationOfLocalDateTimeToSecond(
						itemTimeStampLocalDateTimeStart,
						itemTimeStampLocalDateTimeEnd,
						ZoneOffset.ofHours( Basic.BasicVariables.TIME_ZONE_OFFSET_EAST_EIGHT )
				);
				newItem.itemDateTimeEndInSeconds = Basic.BasicFunctions.durationOfLocalDateTimeToSecond(
						itemTimeStampLocalDateTimeStart,
						itemTimeStampLocalDateTimeEnd,
						ZoneOffset.ofHours( Basic.BasicVariables.TIME_ZONE_OFFSET_EAST_EIGHT )
				);
				newItem.level = level;
				//     /  =(o|_E_E_E_|___A___|_Z_Z_Z_|_Y___Y_|
				// (:P)[x] {]|_EEE___|__AAA__|___Z___|___Y___|
				//     \  =(o|_E_E_E_|_A___A_|_Z_Z_Z_|___Y___|
				//        "

				return newItem;
			}

			// ? -D-> E
			public TodoList.Item createSchedule_DE(
					String itemName,
					LocalDateTime itemTimeStampLocalDateTimeDuration,
					LocalDateTime itemTimeStampLocalDateTimeEnd,
					int level
			) {

				TodoList.Item newItem = new TodoList.Item();
				LocalDateTime tmpLDTStart = LocalDateTime.of(
						itemTimeStampLocalDateTimeEnd.getYear() - itemTimeStampLocalDateTimeDuration.getYear(),
						itemTimeStampLocalDateTimeEnd.getMonthValue() - itemTimeStampLocalDateTimeDuration.getMonthValue(),
						itemTimeStampLocalDateTimeEnd.getDayOfMonth() - itemTimeStampLocalDateTimeDuration.getDayOfMonth(),
						itemTimeStampLocalDateTimeEnd.getHour() - itemTimeStampLocalDateTimeDuration.getHour(),
						itemTimeStampLocalDateTimeEnd.getMinute() - itemTimeStampLocalDateTimeDuration.getMinute(),
						itemTimeStampLocalDateTimeEnd.getSecond() - itemTimeStampLocalDateTimeDuration.getSecond(),
						itemTimeStampLocalDateTimeEnd.getNano() - itemTimeStampLocalDateTimeDuration.getNano()
				);

				newItem.itemDateTimeStartInSeconds = Basic.BasicFunctions.durationOfLocalDateTimeToSecond(
						tmpLDTStart,
						itemTimeStampLocalDateTimeEnd
				);

				return newItem;
			}

			// S -D-> ?
			public TodoList.Item createScheduleSD_(
					String itemName,
					LocalDateTime itemTimeStampLocalDateTimeStart,
					LocalDateTime itemTimeStampLocalDateTimeDuration,
					int level
			) {

				TodoList.Item newItem = new TodoList.Item();
				LocalDateTime tmpLDTEnd = LocalDateTime.of(
						itemTimeStampLocalDateTimeStart.getYear() + itemTimeStampLocalDateTimeDuration.getYear(),
						itemTimeStampLocalDateTimeStart.getMonthValue() +
						itemTimeStampLocalDateTimeDuration.getMonthValue(),
						itemTimeStampLocalDateTimeStart.getDayOfMonth() +
						itemTimeStampLocalDateTimeDuration.getDayOfMonth(),
						itemTimeStampLocalDateTimeStart.getHour() + itemTimeStampLocalDateTimeDuration.getHour(),
						itemTimeStampLocalDateTimeStart.getMinute() + itemTimeStampLocalDateTimeDuration.getMinute(),
						itemTimeStampLocalDateTimeStart.getSecond() + itemTimeStampLocalDateTimeDuration.getSecond(),
						itemTimeStampLocalDateTimeStart.getNano() + itemTimeStampLocalDateTimeDuration.getNano()
				);

				newItem.itemDateTimeStartInSeconds = Basic.BasicFunctions.durationOfLocalDateTimeToSecond(
						itemTimeStampLocalDateTimeStart,
						tmpLDTEnd
				);

				return newItem;
			}

			public void onCreate() {

				// Use @isAnomalous to judge whether onCreate(File, boolean) is anomalous -> true: false
				if ( !fm.onCreate( todoList.TARGET_FILE, false ) ) {
					// Where Exception happens
					basicOutput.log(
							Basic.BasicVariables.BASIC_OUTPUT_LOG_TYPE_ERROR,
							Applications.CLASS_NAME,
							new Basic.BasicException().getLocalizedMessage()
					);
				}
			}

			public static class Item {

				public static final String CLASS_NAME = "Item";
				public int level;
				public long id;
				public String itemName;
				public long itemDateTimeStartInSeconds;
				public long itemDateTimeEndInSeconds;
				TodoList.Item item = new TodoList.Item();
				TimeLine timeLine;

				public long getId() {

					return item.id;
				}

				public String getItemName() {

					return item.itemName;
				}

				public void setItemName( String newName ) {

					item.itemName = newName;
				}

				public long getItemDateTimeStartInSeconds() {

					return item.itemDateTimeStartInSeconds;
				}

				private void setItemDateTimeStartInSeconds( int newStartInSecond ) {

					item.itemDateTimeStartInSeconds = newStartInSecond;
				}

				public long getItemDateTimeEndInSeconds() {

					return item.itemDateTimeEndInSeconds;
				}

				private void setItemDateTimeEndInSeconds( int newEndInSecond ) {

					item.itemDateTimeEndInSeconds = newEndInSecond;
				}

				public void setLevel( int newLevel ) {

					item.level = newLevel;
				}

				public void onCreate(

				) {
					// Initialize variables
					// TODO: 16/07/2022 Hi, William. Come and fix this! 😀

				}

			}
		}
	}

	/**
	 * @author william
	 */

	public static class TimeLine {

		public static final String CLASS_NAME = "TimeLine";

		protected long startTimeStampInSeconds, endTimeStampInSeconds;
		protected long length;
		public String fileNameBase;
		private final String FILE_NAME_EXTENSION = Basic.BasicVariables.DOT + TimeLine.CLASS_NAME;
		private final File TARGET_FILE = new File(
				Basic.BasicVariables.STUDY_PATH_STRING,
				String.valueOf( Basic.BasicVariables.timeLineIdLoadUp )
		);

		static FileManager.FileCreator fc = new FileManager.FileCreator();
		static Basic.BasicOutput basicOutput = new Basic.BasicOutput();
		static TimeLine timeLine = new TimeLine();

		protected static void preparation(
				LocalDateTime startTimeStamp,
				LocalDateTime endTimeStamp
		) {

			try {
				timeLine.length = Basic.BasicFunctions.durationOfLocalDateTimeToSecond(
						startTimeStamp,
						endTimeStamp,
						ZoneOffset.ofHours( Basic.BasicVariables.TIME_ZONE_OFFSET_EAST_EIGHT )
				);
				timeLine.startTimeStampInSeconds = Basic.BasicFunctions.durationOfLocalDateTimeToSecond(
						Basic.BasicVariables.META_YEAR_LOCAL_DATE_TIME,
						startTimeStamp,
						ZoneOffset.ofHours( Basic.BasicVariables.TIME_ZONE_OFFSET_EAST_EIGHT )
				);
				timeLine.endTimeStampInSeconds = Basic.BasicFunctions.durationOfLocalDateTimeToSecond(
						Basic.BasicVariables.META_YEAR_LOCAL_DATE_TIME,
						endTimeStamp,
						ZoneOffset.ofHours( Basic.BasicVariables.TIME_ZONE_OFFSET_EAST_EIGHT )
				);

				// Create new file(s) for newTimeLine & Output procession result (Success or not)
				if ( fc.onCreate( timeLine.TARGET_FILE, false ) ) {
					basicOutput.log(
							Basic.BasicVariables.BASIC_OUTPUT_LOG_TYPE_INFO,
							FileManager.FileCreator.CLASS_NAME,
							Basic.BasicVariables.FILE_MANAGER_FILE_CREATING_SUCCESS
					);
				}

			} catch ( Exception e ) {

				basicOutput.log(
						Basic.BasicVariables.BASIC_OUTPUT_LOG_TYPE_ERROR,
						TimeLine.CLASS_NAME,
						e.getLocalizedMessage()
				);
			}

		}

		public static TimeLine onCreate(
				LocalDateTime startTimeStamp,
				LocalDateTime endTimeStamp,
				long length
		) {

			TimeLine newTimeLine = new TimeLine();

			TimeLine.preparation(
					startTimeStamp,
					endTimeStamp
			);

			// Everything's fine, let's go!

			timeLine.fileNameBase = String.valueOf( Basic.BasicVariables.timeLineIdLoadUp );

			newTimeLine.length = length;
			newTimeLine.startTimeStampInSeconds = Basic.BasicFunctions.durationOfLocalDateTimeToSecond(
					Basic.BasicVariables.META_YEAR_LOCAL_DATE_TIME,
					startTimeStamp
			);
			newTimeLine.endTimeStampInSeconds = Basic.BasicFunctions.durationOfLocalDateTimeToSecond(
					Basic.BasicVariables.META_YEAR_LOCAL_DATE_TIME,
					endTimeStamp
			);

			return newTimeLine;
		}
	}

	/** @author william */

	public static class IdIllegalStateException extends Exception{

		static final long serialVersionUID = 1L;

		/**
		 * Constructs a new exception with {@code null} as its detail message.
		 * The cause is not initialized, and may subsequently be initialized by a
		 * call to {@link #initCause}.
		 */
		public IdIllegalStateException() {
			super();
		}

		/**
		 * Constructs a new exception with the specified detail message.  The
		 * cause is not initialized, and may subsequently be initialized by
		 * a call to {@link #initCause}.
		 *
		 * @param   message   the detail message. The detail message is saved for
		 *          later retrieval by the {@link #getMessage()} method.
		 */
		public IdIllegalStateException(String message) {
			super(message);
		}

		/**
		 * Constructs a new exception with the specified detail message and
		 * cause.  <p>Note that the detail message associated with
		 * {@code cause} is <i>not</i> automatically incorporated in
		 * this exception's detail message.
		 *
		 * @param  message the detail message (which is saved for later retrieval
		 *         by the {@link #getMessage()} method).
		 * @param  cause the cause (which is saved for later retrieval by the
		 *         {@link #getCause()} method).  (A {@code null} value is
		 *         permitted, and indicates that the cause is nonexistent or
		 *         unknown.)
		 * @since  1.4
		 */
		public IdIllegalStateException(String message, Throwable cause) {
			super(message, cause);
		}

		/**
		 * Constructs a new exception with the specified cause and a detail
		 * message of {@code (cause==null ? null : cause.toString())} (which
		 * typically contains the class and detail message of {@code cause}).
		 * This constructor is useful for exceptions that are little more than
		 * wrappers for other throwable_s (for example, {@link
		 * java.security.PrivilegedActionException}).
		 *
		 * @param  cause the cause (which is saved for later retrieval by the
		 *         {@link #getCause()} method).  (A {@code null} value is
		 *         permitted, and indicates that the cause is nonexistent or
		 *         unknown.)
		 * @since  1.4
		 */
		public IdIllegalStateException(Throwable cause) {
			super(cause);
		}

		/**
		 * Constructs a new exception with the specified detail message,
		 * cause, suppression enabled or disabled, and writable stack
		 * trace enabled or disabled.
		 *
		 * @param  message the detail message.
		 * @param cause the cause.  (A {@code null} value is permitted,
		 * and indicates that the cause is nonexistent or unknown.)
		 * @param enableSuppression whether suppression is enabled
		 *                          or disabled
		 * @param writableStackTrace whether the stack trace should
		 *                           be writable
		 * @since 1.7
		 */
		protected IdIllegalStateException(String message, Throwable cause,
										  boolean enableSuppression,
										  boolean writableStackTrace) {
			super(message, cause, enableSuppression, writableStackTrace);
		}
	}

	/** @author william */

	public static class IdNotFoundException
			extends Exception {

		static final long serialVersionUID = 1L;

		/**
		 * Constructs a new exception with {@code null} as its detail message.
		 * The cause is not initialized, and may subsequently be initialized by a
		 * call to {@link #initCause}.
		 */
		public IdNotFoundException() {

			super();
		}

		/**
		 * Constructs a new exception with the specified detail message.  The
		 * cause is not initialized, and may subsequently be initialized by
		 * a call to {@link #initCause}.
		 *
		 * @param message the detail message. The detail message is saved for
		 *                later retrieval by the {@link #getMessage()} method.
		 */
		public IdNotFoundException( String message ) {

			super( message );
		}

		/**
		 * Constructs a new exception with the specified detail message and
		 * cause.  <p>Note that the detail message associated with
		 * {@code cause} is <i>not</i> automatically incorporated in
		 * this exception's detail message.
		 *
		 * @param message the detail message (which is saved for later retrieval
		 *                by the {@link #getMessage()} method).
		 * @param cause   the cause (which is saved for later retrieval by the
		 *                {@link #getCause()} method).  (A {@code null} value is
		 *                permitted, and indicates that the cause is nonexistent or
		 *                unknown.)
		 * @since 1.4
		 */
		public IdNotFoundException(
				String message,
				Throwable cause
		) {

			super(
					message,
					cause
			);
		}

		/**
		 * Constructs a new exception with the specified cause and a detail
		 * message of {@code (cause==null ? null : cause.toString())} (which
		 * typically contains the class and detail message of {@code cause}).
		 * This constructor is useful for exceptions that are little more than
		 * wrappers for other throwable_s (for example, {@link
		 * java.security.PrivilegedActionException}).
		 *
		 * @param cause the cause (which is saved for later retrieval by the
		 *              {@link #getCause()} method).  (A {@code null} value is
		 *              permitted, and indicates that the cause is nonexistent or
		 *              unknown.)
		 * @since 1.4
		 */
		public IdNotFoundException( Throwable cause ) {

			super( cause );
		}

		/**
		 * Constructs a new exception with the specified detail message,
		 * cause, suppression enabled or disabled, and writable stack
		 * trace enabled or disabled.
		 *
		 * @param message            the detail message.
		 * @param cause              the cause.  (A {@code null} value is permitted,
		 *                           and indicates that the cause is nonexistent or unknown.)
		 * @param enableSuppression  whether suppression is enabled
		 *                           or disabled
		 * @param writableStackTrace whether the stack trace should
		 *                           be writable
		 * @since 1.7
		 */
		protected IdNotFoundException(
				String message,
				Throwable cause,
				boolean enableSuppression,
				boolean writableStackTrace
		) {

			super(
					message,
					cause,
					enableSuppression,
					writableStackTrace
			);
		}
	}

	/** @author william */

	public static class IdNotMatchException
			extends Exception {

		public static final String CLASS_NAME = "IdNotMatchException";

		static Basic.BasicOutput basicOutput = new Basic.BasicOutput();

		static final long serialVersionUID = 1L;

		/**
		 * Constructs a new exception with {@code null} as its detail message.
		 * The cause is not initialized, and may subsequently be initialized by a
		 * call to {@link #initCause}.
		 */
		public IdNotMatchException() {

			super();
		}

		/**
		 * Constructs a new exception with the specified detail message.  The
		 * cause is not initialized, and may subsequently be initialized by
		 * a call to {@link #initCause}.
		 *
		 * @param message the detail message. The detail message is saved for
		 *                later retrieval by the {@link #getMessage()} method.
		 */
		public IdNotMatchException( String message ) {

			basicOutput.log(
					Basic.BasicVariables.BASIC_OUTPUT_LOG_TYPE_ERROR,
					IdNotMatchException.CLASS_NAME,
					message
			);
		}

		/**
		 * Constructs a new exception with the specified detail message and
		 * cause.  <p>Note that the detail message associated with
		 * {@code cause} is <i>not</i> automatically incorporated in
		 * this exception's detail message.
		 *
		 * @param message the detail message (which is saved for later retrieval
		 *                by the {@link #getMessage()} method).
		 * @param cause   the cause (which is saved for later retrieval by the
		 *                {@link #getCause()} method).  (A {@code null} value is
		 *                permitted, and indicates that the cause is nonexistent or
		 *                unknown.)
		 * @since 1.4
		 */
		public IdNotMatchException(
				String message,
				Throwable cause
		) {
			basicOutput.log(
					Basic.BasicVariables.BASIC_OUTPUT_LOG_TYPE_ERROR,
					cause,
					message
			);
		}

		/**
		 * Constructs a new exception with the specified cause and a detail
		 * message of {@code (cause==null ? null : cause.toString())} (which
		 * typically contains the class and detail message of {@code cause}).
		 * This constructor is useful for exceptions that are little more than
		 * wrappers for other throwable_s (for example, {@link
		 * java.security.PrivilegedActionException}).
		 *
		 * @param cause the cause (which is saved for later retrieval by the
		 *              {@link #getCause()} method).  (A {@code null} value is
		 *              permitted, and indicates that the cause is nonexistent or
		 *              unknown.)
		 * @since 1.4
		 */
		public IdNotMatchException( Throwable cause ) {

			basicOutput.log(
					Basic.BasicVariables.BASIC_OUTPUT_LOG_TYPE_ERROR,
					cause,
					null
			);
		}

		/**
		 * Constructs a new exception with the specified detail message,
		 * cause, suppression enabled or disabled, and writable stack
		 * trace enabled or disabled.
		 *
		 * @param message            the detail message.
		 * @param cause              the cause.  (A {@code null} value is permitted,
		 *                           and indicates that the cause is nonexistent or unknown.)
		 * @param enableSuppression  whether suppression is enabled
		 *                           or disabled
		 * @param writableStackTrace whether the stack trace should
		 *                           be writable
		 * @since 1.7
		 */
		protected IdNotMatchException(
				String message,
				Throwable cause,
				boolean enableSuppression,
				boolean writableStackTrace
		) {

			basicOutput.log(
					Basic.BasicVariables.BASIC_OUTPUT_LOG_TYPE_ERROR,
					cause,
					String.format("%b, %b", enableSuppression, writableStackTrace)
			);
		}
	}
}

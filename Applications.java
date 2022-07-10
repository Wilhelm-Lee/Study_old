/**
 * When ask for targetFile, please remember to use @targetFile.getAbsoluteFile() as the default combination for file accessing.
 * Suggest avoiding using targetType with isFile() instead.
 */
package com.michealwilliam;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * @author william
 * @version PROTOTYPE_0.6
 */

class Applications {

	public static final String CLASS_NAME = "Applications";

	public static FileManager fm = new FileManager();

	protected static class TodoList
			extends Applications {

		public static final String CLASS_NAME = "TodoList";

		// Due to Settings.HOME_PATH is not a constant variable, cannot use final here
		public static String TODOLIST_FILE = "/TodoList.study";
		public static File TARGET_FILE = new File(
				BasicVariables.studyPath,
				TODOLIST_FILE
		);
		public static boolean isAnomalous = false; // Need to reverse value when using.

		// S -?-> E
		public static Applications.TodoList.@NotNull Item createScheduleS_E(
				String itemName,
				LocalDateTime itemTimeStampLocalDateTimeStart,
				LocalDateTime itemTimeStampLocalDateTimeEnd,
				int level
		) {

			Applications.TodoList.Item newItem = new Item();

			newItem.id = BasicVariables.applicationsTodoListItemIdLoadUp + 1;
			newItem.itemName = itemName;
			newItem.itemDateTimeStartInSeconds = BasicFunctions.durationOfLocalDateTimeToSecond(
					itemTimeStampLocalDateTimeStart,
					itemTimeStampLocalDateTimeEnd,
					ZoneOffset.ofHours( BasicVariables.TIME_ZONE_OFFSET_EAST_EIGHT )
			);
			newItem.itemDateTimeEndInSeconds = BasicFunctions.durationOfLocalDateTimeToSecond(
					itemTimeStampLocalDateTimeStart,
					itemTimeStampLocalDateTimeEnd,
					ZoneOffset.ofHours( BasicVariables.TIME_ZONE_OFFSET_EAST_EIGHT )
			);
			newItem.level = level;
			//    /  |  E E E     A     Z Z Z   Y   Y
			// (:P)==|  EEE      AAA      Z       Y
			//    \  |  E E E   A   A   Z Z Z     Y

			return newItem;
		}

		// ? -D-> E
		public static Applications.TodoList.Item createSchedule_DE(
				String itemName,
				LocalDateTime itemTimeStampLocalDateTimeDuration,
				LocalDateTime itemTimeStampLocalDateTimeEnd,
				int level
		) {

			Applications.TodoList.Item newItem = new Item();
			LocalDateTime tmpLDTStart = LocalDateTime.of(
					itemTimeStampLocalDateTimeEnd.getYear() - itemTimeStampLocalDateTimeDuration.getYear(),
					itemTimeStampLocalDateTimeEnd.getMonthValue() - itemTimeStampLocalDateTimeDuration.getMonthValue(),
					itemTimeStampLocalDateTimeEnd.getDayOfMonth() - itemTimeStampLocalDateTimeDuration.getDayOfMonth(),
					itemTimeStampLocalDateTimeEnd.getHour() - itemTimeStampLocalDateTimeDuration.getHour(),
					itemTimeStampLocalDateTimeEnd.getMinute() - itemTimeStampLocalDateTimeDuration.getMinute(),
					itemTimeStampLocalDateTimeEnd.getSecond() - itemTimeStampLocalDateTimeDuration.getSecond(),
					itemTimeStampLocalDateTimeEnd.getNano() - itemTimeStampLocalDateTimeDuration.getNano()
			);

			newItem.itemDateTimeStartInSeconds = BasicFunctions.durationOfLocalDateTimeToSecond(
					tmpLDTStart,
					itemTimeStampLocalDateTimeEnd
			);

			return newItem;
		}

		// S -D-> ?
		public static Item createScheduleSD_(
				String itemName,
				LocalDateTime itemTimeStampLocalDateTimeStart,
				LocalDateTime itemTimeStampLocalDateTimeDuration,
				int level
		) {

			Item newItem = new Item();
			LocalDateTime tmpLDTEnd = LocalDateTime.of(
					itemTimeStampLocalDateTimeStart.getYear() + itemTimeStampLocalDateTimeDuration.getYear(),
					itemTimeStampLocalDateTimeStart.getMonthValue() + itemTimeStampLocalDateTimeDuration.getMonthValue(),
					itemTimeStampLocalDateTimeStart.getDayOfMonth() + itemTimeStampLocalDateTimeDuration.getDayOfMonth(),
					itemTimeStampLocalDateTimeStart.getHour() + itemTimeStampLocalDateTimeDuration.getHour(),
					itemTimeStampLocalDateTimeStart.getMinute() + itemTimeStampLocalDateTimeDuration.getMinute(),
					itemTimeStampLocalDateTimeStart.getSecond() + itemTimeStampLocalDateTimeDuration.getSecond(),
					itemTimeStampLocalDateTimeStart.getNano() + itemTimeStampLocalDateTimeDuration.getNano()
			);

			newItem.itemDateTimeStartInSeconds = BasicFunctions.durationOfLocalDateTimeToSecond(
					itemTimeStampLocalDateTimeStart,
					tmpLDTEnd
			);

			return newItem;
		}

		public void onCreate() {

			// Use @isAnomalous to judge whether onCreate(File) is anomalous -> true: true
			if ( fm.preparation( Applications.TodoList.TARGET_FILE ) ) {
				// fm.preparation(File) returns isAnomalous as reverted value of TRUE/FALSE
				// Where Exception happens
				BasicOutput.log(
						BasicVariables.BASIC_OUTPUT_LOG_TYPE_ERROR,
						Applications.CLASS_NAME,
						new BasicIllegalStateException().getLocalizedMessage()
				);
			}
		}

		public static class Item {

			public static final String CLASS_NAME = "Item";
			static Applications.TodoList.Item item = new Item();

			AbstractTimeLine.TimeLine timeLine;
			public int level;
			public long id;
			public String itemName;
			public long itemDateTimeStartInSeconds;
			public long itemDateTimeEndInSeconds;

			public static long getId() {

				return item.id;
			}
			public static String getItemName() {

				return item.itemName;
			}
			public static void setItemName( String newName ) {

				item.itemName = newName;
			}
			public static long getItemDateTimeStartInSeconds() {

				return item.itemDateTimeStartInSeconds;
			}
			private static void setItemDateTimeStartInSeconds( int newStartInSecond ) {

				item.itemDateTimeStartInSeconds = newStartInSecond;
			}
			public static long getItemDateTimeEndInSeconds() {

				return item.itemDateTimeEndInSeconds;
			}
			private static void setItemDateTimeEndInSeconds( int newEndInSecond ) {

				item.itemDateTimeEndInSeconds = newEndInSecond;
			}
			public static void setLevel( int newLevel ) {

				item.level = newLevel;
			}
			public static void onCreate(
					// Initialize

			) {

			}

		}
	}
}

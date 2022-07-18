/**
 * When ask for targetFile, please remember to use @targetFile.getAbsoluteFile() as the default combination for file accessing.
 * Suggest avoiding using targetType with isFile() instead.
 */
package com.study;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * @author william
 * @version PROTOTYPE_0.6
 */

public class Applications {


	public static final String CLASS_NAME = "Applications";

	static BasicOutput basicOutput = new BasicOutput();
	static FileManager.FileCreator fm = new FileManager.FileCreator();

	public static class TodoList
			extends Applications {

		public static final String CLASS_NAME = "TodoList";
		static Applications.TodoList todoList = new TodoList();
		/** Due to Settings.HOME_PATH is not a constant variable, cannot use final here */
		public String TODOLIST_FILE = "/TodoList.study";
		public final File TARGET_FILE = new File(
				BasicVariables.STUDY_PATH_STRING,
				TODOLIST_FILE
		);

		// S -?-> E
		public Applications.TodoList.@NotNull Item createScheduleS_E(
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
			//     /  =(o|_E_E_E_|___A___|_Z_Z_Z_|_Y___Y_|
			// (:P)[x] {]|_EEE___|__AAA__|___Z___|___Y___|
			//     \  =(o|_E_E_E_|_A___A_|_Z_Z_Z_|___Y___|
			//        "

			return newItem;
		}

		// ? -D-> E
		public Applications.TodoList.Item createSchedule_DE(
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
		public Item createScheduleSD_(
				String itemName,
				LocalDateTime itemTimeStampLocalDateTimeStart,
				LocalDateTime itemTimeStampLocalDateTimeDuration,
				int level
		) {

			Item newItem = new Item();
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

			newItem.itemDateTimeStartInSeconds = BasicFunctions.durationOfLocalDateTimeToSecond(
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
						BasicVariables.BASIC_OUTPUT_LOG_TYPE_ERROR,
						Applications.CLASS_NAME,
						new BasicIllegalStateException().getLocalizedMessage()
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
			Applications.TodoList.Item item = new Item();
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

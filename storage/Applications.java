package com.study.storage;

import com.study.output.BasicOutput;
import com.study.processors.BasicFunctions;
import com.study.processors.FileManager;
import com.study.runtime.BasicException;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * @author william
 */
public class Applications {

	public static final String CLASS_NAME = "Applications";

	private static final FileManager.FileCreator fc = new FileManager.FileCreator();

	public static class TodoList {

		public static final String CLASS_NAME = "TodoList";

		private static final TodoList todoList = new TodoList();
		/**
		 * Due to Settings.HOME_PATH is not a constant variable, cannot use final here
		 */
		public String TODOLIST_FILE = "/TodoList.study";
		public final File TARGET_FILE = new File(
				BasicVariables.STUDY_PATH_STRING,
				TODOLIST_FILE
		);

		// S -?-> E
		private TodoList.@NotNull Item createScheduleS_E(
				String itemName,
				LocalDateTime itemTimeStampLocalDateTimeStart,
				LocalDateTime itemTimeStampLocalDateTimeEnd,
				int level
		) {

			TodoList.Item newItem = new TodoList.Item();

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

//			TODO: TimeLine.onCreate(  )

			return newItem;
		}

		// ? -D-> E
		private TodoList.Item createSchedule_DE(
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

			newItem.itemDateTimeStartInSeconds = BasicFunctions.durationOfLocalDateTimeToSecond(
					tmpLDTStart,
					itemTimeStampLocalDateTimeEnd
			);

			return newItem;
		}

		// S -D-> ?
		private TodoList.Item createScheduleSD_(
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

			newItem.itemDateTimeStartInSeconds = BasicFunctions.durationOfLocalDateTimeToSecond(
					itemTimeStampLocalDateTimeStart,
					tmpLDTEnd
			);

			return newItem;
		}

		public void onCreate() {

			// Use @isAnomalous to judge whether onCreate(File, boolean) is anomalous -> true: false
			if ( ! fc.onCreate(
					todoList.TARGET_FILE,
					false
			) ) {
				// Where Exception happens
				BasicOutput.log(
						BasicVariables.BASIC_OUTPUT_LOG_TYPE_ERROR,
						Applications.CLASS_NAME,
						new BasicException().getLocalizedMessage()
				);
			}
		}

		public static class Item {

			public static final String CLASS_NAME = "Item";
			private final TodoList.Item item = new TodoList.Item();
			public int level;
			public long id;
			public String itemName;
			public long itemDateTimeStartInSeconds;
			public long itemDateTimeEndInSeconds;
			private final TimeLine timeLine = null;

			public void onCreate(

			) {
				// Initialize variables
				// TODO: 16/07/2022 Hi, William. Come and fix this! &#xD83D;&#xDE00;

			}

		}
	}
}
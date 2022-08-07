package com.study.storage;

import com.study.output.BasicOutput;
import com.study.processors.BasicFunctions;
import com.study.processors.FileManager;

import java.io.File;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * @author william
 */
public class TimeLine {

	public static final String CLASS_NAME = "TimeLine";
	private static final FileManager.FileCreator FILE_CREATOR = new FileManager.FileCreator();
	private static final TimeLine TIME_LINE = new TimeLine();
	private final String FILE_NAME_EXTENSION = BasicVariables.PERIOD + TimeLine.CLASS_NAME;
	private final File TARGET_FILE = new File(
			BasicVariables.STUDY_PATH_STRING,
			String.valueOf( BasicVariables.timeLineIdLoadUp )
	);
	public long startTimeStampInSeconds = 0L, endTimeStampInSeconds = 0L;
	public long length = 0L;
	public String fileNameBase = null;

	private static void preparation(
			LocalDateTime startTimeStamp,
			LocalDateTime endTimeStamp
	) {

		try {
			TIME_LINE.length = BasicFunctions.durationOfLocalDateTimeToSecond(
					startTimeStamp,
					endTimeStamp,
					ZoneOffset.ofHours( BasicVariables.TIME_ZONE_OFFSET_EAST_EIGHT )
			);
			TIME_LINE.startTimeStampInSeconds = BasicFunctions.durationOfLocalDateTimeToSecond(
					BasicVariables.META_YEAR_LOCAL_DATE_TIME,
					startTimeStamp,
					ZoneOffset.ofHours( BasicVariables.TIME_ZONE_OFFSET_EAST_EIGHT )
			);
			TIME_LINE.endTimeStampInSeconds = BasicFunctions.durationOfLocalDateTimeToSecond(
					BasicVariables.META_YEAR_LOCAL_DATE_TIME,
					endTimeStamp,
					ZoneOffset.ofHours( BasicVariables.TIME_ZONE_OFFSET_EAST_EIGHT )
			);

			// Create new file(s) for newTimeLine & Output procession result (Success or not)
			if ( FILE_CREATOR.onCreate(
					TIME_LINE.TARGET_FILE,
					false
			) ) {
				BasicOutput.log(
						BasicVariables.BASIC_OUTPUT_LOG_TYPE_INFO,
						FileManager.FileCreator.CLASS_NAME,
						BasicVariables.FILE_MANAGER_FILE_CREATING_SUCCESS
				);
			}

		} catch ( Exception e ) {

			BasicOutput.log(
					BasicVariables.BASIC_OUTPUT_LOG_TYPE_ERROR,
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

		/* Everything's fine, let's go!
		 *  Initialize @newTimeLine
		 */

		TIME_LINE.fileNameBase = String.valueOf( BasicVariables.timeLineIdLoadUp );

		newTimeLine.length = length;
		newTimeLine.startTimeStampInSeconds = BasicFunctions.durationOfLocalDateTimeToSecond(
				BasicVariables.META_YEAR_LOCAL_DATE_TIME,
				startTimeStamp
		);
		newTimeLine.endTimeStampInSeconds = BasicFunctions.durationOfLocalDateTimeToSecond(
				BasicVariables.META_YEAR_LOCAL_DATE_TIME,
				endTimeStamp
		);

		return newTimeLine;
	}
}

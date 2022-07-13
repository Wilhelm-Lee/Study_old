package com.michealwilliam;

import java.io.File;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * @author william
 */

public class TimeLine {

	public static final String CLASS_NAME = "TimeLine";

	protected long startTimeStampInSeconds, endTimeStampInSeconds;
	protected long length;

	static FileManager fm = new FileManager();
	/** Due to Settings.HOME_PATH is not a constant variable, cannot use final here */
	private final String TIMELINE_FILE = BasicVariables.SLASH + BasicVariables.timeLineIdLoadUp + TimeLine.CLASS_NAME;
	private File TARGET_FILE = new File(
			BasicVariables.studyPath,
			TIMELINE_FILE
	);

	static BasicOutput basicOutput = new BasicOutput();
	static TimeLine timeLine = new TimeLine();

	protected static void preparation(
			LocalDateTime startTimeStamp,
			LocalDateTime endTimeStamp
	) {

		try {
			timeLine.length = BasicFunctions.durationOfLocalDateTimeToSecond(
					startTimeStamp,
					endTimeStamp,
					ZoneOffset.ofHours( BasicVariables.TIME_ZONE_OFFSET_EAST_EIGHT )
			);
			timeLine.startTimeStampInSeconds = BasicFunctions.durationOfLocalDateTimeToSecond(
					BasicVariables.META_YEAR_LOCAL_DATE_TIME,
					startTimeStamp,
					ZoneOffset.ofHours( BasicVariables.TIME_ZONE_OFFSET_EAST_EIGHT )
			);
			timeLine.endTimeStampInSeconds = BasicFunctions.durationOfLocalDateTimeToSecond(
					BasicVariables.META_YEAR_LOCAL_DATE_TIME,
					endTimeStamp,
					ZoneOffset.ofHours( BasicVariables.TIME_ZONE_OFFSET_EAST_EIGHT )
			);

		} catch ( Exception e ) {

			basicOutput.log(
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

		// Everything's fine, let's go!



		return newTimeLine;
	}
}
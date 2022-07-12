package com.michealwilliam;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

/** @author william */

public class AbstractTimeLine {

	static AbstractTimeLine abstractTimeLine = new AbstractTimeLine();
	static BasicOutput basicOutput = new BasicOutput();

	public static final String CLASS_NAME = "AbstractTimeLine";

	protected long startTimeStampInSeconds, endTimeStampInSeconds;
	protected long length;

	public void preparation(
			LocalDateTime startTimeStamp,
			LocalDateTime endTimeStamp
	) {

		try {
			abstractTimeLine.length = BasicFunctions.durationOfLocalDateTimeToSecond(
					startTimeStamp,
					endTimeStamp,
					ZoneOffset.ofHours( BasicVariables.TIME_ZONE_OFFSET_EAST_EIGHT )
			);
			abstractTimeLine.startTimeStampInSeconds = BasicFunctions.durationOfLocalDateTimeToSecond(
					BasicVariables.META_YEAR_LOCAL_DATE_TIME,
					startTimeStamp,
					ZoneOffset.ofHours( BasicVariables.TIME_ZONE_OFFSET_EAST_EIGHT )
			);
			abstractTimeLine.endTimeStampInSeconds = BasicFunctions.durationOfLocalDateTimeToSecond(
					BasicVariables.META_YEAR_LOCAL_DATE_TIME,
					endTimeStamp,
					ZoneOffset.ofHours( BasicVariables.TIME_ZONE_OFFSET_EAST_EIGHT )
			);

		} catch ( Exception e ) {

			basicOutput.log(
					BasicVariables.BASIC_OUTPUT_LOG_TYPE_ERROR,
					AbstractTimeLine.CLASS_NAME,
					e.getLocalizedMessage()
			);
		}

	}

	public static void onCreate(
			LocalDateTime startTimeStamp,
			LocalDateTime endTimeStamp
	) {

		abstractTimeLine.preparation(
				startTimeStamp,
				endTimeStamp
		);

	}

	public static class TimeLine {

		LocalDateTime startTimeStamp, endTimeStamp;

		public static AbstractTimeLine.TimeLine timeLine(
				LocalDateTime startTimeStamp,
				LocalDateTime endTimeStamp)
		{

			Applications.TodoList.Item item = new Applications.TodoList.Item();

			// TODO: Finish here please, William!



			return ;
		}

	}
}


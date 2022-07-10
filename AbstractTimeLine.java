package com.michealwilliam;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class AbstractTimeLine {

	public static final String CLASS_NAME = "AbstractTimeLine";

	public static long startTimeStampInSeconds, endTimeStampInSeconds;
	public static long length;
	private static boolean isAnomalous = false;

	public static boolean preparation(
			LocalDateTime startTimeStamp,
			LocalDateTime endTimeStamp
	) {

		try {
			length = BasicFunctions.durationOfLocalDateTimeToSecond(
					startTimeStamp,
					endTimeStamp,
					ZoneOffset.ofHours( BasicVariables.TIME_ZONE_OFFSET_EAST_EIGHT )
			);
			startTimeStampInSeconds = BasicFunctions.durationOfLocalDateTimeToSecond(
					BasicVariables.META_YEAR_LOCAL_DATE_TIME,
					startTimeStamp,
					ZoneOffset.ofHours( BasicVariables.TIME_ZONE_OFFSET_EAST_EIGHT )
			);
			endTimeStampInSeconds = BasicFunctions.durationOfLocalDateTimeToSecond(
					BasicVariables.META_YEAR_LOCAL_DATE_TIME,
					endTimeStamp,
					ZoneOffset.ofHours( BasicVariables.TIME_ZONE_OFFSET_EAST_EIGHT )
			);

		} catch ( Exception e ) {

			/*
				In case there were any sort of issue happened... (Triple periods for stronger-stronger pausing (Troll Face))
				About LocalDateTime mostly.
			 */

			BasicOutput.log(
					BasicVariables.BASIC_OUTPUT_LOG_TYPE_ERROR,
					AbstractTimeLine.CLASS_NAME,
					e.getLocalizedMessage()
			);
			return AbstractTimeLine.isAnomalous = true;
		}

		return AbstractTimeLine.isAnomalous = false;
	}

	public static boolean onCreate(
			LocalDateTime startTimeStamp,
			LocalDateTime endTimeStamp
	) {

		if ( !preparation(
				startTimeStamp,
				endTimeStamp
		) ) {

			AbstractTimeLine.isAnomalous = true;

			try {
				throw new IllegalStateException();
			} catch ( IllegalStateException iSE ) {
				BasicOutput.log(
						BasicVariables.BASIC_OUTPUT_LOG_TYPE_ERROR,
						AbstractTimeLine.CLASS_NAME,
						iSE.getLocalizedMessage()
				);
			}

		} else {

			// TODO: Ready

		}
		return true;
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

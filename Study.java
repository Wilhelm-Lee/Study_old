package com.michealwilliam;

public interface Study {

	/**
	 *	This is the basic model of all the classes who need
	 *	boolean onCreate(...) & isAnomalous <boolean>, and
	 *	especially the latter one for entrance of that class.
	 */

	boolean isAnomalous = false;

	default boolean onCreate() {
		return isAnomalous;
	}
}

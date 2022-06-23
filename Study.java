package com.michealwilliam;

import java.io.File;

public interface Study {

	/**
	 *	This is the basic model of all the classes who need
	 *	boolean onCreate(...) & fm.isAnomalous <boolean>, and
	 *	especially the latter one for entrance of that class.
	 */

	FileManager fm = new FileManager();

	default boolean preparation(File targetFile) {
		try {
			if (!fm.checkExistence(new File(targetFile.getParent()), "path")) {
				fm.isAnomalous = true;
				BasicOutput.log(BasicOutput.WARN, "TodoList", "Target path does not seem to be existed");
				fm.creating(new File(targetFile.getParent()), "path", false);
				// Retry
				preparation(targetFile.getAbsoluteFile()); // Actually, it does not need to getAbsoluteFile(), just original targetFile
			} else {
				fm.isAnomalous = false;
				BasicOutput.log(BasicOutput.INFO, "TodoList", "Target path " + new File(targetFile.getParent()).getAbsoluteFile() + " exists");
				// Judge whether the targetFile exists or not
				if (!fm.checkExistence(targetFile.getAbsoluteFile(), "File")) {
					fm.isAnomalous = true;
					BasicOutput.log(BasicOutput.WARN, "TodoList", "Target file does not seem to be existed");
					fm.creating(targetFile.getAbsoluteFile(), "File", false);
					// Retry
					preparation(targetFile.getAbsoluteFile());
				} else {
					// targetFile exists
					fm.isAnomalous = false;
					BasicOutput.log(BasicOutput.INFO, "TodoList", "Target file " + targetFile.getAbsoluteFile() + " exists");
				}
			}
		} catch (Exception e) {

			/*
			  This case should not happen, because once
			  there were a File or Path does not exist,
			  preparation() would solve it by trying
			  recursively.
		  	*/

			BasicOutput.log(BasicOutput.ERROR, "TodoList: " + targetFile.getAbsolutePath(),"\n\t" + e);
			return fm.isAnomalous = true;
		}
		return fm.isAnomalous;
	}
	default boolean onCreate() {
//		return fm.isAnomalous;
		return false;
	}
}

/**
 * When ask for targetFile, please remember to use @targetFile.getAbsoluteFile() as the default combination for file accessing.
 * Suggest avoiding using targetType with isFile() instead.
 */
package com.michealwilliam;

import java.io.File;
import java.util.ArrayList;

import static com.michealwilliam.BasicOutput.errors;

/**
 * @author william
 * @version PROTOTYPE_0.5
 */

public class Functions {

	public static FileManager fm = new FileManager();
	public static final File targetPath = new File(fm.fileHomePath, "/Documents/StudyFiles");
	public static final File TODOLIST_FILE = new File(targetPath, "TodoList.study");
	public static final String TODOLIST_FILE_NAME = "TodoList";
	public static final String TODOLIST_FILE_TYPE = ".study";
	protected static final ArrayList<String> TOOLS = new ArrayList<>(0);

	protected static class TodoList extends Functions {

		public static final File targetFile = new File(targetPath, "/" + "TodoList.study");

		public boolean onCreate() {

			// Use @isAnomalous to judge whether onCreate(File) is anomalous
			if (fm.preparation(targetPath)) {
				errors("Functions.TodoList. boolean onCreate()", "Unsolvable problem met (kernel code problem), program is exiting");
				return fm.isAnomalous = true;
			}

			return !fm.isAnomalous;
		}
	}
}

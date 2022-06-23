/**
 * When ask for targetFile, please remember to use @targetFile.getAbsoluteFile() as the default combination for file accessing.
 * Suggest avoiding using targetType with isFile() instead.
 */
package com.michealwilliam;

import java.io.File;
import java.util.ArrayList;

import static com.michealwilliam.BasicOutput.ERROR;
import static com.michealwilliam.FileManager.HOME_PATH;

/**
 * @author william
 * @version PROTOTYPE_0.5
 */

public class Functions {

	public static FileManager fm = new FileManager();
	public static BasicFunctions basicFunctions = new BasicFunctions();

	protected static final ArrayList<String> TOOLS = new ArrayList<>(0);

	protected static class TodoList extends Functions {

		public static final String TODOLIST_PATH = HOME_PATH + "/Documents/StudyFiles";
		public static final String TODOLIST_FILE = "/TodoList.study";
		public static final File TARGET_FILE = new File(TODOLIST_PATH, TODOLIST_FILE);
		public boolean isAnomalous = false; // Need to reverse value when using.

		public boolean createSchedule(String itemName, String itemDateTimeStart, String itemDateTimeEnd, int urgencyLevel) {


			return !isAnomalous;
		}
		public boolean createSchedule(String itemName, String itemDateTimeStart, int itemDurationS, int urgencyLevel) {


			return !isAnomalous;
		}
		public boolean createSchedule(String itemName, int itemDurationS, String itemDateTimeEnd, int urgencyLevel) {


			return !isAnomalous;
		}
		public boolean onCreate() {

			// Use @isAnomalous to judge whether onCreate(File) is anomalous -> true: true
			if (fm.preparation(TARGET_FILE)) {
				// Where Exception happens
				BasicOutput.log(ERROR, "Functions.TodoList. boolean onCreate()", "Unsolvable problem met (kernel code problem), program is exiting");
				return fm.isAnomalous = true;
			}

			return !fm.isAnomalous;
		}

		public static class Item {

			public int level;
			public int id = 0;
			public String itemName;
			public int itemDateTimeStartS;
			public int itemDateTimeEndS;
			public int itemDurationS;

			// Getters & Setters
				// Getters
				public int getId() {
					return id;
				}
				public String getItemName() {
					return this.itemName;
				}
				public int getItemDateTimeStartS() {
					return this.itemDateTimeStartS;
				}
				public int getItemDateTimeEndS() {
					return this.itemDateTimeEndS;
				}
				public int getItemDurationS() {
					return this.itemDurationS;
				}

				// Setters
				private void setLevel( int newLevel ) {
					this.level = newLevel;
				}
				public void setItemName( String newName ) {
					this.itemName = newName;
				}
				public void setItemDateTimeStartS( int newStartInSecond ) {
					this.itemDateTimeStartS = newStartInSecond;
				}
				public void setItemDateTimeEndS( int newEndInSecond ) {
					this.itemDateTimeEndS = newEndInSecond;
				}
				public void getItemDurationS( int newDurationInSecond ) {
					this.itemDurationS = newDurationInSecond;
				}
		}
	}
}

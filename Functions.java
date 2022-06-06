/**
 * When ask for targetFile, please remember to use @targetFile.getAbsoluteFile() as the default combination for file accessing.
 * Suggest avoiding using targetType with isFile() instead.
 */
package com.michealwilliam;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author william
 * @version PROTOTYPE_0.5
 */
public class Functions {

	FileManager fm = new FileManager();
	protected static final ArrayList<String> TOOLS = new ArrayList<>(0);

	protected static class TodoList extends Functions {

		public static final String TARGET_FILE_NAME = "TodoList";
		public static final String TARGET_FILE_TYPE = ".study";
		public final File targetPath = new File(fm.fileHomePath, "/Documents/StudyFiles");
		public final File targetFile = new File(targetPath, "/" + TARGET_FILE_NAME + TARGET_FILE_TYPE);

		public boolean onCreate() throws IOException {

			// Use @isAnomalous to judge whether onCreate(File) is anomalous
			if (!fm.preparation(targetPath)) {
				fm.errors("preparation(File) was not prepared properly");
				fm.isAnomalous = true;
				return false;
			}
			// The targetPath & targetFile has been ensured
			// Load AbsolutePath & CanonicalPath

//			fileReader = new FileReader(this.targetFile.getAbsoluteFile());
//			targetFileContent.add((char) fileReader.read());
			// Must use FileWriter before using FileReader, otherwise the targetFile would get content erased.
			// Therefor, just COPY the targetFile as cloneFile and mortify it via fileWriter.
//			creating(targetFileCopy, "File", false);

//			fileReader.close();

			return fm.isAnomalous;
		}
	}
}
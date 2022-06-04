/**
 * When ask for targetFile, please remember to use @targetFile.getAbsoluteFile() as the default combination for file accessing.
 * Suggest avoiding using targetType with isFile() instead.
 */
package com.michealwilliam;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author william
 */
public class Functions {

	protected final Scanner scn = new Scanner(System.in);
	protected final File fileHomePath = new File("/home/william");
	protected String systemType = System.getProperty("os.name");
	protected Runtime runtime;
	protected Process process;
	protected final String[] cmd = new String[1];
	protected static final ArrayList<String> TOOLS = new ArrayList<>(0);
	protected static boolean ifFirstRun = true;

	protected static class TodoList extends Functions {

		private static final String TARGET_FILE_NAME = "TodoList";
		private static final String TARGET_FILE_TYPE = ".study";
		private final File targetPath = new File(fileHomePath, "/Documents/StudyFiles");
		private final File targetFile = new File(targetPath, "/" + TARGET_FILE_NAME + TARGET_FILE_TYPE);
		private FileReader fileReader;
		private FileWriter fileWriter;
		private final ArrayList<Character> targetFileContent = new ArrayList<>(0);
		private boolean isAnomalous = false;
//		private final File targetFileCopy = new File(targetFile.getParent() + "/" + TARGET_FILE_NAME + "Copy" + TARGET_FILE_TYPE);

		private boolean ifAsk(@NotNull File targetObject, String action) {
			request(targetObject.isFile()
					? "How would you like to " + action + " " + targetObject.getAbsoluteFile() + " ? y/n"
					: "How would you like to " + action + " " + targetObject + " ? y/n");

			return "y".equalsIgnoreCase(scn.next());
		}
		private void creating(@NotNull File targetObject, @NotNull String targetType, boolean ifAskNeeded) throws IOException {
			String action = "Creating";
			this.cmd[1] = "File".equalsIgnoreCase(targetType)
					? "touch " + targetObject.getAbsoluteFile()
					: "mkdir " + targetObject;

			// if not exists
			if (!targetObject.exists()) {
				// Ask
				if (ifAskNeeded) {
					if (ifAsk(targetObject, action)) {
						runtime = Runtime.getRuntime();
						process = runtime.exec(this.cmd);
					} else {
						requestDenied(targetObject, targetType);
					}
				} else {
					runtime = Runtime.getRuntime();
					process = runtime.exec(this.cmd);
				}
			} else {
				information(targetType.toUpperCase() + targetObject.getAbsoluteFile() + " has already existed");
			}
		}
		private void coping(@NotNull File targetObject, @NotNull File destination, @NotNull String destinationType,
							boolean ifAskNeeded) throws IOException {
			String action = "Coping";

			if( ifAskNeeded ){
				// Existence of @destination
				if(checkExistence(destination, destinationType)) {
					warnings(action, "Destined File is already existed, " + action + "will OVERWRITE it");
					if( !ifAsk(destination, action) ) {
						requestDenied(destination, destinationType);
						information(action, "Canceled");
					} else {
						this.cmd[0] = "cp " + targetObject.getAbsoluteFile() + " " + destination.getAbsoluteFile();
						runtime = Runtime.getRuntime();
						process = runtime.exec(cmd);
					}
				}

			} else {
				// Existence of @destination
				if(checkExistence(destination, destinationType)) {
					warnings(action + ": Destined File is already existed, " + action + "will OVERWRITE it");
					this.cmd[0] = "cp " + targetObject.getAbsoluteFile() + " " + destination.getAbsoluteFile();
					runtime = Runtime.getRuntime();
					process = runtime.exec(cmd);
				}
			}

		}
		private void requestDenied(@NotNull File targetObject, String targetType) {
			warnings(targetType + " " + targetObject + " failed, caused & canceled by user");
		}
		private boolean checkExistence(@NotNull File targetObject, @NotNull String targetType) {
			return "File".equalsIgnoreCase(targetType)
					? targetObject.getAbsoluteFile().exists()
					: targetObject.exists();
		}
		private void request(String content) {
			System.out.println("Request: " + content);
		}
		private void information(String content) {
			System.out.println("Info: " + content);
		}
		private void warnings(String content) {
			System.out.println("Warning: " + content);
		}
		private void errors(String content) {
			System.out.println("Error: " + content);
		}
		private void request(String initiator, String content) {
			System.out.println("Request(" + initiator + "): " + content);
		}
		private void information(String initiator, String content) {
			System.out.println("Info(" + initiator + "): " + content);
		}
		private void warnings(String initiator, String content) {
			System.out.println("Warning(" + initiator + "): " + content);
		}
		private void errors(String initiator, String content) {
			System.out.println("Error(" + initiator + "): " + content);
		}
		private boolean preparation(File targetFile) throws IOException {
			try {
				if (!checkExistence(targetPath, "path")) {
					isAnomalous = true;
					warnings("Target path does not seem to be existed");
					creating(targetPath, "path", false);
					// Retry
					preparation(targetFile.getAbsoluteFile());
				} else {
					isAnomalous = false;
					information("Target path " + this.targetPath.getAbsoluteFile() + " exists");
					// Judge whether the targetFile exists or not
					if (!checkExistence(this.targetFile.getAbsoluteFile(), "file")) {
						isAnomalous = true;
						warnings("Target file does not seem to be existed");
						creating(this.targetFile.getAbsoluteFile(), "file", false);
						// Retry
						preparation(targetPath);
					} else {
						// targetFile exists
						isAnomalous = false;
						information("Target file " + this.targetFile.getAbsoluteFile() + " exists");
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return !isAnomalous;
		}
		public boolean onCreate() throws IOException {

			// Use @isAnomalous to judge whether onCreate(File) is anomalous
			if (!preparation(targetPath)) {
				errors("preparation(File) was not prepared properly");
				isAnomalous = true;
				return false;
			}
			// The targetPath & targetFile has been ensured
			// Load AbsolutePath & CanonicalPath

			fileReader = new FileReader(this.targetFile.getAbsoluteFile());
			targetFileContent.add((char) fileReader.read());
			// Must use FileWriter before using FileReader, otherwise the targetFile would get content erased.
			// Therefor, just COPY the targetFile as cloneFile and mortify it via fileWriter.
//			creating(targetFileCopy, "file", false);

			fileReader.close();

			return isAnomalous;
		}
	}
}
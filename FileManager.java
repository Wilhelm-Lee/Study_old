package com.michealwilliam;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import static com.michealwilliam.BasicOutput.*;

public class FileManager {

	/**
	 * @author william
	 * @param isAnomalous

	 */

	public Scanner scn = new Scanner(System.in);
	public final File fileHomePath = new File("/home/william");
	public final String[] cmd = new String[1];
	public Runtime runtime;
	public Process process;

	//	Functions.TodoList todoList = new Functions.TodoList();
	//	final ArrayList<Character> targetFileContent = new ArrayList<>(0);
	public boolean isAnomalous = false;

	public boolean ifAsk(@NotNull File targetObject, String action) {
		request(targetObject.isFile()
				? "How would you like to " + action + " " + targetObject.getAbsoluteFile() + " ? y/n"
				: "How would you like to " + action + " " + targetObject + " ? y/n");

		return "y".equalsIgnoreCase(scn.next());
	}
	public void creating(@NotNull File targetObject, @NotNull String targetType, boolean ifAskNeeded) throws IOException {

		String action = "Creating";

		this.cmd[0] = "File".equalsIgnoreCase(targetType) ?
				  "touch " + targetObject
				: "mkdir -p " + targetObject;

		// if not exists
		if ( !targetObject.exists() ) {
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
	public void coping(@NotNull File targetObject, @NotNull File destination, @NotNull String destinationType, boolean ifAskNeeded) throws IOException {

		String action = "Coping";

		if( checkExistence(destination, "File") ) {
			warnings(action, "Destined File is already existed, " + action + "will OVERWRITE it");
			if( ifAskNeeded ) {
				if( !ifAsk(destination, action) ) {
					requestDenied(destination, destinationType);
					information(action, "Canceled");
					return;
				}
			}
		}
		this.cmd[0] = "cp " + targetObject.getAbsoluteFile() + " " + destination.getAbsoluteFile();
		runtime = Runtime.getRuntime();
		process = runtime.exec(cmd);

	}
	public void requestDenied(@NotNull File targetObject, String targetType) {
		warnings(targetType + " " + targetObject + " failed, caused & canceled by user");
	}
	public boolean checkExistence(@NotNull File targetObject, @NotNull String targetType) {
		return "File".equalsIgnoreCase(targetType)
				? targetObject.getAbsoluteFile().exists()
				: targetObject.exists();
	}
	public boolean preparation(File targetFile) {
		try {
			if (!checkExistence(Functions.TodoList.targetPath, "path")) {
				isAnomalous = true;
				warnings("TodoList", "Target path does not seem to be existed");
				creating(Functions.targetPath, "path", false); // Static field of @Function, using direct access
				// Retry
				preparation(targetFile.getAbsoluteFile());
			} else {
				isAnomalous = false;
				information("TodoList", "Target path " + Functions.TodoList.targetPath.getAbsoluteFile() + " exists");
				// Judge whether the targetFile exists or not
				if (!checkExistence(Functions.TodoList.targetFile.getAbsoluteFile(), "File")) {
					isAnomalous = true;
					warnings("TodoList", "Target file does not seem to be existed");
					creating(Functions.TodoList.targetFile.getAbsoluteFile(), "File", false);
					// Retry
					preparation(Functions.TodoList.targetPath);
				} else {
					// targetFile exists
					isAnomalous = false;
					information("TodoList", "Target file " + Functions.TodoList.targetFile.getAbsoluteFile() + " exists");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isAnomalous;
	}
}

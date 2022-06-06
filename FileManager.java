package com.michealwilliam;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileManager {

	Scanner scn = new Scanner(System.in);
	Functions.TodoList todoList = new Functions.TodoList();
	public final File fileHomePath = new File("/home/william");
	public Runtime runtime;
	public Process process;
	public final String[] cmd = new String[1];
//	final ArrayList<Character> targetFileContent = new ArrayList<>(0);
	boolean isAnomalous = false;

	public boolean ifAsk(@NotNull File targetObject, String action) {
		request(targetObject.isFile()
				? "How would you like to " + action + " " + targetObject.getAbsoluteFile() + " ? y/n"
				: "How would you like to " + action + " " + targetObject + " ? y/n");

		return "y".equalsIgnoreCase(scn.next());
	}
	public void creating(@NotNull File targetObject, @NotNull String targetType, boolean ifAskNeeded) throws IOException {
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
	public void coping(@NotNull File targetObject, @NotNull File destination, @NotNull String destinationType, boolean ifAskNeeded) throws IOException {
		String action = "Coping";

		if( checkExistence(destination, "File") ) {
			warnings(action, "Destined File is already existed, " + action + "will OVERWRITE it");
			if( ifAskNeeded ){
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
	public void request(String content) {
		System.out.println("Request: " + content);
	}
	public void information(String content) {
		System.out.println("Info: " + content);
	}
	public void warnings(String content) {
		System.out.println("Warning: " + content);
	}
	public void errors(String content) {
		System.out.println("Error: " + content);
	}
	public void request(String initiator, String content) {
		System.out.println("Request(" + initiator + "): " + content);
	}
	public void information(String initiator, String content) {
		System.out.println("Info(" + initiator + "): " + content);
	}
	public void warnings(String initiator, String content) {
		System.out.println("Warning(" + initiator + "): " + content);
	}
	public void errors(String initiator, String content) {
		System.out.println("Error(" + initiator + "): " + content);
	}
	public boolean preparation(File targetFile) {
		try {
			if (!checkExistence(todoList.targetPath, "path")) {
				isAnomalous = true;
				warnings("Target path does not seem to be existed");
				creating(todoList.targetPath, "path", false);
				// Retry
				preparation(targetFile.getAbsoluteFile());
			} else {
				isAnomalous = false;
				information("Target path " + todoList.targetPath.getAbsoluteFile() + " exists");
				// Judge whether the targetFile exists or not
				if (!checkExistence(todoList.targetFile.getAbsoluteFile(), "File")) {
					isAnomalous = true;
					warnings("Target file does not seem to be existed");
					creating(this.todoList.targetFile.getAbsoluteFile(), "File", false);
					// Retry
					preparation(todoList.targetPath);
				} else {
					// targetFile exists
					isAnomalous = false;
					information("Target file " + todoList.targetFile.getAbsoluteFile() + " exists");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return !isAnomalous;
	}
}

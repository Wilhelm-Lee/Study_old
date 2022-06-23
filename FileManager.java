package com.michealwilliam;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author william
 */

public class FileManager {

	public static String userNameOfThisAccountInThisOS = "william";
	public static final String HOME_PATH = "/home/" + userNameOfThisAccountInThisOS;
	public Scanner scn = new Scanner(System.in);
	public List<String> cmd = new ArrayList<>(0);
	public Runtime runtime;
	public Process process;
	public boolean isAnomalous = false;

	public boolean ifAsk(@NotNull File targetObject, String action) {
		BasicOutput.log(BasicOutput.REQUEST,
				targetObject.isFile()
				? "How would you like to " + action + " " + targetObject.getAbsoluteFile() + " ? y/n"
				: "How would you like to " + action + " " + targetObject + " ? y/n");

		return "y".equalsIgnoreCase(scn.next());
	}
	public void creating(@NotNull File targetObject, @NotNull String targetType, boolean ifAskNeeded) throws IOException {

		String action = "Creating";

		this.cmd.clear();

		if ( "File".equalsIgnoreCase(targetType) ) {
			this.cmd.add("touch");
			this.cmd.add( targetObject.getAbsolutePath() );
		} else {
			this.cmd.add("mkdir");
			this.cmd.add("-p");
			this.cmd.add( targetObject.getAbsolutePath() );
		}

		// if not exists
		if ( !targetObject.exists() ) {
			// Ask
			if ( ifAskNeeded ) {
				if ( ifAsk(targetObject, action) ) {
					runtime = Runtime.getRuntime();
					process = runtime.exec( this.cmd.toArray(new String[cmd.size()]) );
				} else {
					requestDenied(targetObject, targetType);
				}
			} else {
				runtime = Runtime.getRuntime();
				process = runtime.exec( this.cmd.toArray(new String[cmd.size()]) );
			}
		} else {
			BasicOutput.log(BasicOutput.INFO, targetType.toUpperCase() + targetObject.getAbsoluteFile() + " has already existed");
		}

	}
	public void requestDenied(@NotNull File targetObject, String targetType) {
		BasicOutput.log(BasicOutput.WARN, targetType + " " + targetObject + " failed, caused & canceled by user");
	}
	public boolean checkExistence(@NotNull File targetObject, @NotNull String targetType) {
		return "File".equalsIgnoreCase(targetType)
				? targetObject.getAbsoluteFile().exists()
				: targetObject.exists();
	}
	public boolean preparation(File targetFile) {
		try {
			if (!checkExistence(new File(targetFile.getParent()), "path")) {
				isAnomalous = true;
				BasicOutput.log(BasicOutput.WARN, "TodoList", "Target path does not seem to be existed");
				creating(new File(targetFile.getParent()), "path", false);
				// Retry
				preparation(targetFile.getAbsoluteFile()); // Actually, it does not need to getAbsoluteFile(), just original targetFile
			} else {
				isAnomalous = false;
				BasicOutput.log(BasicOutput.INFO, "TodoList", "Target path " + new File(targetFile.getParent()).getAbsoluteFile() + " exists");
				// Judge whether the targetFile exists or not
				if (!checkExistence(targetFile.getAbsoluteFile(), "File")) {
					isAnomalous = true;
					BasicOutput.log(BasicOutput.WARN, "TodoList", "Target file does not seem to be existed");
					creating(targetFile.getAbsoluteFile(), "File", false);
					// Retry
					preparation(targetFile.getAbsoluteFile());
				} else {
					// targetFile exists
					isAnomalous = false;
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
			return isAnomalous = true;
		}
		return isAnomalous;
	}
}

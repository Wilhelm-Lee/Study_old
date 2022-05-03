/** TODO: Replace all "..." into information(String)/ warnings(String)/ errors(String) */
package com.MichealWilliam;

import org.jetbrains.annotations.NotNull;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Functions {

	public Scanner scn = new Scanner(System.in);
	public File fileHomePath = new File( "/home/william" );
	public File targetPath = new File(fileHomePath, "/Documents/StudyFiles" );
	public String systemType = System.getProperty( "os.name" );
	public File targetFile;
	public Runtime runtime;
	public Process process;

	public boolean ifAsk(@NotNull File targetObject, String action) {
		request("Would you like to " + action + " " + targetObject + " ? y/n" );
		return scn.next().equalsIgnoreCase( "y" );
	}
	public void creating(String targetType, @NotNull File targetObject) throws IOException {
		String action = "Creating";
		String cmd = targetType.equalsIgnoreCase( "File" ) ? "touch " + targetObject : "mkdir " + targetObject;
		// Ask
		if ( ifAsk(targetObject, action) ) {
			runtime = Runtime.getRuntime();
			process = runtime.exec(cmd);
		} else {
			requestDenied(targetObject, targetType);
		}
	}
	public void requestDenied(@NotNull File targetObject, String targetType) {
		warnings(targetType + " " + targetObject + " failed, caused & canceled by user" );
	}
	public boolean checkExistence(@NotNull File targetObject) {
		return targetObject.exists();
	}
	public void request(String content) {
		System.out.println( "Request: " + content);
	}
	public void information(String content) {
		System.out.println( "Info: " + content);
	}
	public void warnings(String content) {
		System.out.println( "Warning: " + content);
	}
	public void errors(String content) {
		System.out.println( "Error: " + content);
	}

	public static class TodoList extends Functions {

		public FileReader fileReader;
		public FileWriter fileWriter;
		public String targetFile_AbsolutePath;
		public String targetFile_CanonicalPath;
		public ArrayList<Character> targetFileContent;
		public static boolean isAnomalous = false;

		public boolean Preparation(File targetPath) throws IOException {

			// Check existence of the path
				// Not:
					// Create path
					// isAnomalous = true;
				// Load on path
				// isAnomalous = false;
			// Check existence of the file
				// Not:
					// Create file
					// isAnomalous = true;
				// Aim file
				// isAnomalous = false;

			// TODO: loadPath(File targetPath)

			if( !checkExistence(targetPath) ) {
				warnings("Your target path does not seem to be existed" );
				// Auto doing, no ask
				creating( "path", targetPath);
				isAnomalous = true;
				// Retry
				Preparation(targetPath);
			} else {
				information("Target path " + targetPath + " exists" );
				// Judge whether the targetFile exists or not
				if ( !checkExistence(targetFile) ) {
					warnings("Your target file does not seem to be existed" );
					// Auto doing, no ask
					creating( "file", targetFile);
					// Retry
					Preparation(targetPath);
				}
			}

			return true;
		}

		public boolean onCreate(File targetFile) throws IOException {

			targetFileContent = new ArrayList<>(0);
			super.targetFile = new File(super.targetPath, "/TODO.study" ); // TodoList

			// Special situation (theoretically impossible)
			if ( !Preparation(super.targetPath) ) {
				errors( "Preparation(File) was not prepared properly" );
				isAnomalous = true;
			}

			// Use @isAnomalous to judge whether onCreate(File) is anomalous
			if ( isAnomalous ) {
				return false;
			}

			// The targetPath & targetFile has been confirmed
			// Load AbsolutePath & CanonicalPath
			targetFile_AbsolutePath = super.targetFile.getAbsolutePath();
			targetFile_CanonicalPath = super.targetFile.getCanonicalPath();

			fileReader = new FileReader(super.targetFile);
			fileWriter = new FileWriter(super.targetFile);
			targetFileContent.add( (char)fileReader.read() );

			// Test
			System.out.println(targetFileContent);
			// Test OVER
			return isAnomalous;
		} // onCreate(File)


	}
}
/** When ask for targetFile, please remember to use @targetFile.getParentFile() as the default combination for file accessing. */
/** Trying to use assert for testing. */
package com.MichealWilliam;

import org.jetbrains.annotations.NotNull;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Functions {

	public Scanner scn = new Scanner(System.in);
	public File fileHomePath = new File( "/home/william" );
	public String systemType = System.getProperty( "os.name" );
	public Runtime runtime;
	public Process process;

	public static class TodoList extends Functions {

		public File targetPath = new File(fileHomePath, "/Documents/StudyFiles" );
		public File targetFile = new File(targetPath, "/TodoList.study");
		public FileReader fileReader;
		public FileWriter fileWriter;
		public String targetFile_AbsolutePath;
		public String targetFile_CanonicalPath;
		public ArrayList<Character> targetFileContent;
		public static boolean isAnomalous = false;

		public boolean ifAsk(@NotNull File targetObject, String action) {
			request("Would you like to " + action + " " + targetObject + " ? y/n" );
			return scn.next().equalsIgnoreCase( "y" );
		}
		public void creating(@NotNull File targetObject, String targetType) throws IOException {
			String action = "Creating";
			String cmd = targetType.equalsIgnoreCase( "File" ) ? "touch " + targetObject.getParentFile() : "mkdir " + targetObject;
			// Ask
			if ( ifAsk(targetObject, action) ) {
				runtime = Runtime.getRuntime();
				process = runtime.exec(cmd);
			} else {
				requestDenied(targetObject, targetType);
			}
		}
		public void loading(@NotNull File targetObject, String targetType) {
			if ( targetType.equalsIgnoreCase("File") ) {
				targetFile = targetObject.getAbsoluteFile();
			} else {
				targetPath = targetObject.getAbsoluteFile();
			}
		}
		public void requestDenied(@NotNull File targetObject, String targetType) {
			warnings(targetType + " " + targetObject + " failed, caused & canceled by user" );
		}
		public boolean checkExistence(@NotNull File targetObject, String targetType) {
			return targetType.equalsIgnoreCase("File") ? targetObject.getParentFile().exists() : targetObject.exists();
		}
		public void request(String content) {
			System.out.print( "Request: " + content);
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
		public boolean Preparation(File targetFile) throws IOException {
			/** Why does targetFile path cannot be specified into a file-unit? */

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

			if( !checkExistence(targetPath, "path") ) {
				isAnomalous = true;
				warnings("Target path does not seem to be existed" );
				// Auto doing, no asks
				creating( targetPath, "path");
				// Retry
				Preparation(targetFile);
			} else {
				isAnomalous = false;
				information("Target path " + targetPath + " exists" );
				// Judge whether the targetFile exists or not
				if ( !checkExistence(this.targetFile, "file") ) {
					isAnomalous = true;
					warnings("Target file does not seem to be existed" );
					// Auto doing, no ask
					creating(targetFile, "file");
					// Retry
					Preparation(targetPath);
				} else {
					// targetFile exists
					isAnomalous = false;
					information("Target file " + targetFile + " exists");
				}
			}

			return !isAnomalous;
		}
		public boolean onCreate() throws IOException {

			targetFileContent = new ArrayList<>(0);

			// Use @isAnomalous to judge whether onCreate(File) is anomalous
			if ( !Preparation(targetPath) ) {
				errors( "Preparation(File) was not prepared properly" );
				isAnomalous = true;
				return false;
			}

			// The targetPath & targetFile has been confirmed
			// Load AbsolutePath & CanonicalPath
			targetFile_AbsolutePath = targetFile.getParentFile().getAbsolutePath();
			targetFile_CanonicalPath = targetFile.getParentFile().getCanonicalPath();

			fileReader = new FileReader(this.targetFile);
			fileWriter = new FileWriter(this.targetFile);
			targetFileContent.add( (char)fileReader.read() );

			// Test
			System.out.println(targetFileContent);
			// Test OVER
			return isAnomalous;
		} // onCreate(File)


	}
}

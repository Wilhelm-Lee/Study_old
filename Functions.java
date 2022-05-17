/** When ask for targetFile, please remember to use @targetFile.getAbsoluteFile() as the default combination for file accessing. */
/** Suggest avoiding using targetType with isFile() instead. */
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

		public String targetFileName = "TodoList";
		public String targetFileType = ".study";
		public File targetPath = new File(fileHomePath, "/Documents/StudyFiles" );
		public File targetFile = new File(targetPath, "/" + targetFileName + targetFileType);
		public FileReader fileReader;
		public FileWriter fileWriter;
		public ArrayList<Character> targetFileContent = new ArrayList<>(0);
		public static boolean isAnomalous = false;
		public File targetFileCopy = new File(targetFile.getParent() + "/" + targetFileName +
											  "Copy" + targetFileType);

		public boolean ifAsk(@NotNull File targetObject, String action) {
			request( targetObject.isFile() ? "How would you like to " + action + " " +
					 targetObject.getAbsoluteFile() + " ? y/n"
					 : "Would you like to " + action + " " + targetObject + " ? y/n" );

			return scn.next().equalsIgnoreCase( "y" );
		}
		public void creating(@NotNull File targetObject, @NotNull String targetType,
							 boolean ifAskNeeded) throws IOException {
			String action = "Creating";
			String cmd = targetType.equalsIgnoreCase("File") ? "touch " + targetObject.getAbsoluteFile()
						 : "mkdir " + targetObject;
			// if not exists
			if ( !targetObject.exists() ) {
				// Ask
				if (ifAskNeeded) {
					if ( ifAsk(targetObject, action) ) {
						runtime = Runtime.getRuntime();
						process = runtime.exec(cmd);
					} else {
						requestDenied(targetObject, targetType);
					}
				} else {
					runtime = Runtime.getRuntime();
					process = runtime.exec(cmd);
				}
			} else {
				information(targetType.toUpperCase() + targetObject.getAbsoluteFile() + " has already existed");
			}
		}
		public void loading(@NotNull File targetObject, @NotNull String targetType) {
			if ( targetType.equalsIgnoreCase("File") ) {
				this.targetFile = targetObject.getAbsoluteFile();
			} else {
				this.targetPath = targetObject.getAbsoluteFile(); // It won't influence
			}
		}
		public void coping(@NotNull File targetObject, @NotNull File destination,
						   @NotNull String targetType, @NotNull String destinationType,
						   boolean ifAskNeeded) throws IOException {
			String action_formmer = "Coping";
			String action_latter = "to";
			String cmd;
			// targetType
			if ( ifAskNeeded ) {
				if ( targetType.equalsIgnoreCase("Content") ) {
					if ( destinationType.equalsIgnoreCase("File") ||
						 destinationType.equalsIgnoreCase("Content")) {

						ArrayList<Character> tmp = new ArrayList<>(0);
						this.fileReader = new FileReader(targetFile.getAbsoluteFile());
						tmp.add((char) this.fileReader.read());
					} else {
						//TODO: destination is a path, gotta create a file for it, located & named by ask()

					}
				} else {
					if ( targetType.equalsIgnoreCase("File") ) {

					} else {
						if ( targetType.equalsIgnoreCase("Path") ) {
							warnings( targetType + " does not support " + action_formmer.toUpperCase() +
									  ". Action stopped");
							information("Suggested using " +
									"\"Creating(File, String, boolean) throws IOException\" to create a path");
						}
					}
				}
			}

		}
		public void requestDenied(@NotNull File targetObject, String targetType) {
			warnings(targetType + " " + targetObject + " failed, caused & canceled by user" );
		}
		public boolean checkExistence(@NotNull File targetObject, @NotNull String targetType) {
			return targetType.equalsIgnoreCase("File") ?
					targetObject.getAbsoluteFile().exists() : targetObject.exists();
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
		public boolean ask( @NotNull File targetObject, @NotNull String targetType,
							String action_formmer, String action_middle, String action_latter ) {
			// Ask
			if ( targetType.equalsIgnoreCase("File") ) {
				if ( ifAsk(targetObject.getAbsoluteFile(), action_formmer + "-" +
						action_middle + "-" + action_latter) ) {
					// TODO
				}
			} else if ( targetType.equalsIgnoreCase("Path") ){
				if ( ifAsk(targetObject, action_formmer + "-" + action_middle + "-" + action_latter) ) {
					// TODO
				}
			}
			//TODO: Fix return token
			return true;
		}
		public boolean Preparation(File targetFile) throws IOException {
			try {
				if( !checkExistence(targetPath, "path") ) {
					isAnomalous = true;
					warnings("Target path does not seem to be existed" );
					creating( targetPath, "path", false);
					// Retry
					Preparation(targetFile.getAbsoluteFile());
				} else {
					isAnomalous = false;
					information("Target path " + this.targetPath.getAbsoluteFile() + " exists" );
					// Judge whether the targetFile exists or not
					if ( !checkExistence(this.targetFile.getAbsoluteFile(), "file") ) {
						isAnomalous = true;
						warnings("Target file does not seem to be existed" );
						creating(this.targetFile.getAbsoluteFile(), "file", false);
						// Retry
						Preparation(targetPath);
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
			if ( !Preparation(targetPath) ) {
				errors( "Preparation(File) was not prepared properly" );
				isAnomalous = true;
				return false;
			}
			// The targetPath & targetFile has been ensured
			// Load AbsolutePath & CanonicalPath

			fileReader = new FileReader(this.targetFile.getAbsoluteFile());
			targetFileContent.add( (char) fileReader.read() );
			// Must use FileWriter before using FileReader, otherwise the targetFile would get content erasing.
			// Therefor, just copy the targetFile as a cloneFile and mortify it via fileWriter.
//			coping(this.targetFile, this.targetFileCopy.getParentFile(), "file", false);
			creating(targetFileCopy, "file", false);

			fileReader.close();

//			fileWriter = new FileWriter(this.targetFile.getAbsoluteFile());

			return isAnomalous;
		} // onCreate(File)
	}
}

/** When ask for targetFile, please remember to use @targetFile.getAbsoluteFile() as the default combination for file accessing. */
/** Suggest avoiding using targetType with isFile() instead. */
package com.MichealWilliam;

import org.jetbrains.annotations.NotNull;
import java.io.*;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Functions {

	protected final Scanner scn = new Scanner(System.in);
	protected final File fileHomePath = new File( "/home/william" );
	protected String systemType = System.getProperty( "os.name" );
	protected Runtime runtime;
	protected Process process;
	protected final String[] cmd = new String[1];

	protected static class TodoList extends Functions {

		private final String targetFileName = "TodoList";
		private final String targetFileType = ".study";
		private File targetPath = new File(fileHomePath, "/Documents/StudyFiles" );
		private File targetFile = new File(targetPath, "/" + targetFileName + targetFileType);
		private FileReader fileReader;
		private FileWriter fileWriter;
		private ArrayList<Character> targetFileContent = new ArrayList<>(0);
		private static boolean isAnomalous = false;
		private final File targetFileCopy = new File(targetFile.getParent() + "/" + targetFileName + "Copy" + targetFileType);

		private boolean ifAsk(@NotNull File targetObject, String action) {
			request( targetObject.isFile()
					 ? "How would you like to " + action + " " + targetObject.getAbsoluteFile() + " ? y/n"
					 : "Would you like to " + action + " " + targetObject + " ? y/n" );

			return scn.next().equalsIgnoreCase( "y" );
		}
		private void creating(@NotNull File targetObject, @NotNull String targetType, boolean ifAskNeeded) throws IOException {
			String action = "Creating";
			this.cmd[1] = targetType.equalsIgnoreCase("File")
						  ? "touch " + targetObject.getAbsoluteFile()
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
		private void loading(@NotNull File targetObject, @NotNull String targetType) {
			if ( targetType.equalsIgnoreCase("File") ) {
				this.targetFile = targetObject.getAbsoluteFile();
			} else {
				this.targetPath = targetObject.getAbsoluteFile(); // Using .getAbsoluteFile() does not matter
			}
		}
		private void coping(@NotNull File targetObject, @NotNull File destination, @NotNull String targetType, @NotNull String destinationType, boolean ifAskNeeded) throws IOException {
			String action = "Coping";
			// targetType
			if ( ifAskNeeded ) {
				if ( targetType.equalsIgnoreCase("Content") ) {
					if ( destinationType.equalsIgnoreCase("File") || destinationType.equalsIgnoreCase("Content")) {
						ArrayList<Character> tmp = new ArrayList<>(0);

						this.fileReader = new FileReader(targetFile.getAbsoluteFile());
						tmp.add((char) this.fileReader.read());
					} else {
						//TODO: destination is only a path, gotta create a file for it, located & named by ask()

					}
				} else {
					// not "Content"
					if ( targetType.equalsIgnoreCase("File") ) {
						// cmd[1] = "cp ...";

					} else {
						if ( targetType.equalsIgnoreCase("Path") ) {
							
						}
					}
				}
			} else {
				// no ask()
			}

		}
		private void requestDenied(@NotNull File targetObject, String targetType) {
			warnings(targetType + " " + targetObject + " failed, caused & canceled by user" );
		}
		private boolean checkExistence(@NotNull File targetObject, @NotNull String targetType) {
			return targetType.equalsIgnoreCase("File") ?
					targetObject.getAbsoluteFile().exists() : targetObject.exists();
		}
		private void request(String content) {
			System.out.print( "Request: " + content);
		}
		private void information(String content) {
			System.out.println( "Info: " + content);
		}
		private void warnings(String content) {
			System.out.println( "Warning: " + content);
		}
		private void errors(String content) {
			System.out.println( "Error: " + content);
		}
		private boolean ask( @NotNull File targetObject, @NotNull String targetType, String action ) throws IOException {
			// Ask
			if ( targetType.equalsIgnoreCase("File") ) {
				if ( ifAsk(targetObject.getAbsoluteFile(), action) ) {
					if (action.equalsIgnoreCase("Creating")) {
						creating(targetObject, targetType, false);

					} else if (action.equalsIgnoreCase("Coping")){
						warnings("coping() is yet to be finished");

					} else if (action.equalsIgnoreCase("Loading")) {
						loading(targetObject, targetType);
					}
				}
			} else if ( targetType.equalsIgnoreCase("Path") ) {
				if ( ifAsk(targetObject, action) ) {
					// TODO
				}
			}
			//TODO: Fix return token
			return true;
		}
		private boolean Preparation(File targetFile) throws IOException {
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
			// Must use FileWriter before using FileReader, otherwise the targetFile would get content erased.
			// Therefor, just copy the targetFile as cloneFile and mortify it via fileWriter.
//			coping(this.targetFile, this.targetFileCopy.getParentFile(), "file", false);
			creating(targetFileCopy, "file", false);

			fileReader.close();

//			fileWriter = new FileWriter(this.targetFile.getAbsoluteFile());

			return isAnomalous;
		} // onCreate(File)
	}
}

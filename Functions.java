/**
 * When ask for targetFile, please remember to use @targetFile.getAbsoluteFile() as the default combination for file accessing.
 * Suggest avoiding using targetType with isFile() instead.
*/
package com.MichealWilliam;

import org.jetbrains.annotations.NotNull;
import java.io.*;
import java.util.ArrayList;
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
		private static boolean isAnnomalous = false;
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
		private void loading(@NotNull File targetObject, @NotNull String targetType) {
			if ( targetType.equalsIgnoreCase("File") ) {
				this.targetFile = targetObject.getAbsoluteFile();
			} else {
				this.targetPath = targetObject.getAbsoluteFile(); // Using getAbsoluteFile() does not matter
			}
		}
		private void coping(@NotNull File targetObject, @NotNull File destination, @NotNull String targetType, @NotNull String destinationType, boolean ifAskNeeded) throws IOException {
			String action = "Coping";

			if( targetType.equalsIgnoreCase("Path") && destinationType.equalsIgnoreCase("Path") ){
				// Existence
				if( !checkExistence(destination, "path") ){
					creating(destination, destinationType, ifAskNeeded);
					// Retry
					coping(targetObject, destination, targetType, destinationType, ifAskNeeded);
				} else {
					// Path exists. Then loading(), now copy path"@String@" based on this.targetPath
					this.targetPath = new File(this.targetPath + destination.toString());
					// Use "mkdir -p" + this.targetPath
					this.cmd[1] = "mkdir -p " + this.targetPath;
					runtime	= Runtime.getRuntime();
					process = runtime.exec(this.cmd);
				}
			}

		}
		private void requestDenied(@NotNull File targetObject, String targetType) {
			warnings(targetType + " " + targetObject + " failed, caused & canceled by user" );
		}
		private boolean checkExistence(@NotNull File targetObject, @NotNull String targetType) {
			return targetType.equalsIgnoreCase("File")
				   ? targetObject.getAbsoluteFile().exists()
				   : targetObject.exists();
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
						// TODO: coping()
						warnings("coping() is yet to be finished");

					} else if (action.equalsIgnoreCase("Loading")) {
						loading(targetObject, targetType);
					}
				} // no else
			} else if ( targetType.equalsIgnoreCase("Path") ) { // What does code below do?
				if ( ifAsk(targetObject.getAbsoluteFile(), action) ) {
					if ( action.equalsIgnoreCase("Coping") ) {
						request("Please input your destination for " + action + " ! (AbsolutePath)\nLike: \"/home/${USER_NAME}/.../${TARGET_PATH}\"\nDestination == ");
						String destinationS = scn.next();
						File destination = new File(destinationS);
						request("Please input the type of destination! (\"File\", \"Path\", \"Content\")\nDestinationType == ");
						String destinationType = scn.next();
						coping(targetObject, destination, targetType, destinationType, true);
					} else if (action.equalsIgnoreCase( "Creating" )) {

					}
				}
			}
			//TODO: Fix token, return below
			return true;
		}
		private boolean Preparation(File targetFile) throws IOException {
			try {
				if( !checkExistence(targetPath, "path") ) {
					isAnnomalous = true;
					warnings("Target path does not seem to be existed" );
					creating( targetPath, "path", false);
					// Retry
					Preparation(targetFile.getAbsoluteFile());
				} else {
					isAnnomalous = false;
					information("Target path " + this.targetPath.getAbsoluteFile() + " exists" );
					// Judge whether the targetFile exists or not
					if ( !checkExistence(this.targetFile.getAbsoluteFile(), "file") ) {
						isAnnomalous = true;
						warnings("Target file does not seem to be existed" );
						creating(this.targetFile.getAbsoluteFile(), "file", false);
						// Retry
						Preparation(targetPath);
					} else {
						// targetFile exists
						isAnnomalous = false;
						information("Target file " + this.targetFile.getAbsoluteFile() + " exists");
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return !isAnnomalous;
		}
		public boolean onCreate() throws IOException {

			// Use @isAnnomalous to judge whether onCreate(File) is anomalous
			if ( !Preparation(targetPath) ) {
				errors( "Preparation(File) was not prepared properly" );
				isAnnomalous = true;
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

			return isAnnomalous;
		} // onCreate(File)
	}
}
/*
			// targetType
			// TRUE
			if ( ifAskNeeded ) {
				// TRUE_Content
				if ( targetType.equalsIgnoreCase("Content") ) {
					// TRUE_Content_Content
					if ( destinationType.equalsIgnoreCase("Content") ) {
						ArrayList<Character> tmp = new ArrayList<>(0);

						this.fileReader = new FileReader(targetFile.getAbsoluteFile());
						tmp.add((char) this.fileReader.read());
						fileReader.close();

						// if File does exist
						// TRUE_Content_Content_TRUE
						if ( checkExistence(targetObject, "file") ) {
							fileWriter = new FileWriter(targetObject.getAbsoluteFile());
							fileWriter.write(tmp.toString());
							fileWriter.close();

						// TRUE_Content_Content_FALSE
						} else {
							// Does not exist
							creating(targetObject, "file", true);
							// Retry coping(,,,,)
							coping(targetObject, destination, targetType, destinationType, true);
						}
					// TRUE_Content_File
					} else if( destinationType.equalsIgnoreCase("File") ){
							this.cmd[1] = "cp " + targetObject.getAbsoluteFile() + " " + destination.getAbsoluteFile();
							runtime = Runtime.getRuntime();
							process = runtime.exec(cmd);

					// TRUE_Content_Path
					} else {
						// TODO: destination is only a path, gotta create a file for it, located & named by ask()
						creating(targetObject, "path", true);
					}
				} else {
					// not "Content"
					// TRUE_File
					if ( targetType.equalsIgnoreCase("File") ) {
						// cmd[1] = "cp ...";

						// TRUE_File_Content

					} else {
						if ( targetType.equalsIgnoreCase("Path") ) {
							// Check if path exits
						}
					}
				}
			// FALSE
			} else {
				// no ask()
			}
 */
package com.study;

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

	public static final String CLASS_NAME = "FileManager";
	static BasicOutput basicOutput = new BasicOutput();

	public static class FileCreator {

		public static final String CLASS_NAME = "FileCreator";

		Scanner scn = new Scanner( System.in );
		List<String> cmd = new ArrayList<>( 0 );
		Runtime runtime;
		Process process;
		boolean isAllRight = true;

		private boolean ifAsk(
				@NotNull File targetObject
		) {

			FileManager.basicOutput.log(
					BasicVariables.BASIC_OUTPUT_LOG_TYPE_REQUEST,
					targetObject.isFile()
							? BasicVariables.FILE_MANAGER_OUTPUT_TEXT_HOW_WOULD_YOU_LIKE_TO +
							  /* Specific Action by @CLASS_NAME (down) */
							  BasicVariables.FILE_MANAGER_ACTIONS_CREATING +
							  BasicVariables.SPACE +
							  targetObject.getAbsoluteFile() +
							  BasicVariables.FILE_MANAGER_OUTPUT_TEXT_QUESTIONMARK_YN
							: BasicVariables.FILE_MANAGER_OUTPUT_TEXT_HOW_WOULD_YOU_LIKE_TO +
							  BasicVariables.FILE_MANAGER_ACTIONS_CREATING +
							  BasicVariables.SPACE +
							  targetObject.getAbsolutePath() +
							  BasicVariables.FILE_MANAGER_OUTPUT_TEXT_QUESTIONMARK_YN
			);

			return BasicVariables.FILE_MANAGER_OUTPUT_TEXT_Y.equalsIgnoreCase( scn.next() ) ||
				   BasicVariables.FILE_MANAGER_OUTPUT_TEXT_YES.equalsIgnoreCase( scn.next() );
		}

		private void creating(
				@NotNull File targetObject,
				@NotNull String targetType,
				boolean ifAskNeeded
		) {

			try {

				this.cmd.clear();

				if ( BasicVariables.FILE_MANAGER_TARGET_TYPE_FILE_STRING.equalsIgnoreCase( targetType ) ) {
					this.cmd.add( BasicVariables.LINUX_COMMAND_TOUCH );
					this.cmd.add( targetObject.getAbsolutePath() );
				} else {
					this.cmd.add( BasicVariables.LINUX_COMMAND_MKDIR );
					// the flag
					this.cmd.add( "-p" );
					this.cmd.add( targetObject.getAbsolutePath() );
				}

				// if not exists
				if ( !targetObject.exists() ) {
					// Then create it
					// Ask
					if ( ifAskNeeded ) {
						if ( ifAsk(	targetObject ) ) {
							runtime = Runtime.getRuntime();
							process = runtime.exec( this.cmd.toArray( new String[ cmd.size() ] ) );
						} else {
							requestDenied(
									targetObject,
									targetType
							);
						}
					} else {
						runtime = Runtime.getRuntime();
						process = runtime.exec( this.cmd.toArray( new String[ cmd.size() ] ) );
					}
				} else {
					FileManager.basicOutput.log(
							BasicVariables.BASIC_OUTPUT_LOG_TYPE_INFO,
							targetType.toUpperCase() +
							targetObject.getAbsoluteFile() +
							BasicVariables.FILE_MANAGER_OUTPUT_TEXT_HAD_ALREADY_EXISTED
					);
				}
			} catch ( IOException ioe ) {
				FileManager.basicOutput.log(
						BasicVariables.BASIC_OUTPUT_LOG_TYPE_ERROR,
						FileCreator.CLASS_NAME,
						ioe.getLocalizedMessage()
				);
			}
		}

		private void requestDenied(
				@NotNull File targetObject,
				String targetType
		) {

			FileManager.basicOutput.log(
					BasicVariables.BASIC_OUTPUT_LOG_TYPE_WARN,
					targetType +
					BasicVariables.SPACE +
					targetObject +
					BasicVariables.FILE_MANAGER_OUTPUT_TEXT_FAILED_CAUSED_AND_CANCELED_BY_USER
			);
		}

		private boolean checkExistence(
				@NotNull File targetObject,
				@NotNull String targetType
		) {

			return BasicVariables.FILE_MANAGER_TARGET_TYPE_FILE_STRING.equalsIgnoreCase( targetType )
					? targetObject.getAbsoluteFile().exists()
					: targetObject.exists();
		}

		public boolean onCreate( File targetFile, boolean ifAskNeeded ) {

			try {
				if ( !checkExistence(
						new File( targetFile.getParent() ),
						BasicVariables.FILE_MANAGER_TARGET_TYPE_PATH_STRING
				) ) {
					isAllRight = false;

					FileManager.basicOutput.log(
							BasicVariables.BASIC_OUTPUT_LOG_TYPE_WARN,
							BasicVariables.FILE_MANAGER_OUTPUT_TEXT_TARGET_PATH_DOES_NOT_EXIST
					);

					creating(
							new File( targetFile.getParent() ),
							BasicVariables.FILE_MANAGER_TARGET_TYPE_PATH_STRING,
							ifAskNeeded
					);
					// Retry
					onCreate( targetFile.getAbsoluteFile(), false );
					// Actually, it does not need to getAbsoluteFile(), just original targetFile would also be fine
				} else {
					isAllRight = true;
					FileManager.basicOutput.log(
							BasicVariables.BASIC_OUTPUT_LOG_TYPE_INFO,
							BasicVariables.TARGET +
							BasicVariables.FILE_MANAGER_TARGET_TYPE_PATH_STRING +
							new File( targetFile.getParent() ).getAbsoluteFile() +
							BasicVariables.FILE_MANAGER_OUTPUT_TEXT_HAD_ALREADY_EXISTED
					);
					// Judge whether the targetFile exists or not
					if ( !checkExistence(
							targetFile.getAbsoluteFile(),
							BasicVariables.FILE_MANAGER_TARGET_TYPE_FILE_STRING
					) ) {
						isAllRight = false;
						FileManager.basicOutput.log(
								BasicVariables.BASIC_OUTPUT_LOG_TYPE_WARN,
								BasicVariables.FILE_MANAGER_OUTPUT_TEXT_TARGET_FILE_DOES_NOT_EXIST
						);
						creating(
								targetFile.getAbsoluteFile(),
								BasicVariables.FILE_MANAGER_TARGET_TYPE_FILE_STRING,
								ifAskNeeded
						);
						// Retry
						onCreate( targetFile.getAbsoluteFile(), false );
					} else {
						// targetFile exists
						isAllRight = true;
						FileManager.basicOutput.log(
								BasicVariables.BASIC_OUTPUT_LOG_TYPE_INFO,
								BasicVariables.TARGET +
								BasicVariables.FILE_MANAGER_TARGET_TYPE_FILE_STRING +
								targetFile.getAbsoluteFile() +
								BasicVariables.FILE_MANAGER_OUTPUT_TEXT_HAD_ALREADY_EXISTED
						);
					}
				}
			} catch ( Exception e ) {

				/*
				  This case should not happen, because once
				  there were a File or Path does not exist,
				  preparation() would solve it by trying
				  recursively.
				  This is an exception-like reporting code
				  */

				FileManager.basicOutput.log(
						BasicVariables.BASIC_OUTPUT_LOG_TYPE_ERROR,
						FileCreator.CLASS_NAME,
						e.getLocalizedMessage()
				);
				return isAllRight = false;
			}
			return isAllRight = true;
		}
	}
}

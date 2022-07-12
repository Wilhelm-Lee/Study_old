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

	public static final String CLASS_NAME = "FileManager";

	static BasicOutput basicOutput = new BasicOutput();

	Scanner scn = new Scanner( System.in );
	List<String> cmd = new ArrayList<>( 0 );
	Runtime runtime;
	Process process;
	boolean isAnomalous = false;

	public boolean ifAsk(
			@NotNull File targetObject,
			String action
	) {

		basicOutput.log(
				BasicVariables.BASIC_OUTPUT_LOG_TYPE_REQUEST,
				targetObject.isFile()
						? BasicVariables.FILE_MANAGER_OUTPUT_TEXT_HOW_WOULD_YOU_LIKE_TO +
						  action +
						  BasicVariables.SPACE +
						  targetObject.getAbsoluteFile() +
						  BasicVariables.FILE_MANAGER_OUTPUT_TEXT_QUESTIONMARK_YN
						: BasicVariables.FILE_MANAGER_OUTPUT_TEXT_HOW_WOULD_YOU_LIKE_TO +
						  action +
						  BasicVariables.SPACE +
						  targetObject.getAbsolutePath() +
						  BasicVariables.FILE_MANAGER_OUTPUT_TEXT_QUESTIONMARK_YN
		);

		return BasicVariables.FILE_MANAGER_OUTPUT_TEXT_Y.equalsIgnoreCase( scn.next() ) ||
			   BasicVariables.FILE_MANAGER_OUTPUT_TEXT_YES.equalsIgnoreCase( scn.next() );
	}

	public void creating(
			@NotNull File targetObject,
			@NotNull String targetType,
			boolean ifAskNeeded
	) {

		try {

			this.cmd.clear();

			if ( BasicVariables.FILE_MANAGER_TARGET_TYPE_FILE.equalsIgnoreCase( targetType ) ) {
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
					if ( ifAsk(
							targetObject,
							BasicVariables.FILE_MANAGER_ACTIONS_CREATING
					) ) {
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
				basicOutput.log(
						BasicVariables.BASIC_OUTPUT_LOG_TYPE_INFO,
						targetType.toUpperCase() +
						targetObject.getAbsoluteFile() +
						BasicVariables.FILE_MANAGER_OUTPUT_TEXT_HAD_ALREADY_EXISTED
				);
			}
		} catch ( IOException ioe ) {
			basicOutput.log(
					BasicVariables.BASIC_OUTPUT_LOG_TYPE_ERROR,
					FileManager.CLASS_NAME,
					ioe.getLocalizedMessage()
			);
		}
	}

	public void requestDenied(
			@NotNull File targetObject,
			String targetType
	) {

		basicOutput.log(
				BasicVariables.BASIC_OUTPUT_LOG_TYPE_WARN,
				targetType +
				BasicVariables.SPACE +
				targetObject +
				BasicVariables.FILE_MANAGER_OUTPUT_TEXT_FAILED_CAUSED_AND_CANCELED_BY_USER
		);
	}

	public boolean checkExistence(
			@NotNull File targetObject,
			@NotNull String targetType
	) {

		return BasicVariables.FILE_MANAGER_TARGET_TYPE_FILE.equalsIgnoreCase( targetType )
				? targetObject.getAbsoluteFile().exists()
				: targetObject.exists();
	}

	public boolean preparation( File targetFile ) {

		try {
			if ( !checkExistence(
					new File( targetFile.getParent() ),
					BasicVariables.FILE_MANAGER_TARGET_TYPE_PATH
			) ) {
				isAnomalous = true;

				basicOutput.log(
						BasicVariables.BASIC_OUTPUT_LOG_TYPE_WARN,
						BasicVariables.FILE_MANAGER_OUTPUT_TEXT_TARGET_PATH_DOES_NOT_EXIST
				);

				creating(
						new File( targetFile.getParent() ),
						BasicVariables.FILE_MANAGER_TARGET_TYPE_PATH,
						false
				);
				// Retry
				preparation( targetFile.getAbsoluteFile() );
				// Actually, it does not need to getAbsoluteFile(), just original targetFile would also be fine
			} else {
				isAnomalous = false;
				basicOutput.log(
						BasicVariables.BASIC_OUTPUT_LOG_TYPE_INFO,
						BasicVariables.TARGET +
						BasicVariables.FILE_MANAGER_TARGET_TYPE_PATH +
						new File( targetFile.getParent() ).getAbsoluteFile() +
						BasicVariables.FILE_MANAGER_OUTPUT_TEXT_HAD_ALREADY_EXISTED
				);
				// Judge whether the targetFile exists or not
				if ( !checkExistence(
						targetFile.getAbsoluteFile(),
						BasicVariables.FILE_MANAGER_TARGET_TYPE_FILE
				) ) {
					isAnomalous = true;
					basicOutput.log(
							BasicVariables.BASIC_OUTPUT_LOG_TYPE_WARN,
							BasicVariables.FILE_MANAGER_OUTPUT_TEXT_TARGET_FILE_DOES_NOT_EXIST
					);
					creating(
							targetFile.getAbsoluteFile(),
							BasicVariables.FILE_MANAGER_TARGET_TYPE_FILE,
							false
					);
					// Retry
					preparation( targetFile.getAbsoluteFile() );
				} else {
					// targetFile exists
					isAnomalous = false;
					basicOutput.log(
							BasicVariables.BASIC_OUTPUT_LOG_TYPE_INFO,
							BasicVariables.TARGET +
							BasicVariables.FILE_MANAGER_TARGET_TYPE_FILE +
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

			basicOutput.log(
					BasicVariables.BASIC_OUTPUT_LOG_TYPE_ERROR,
					FileManager.CLASS_NAME,
					e.getLocalizedMessage()
			);
			return isAnomalous = true;
		}
		return isAnomalous;
	}
}

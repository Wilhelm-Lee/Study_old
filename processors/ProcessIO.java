package com.study.processors;

import com.study.input.BasicInput;
import com.study.storage.BasicVariables;
import org.jetbrains.annotations.NotNull;

/**
 * @author william
 */
public class ProcessIO {

	public static final @NotNull String CLASS_NAME = "ProcessIO";

	public class ProcessInput {

		public static final @NotNull String CLASS_NAME = "ProcessInput";

		public void onCreate() {

			String input = BasicInput.recorder();

			String[] inputSlitted = input.split( String.valueOf(BasicVariables.SPACE) );

			for ( int i = 0; i < inputSlitted.length; i ++ ) {
				// TODO: ProcessCommand()
			}



		}

	}

	public class BasicOutputProcess {

		public static final @NotNull String CLASS_NAME = "BasicOutputProcess";

	}

}

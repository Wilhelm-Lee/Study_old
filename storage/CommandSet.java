package com.study.storage;

/**
 * @author william
 */
public class CommandSet {

	/**
	 * Run Help-Doc
	 */
	public static final String _HELP = "HELP";

	/**
	 * Exit the programme
	 */
	public static final String _EXIT = "EXIT";

	/**
	 * Print out local date & time
	 */
	public static final String _TIME = "TIME";
	public static final char[] _TIME_F =
			new char[]
					{
							' ',
							// no flg: "DD dd MM, YY"
							'f',
							// Format date & time with yours
							's'
							// format Simply/Shortly: "HH-mm-ss"
					};
	/** Users do not actually need to type in capitalized for all */
	public static final String[] _TIME_FLAG =
			new String[]
					{
							" ",
							// no flg: "DD dd MM, YY"
							"FORMAT",
							// FORMAT date & time with yours
							"SHORT"
							// format simply/SHORTly: "HH-mm-ss"
					};
}

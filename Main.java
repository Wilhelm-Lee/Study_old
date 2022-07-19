package com.study;

/*
 * *----------------------------------------------------------------*
 * |   Modifier			Class		Package		Subclass	World	|
 * +----------------------------------------------------------------+
 * |   public			Y			Y			Y			Y		|
 * |   protected		Y			Y			Y			N		|
 * |   no_modifier		Y			Y			N			N		|
 * |   private			Y			N			N			N		|
 * *----------------------------------------------------------------*
 * ..............................................July 15th, 2022.....
 */

/**
 * @author william
 */
public class Main {
	public static void main( String[] args ) {

		Applications.TodoList todoList = new Applications.TodoList();
		todoList.onCreate();
	}
}
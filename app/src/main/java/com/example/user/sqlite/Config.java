package com.example.user.sqlite;

/**
 * Created by User on 09.10.2016.
 */
public class Config {
    public  static  final  String DB_NAME="myDB";
    public static final String TABLE_PERSON = "Person";
    public static final String KEY_ID = "Id";
    public static final String KEY_NAME = "Name";
    public static final String KEY_SURNAME = "SurName";
    public static final String KEY_AGE = "Age";
    public static final String[] COLUMNS = {KEY_ID,KEY_NAME,KEY_SURNAME,KEY_AGE};
    public static  final String COMMAND_CREATE="create table "+TABLE_PERSON+" (Id INTEGER PRIMARY KEY, Name TEXT, SurName TEXT, Age INTEGER );";
    public static  final String COMMAND_DELETE="DROP TABLE IF EXISTS "+TABLE_PERSON;
    public  static  final  String COMMAND_SELECT="SELECT * FROM "+TABLE_PERSON;
}

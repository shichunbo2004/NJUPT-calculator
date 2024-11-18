package com.example.login.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


// 数据库访问类
public class DataBaseHelper extends SQLiteOpenHelper {
    // 数据库名称
    public static final String DATABASE = "title.db";

    // 数据库版本号
    public static final int VERSION = 1;

    // 创建用户表User
    public static final String CREATE_USER = "create table User ("
            + "account text primary key,"
            + "password text)";

  // 创建学生表Student
  public static final String CREATE_STUDENT = "create table Student ("
    + "account text primary key,"
    + "name text,"
    + "age text,"
    + "phone text,"
    + "college text)";



  public static final String CREATE_HUILV = "create table HuiLv ("
    + "id integer primary key autoincrement,"
    + "unit1 text,"
    + "unit2 text,"
    + "value text)";

  public static final String CREATE_MIANJI = "create table Mianji ("
    + "id integer primary key autoincrement,"
    + "unit1 text,"
    + "unit2 text,"
    + "value text)";

  public static final String CREATE_TIJI= "create table Tiji ("
    + "id integer primary key autoincrement,"
    + "unit1 text,"
    + "unit2 text,"
    + "value text)";



  public static final String CREATE_ZHONGLIANG = "create table Zhongliang ("
    + "id integer primary key autoincrement,"
    + "unit1 text,"
    + "unit2 text,"
    + "value text)";

  public static final String CREATE_CHANGDU = "create table Changdu ("
    + "id integer primary key autoincrement,"
    + "unit1 text,"
    + "unit2 text,"
    + "value text)";





  // 创建DB对象时的构造函数
    public DataBaseHelper(Context context) {
        super(context, DATABASE, null, VERSION);
    }

    // 创建数据库
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USER);
        db.execSQL(CREATE_STUDENT);
        db.execSQL(CREATE_HUILV);
        db.execSQL(CREATE_MIANJI);
        db.execSQL(CREATE_TIJI);
        db.execSQL(CREATE_CHANGDU);
        db.execSQL(CREATE_ZHONGLIANG);

    }
    // 升级数据库
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists User");
        db.execSQL("drop table if exists Student");
        onCreate(db);
    }
}

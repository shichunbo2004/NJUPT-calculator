package com.example.login;

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

    // 创建DB对象时的构造函数
    public DataBaseHelper(Context context) {
        super(context, DATABASE, null, VERSION);
    }

    // 创建数据库
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USER);
        db.execSQL(CREATE_STUDENT);
    }
    // 升级数据库
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists User");
        db.execSQL("drop table if exists Student");
        onCreate(db);
    }
}

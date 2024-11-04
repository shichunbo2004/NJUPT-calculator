package com.example.login;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;



// 数据库中的CRUD操作
public class UserDao {
    private Context context;         //上下文
    private DataBaseHelper dbHelper; //数据库访问对象
    private SQLiteDatabase db;       //可对数据库进行读写的操作对象

    public UserDao(Context context) {
        this.context = context;
    }

    // 创建并打开数据库（如果数据库已存在直接打开）
    public void open() throws SQLiteException {
        dbHelper = new DataBaseHelper(context);
        try {
            db = dbHelper.getWritableDatabase();
        } catch (SQLiteException exception) {
            db = dbHelper.getReadableDatabase();
        }
    }

    // 关闭数据库
    public void close() {
        if (db != null) {
            db.close();
            db = null;
        }
    }

    // 添加用户信息
    public void addUser(Yonghu user) {
        ContentValues values = new ContentValues();
        values.put("account", user.getAccount());
        values.put("password", user.getPassword());
        db.insert("User", null, values);
    }

    // 删除用户信息
    public void deleteUser(Yonghu user) {
        db.delete("User", "account = ?", new String[]{user.getAccount()});
    }

    // 修改用户信息
    public void updateUser(Yonghu user) {
        ContentValues values = new ContentValues();
        values.put("password", user.getPassword());
        db.update("User", values, "account = ?", new String[]{user.getAccount()});
    }

    // 查询用户信息
    public boolean findUser(Yonghu user) {
        //查询user表中where指定列元素的记录
        Cursor cursor = db.query("User", null, "account = ?", new String[]{user.getAccount()}, null, null, null);
        if (cursor == null || cursor.getCount() < 1) {
            return false;
        }
        cursor.close();
        return true;
    }

    // 判断账号是否存在
    public boolean isExist(String account) {
        Cursor cursor = db.query("User", null, "account = ?", new String[] {account}, null, null, null);
        return cursor != null && cursor.getCount() > 0;
    }

    // 根据账号来查找用户密码，登录时校验密码
    public String getPassword(String account) {
        Cursor cursor = db.query("User", null, "account = ?", new String[] {account}, null, null, null);
        cursor.moveToFirst();
        @SuppressLint("Range") String password = cursor.getString(cursor.getColumnIndex("password"));
        return password;
    }

}
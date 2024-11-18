package com.example.login.db;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

import com.example.login.Yonghu;

import java.util.ArrayList;


// 数据库中的CRUD操作
public class ZhongliangDao {
    private Context context;         //上下文
    private DataBaseHelper dbHelper; //数据库访问对象
    private SQLiteDatabase db;       //可对数据库进行读写的操作对象

    public ZhongliangDao(Context context) {
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


  public void addValue(String unit1, String unit2,String value) {
    ContentValues values = new ContentValues();
    values.put("unit1", unit1);
    values.put("unit2", unit2);
    values.put("value", value);
    db.insert("Zhongliang", null, values);
  }


  public ArrayList<ExchangeBean> findValue(String unit1, String unit2) {
    ArrayList<ExchangeBean> mlist=new ArrayList<>();
    //查询user表中where指定列元素的记录
    Cursor cursor = db.query("Zhongliang", null, "unit1 = ? and unit2 = ? ", new String[] {unit1,unit2}, null, null, null);
    if (cursor == null || cursor.getCount() < 1) {
    }else {
      if (cursor.moveToNext()){
        @SuppressLint("Range") String unitQuery1 = cursor.getString(cursor.getColumnIndex("unit1"));
        @SuppressLint("Range") String unitQuery2 = cursor.getString(cursor.getColumnIndex("unit2"));
        @SuppressLint("Range") String valueQuery = cursor.getString(cursor.getColumnIndex("value"));
        mlist.add(new ExchangeBean(unitQuery1,unitQuery2,valueQuery));
      }
    }
    cursor.close();

    return  mlist;
  }

  // 判断账号是否存在
  public boolean isExist(String unit1,String unit2) {

    Cursor cursor = db.query("Zhongliang", null, "unit1 = ? and unit2 = ? ", new String[] {unit1,unit2}, null, null, null);
    return cursor != null && cursor.getCount() > 0;
  }
}

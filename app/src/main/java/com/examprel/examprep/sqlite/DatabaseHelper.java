package com.examprel.examprep.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper{
    private static String DATABASE = "database.db";
    private static String TABLE ="mytable";
    private static String NAME = "name";
    private static String STANDARD = "standard";
    private static String STREAM = "stream";
    String br;
    public DatabaseHelper(Context context) {
        super(context, DATABASE, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
      br = "CREATE TABLE "+TABLE+" ("+NAME+"Text,"+STANDARD+"Text, "+STREAM+"Text);";
      db.execSQL(br);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
          db.execSQL("DROP TABLE IF EXISTS  "+TABLE+" ;");
    }

    public void insertdata(String name, String standard, String stream){
        System.out.println("Hello"+br);
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME,name);
        contentValues.put(STANDARD,standard);
        contentValues.put(STREAM,stream);
        db.insert(TABLE,null,contentValues);
    }
  public List<DataModel> getData(){
        List<DataModel> dataModels = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
      Cursor cursor = db.rawQuery("select * from "+TABLE+" ;",null);
      StringBuffer stringBuffer = new StringBuffer();
      DataModel dataModel = null;
      while (cursor.moveToNext()){
          dataModel = new DataModel();
          String name = cursor.getString(cursor.getColumnIndexOrThrow("name"));
          String standard = cursor.getString(cursor.getColumnIndexOrThrow("standard"));
          String stream = cursor.getString(cursor.getColumnIndexOrThrow("stream"));

          dataModel.setName(name);
          dataModel.setStandard(standard);
          dataModel.setStream(stream);
          dataModels.add(dataModel);
      }
    return dataModels;
  }

}

package com.example.acer.lzh.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DbService {
	private Context context;
	private  DbOpenHelper dbOpenHelper;
	public DbService(Context context){
		this.context=context;
		dbOpenHelper = new DbOpenHelper(context);
	}
	public void insert(String id,String icon, String name, String price) {

		SQLiteDatabase db = dbOpenHelper.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put("id",id);
		values.put("icon",icon);
		values.put("name",name);
		values.put("price",price);
		db.insert("save", null, values);
		
	}
	public Cursor getcursor() {
		// TODO Auto-generated method stub
		SQLiteDatabase db = dbOpenHelper.getWritableDatabase();
		return db.rawQuery("select * from save",null);
		
	}
	public void delete(String name) {
		// TODO Auto-generated method stub
		SQLiteDatabase db=dbOpenHelper.getWritableDatabase();
		db.execSQL("delete from save where name=?",new String[]{name});
		
	}
	
	
	
}

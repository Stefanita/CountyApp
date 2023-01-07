package com.example.a2activity.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.TextView;

import java.nio.charset.StandardCharsets;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DBNAME="login.db";
    private Context mContext;
    public DBHelper(Context context) {
        super(context, "login.db", null, 1);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table users(username TEXT primary key, password TEXT, email Text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("drop table if exists users");

    }

    public Boolean checkusername(String username){
        SQLiteDatabase db = mContext.openOrCreateDatabase(DBNAME, Context.MODE_PRIVATE, null);
        Cursor cursor=db.rawQuery("select * from users where username=?",new String[]{username});

      if(cursor.getCount()>0)
          return true;
      else
          return false;

    }

    public Boolean checkusernamepassword(String username, String password) {
        SQLiteDatabase db = mContext.openOrCreateDatabase(DBNAME, Context.MODE_PRIVATE, null);
        Cursor cursor = db.rawQuery("select * from users where username=? and password=?", new String[]{username, password});
        System.out.println("The cursor is:"+cursor);
        if (cursor.getCount() > 0)
            return false;
        else
            return true;
    }

        public Boolean insertData(String username,String password, String email){
            SQLiteDatabase db = mContext.openOrCreateDatabase(DBNAME, Context.MODE_PRIVATE, null);
            ContentValues values = new ContentValues();
            values.put("username", username);
            values.put("email", email);
            values.put("password", password);

            long result = db.insert("users", null, values);
            db.close();
            if (result == -1)
                return false;
            else
                return true;
        }

    public String[] CheckData(String username) {
        String[] values = new String[2]; // create a string array to store the values
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT username, email FROM users WHERE username = ?", new String[] {username});
        if (cursor.moveToFirst()) {
            values[0] = cursor.getString(0); // store the username
            values[1] = cursor.getString(1); // store the email
        }
        cursor.close(); // close the cursor object
        return values;
    }
}




package sg.edu.np.practical2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.Random;

public class MyDBHandler extends SQLiteOpenHelper {
    public static int DATABASE_VERSION = 1;
    public static String DATABASE_NAME = "users.db";
    public static String USER = "user";
    public static String COLUMN_NAME = "Name";
    public static String COLUMN_DESCRIPTION = "Description";
    public static String COLUMN_ID = "id";
    public static String COLUMN_FOLLOWED = "followed";


    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        String CREATE_TABLE = "CREATE TABLE " + USER + "(" + COLUMN_NAME + " TEXT," + COLUMN_DESCRIPTION + " TEXT," + COLUMN_ID
                + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_FOLLOWED + " INTEGER" + ")";
        db.execSQL(CREATE_TABLE);
        for (int i = 0; i < 20; i++) {
            ContentValues values = new ContentValues();
            values.put("name", "Name" + new Random().nextInt());
            values.put("description", "Description" + new Random().nextInt());
            values.put("followed", new Random().nextInt() % 2 == 0);
            db.insert(USER, null, values);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS " + USER);
        onCreate(db);
    }

    public ArrayList<User> getUsers(){
        ArrayList<User> usersList = new ArrayList<>();
        String query = "SELECT * FROM " + USER;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()){
            User queryData = new User();
            queryData.setName(cursor.getString(0));
            queryData.setDescription(cursor.getString(1));
            queryData.setId(cursor.getInt(2));
            queryData.setFollowed(Boolean.parseBoolean(cursor.getString(3)));

            usersList.add(queryData);
        }
        cursor.close();
        db.close();
        return usersList;
    }

    public void updateUser(User user){
        ContentValues values = new ContentValues();
        values.put(COLUMN_FOLLOWED, user.isFollowed());

        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(USER, null, values);
        db.close();
    }


}

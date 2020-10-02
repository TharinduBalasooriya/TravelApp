package com.example.travelapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DBHandler extends SQLiteOpenHelper {

    private static final int VERSION = 1;
    private static final String DB_NAME = "TravelApp";
    //table names

    private static final String BOOKING_TABLE_NAME = "bookings";
    private static final String USER_PROFILE_DETAILS ="userdetails";

    //common column names
    private  static final String ID = "id";
    private static final String STARTED = "started";
    private static final String FINISHED = "finished";

    //hotel booking table
    private  static  final String CUSNAME = "name";
    private  static  final String CUSMAIL = "email";
    private  static  final String CUSMOBILE = "mobile";
    private  static  final String CUSID = "nic";
    private  static final  String HOTEL_NAME = "hotelName";

    //User Details Table
    private static final String  USERNAME = "username";
    private static final String USEREMAIL ="usermail";
    private static final String USERPHONE = "userphone";
    private static final String PASSWORD = "password";

    public DBHandler(@Nullable Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
            String BOOKING_TABLE_CREATE_QUERY = "CREATE TABLE "+BOOKING_TABLE_NAME+" " +
                    "("
                    +ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
                    +CUSNAME + " TEXT,"
                    +HOTEL_NAME + " TEXT,"
                    +CUSMAIL + " TEXT,"
                    +CUSMOBILE + " TEXT,"
                    +CUSID + " TEXT,"
                    +STARTED+ " TEXT,"
                    +FINISHED+" TEXT" +
                    ");";

        db.execSQL(BOOKING_TABLE_CREATE_QUERY);
        Log.d("T1","db created");

        String USER_PROFILE_DETAILS_CREATE_QUERY = "CREATE TABLE "+USER_PROFILE_DETAILS+" " +
                "("
                +ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
                +USERNAME + " TEXT,"
                +USEREMAIL + " TEXT,"
                +USERPHONE + " TEXT,"
                +PASSWORD + " TEXT"+
                ");";


        db.execSQL(USER_PROFILE_DETAILS_CREATE_QUERY);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        String DROP_BOOKING_TABLE_QUERY = "DROP TABLE IF EXISTS "+ BOOKING_TABLE_NAME;
        // Drop older table if existed
        db.execSQL(DROP_BOOKING_TABLE_QUERY);
        // Create tables again
        onCreate(db);


        String DROP_USER_PROFILE_DETAILS_TABLE = "DROP TABLE IF EXISTS "+ USER_PROFILE_DETAILS;
        // Drop older table if existed
        db.execSQL(DROP_USER_PROFILE_DETAILS_TABLE);
        // Create tables again
        onCreate(db);

    }

    public void addBooking(BookingModel booking){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(CUSNAME,booking.getName());
        contentValues.put(HOTEL_NAME,booking.gethName());
        contentValues.put(CUSMAIL,booking.getName());
        contentValues.put(CUSMOBILE,booking.getMobile());
        contentValues.put(CUSID,booking.getNic());
        contentValues.put(STARTED,booking.getStarted());
        contentValues.put(FINISHED,booking.getFinished());

        //save to table
        sqLiteDatabase.insert(BOOKING_TABLE_NAME,null,contentValues);
        // close database
        sqLiteDatabase.close();

    }
}

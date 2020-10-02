package com.example.travelapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class DBHandler extends SQLiteOpenHelper {

    private static final int VERSION = 1;
    private static final String DB_NAME = "TravelApp";
    //table names

    private static final String BOOKING_TABLE_NAME = "bookings";
    private static final String USER_PROFILE_DETAILS ="userdetails";
    private static final String TRIP_TABLE_NAME = "trip";
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
    private static  final  String CHECK_IN = "checkIn";
    private static  final String CHECK_OUT = "checkOut";
    private static final String PRICE_HOTEL = "price";
    private  static  final  String DISCOUNT_RATE = "discountRate";
    private static  final  String  PERSON_COUNT = "numberofPerson";
    private static  final  String  TOTALPRICE_HOTEL = "totprice";
    private static  final  String  DISCPRICE_HOTEL = "discountValue";
    private static  final  String  FINALPRICE_HOTEL = "finalprice";



    //User Details Table
    private static final String  USERNAME = "username";
    private static final String USEREMAIL ="usermail";
    private static final String USERPHONE = "userphone";
    private static final String PASSWORD = "password";

    //destination table
    private  static  final String PLACE = "place";
    private  static  final String TRIP_DATE = "date";
    private  static  final String TIME = "time";
    private  static  final String NO_OF_PARTICIPANTS = "number";



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
                +FINISHED+" TEXT,"
                +CHECK_IN+ " TEXT,"
                +CHECK_OUT+ " TEXT,"
                +PRICE_HOTEL+ " TEXT,"
                +DISCOUNT_RATE+ " TEXT,"
                +PERSON_COUNT+ " TEXT,"
                +TOTALPRICE_HOTEL+ " TEXT,"
                +DISCPRICE_HOTEL+ " TEXT,"
                +FINALPRICE_HOTEL+ " TEXT" +
                ");";

        String USER_PROFILE_DETAILS_CREATE_QUERY = "CREATE TABLE "+USER_PROFILE_DETAILS+" " +
                "("
                +USERNAME + " TEXT,"
                +USEREMAIL + " TEXT,"
                +USERPHONE + " TEXT,"
                +PASSWORD + " TEXT"+
                ");";

        String TRIP_TABLE_CREATE_QUERY = "CREATE TABLE "+TRIP_TABLE_NAME+" " +
                "("
                +ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
                +PLACE + " TEXT,"
                +TRIP_DATE + " TEXT,"
                +TIME + " TEXT,"
                +NO_OF_PARTICIPANTS + " TEXT,"
                +STARTED+ " TEXT,"
                +FINISHED+" TEXT" +
                ");";

        db.execSQL(TRIP_TABLE_CREATE_QUERY);
        db.execSQL(BOOKING_TABLE_CREATE_QUERY);
        db.execSQL(USER_PROFILE_DETAILS_CREATE_QUERY);
        Log.d("T1","db created");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        String DROP_BOOKING_TABLE_QUERY = "DROP TABLE IF EXISTS "+ BOOKING_TABLE_NAME;
        // Drop older table if existed
        db.execSQL(DROP_BOOKING_TABLE_QUERY);
        String DROP_USER_PROFILE_DETAILS_TABLE = "DROP TABLE IF EXISTS "+ USER_PROFILE_DETAILS;
        // Drop older table if existed
        db.execSQL(DROP_USER_PROFILE_DETAILS_TABLE);
        String DROP_TRIP_TABLE_QUERY = "DROP TABLE IF EXISTS "+ TRIP_TABLE_NAME;
        // Drop older table if existed
        db.execSQL(DROP_TRIP_TABLE_QUERY);
        // Create tables again
        onCreate(db);

    }

    //add booking method
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
        contentValues.put(CHECK_IN,booking.getCheckIn());
        contentValues.put(CHECK_OUT,booking.getCheckOut());
        contentValues.put(PRICE_HOTEL,booking.getPrice());
        contentValues.put(DISCOUNT_RATE,booking.getDiscount());
        contentValues.put(PERSON_COUNT,booking.getPersonCount());
        contentValues.put(TOTALPRICE_HOTEL,booking.getTotPrice());
        contentValues.put(DISCPRICE_HOTEL,booking.getDiscountPrice());
        contentValues.put(FINALPRICE_HOTEL,booking.getFinalPrice());

        //save to table
        sqLiteDatabase.insert(BOOKING_TABLE_NAME,null,contentValues);
        // close database
        sqLiteDatabase.close();


    }
    //get All bookings

    public List<BookingModel> getAllBookings(){

        List<BookingModel> bookings = new ArrayList();
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * FROM " + BOOKING_TABLE_NAME;

        Cursor cursor = db.rawQuery(query,null);



        if(cursor.moveToFirst()){
            do {
                // Create new Booking Object
                BookingModel booking = new BookingModel();
                // mmgby6hh
               booking.setId(cursor.getInt(0));
               booking.setName(cursor.getString(1));
               booking.sethName(cursor.getString(2));
               booking.setEmail(cursor.getString(3));
               booking.setMobile(Integer.parseInt(cursor.getString(4)));
               booking.setNic(cursor.getString(5));
               booking.setStarted(cursor.getLong(6));
               booking.setFinished(cursor.getLong(7));
               booking.setCheckIn(cursor.getString(8));
               booking.setCheckOut(cursor.getString(9));
               booking.setPrice(Integer.parseInt(cursor.getString(10)));
               booking.setDiscount(Integer.parseInt(cursor.getString(11)));
               booking.setPersonCount(Integer.parseInt(cursor.getString(12)));
               booking.setTotPrice(Double.parseDouble(cursor.getString(13)));
               booking.setDiscountPrice(Double.parseDouble(cursor.getString(14)));
                booking.setFinalPrice(Double.parseDouble(cursor.getString(15)));


               Log.d("GetData"," " + cursor.getInt(0));
               Log.d("GetData",""+booking.getMobile());
                //toDos [obj,objs,asas,asa]
                bookings.add(booking);
            }while (cursor.moveToNext());
        }
        return bookings;

    }
    //delete Booking
    public void deleteBooking(int id){
        SQLiteDatabase db = getWritableDatabase();
        db.delete(BOOKING_TABLE_NAME,"id =?",new String[]{String.valueOf(id)});
        db.close();
    }

    public void addTrip(TripModel tripmodel){
           SQLiteDatabase sqLiteDatabase = getWritableDatabase();

           ContentValues contentValues = new ContentValues();

           contentValues.put(PLACE, tripmodel.getPlace());
           contentValues.put(TRIP_DATE, tripmodel.getDate());
           contentValues.put(TIME, tripmodel.getTime());
           contentValues.put(NO_OF_PARTICIPANTS, tripmodel.getNumber());


            //save to table
            sqLiteDatabase.insert(TRIP_TABLE_NAME, null, contentValues);
            //close database
            sqLiteDatabase.close();

    }
}

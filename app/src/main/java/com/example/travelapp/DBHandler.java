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
    private static final String ORDER_TABLE_NAME = "order_table";
    private static final String CARD_TABLE_NAME = "card_table";
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

    //order Table
    private static final String ITEM1_QTY = "item1quanitity";
    private static final String ITEM2_QTY = "item2quanitity";
    private static final String ITEM3_QTY = "item3quanitity";
    private static final String TOT_PRICE_ORDER = "item4quanitity";

    //cardtable
    private  static  final String CRD_NAME = "crdName";
    private  static  final String CRD_NUM = "crdNumber";
    private  static  final String CRD_EXP = "exp";
    private  static  final String CRD_CVV = "cvv";


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
                +ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
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
        String ORDER_TABLE_CREATE_QUERY = "CREATE TABLE "+ORDER_TABLE_NAME+" " +
                "("
                +ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
                +CUSNAME + " TEXT,"
                +CUSMOBILE + " TEXT,"
                +ITEM1_QTY + " TEXT,"
                +ITEM2_QTY + " TEXT,"
                +ITEM3_QTY+ " TEXT,"
                +TOT_PRICE_ORDER+" TEXT" +
                ");";

        String CARD_TABLE_CREATE_QUERY = "CREATE TABLE "+CARD_TABLE_NAME+" " +
            "("
                +ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
                +CRD_NAME + " TEXT,"
                +CRD_NUM + " TEXT,"
                +CRD_CVV + " TEXT,"
                +CRD_EXP + " TEXT" +
                ");";


        db.execSQL(TRIP_TABLE_CREATE_QUERY);
        db.execSQL(BOOKING_TABLE_CREATE_QUERY);
        db.execSQL(USER_PROFILE_DETAILS_CREATE_QUERY);
        db.execSQL(ORDER_TABLE_CREATE_QUERY);
        db.execSQL(CARD_TABLE_CREATE_QUERY);
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

        String DROP_ORDER_TABLE = "DROP TABLE IF EXISTS "+ ORDER_TABLE_NAME;
        // Drop older table if existed
        db.execSQL(DROP_ORDER_TABLE );
        String DROP_CARD_TABLE = "DROP TABLE IF EXISTS "+ CARD_TABLE_NAME;
        // Drop older table if existed
        db.execSQL(DROP_CARD_TABLE );
        // Create tables again
        onCreate(db);

    }

    //add booking method
    public void addBooking(BookingModel booking){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(CUSNAME,booking.getName());
        contentValues.put(HOTEL_NAME,booking.gethName());
        contentValues.put(CUSMAIL,booking.getEmail());
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
    // get single booking
    public BookingModel getSingleBooking(int id){
        SQLiteDatabase db = getWritableDatabase();

        Cursor cursor = db.query(BOOKING_TABLE_NAME,new String[]{ID,CUSNAME,HOTEL_NAME,CUSMAIL, CUSMOBILE,CUSID,STARTED,FINISHED,CHECK_IN,CHECK_OUT,PRICE_HOTEL,DISCOUNT_RATE,PERSON_COUNT,TOTALPRICE_HOTEL,DISCPRICE_HOTEL,FINALPRICE_HOTEL},
                ID + "= ?",new String[]{String.valueOf(id)}
                ,null,null,null);

        BookingModel booking;
        if(cursor != null){
            cursor.moveToFirst();
            booking = new BookingModel(

                    //public BookingModel(/int id, /String name, /String nic, /String email, /String hName, /int mobile, /long started, /long finished,/int price,/int discount,String /checkIn,String /checkOut,int personCount)
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(5),
                    cursor.getString(3),
                    cursor.getString(2),
                    Integer.parseInt(cursor.getString(4)),
                    Long.parseLong(cursor.getString(6)),
                    Long.parseLong(cursor.getString(7)),
                    Integer.parseInt(cursor.getString(10)),
                    Integer.parseInt(cursor.getString(11)),
                    cursor.getString(8),
                    cursor.getString(9),
                    Integer.parseInt(cursor.getString(12))




            );
            return booking;
        }
        return null;
    }
    //update single booking
    public int updateSingleBooking(BookingModel booking){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(CUSNAME,booking.getName());
        contentValues.put(HOTEL_NAME,booking.gethName());
        contentValues.put(CUSMAIL,booking.getEmail());
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

        int status = db.update(BOOKING_TABLE_NAME,contentValues,ID +" =?",
                new String[]{String.valueOf(booking.getId())});

        db.close();
        return status;
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

    //add order
    public void adddOrder(OrderModel order){

        SQLiteDatabase db =  getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(CUSNAME,order.getCusName());
        contentValues.put(CUSMOBILE,order.getCusMobile());
        contentValues.put(ITEM1_QTY,order.getItem1q());
        contentValues.put(ITEM2_QTY,order.getItemq2());
        contentValues.put(ITEM3_QTY,order.getItemq3());
        contentValues.put(TOT_PRICE_ORDER,order.getTotPrice());

        db.insert(ORDER_TABLE_NAME,null,contentValues);
        db.close();

    }

    //get All orders
    public List<OrderModel> getAllOrders(){

        List<OrderModel> orders = new ArrayList();
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * FROM "+ORDER_TABLE_NAME;

        Cursor cursor = db.rawQuery(query,null);

        if(cursor.moveToFirst()){
            do {
                // Create new ToDo object
                OrderModel order = new OrderModel();
                // mmgby6hh
                order.setId(cursor.getInt(0));
                order.setCusName(cursor.getString(1));
                order.setCusMobile(cursor.getString(2));
                order.setItem1q(Integer.parseInt(cursor.getString(3)));
                order.setItemq2(Integer.parseInt(cursor.getString(4)));
                order.setItemq3(Integer.parseInt(cursor.getString(5)));
                order.setTotPrice(Double.parseDouble(cursor.getString(6)));
                //toDos [obj,objs,asas,asa]
                orders.add(order);
            }while (cursor.moveToNext());
        }
        return orders;
    }
    //delete Order
    public void deleteOrder(int id){
        SQLiteDatabase db = getWritableDatabase();
        db.delete(ORDER_TABLE_NAME,"id =?",new String[]{String.valueOf(id)});
        db.close();
    }

    //update order
    public int updateOrder(OrderModel order){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(CUSNAME,order.getCusName());
        contentValues.put(CUSMOBILE,order.getCusMobile());
        contentValues.put(ITEM1_QTY,order.getItem1q());
        contentValues.put(ITEM2_QTY,order.getItemq2());
        contentValues.put(ITEM3_QTY,order.getItemq3());



        int status = db.update(ORDER_TABLE_NAME,contentValues,ID +" =?",
                new String[]{String.valueOf(order.getId())});

        db.close();
        return status;
    }

    //getAllTrips
    public List<TripModel> getAllTrips(){

        List<TripModel> trips = new ArrayList();
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * FROM "+TRIP_TABLE_NAME;

        Cursor cursor = db.rawQuery(query,null);

        if(cursor.moveToFirst()){
            do {

                TripModel trip = new TripModel();
                // mmgby6hh
                trip.setId(cursor.getInt(0));
                trip.setPlace(cursor.getString(1));
                trip.setDate(cursor.getString(2));
                trip.setTime(cursor.getString(3));
                trip.setNumber(cursor.getString(4));
                trips.add(trip);
            }while (cursor.moveToNext());
        }
        return trips;
    }
    //delete Trip
    public void deleteTrip(int id){
        SQLiteDatabase db = getWritableDatabase();
        db.delete(TRIP_TABLE_NAME,"id =?",new String[]{String.valueOf(id)});
        db.close();
    }
    //update trip
    public int updateTrp(TripModel tripmodel){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(PLACE, tripmodel.getPlace());
        contentValues.put(TRIP_DATE, tripmodel.getDate());
        contentValues.put(TIME, tripmodel.getTime());
        contentValues.put(NO_OF_PARTICIPANTS, tripmodel.getNumber());



        int status = db.update(TRIP_TABLE_NAME,contentValues,ID +" =?",
                new String[]{String.valueOf(tripmodel.getId())});

        db.close();
        return status;
    }

    //add Users

    public void addUser(UserModel userModel){



        SQLiteDatabase db =  getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(USERNAME,userModel.getUserName());
        contentValues.put(USEREMAIL, userModel.getEmail());
        contentValues.put(USERPHONE,userModel.getMobile());
        contentValues.put(PASSWORD,userModel.getPassword());


        db.insert(USER_PROFILE_DETAILS,null,contentValues);
        db.close();

    }
  //add cards

    public void addCard(cardModel cardModel){



        SQLiteDatabase db =  getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(CRD_NAME,cardModel.getName());
        contentValues.put(CRD_NUM,cardModel.getNumber());
        contentValues.put(CRD_CVV,cardModel.getCvv());
        contentValues.put(CRD_EXP,cardModel.getExpDate());



        db.insert(CARD_TABLE_NAME,null,contentValues);
        db.close();

    }
    //getAllCard



    public List<cardModel> getAllCard(){

        List<cardModel> cards = new ArrayList();
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * FROM "+CARD_TABLE_NAME;

        Cursor cursor = db.rawQuery(query,null);

        if(cursor.moveToFirst()){
            do {

                cardModel card = new cardModel();

                card.setId(cursor.getInt(0));
                card.setName(cursor.getString(1));
                card.setNumber(cursor.getString(2));
                card.setExpDate(cursor.getString(4));
                card.setCvv(cursor.getString(3));
                cards.add(card);
            }while (cursor.moveToNext());
        }
        return cards;
    }
    //deleteCard
    public void deleteCard(int id){
        SQLiteDatabase db = getWritableDatabase();
        db.delete(CARD_TABLE_NAME,"id =?",new String[]{String.valueOf(id)});
        db.close();
    }
    //update card

    public int updateCard(cardModel cardModel){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues contentValues = new ContentValues();



        contentValues.put(CRD_NAME,cardModel.getName());
        contentValues.put(CRD_NUM,cardModel.getNumber());
        contentValues.put(CRD_EXP, cardModel.getExpDate());
        contentValues.put(CRD_CVV,cardModel.getCvv());




        int status = db.update(CARD_TABLE_NAME,contentValues,ID +" =?",
                new String[]{String.valueOf(cardModel.getId())});

        db.close();
        return status;
    }



}

package com.mobileappscompany.training.mymyrecyclersqliteapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 2/9/2017.
 */

public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "carsManager";

    private static final String TABLE_CARS = "cars";

    private static final String COL_ID = "id";
    private static final String COL_NAME = "name";
    private static final String COL_DEALER = "dealer";
    private static final String COL_PHOTO = "photo";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CARS_TABLE = "CREATE TABLE " + TABLE_CARS + "("
                + COL_ID + " INTEGER PRIMARY KEY, "
                + COL_NAME + " TEXT,"
                + COL_DEALER + " TEXT,"
                + COL_PHOTO + " TEXT" + ")";
        db.execSQL(CREATE_CARS_TABLE);

        addCar(new Car("Jetta", "Volkswagen", "http://buyersguide.caranddriver.com/media/assets/submodel/7883.jpg"), db);
        addCar(new Car("City", "Honda", "https://www.honda.mx/assets/img/autos/honda/modelos/city/poster_video.jpg"), db);
        addCar(new Car("Passat", "Volkswagen", "http://www.vw.com.mx/content/medialib/vwd4/mx_mexico_/modelos/modelos-2016/passat/galeria/exterior/exterior1/_jcr_content/renditions/rendition.960.455.file/exterior1.jpg"), db);
        addCar(new Car("A3", "Audi", "http://7www.ecestaticos.com/imagestatic/clipping/757/9a0/7579a028d02dba86c02f138e92cd8e21/en-mayo-un-nuevo-audi-a3-mas-tecnologico.jpg?mtime=1460131545"), db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CARS);

        onCreate(db);
    }

//    public void addCar(Car car) {
//        SQLiteDatabase db = this.getWritableDatabase();
//
//        addCar(car, db);
//    }

    private void addCar(Car car, SQLiteDatabase db) {
        ContentValues values = new ContentValues();

        values.put(COL_NAME, car.getName());
        values.put(COL_DEALER, car.getDealer());
        values.put(COL_PHOTO, car.getPhoto());

        db.insert(TABLE_CARS, null, values);
//        db.close();
    }

//    public Car getCar(int id) {
//        SQLiteDatabase db = this.getReadableDatabase();
//
//        Cursor cursor = db.query(TABLE_CARS,
//                new String[]{COL_ID, COL_NAME, COL_DEALER, COL_PHOTO},
//                COL_ID + "=?",
//                new String[]{String.valueOf(id)}, null, null, null, null);
//
//        if(cursor != null) {
//            cursor.moveToFirst();
//        }
//
//        Car car = new Car(Integer.parseInt(cursor.getString(0)),
//                cursor.getString(1), cursor.getString(2), cursor.getString(3));
//
//        return car;
//    }

    public List<Car> getAllCars() {
        List<Car> cars = new ArrayList<>();

        String selectAllCarsQuery = "SELECT * FROM " + TABLE_CARS;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectAllCarsQuery, null);

        if(cursor.moveToFirst()) {
            do {
                Car car = new Car();
                car.setId(Integer.parseInt(cursor.getString(0)));
                car.setName(cursor.getString(1));
                car.setDealer(cursor.getString(2));
                car.setPhoto(cursor.getString(3));
                cars.add(car);
            } while (cursor.moveToNext());
        }

        return cars;
    }

//    public int updateCar(Car car) {
//        SQLiteDatabase db = this.getWritableDatabase();
//
//        ContentValues values = new ContentValues();
//        values.put(COL_NAME, car.getName());
//        values.put(COL_DEALER, car.getDealer());
//
//        // updating row
//        return db.update(TABLE_CARS, values, COL_ID + " = ?",
//                new String[]{String.valueOf(car.getId())});
//    }

    // Deleting single car
//    public void deleteContact(Car car) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        db.delete(TABLE_CARS, COL_ID + " = ?",
//                new String[]{String.valueOf(car.getId())});
//        db.close();
//    }

//    public int getCarsCount() {
//        String countQuery = "SELECT  * FROM " + TABLE_CARS;
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor cursor = db.rawQuery(countQuery, null);
//        cursor.close();
//
//        return cursor.getCount();
//    }
}

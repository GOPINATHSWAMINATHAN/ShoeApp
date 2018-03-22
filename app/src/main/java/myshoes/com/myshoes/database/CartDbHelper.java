package myshoes.com.myshoes.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import myshoes.com.myshoes.model.Cart;

/**
 * Created by gopinath on 19/03/18.
 */

public class CartDbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "CartAdapter.db";
    public static final String CREATE_TABLE = "CREATE TABLE " + CartContract.CartEntry.TABLE_NAME + "(" + CartContract.CartEntry._ID + " integer primary key autoincrement, " + CartContract.CartEntry.COLUMN_PRODUCT_NAME + " text, " + CartContract.CartEntry.COLUMN_PRODUCT_DESCRIPTION + " text, " + CartContract.CartEntry.COLUMN_PRODUCT_PRICE + " text, " + CartContract.CartEntry.COLUMN_IMAGE_URL + " text, " + CartContract.CartEntry.COLUMN_PRODUCT_QUANTITY + " text" + ")";
    public static final String DROP_TABLE = "DROP TABLE IF EXISTS " + CartContract.CartEntry.TABLE_NAME;
    public static final String SELECT_DB = "SELECT * FROM " + CartContract.CartEntry.TABLE_NAME;
    int id;

    public CartDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_TABLE);
        onCreate(db);
    }

    public boolean insertProducts(Cart cart) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(CartContract.CartEntry.COLUMN_PRODUCT_NAME, cart.getProductName());
        contentValues.put(CartContract.CartEntry.COLUMN_PRODUCT_DESCRIPTION, cart.getProductDescription());
        contentValues.put(CartContract.CartEntry.COLUMN_PRODUCT_PRICE, cart.getProductPrice());
        contentValues.put(CartContract.CartEntry.COLUMN_IMAGE_URL, cart.getImageUrl());
        contentValues.put(CartContract.CartEntry.COLUMN_PRODUCT_QUANTITY, cart.getProductQuantity());
        db.insert(CartContract.CartEntry.TABLE_NAME, null, contentValues);
        db.close();
        return true;
    }

    public List<Cart> getData() {
        List<Cart> cartList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        try {
            Cursor res = db.rawQuery(SELECT_DB, null);
            if (res.moveToFirst()) {
                do {
                    Cart myCart = new Cart();
                    myCart.setProductId(res.getString(0));
                    myCart.setProductName(res.getString(1));
                    myCart.setProductDescription(res.getString(2));
                    myCart.setProductPrice(res.getString(3));
                    myCart.setImageUrl(res.getString(4));
                    myCart.setProductQuantity(res.getString(5));
                    cartList.add(myCart);
                }
                while (res.moveToNext());


            }
        } finally {
            db.close();
        }
        return cartList;
    }

    public int numberOfRows() {
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows;
        try {
            numRows = (int) DatabaseUtils.queryNumEntries(db, CartContract.CartEntry.TABLE_NAME);
        } finally {
            db.close();
        }
        return numRows;
    }

    public boolean deleteCartProduct(String id) {
        String table = CartContract.CartEntry.TABLE_NAME;
        String whereClause = "_id=?";
        String[] whereArgs = new String[]{String.valueOf(id)};
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(table, whereClause, whereArgs);
        db.close();
        return true;
    }

    public boolean updatePrice(int price, int position) {
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            db.execSQL("UPDATE " + CartContract.CartEntry.TABLE_NAME + " SET " + CartContract.CartEntry.COLUMN_PRODUCT_PRICE + "=" + price + " where " + CartContract.CartEntry._ID + "=" + position);
        } catch (Exception e) {
            db.close();
        }
        return true;
    }

    //update tablename set quantity=3 where id=position
    public boolean updateQuantity(int quantity, int position) {
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            db.execSQL("UPDATE " + CartContract.CartEntry.TABLE_NAME + " SET " + CartContract.CartEntry.COLUMN_PRODUCT_QUANTITY + "=" + quantity + " where " + CartContract.CartEntry._ID + "=" + position);
        } finally {
            db.close();
        }
        return true;
    }


    public boolean deleteEntireCart() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("Delete from " + CartContract.CartEntry.TABLE_NAME);
        return true;
    }
}

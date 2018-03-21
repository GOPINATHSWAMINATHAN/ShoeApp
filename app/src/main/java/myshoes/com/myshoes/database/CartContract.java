package myshoes.com.myshoes.database;

import android.provider.BaseColumns;

/**
 * Created by gopinath on 19/03/18.
 */

public class CartContract {

    private CartContract() {

    }

    public static class CartEntry implements BaseColumns {
        public static final String TABLE_NAME = "products";
        public static final String COLUMN_IMAGE_URL = "imageUrl";
        public static final String COLUMN_PRODUCT_NAME = "productName";
        public static final String COLUMN_PRODUCT_DESCRIPTION = "productDescription";
        public static final String COLUMN_PRODUCT_PRICE = "productPrize";
        public static final String COLUMN_PRODUCT_QUANTITY = "quantity";


    }
}

package myshoes.com.myshoes.model;

import java.util.Arrays;
import java.util.List;

import myshoes.com.myshoes.R;

/**
 * Created by gopinath on 12/02/18.
 */


public class Gallery {

    public static Gallery get() {
        return new Gallery();
    }

    private Gallery() {
    }

    public List<Image> getData() {
        return Arrays.asList(
                new Image(R.drawable.shop1),
                new Image(R.drawable.shop1),
                new Image(R.drawable.shop1),
                new Image(R.drawable.shop1),
                new Image(R.drawable.shop1),
                new Image(R.drawable.shop1));
    }
}


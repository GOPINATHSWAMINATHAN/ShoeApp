package myshoes.com.myshoes.utils;

import android.app.Application;

/**
 * Created by gopinath on 12/02/18.
 */

public class App extends Application {

    private static App instance;

    public static App getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        DiscreteScrollViewOptions.init(this);
    }
}

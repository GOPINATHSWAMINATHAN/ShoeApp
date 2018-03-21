package myshoes.com.myshoes.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by gopinath on 18/03/18.
 */

public class WomenAdapter extends RecyclerView.Adapter<WomenAdapter.WomenViewHolder> {


    @Override
    public WomenViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(WomenViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class WomenViewHolder extends RecyclerView.ViewHolder {

        public WomenViewHolder(View itemView) {
            super(itemView);
        }
    }
}

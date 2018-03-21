package myshoes.com.myshoes.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by gopinath on 18/03/18.
 */

public class MenAdapter extends RecyclerView.Adapter<MenAdapter.MenViewHolder> {

    @Override
    public MenViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(MenViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MenViewHolder extends RecyclerView.ViewHolder {

        public MenViewHolder(View itemView) {
            super(itemView);
        }
    }
}

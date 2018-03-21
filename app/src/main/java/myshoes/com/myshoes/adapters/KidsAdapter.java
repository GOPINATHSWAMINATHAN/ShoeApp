package myshoes.com.myshoes.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by gopinath on 18/03/18.
 */

public class KidsAdapter extends RecyclerView.Adapter<KidsAdapter.KidsViewHolder> {


    @Override
    public KidsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(KidsViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class KidsViewHolder extends RecyclerView.ViewHolder {
        public KidsViewHolder(View itemView) {
            super(itemView);
        }
    }
}

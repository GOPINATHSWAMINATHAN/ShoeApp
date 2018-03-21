package myshoes.com.myshoes.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import myshoes.com.myshoes.R;
import myshoes.com.myshoes.model.CategoryProducts;

/**
 * Created by gopinath on 18/03/18.
 */

public class CategoryProductsAdapter extends RecyclerView.Adapter<CategoryProductsAdapter.CategoryViewHolder> {
    private ListItemClickListener mOnClickListener;
    private Context context;
    private List<CategoryProducts> mCategoryData = new ArrayList<>();

    public CategoryProductsAdapter(Context context, ArrayList<CategoryProducts> mCategoryData, ListItemClickListener listener) {
        this.context = context;
        this.mCategoryData = mCategoryData;
        this.mOnClickListener = listener;
    }

    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.products_view, parent, false);
        CategoryViewHolder viewHolder = new CategoryViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CategoryViewHolder holder, int position) {
        Log.e("CATEGORY DATA", "" + mCategoryData.get(position).getProdName());
        holder.name.setText(mCategoryData.get(position).getProdName());
        holder.price.setText(String.valueOf(mCategoryData.get(position).getMrpPrice()));
        holder.description.setText(mCategoryData.get(position).getDescription());
        Glide.with(context).load(mCategoryData.get(position).getThumbnail()).into(holder.thumbnail);
    }

    @Override
    public int getItemCount() {
        return mCategoryData.size();
    }

    public interface ListItemClickListener {
        void onListItemClick(int clickedItemIndex);
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        LinearLayout mLinearLayout;
        ImageView thumbnail;
        private TextView name, price, description;

        public CategoryViewHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();
            thumbnail = itemView.findViewById(R.id.category_product_image);
            name = itemView.findViewById(R.id.product_name);
            price = itemView.findViewById(R.id.product_Price);
            description = itemView.findViewById(R.id.product_description);


        }
    }
}

package my.com.represent.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import my.com.represent.R;
import my.com.represent.entity.GoodsEntity;

public class GoodsAdapter extends RecyclerView.Adapter<GoodsAdapter.ViewHolder> {
    private LayoutInflater layoutInflater;
    private List<GoodsEntity> list;
    private Context context;
    
    public GoodsAdapter(List<GoodsEntity> list, Context context) {
        this.list = list;
        this.context = context;
        layoutInflater=LayoutInflater.from(context);
    }
    
    public void setData(List<GoodsEntity> list){
        this.list=list;
        notifyDataSetChanged();
    }
    
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=layoutInflater.inflate(R.layout.recycleview_item_goods,parent,false);
        return new GoodsAdapter.ViewHolder(view);
    }
    
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.image.setBackgroundResource(list.get(position).getImgId());
        holder.foodName.setText(list.get(position).getName());
        if( mOnItemClickListener!= null){
            holder.itemView.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemClickListener.onClick(position);
                }
            });
        }
    }
    
    @Override
    public int getItemCount() {
        return list == null ? 0:list.size();
    }
    
    class ViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView foodName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.image);
            foodName=itemView.findViewById(R.id.food_name);
        }
    }
    
    
    public interface OnItemClickListener{
        void onClick( int position);
    }
    
    private OnItemClickListener mOnItemClickListener;
    
    public void setOnItemClickListener(OnItemClickListener onItemClickListener ){
        this. mOnItemClickListener=onItemClickListener;
    }
    
    
}

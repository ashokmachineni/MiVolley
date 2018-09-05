package com.example.ashokmachineni.mivolley;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyAdapter extends RecyclerView.Adapter<RecyAdapter.MyViewHolder> {
    //RequestOptions options;
    private Context mContext;
    private List<Aclouds> mData;

    public RecyAdapter(Context mContext, List<Aclouds> mData) {
        this.mContext = mContext;
        this.mData = mData;
        /*options = new RequestOptions()
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.ic_launcher_background);*/
    }

    @NonNull
    @Override
    public RecyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view;
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        view = layoutInflater.inflate(R.layout.item_list,viewGroup,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyAdapter.MyViewHolder myViewHolder, final int position) {
        myViewHolder.tvname.setText(mData.get(position).getName());
        myViewHolder.tvstudio.setText(mData.get(position).getStudio());
        //Glide.with(mContext).load(mData.get(position).getImage_url()).apply(options).into(myViewHolder.AImage);

        Picasso.get()
                .load(mData.get(position).getImage_url())
                .into(myViewHolder.AImage);
        myViewHolder.liView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Toast.makeText(mContext,"set"+mData.get(position),Toast.LENGTH_SHORT).show();
               Intent i = new Intent(mContext,GalleryActivity.class);
               i.putExtra("rowname",mData.get(myViewHolder.getAdapterPosition()).getName());
               mContext.startActivity(i);
            }
        });


    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvname,tvstudio;
        ImageView AImage;
        CardView liView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvname = itemView.findViewById(R.id.rowname);
            tvstudio = itemView.findViewById(R.id.studio);
            AImage = itemView.findViewById(R.id.thumbnail);
            liView = itemView.findViewById(R.id.ll_item);
        }
    }
}

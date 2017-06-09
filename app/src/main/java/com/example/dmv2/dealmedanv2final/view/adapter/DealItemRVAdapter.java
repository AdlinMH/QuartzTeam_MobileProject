package com.example.dmv2.dealmedanv2final.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dmv2.dealmedanv2final.R;
import com.example.dmv2.dealmedanv2final.model.entity.Dealitem;
import com.example.dmv2.dealmedanv2final.view.activity.SubMainActivity;

import java.util.ArrayList;
import java.util.List;

import static com.example.dmv2.dealmedanv2final.view.activity.ParentActivity.doEllipsize;
import static java.security.AccessController.getContext;

/**
 * Created by CM on 6/2/2017.
 */

public class DealItemRVAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Dealitem> dealitems;
    Context mContext;

    public List<Dealitem> getDealitems() {
        return dealitems;
    }

    public void setDealitems(List<Dealitem> dealitems) {
        this.dealitems = dealitems;
    }

    public DealItemRVAdapter() {
        this.dealitems = new ArrayList<>();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View _view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_dealitem_linear, parent, false);
        return new ItemDealItemHolder(_view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final DealItemRVAdapter.ItemDealItemHolder _holder = (DealItemRVAdapter.ItemDealItemHolder) holder;
        final Dealitem _dealitem = this.dealitems.get(position);

        _holder.name.setText(_dealitem.getNama());
        _holder.tempat.setText(doEllipsize(_dealitem.getTempat(),24,0));
        _holder.tempat.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_menu_compass, 0, 0, 0);
        _holder.stock.setText(String.valueOf(_dealitem.getStock()));
        _holder.diskon.setText(_dealitem.getIDRHargaDiskon());
        _holder.price.setText(_dealitem.getIDRHarga());
        _holder.price.setPaintFlags(_holder.price.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

        _holder.image.setImageResource(_dealitem.getImage());

        _holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                Intent _intent = new Intent(v.getContext(), SubMainActivity.class);
                _intent.putExtra("fragmentName", "dealItemDetail");
                _intent.putExtra("dealitem", _dealitem);
                v.getContext().startActivity(_intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dealitems.size();
    }

    private class ItemDealItemHolder extends RecyclerView.ViewHolder
    {
//        private ImageView image;
        private TextView name, price, tempat, diskon, stock;
        private ImageView image;

        public ItemDealItemHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.item_linear_image);
            name = (TextView) itemView.findViewById(R.id.item_hm_linear_name);
            price = (TextView) itemView.findViewById(R.id.item_hm_linear_price);
            tempat = (TextView) itemView.findViewById(R.id.item_hm_linear_place);
            diskon = (TextView) itemView.findViewById(R.id.item_hm_linear_diskon);
            stock = (TextView) itemView.findViewById(R.id.item_hm_linear_stock);

        }
    }
}

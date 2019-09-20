package com.muhfikrihadian.sportq.holder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.muhfikrihadian.sportq.R;
import com.muhfikrihadian.sportq.adapter.AttachViewHolder;
import com.muhfikrihadian.sportq.adapter.MenuItemBean;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MenuItemBindView extends AttachViewHolder<MenuItemBindView.MenuItemViewHolder> {


    @Override
    public void bindView(MenuItemViewHolder holder, int i, Object obj) {
        MenuItemBean value = (MenuItemBean) obj;
        holder.imageIconView.setImageResource(value.getImageResource());
        holder.titleTxt.setText(value.getTitle());
    }

    @Override
    public MenuItemViewHolder onCreateVH(ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_menu_home, parent, false);
        return new MenuItemViewHolder(view);
    }

    public class MenuItemViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.imageIconView)
        ImageView imageIconView;
        @BindView(R.id.titleTxt)
        TextView titleTxt;

        public MenuItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}

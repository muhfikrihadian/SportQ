package com.muhfikrihadian.sportq.adapter;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BaseRecyclerAdapter<T extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<T> {
    private boolean isLoading;
    private int lastVivibleItem;
    private List list;
    private OnItemClickedListener listener;
    private LongItemClickedListener longItemClickedListener;
    private AttachViewHolder onAttachViewHolder;
    private OnLoadMoreListener onLoadMoreListener;
    private int totalItemCount;
    int visibleThreshold = 5;

    public interface OnItemClickedListener {
        void onItemClicked(View view, int i, boolean z, int i2);
    }

    public interface LongItemClickedListener {
        void onItemClicked(View view, int i);
    }

    public interface OnLoadMoreListener {
        void onLoadMore();
    }

    public BaseRecyclerAdapter(List listBeanList) {
        this.list = listBeanList;
    }


    public BaseRecyclerAdapter onCreateVHolder(AttachViewHolder AttachImpl) {
        this.onAttachViewHolder = AttachImpl;
        return this;
    }

    public void setOnItemClicked(OnItemClickedListener listener) {
        this.listener = listener;
    }

    public void setOnLongItemClicked(LongItemClickedListener listener) {
        this.longItemClickedListener = listener;
    }


    public void setOnLoadMoreListener(RecyclerView recyclerView, final OnLoadMoreListener onLoadMoreListener) {
        this.onLoadMoreListener = onLoadMoreListener;
        final LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                totalItemCount = linearLayoutManager.getItemCount();
                lastVivibleItem = linearLayoutManager.findLastVisibleItemPosition();
                if (!isLoading && totalItemCount <= lastVivibleItem + visibleThreshold) {
                    if (onLoadMoreListener != null) {
                        onLoadMoreListener.onLoadMore();
                    }
                    isLoading = true;
                }
            }
        });
    }

    public T onCreateViewHolder(ViewGroup parent, int viewType) {
        return (T) this.onAttachViewHolder.onCreateVH(parent, viewType);
    }

    public void onBindViewHolder(T holder, final int position) {
        Object ob = this.list.get(position);
        if (this.listener != null) {
            holder.itemView.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    listener.onItemClicked(view, position, isLoading, list.size());
                }
            });
        }

        if (this.longItemClickedListener != null) {
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    longItemClickedListener.onItemClicked(v, position);
                    return true;
                }
            });
        }
        this.onAttachViewHolder.bindView(holder, position, ob);
    }

    public void stopLoading() {
        this.isLoading = false;
    }

    public int getItemCount() {
        return this.list == null ? 0 : this.list.size();
    }

    public int getItemViewType(int position) {
        return this.onAttachViewHolder.getItemViewType(position, list.get(position), this.list.size());
    }
}

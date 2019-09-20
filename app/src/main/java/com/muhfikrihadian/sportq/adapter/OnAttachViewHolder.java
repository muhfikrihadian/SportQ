package com.muhfikrihadian.sportq.adapter;

import android.view.ViewGroup;

public interface OnAttachViewHolder<T> {
    void bindView(T t, int i, Object obj);

    T onCreateVH(ViewGroup viewGroup, int i);
}

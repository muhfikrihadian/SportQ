package com.muhfikrihadian.sportq.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.muhfikrihadian.sportq.R;
import com.muhfikrihadian.sportq.pojos.LapanganModel;

import java.util.ArrayList;

public class ListLapanganAdapter extends RecyclerView.Adapter<ListLapanganAdapter.ListPekerjaanViewHolder> {
    private ArrayList<LapanganModel> dataList;

    public ListLapanganAdapter(ArrayList<LapanganModel> dataList) {
        this.dataList = dataList;
    }

    @Override
    public ListPekerjaanViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_lapangan, parent, false);
        return new ListPekerjaanViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ListPekerjaanViewHolder holder, int position) {
        holder.txtNama.setText(dataList.get(position).getNama());
        holder.txtNpm.setText(dataList.get(position).getNpm());
        holder.txtNoHp.setText(dataList.get(position).getNohp());
    }

    @Override
    public int getItemCount() {
        return (dataList != null) ? dataList.size() : 0;
    }

    public class ListPekerjaanViewHolder extends RecyclerView.ViewHolder {
        private TextView txtNama, txtNpm, txtNoHp;

        public ListPekerjaanViewHolder(View itemView) {
            super(itemView);
            txtNama = (TextView) itemView.findViewById(R.id.txt_nama_mahasiswa);
            txtNpm = (TextView) itemView.findViewById(R.id.txt_npm_mahasiswa);
            txtNoHp = (TextView) itemView.findViewById(R.id.txt_nohp_mahasiswa);
        }
    }
}

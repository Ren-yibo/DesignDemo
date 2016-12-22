package com.design.main;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.design.R;

import java.util.List;

/**
 * @author 任益波
 * @date 2016/10/14
 * @description
 */
public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.RecycleHolder> {

    private List<String> list;
    private Context context;

    public RecycleAdapter(List<String> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onBindViewHolder(RecycleHolder holder, int position) {
        holder.mTv.setText(list.get(position));
    }

    @Override
    public RecycleHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_recycle, parent, false);
        RecycleHolder holder = new RecycleHolder(view);
        return holder;
    }

    class RecycleHolder extends RecyclerView.ViewHolder {

        private TextView mTv;

        public RecycleHolder(View itemView) {
            super(itemView);
            mTv = (TextView) itemView.findViewById(R.id.recycleItemTv);
        }
    }
}

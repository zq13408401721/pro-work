package com.mywork.base;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public abstract class BaseAdapter<T> extends RecyclerView.Adapter {
    //列表数据
    protected List<T> mData;
    protected Context mContext;

    //接口回调
    ItemClickListener itemClickListener;

    public BaseAdapter(Context context,List<T> list){
        mContext = context;
        mData = list;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(getLayout(),null);
        BaseViewHolder viewHolder = new BaseViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(itemClickListener != null){
                    itemClickListener.itemClick(viewHolder,viewHolder.getLayoutPosition());
                }
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        T data = mData.get(position);
        bindData((BaseViewHolder) holder,data);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    /**
     * 刷新列表数据
     * @param list
     */
    public void update(List<T> list){
        mData.clear();
        mData.addAll(list);
        notifyDataSetChanged();
    }

    protected abstract int getLayout();
    protected abstract void bindData(BaseViewHolder holder,T data);

    public static class BaseViewHolder extends RecyclerView.ViewHolder{

        SparseArray views;

        public BaseViewHolder(@NonNull View itemView) {
            super(itemView);
            views = new SparseArray();
        }

        /**
         * 获取Item的界面元素
         * @param id
         * @return
         */
        public View getView(int id){
            View view = (View) views.get(id);
            if(view == null){
                view = itemView.findViewById(id);
                views.append(id,view);
            }
            return view;
        }
    }

    /**
     * 设置接口回调
     * @param listener
     */
    public void addItemClickListener(ItemClickListener listener){
        itemClickListener = listener;
    }

    public interface ItemClickListener{
        void itemClick(BaseViewHolder viewHolder,int position);
    }

}

package com.winfooz.homescreen.ui.base;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;


import com.winfooz.homescreen.ui.interfaces.ViewHolderInterface;

import java.util.ArrayList;
import java.util.Objects;

public class BaseAdapter<T extends BaseItemViewModel> extends RecyclerView.Adapter<BaseAdapter.ViewHolder> {

    private ArrayList<T> list;
    private ViewHolderInterface viewHolderInterface;

    public BaseAdapter(ArrayList<T> list, ViewHolderInterface viewHolderInterface) {
        if (list == null)
            this.list = new ArrayList<>();
        else
            this.list = list;
        this.viewHolderInterface = viewHolderInterface;
    }

    public void updateList(ArrayList<T> list) {
        this.list.clear();
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        return list.get(position).getLayoutId();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewDataBinding binding =
                DataBindingUtil.bind(LayoutInflater.from(parent.getContext())
                        .inflate(viewType, parent, false));

        final ViewHolder holder = new ViewHolder<>(Objects.requireNonNull(binding));
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final int id = v.getId();
                viewHolderInterface.onViewClicked(holder.getAdapterPosition(), id);
            }
        };
        binding.getRoot().setOnClickListener(listener);
        if (binding.getRoot() instanceof ViewGroup)
            addClickListeners((ViewGroup) binding.getRoot(), listener);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        T model = list.get(position);
        holder.getBinding().setVariable(com.winfooz.homescreen.BR.viewModel, model);
        holder.getBinding().executePendingBindings();
    }

    @Override
    public int getItemCount() {
        if (list == null) return 0;
        return list.size();
    }

    private void addClickListeners(ViewGroup parent, View.OnClickListener listener) {
//        try {
        for (int i = 0; i < parent.getChildCount(); i++) {
            if (parent.getChildAt(i) instanceof ViewGroup)
                addClickListeners((ViewGroup) parent.getChildAt(i), listener);
            else
                parent.getChildAt(i).setOnClickListener(listener);
        }

    }

    public static class ViewHolder<V extends ViewDataBinding> extends RecyclerView.ViewHolder {

        private V binding;

        ViewHolder(V binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        V getBinding() {
            return binding;
        }

    }

}

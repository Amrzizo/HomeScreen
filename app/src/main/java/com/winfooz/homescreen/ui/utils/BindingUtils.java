package com.winfooz.homescreen.ui.utils;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

//import com.winfooz.homescreen.ui.base.BaseAdapter;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.mikhaellopez.circularimageview.CircularImageView;
import com.winfooz.homescreen.ui.base.BaseAdapter;


public final class BindingUtils {


    @BindingAdapter("adapter")
    public static void setAdapter(RecyclerView recyclerView, BaseAdapter adapter) {
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
    }


    @BindingAdapter(value = {"gridAdapter", "spanCount"})
    public static void setGridAdapter(RecyclerView recyclerView, BaseAdapter adapter, int spanCount) {
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(recyclerView.getContext(), spanCount));
    }


    @BindingAdapter("roundedImageUrl")
    public static void setRoundedImageUrl(final ImageView imageView, String url) {
        if (TextUtils.isEmpty(url)) return;

        Context context = imageView.getContext();
        Glide.with(context).load(url)
                .apply(RequestOptions.circleCropTransform())
                .into(imageView);
    }

    @BindingAdapter("imageUrl")
    public static void setImageUrl(CircularImageView imageView, String url) {

        Context context = imageView.getContext();

        Glide.with(context)
                .load(url)
                .into(imageView);
    }

    @BindingAdapter("visibleIf")
    public static void changeVisibility(@NonNull View view, boolean visible) {
        view.setVisibility(visible ? View.VISIBLE : View.GONE);
    }

    @BindingAdapter("invisibleIf")
    public static void changeInvisibility(@NonNull View view, boolean inVisible) {
        view.setVisibility(inVisible ? View.INVISIBLE : View.VISIBLE);
    }


}

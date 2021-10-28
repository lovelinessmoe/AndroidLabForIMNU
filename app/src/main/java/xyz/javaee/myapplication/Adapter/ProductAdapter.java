package xyz.javaee.myapplication.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import xyz.javaee.myapplication.R;
import xyz.javaee.myapplication.entity.Product;

public class ProductAdapter extends ArrayAdapter {
    private int resourceId;

    public ProductAdapter(Context context, int textViewResourceId, List<Product> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        Product product = (Product) getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId, null);

        ImageView productImage = view.findViewById(R.id.productImage);
        productImage.setImageResource(product.getAvatar());

        TextView productName = view.findViewById(R.id.name_tv);
        productName.setText(product.getName());

        TextView levelOfAppearance_tv = view.findViewById(R.id.height);
        levelOfAppearance_tv.setText("身高+" + product.getHeight());

        TextView height = view.findViewById(R.id.levelOfAppearance_tv);
        height.setText("颜值+" + product.getHeight());

        TextView sellmoney_tv = view.findViewById(R.id.sellmoney_tv);
        sellmoney_tv.setText(product.getMoney() + "元");

        return view;
    }
}
package xyz.javaee.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import xyz.javaee.myapplication.Adapter.ProductAdapter;
import xyz.javaee.myapplication.entity.People;
import xyz.javaee.myapplication.entity.Product;

public class ShopActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        Intent intent = getIntent();
        People user = (People) intent.getSerializableExtra("user");

        Product product1 = new Product(R.drawable.shinei_dianshi02,"书中自有黄金屋", 40.0, 40, 10);
        Product product2 = new Product(R.drawable.shinei_dianti02,"增高器", 140.0, 0, 20);
        Product product3 =  new Product(R.drawable.shinei_dachuang02,"整形",400.0,100,0);
        ArrayList<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);
        products.add(product3);

        //配置适配器
        ProductAdapter adapter = new ProductAdapter(ShopActivity.this, R.layout.shop_layout, products);
        //获取ListView对象
        ListView listView = findViewById(R.id.list_product);
        //将适配器关联到ListView
        listView.setAdapter(adapter);

/*
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int res;

                switch (view.getId()) {
                    case R.id.product1:
                        res = user.buy(200.0);
                        if (res > 0) {
                            user.beautiful(10);
                        } else {
                            Toast.makeText(getApplicationContext(), "余额不足", Toast.LENGTH_LONG).show();
                        }
                        break;
                    case R.id.product2:
                        res = user.buy(400.0);
                        if (res > 0) {
                            user.growTaller(10);
                        } else {
                            Toast.makeText(getApplicationContext(), "余额不足", Toast.LENGTH_LONG).show();
                        }
                        break;
                    case R.id.product3:
                        res = user.buy(40.0);
                        if (res > 0) {
                            user.growTaller(30);
                            user.beautiful(40);
                        } else {
                            Toast.makeText(getApplicationContext(), "余额不足", Toast.LENGTH_LONG).show();
                        }
                        break;
                }
            }
        };

        View product1 = findViewById(R.id.product1);
        View product2 = findViewById(R.id.product2);
        View product3 = findViewById(R.id.product3);

        product1.setOnClickListener(onClickListener);
        product2.setOnClickListener(onClickListener);
        product3.setOnClickListener(onClickListener);*/


    }
}
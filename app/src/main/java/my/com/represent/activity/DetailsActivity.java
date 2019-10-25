package my.com.represent.activity;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.xutils.DbManager;
import org.xutils.ex.DbException;

import androidx.annotation.Nullable;

import my.com.represent.R;
import my.com.represent.db.DbHelper;
import my.com.represent.entity.OrderEntity;

public class DetailsActivity extends Activity {
    private ImageView image;
    private TextView food_name;
    private TextView food_price;
    private ImageView minues;
    private ImageView plus;
    private EditText food_num;
    private TextView food_add;
    private TextView food_des;
    private String name;
    private int imgId;
    private String des;
    private String price;
    
    private void assignViews() {
        image = (ImageView) findViewById(R.id.image);
        food_name = (TextView) findViewById(R.id.food_name);
        food_price = (TextView) findViewById(R.id.food_price);
        minues = (ImageView) findViewById(R.id.minues);
        food_num = (EditText) findViewById(R.id.food_num);
        plus = (ImageView) findViewById(R.id.plus);
        food_add = (TextView) findViewById(R.id.food_add);
        food_des = (TextView) findViewById(R.id.food_des);
    }
    
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_details);
        
        name=getIntent().getStringExtra("name");
        imgId=getIntent().getIntExtra("imgId",0);
        des=getIntent().getStringExtra("des");
        price=getIntent().getStringExtra("price");
        
        aView();
        aEvent();
    }
    
    private void aEvent() {
        minues.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num=food_num.getText().toString().trim();
                if (TextUtils.isEmpty(num)){
                }else {
                    int b= Integer.parseInt(num);
                    if (b>1){
                        b--;
                        food_num.setText(b+"");
                    }
                }
            }
        });

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View c) {
                String num=food_num.getText().toString().trim();
                if (TextUtils.isEmpty(num)){
                    food_num.setText("1");
                }else {
                    int a= Integer.parseInt(num);
                    a++;
                    food_num.setText(a+"");
                }
            }
        });

        food_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View a) {
                String num=food_num.getText().toString().trim();
                if (TextUtils.isEmpty(num) || num.equals("0")){
                    Toast.makeText(DetailsActivity.this,"Add fail",Toast.LENGTH_SHORT).show();
                }else {
                    DbManager dbManager= DbHelper.getInstance().getDbManager(DetailsActivity.this,null);
                    OrderEntity orderEntity=new OrderEntity();
                    orderEntity.setDes(des);
                    orderEntity.setName(name);
                    orderEntity.setNum(num);
                    orderEntity.setPrice(price);
                    orderEntity.setImgId(imgId);
                    try {
                        dbManager.save(orderEntity);
                        Toast.makeText(DetailsActivity.this,"Add to cart",Toast.LENGTH_SHORT).show();
                        finish();
                    } catch (DbException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
    
    private void aView() {
        assignViews();

        food_name.setText(name);
        food_price.setText(price);
        food_des.setText(des);
        image.setBackgroundResource(imgId);
    }
}

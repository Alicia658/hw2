package my.com.represent.activity;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import org.xutils.DbManager;
import org.xutils.ex.DbException;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import my.com.represent.R;
import my.com.represent.adapter.OrderAdapter;
import my.com.represent.db.DbHelper;
import my.com.represent.entity.OrderEntity;

public class OrderActivity extends Activity {
    private RecyclerView recyclerView;
    private TextView foodPrice;
    private List<OrderEntity> list;
    private OrderAdapter adapter;
    
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        
        aView();

    }

        

    
    @Override
    protected void onResume() {
        super.onResume();
        aData();
    }
    
    private void aData() {
        if (list!=null){
            list.clear();
        }
        DbManager dbManager= DbHelper.getInstance().getDbManager(this,null);
        try {
            list=dbManager.selector(OrderEntity.class).findAll();
        } catch (DbException e) {
            e.printStackTrace();
        }
        if (list!=null && list.size()>0) {
            adapter.setData(list);
        }
        
        double total=0;
        for (OrderEntity entity : list){
            double price= Double.parseDouble(entity.getPrice());
            int num=Integer.parseInt(entity.getNum());
            total=total+price*num;
        }
        foodPrice.setText(total+"");
    }
    
    private void aView() {
        recyclerView=findViewById(R.id.recycleview);
        foodPrice=findViewById(R.id.food_total_price);
        list=new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter=new OrderAdapter(list,this);
        recyclerView.setAdapter(adapter);
    }
}

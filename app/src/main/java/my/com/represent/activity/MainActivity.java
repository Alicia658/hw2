package my.com.represent.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import my.com.represent.R;
import my.com.represent.adapter.GoodsAdapter;
import my.com.represent.db.DbHelper;
import my.com.represent.entity.GoodsEntity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.xutils.DbManager;
import org.xutils.ex.DbException;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private TextView foodOrder;
    private List<GoodsEntity> list;
    private GoodsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        aView();
        aEvent();
    }
    
    private void aEvent() {
        adapter.setOnItemClickListener(new GoodsAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position) {
                Intent intent=new Intent(MainActivity.this,DetailsActivity.class);
                intent.putExtra("name",list.get(position).getName());
                intent.putExtra("imgId",list.get(position).getImgId());
                intent.putExtra("des",list.get(position).getDes());
                intent.putExtra("price",list.get(position).getPrice());
                startActivity(intent);
            }
        });
        
        foodOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,OrderActivity.class);
                startActivity(intent);
            }
        });
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
            list=dbManager.selector(GoodsEntity.class).findAll();
        } catch (DbException e) {
            e.printStackTrace();
        }
    
        if (list!=null && list.size()>0){
        
            Log.e("HH",list.toString());
            adapter.setData(list);
        }else {
            GoodsEntity entity1=new GoodsEntity();
            entity1.setImgId(R.drawable.burger);
            entity1.setName("Burger");
            entity1.setDes("These are juicy, and spices can be easily added or changed to suit anyone's taste.");
            entity1.setPrice("10");
    
            GoodsEntity entity2=new GoodsEntity();
            entity2.setImgId(R.drawable.fries);
            entity2.setName("Fires");
            entity2.setDes("Made with organic potatoes.");
            entity2.setPrice("11");
            
            GoodsEntity entity3=new GoodsEntity();
            entity3.setImgId(R.drawable.taco);
            entity3.setName("Taco");
            entity3.setDes("traditional Mexican dish consisting of a small hand-sized corn or wheat tortilla topped with a filling.");
            entity3.setPrice("12");
    
            GoodsEntity entity4=new GoodsEntity();
            entity4.setImgId(R.drawable.steak);
            entity4.setName("Steak");
            entity4.setDes("Very very juicy which is A6 quality.");
            entity4.setPrice("13");
    
            GoodsEntity entity5=new GoodsEntity();
            entity5.setImgId(R.drawable.curry);
            entity5.setName("Curry");
            entity5.setDes("Using a complex combination of spices or herbs, usually including ground turmeric, cumin, coriander, ginger, and fresh or dried chilies.");
            entity5.setPrice("14");
            
            GoodsEntity entity6=new GoodsEntity();
            entity6.setImgId(R.drawable.noodle);
            entity6.setName("Noodles");
            entity6.setDes("Made from ground durum wheat and water or eggs with yummy teriyaki sauce.");
            entity6.setPrice("15");
    
            GoodsEntity entity7=new GoodsEntity();
            entity7.setImgId(R.drawable.chips);
            entity7.setName("Chips");
            entity7.setDes("Normal chips suitable for parties.");
            entity7.setPrice("16");
    
            GoodsEntity entity8=new GoodsEntity();
            entity8.setImgId(R.drawable.orange);
            entity8.setName("Orange");
            entity8.setDes("Fresh orange.");
            entity8.setPrice("17");
    
            GoodsEntity entity9=new GoodsEntity();
            entity9.setImgId(R.drawable.bread);
            entity9.setName("Bread");
            entity9.setDes("Organic bread.");
            entity9.setPrice("17");
    
            GoodsEntity entity10=new GoodsEntity();
            entity10.setImgId(R.drawable.pizza);
            entity10.setName("Pizza");
            entity10.setDes("Topped with tomatoes, cheese, and often various other ingredients (anchovies, olives, meat, etc.");
            entity10.setPrice("5");
    
            GoodsEntity entity11=new GoodsEntity();
            entity11.setImgId(R.drawable.tea);
            entity11.setName("Tea");
            entity11.setDes("Green tea.");
            entity11.setPrice("5");
    
            GoodsEntity entity12=new GoodsEntity();
            entity12.setImgId(R.drawable.coke);
            entity12.setName("Coke");
            entity12.setDes("Coca cola.");
            entity12.setPrice("5");
            
            GoodsEntity entity13=new GoodsEntity();
            entity13.setImgId(R.drawable.milkshake);
            entity13.setName("Milkshake");
            entity13.setDes("Banana milkshake.");
            entity13.setPrice("5");
    
            
            try {
                dbManager.save(entity1);
                dbManager.save(entity2);
                dbManager.save(entity3);
                dbManager.save(entity4);
                dbManager.save(entity5);
                dbManager.save(entity6);
                dbManager.save(entity7);
                dbManager.save(entity8);
                dbManager.save(entity9);
                dbManager.save(entity10);
                dbManager.save(entity11);
                dbManager.save(entity12);
                dbManager.save(entity13);
            } catch (DbException e) {
                e.printStackTrace();
            }
        
            aData();
        }
    
    }
    
    private void aView() {
        recyclerView = (RecyclerView) findViewById(R.id.recycleview);
        foodOrder = (TextView) findViewById(R.id.food_order);
        list=new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter=new GoodsAdapter(list,this);
        recyclerView.setAdapter(adapter);
    }
}

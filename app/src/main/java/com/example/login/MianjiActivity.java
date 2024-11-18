package com.example.login;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import com.example.login.db.ChangduDao;
import com.example.login.db.ExchangeBean;
import com.example.login.db.MianJiDao;

import java.util.ArrayList;

public class MianjiActivity extends AppCompatActivity {

  private LinearLayout main;
  private Spinner sp1;
  private Spinner sp2;
  private EditText etExchangeQuantity;
  private TextView tvResult;
  private Button btExchange;
  private Button btAdd;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.activity_mianji);

    initView();
    btAdd.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent intent=new Intent(MianjiActivity.this,AddMianJiActivity.class);
        startActivity(intent);
      }
    });
    btExchange.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        if (TextUtils.isEmpty(etExchangeQuantity.getText().toString())){
          Toast.makeText(MianjiActivity.this,"请添加换算数量",Toast.LENGTH_SHORT).show();
          return;
        }
        MianJiDao mianJiDao = new MianJiDao(getApplicationContext());
        mianJiDao.open();
        if (!mianJiDao.isExist(sp1.getSelectedItem().toString(),sp2.getSelectedItem().toString())) {
          Toast.makeText(MianjiActivity.this,"请添加换算关系",Toast.LENGTH_SHORT).show();
        }else {
          ArrayList<ExchangeBean> value = mianJiDao.findValue(sp1.getSelectedItem().toString(), sp2.getSelectedItem().toString());
          ExchangeBean exchangeBean = value.get(0);

          try {
            double v = Double.parseDouble(exchangeBean.getValue());

            double quantity=Double.parseDouble(etExchangeQuantity.getText().toString());
            tvResult.setText(""+(v*quantity));
          }catch (Exception e){

          }


        }
      }
    });
  }

  private void initView() {
    main = (LinearLayout) findViewById(R.id.main);
    sp1 = (Spinner) findViewById(R.id.sp1);
    sp2 = (Spinner) findViewById(R.id.sp2);
    etExchangeQuantity = (EditText) findViewById(R.id.et_exchange_quantity);
    tvResult = (TextView) findViewById(R.id.tv_result);
    btExchange = (Button) findViewById(R.id.bt_exchange);
    btAdd = (Button) findViewById(R.id.bt_add);
  }
}

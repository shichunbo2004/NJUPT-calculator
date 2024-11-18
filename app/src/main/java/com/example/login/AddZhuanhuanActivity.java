package com.example.login;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;


import com.example.login.db.HuiLvDao;

public class AddZhuanhuanActivity extends AppCompatActivity {

  private LinearLayout main;
  private Spinner sp1;
  private Spinner sp2;
  private EditText etExchangeQuantity;
  private Button btAdd;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.activity_add_zhuanhuan);

    initView();

    btAdd.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        if (TextUtils.isEmpty(etExchangeQuantity.getText().toString())){
          Toast.makeText(AddZhuanhuanActivity.this,"请完善信息",Toast.LENGTH_SHORT).show();
          return;
        }
        HuiLvDao huiLvDao = new HuiLvDao(getApplicationContext());
        huiLvDao.open();
        if (huiLvDao.isExist(sp1.getSelectedItem().toString(),sp2.getSelectedItem().toString())) {
          Toast.makeText(AddZhuanhuanActivity.this,"已经添加请勿重复添加",Toast.LENGTH_SHORT).show();
        }else {
          huiLvDao.addValue(sp1.getSelectedItem().toString(),sp2.getSelectedItem().toString(),etExchangeQuantity.getText().toString());
          Toast.makeText(AddZhuanhuanActivity.this,"添加成功",Toast.LENGTH_SHORT).show();
          huiLvDao.close();
        }
      }
    });
  }

  private void initView() {
    main = (LinearLayout) findViewById(R.id.main);
    sp1 = (Spinner) findViewById(R.id.sp1);
    sp2 = (Spinner) findViewById(R.id.sp2);
    etExchangeQuantity = (EditText) findViewById(R.id.et_exchange_quantity);
    btAdd = (Button) findViewById(R.id.bt_add);
  }
}
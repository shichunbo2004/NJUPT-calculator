package com.example.login;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class JisuanMainActivity extends Activity implements OnClickListener {
    /** Called when the activity is first created. */
    private String string = "0";
    private Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0;
    private Button btnadd, btnsub, btnmul, btndiv, btnsin, btncos, btntan;
    private Button btnln, btnlog, btne, btneq, btnpoint, btndel, btnpower;
    private Button btnsq, btnpai, btnc, btnb1, btnb2, btnfa;
    private TextView btnt0, btnt1;
    private boolean flag = false;
    private GetValue getValue = new GetValue();
    private Judge judge = new Judge();

    private void init() {
        btn1 = (Button) this.findViewById(R.id.one);
        btn2 = (Button) this.findViewById(R.id.two);
        btn3 = (Button) this.findViewById(R.id.three);
        btn4 = (Button) this.findViewById(R.id.four);
        btn5 = (Button) this.findViewById(R.id.five);
        btn6 = (Button) this.findViewById(R.id.six);
        btn7 = (Button) this.findViewById(R.id.seven);
        btn8 = (Button) this.findViewById(R.id.eight);
        btn9 = (Button) this.findViewById(R.id.nine);
        btn0 = (Button) this.findViewById(R.id.zero);
        btnadd = (Button) this.findViewById(R.id.add);
        btnsub = (Button) this.findViewById(R.id.subtract);
        btnmul = (Button) this.findViewById(R.id.multiple);
        btndiv = (Button) this.findViewById(R.id.division);
        btnsin = (Button) this.findViewById(R.id.sin);
        btncos = (Button) this.findViewById(R.id.cos);
        btntan = (Button) this.findViewById(R.id.tan);
        btnln = (Button) this.findViewById(R.id.ln);
        btnlog = (Button) this.findViewById(R.id.log);
        btne = (Button) this.findViewById(R.id.e);
        btneq = (Button) this.findViewById(R.id.eq);
        btnpoint = (Button) this.findViewById(R.id.point);
        btndel = (Button) this.findViewById(R.id.del);
        btnpower = (Button) this.findViewById(R.id.power);
        btnfa = (Button) this.findViewById(R.id.factorial);
        btnsq = (Button) this.findViewById(R.id.square_root);
        btnpai = (Button) this.findViewById(R.id.pai);
        btnc = (Button) this.findViewById(R.id.c);
        btnb1 = (Button) this.findViewById(R.id.brackets1);
        btnb2 = (Button) this.findViewById(R.id.brackets2);
        btnt0 = (TextView) this.findViewById(R.id.text0);
        btnt1 = (TextView) this.findViewById(R.id.text1);

        this.btn0.setOnClickListener(this);
        this.btn1.setOnClickListener(this);
        this.btn2.setOnClickListener(this);
        this.btn3.setOnClickListener(this);
        this.btn4.setOnClickListener(this);
        this.btn5.setOnClickListener(this);
        this.btn6.setOnClickListener(this);
        this.btn7.setOnClickListener(this);
        this.btn8.setOnClickListener(this);
        this.btn9.setOnClickListener(this);
        this.btnadd.setOnClickListener(this);
        this.btnb1.setOnClickListener(this);
        this.btnb2.setOnClickListener(this);
        this.btnc.setOnClickListener(this);
        this.btncos.setOnClickListener(this);
        this.btndel.setOnClickListener(this);
        this.btndiv.setOnClickListener(this);
        this.btne.setOnClickListener(this);
        this.btneq.setOnClickListener(this);
        this.btnfa.setOnClickListener(this);
        this.btnln.setOnClickListener(this);
        this.btnlog.setOnClickListener(this);
        this.btnmul.setOnClickListener(this);
        this.btnpai.setOnClickListener(this);
        this.btnpoint.setOnClickListener(this);
        this.btnpower.setOnClickListener(this);
        this.btnsin.setOnClickListener(this);
        this.btnsq.setOnClickListener(this);
        this.btnsub.setOnClickListener(this);
        this.btntan.setOnClickListener(this);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jisuan);
        this.init();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuItem exit = menu.add("EXIT");
        exit.setOnMenuItemClickListener(new OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                finish();
                return true;
            }
        });
        return true;
    }

    @Override
    public void onClick(View v) {

        if ("error".equals(btnt1.getText().toString())
                || "∞".equals(btnt1.getText().toString())) {
            string = "0";
        }

        if (v == this.btn0) {
            string = judge.digit_judge(string, "0", flag);
            flag = false;
            btnt1.setText(string);
        } else if (v == this.btn1) {
            string = judge.digit_judge(string, "1", flag);
            flag = false;
            btnt1.setText(string);
        } else if (v == this.btn2) {
            string = judge.digit_judge(string, "2", flag);
            flag = false;
            btnt1.setText(string);
        } else if (v == this.btn3) {
            string = judge.digit_judge(string, "3", flag);
            flag = false;
            btnt1.setText(string);
        } else if (v == this.btn4) {
            string = judge.digit_judge(string, "4", flag);
            flag = false;
            btnt1.setText(string);
        } else if (v == this.btn5) {
            string = judge.digit_judge(string, "5", flag);
            flag = false;
            btnt1.setText(string);
        } else if (v == this.btn6) {
            string = judge.digit_judge(string, "6", flag);
            flag = false;
            btnt1.setText(string);
        } else if (v == this.btn7) {
            string = judge.digit_judge(string, "7", flag);
            flag = false;
            btnt1.setText(string);
        } else if (v == this.btn8) {
            string = judge.digit_judge(string, "8", flag);
            flag = false;
            btnt1.setText(string);
        } else if (v == this.btn9) {
            string = judge.digit_judge(string, "9", flag);
            flag = false;
            btnt1.setText(string);
        } else if (v == this.btneq) {
            btnt0.setText(string + "=");
            string = getValue.advanced_dispose(string);
            string = judge.digit_dispose(string);
            flag = true;
            btnt1.setText(string);
        } else if (v == this.btnadd) {
            string = judge.judge(string, "+");
            flag = false;
            btnt1.setText(string);
        } else if (v == this.btnsub) {
            string = judge.judge(string, "-");
            flag = false;
            btnt1.setText(string);
        } else if (v == this.btnmul) {
            string = judge.judge(string, "×");
            flag = false;
            btnt1.setText(string);
        } else if (v == this.btndiv) {
            string = judge.judge(string, "÷");
            flag = false;
            btnt1.setText(string);
        } else if (v == this.btnb1) {
            if ("0".equals(string) || flag) {
                string = "(";
            } else
                string += "(";
            flag = false;
            btnt1.setText(string);
        } else if (v == this.btnb2) {
            if ("0".equals(string) || flag) {
                string = ")";
            } else
                string += ")";
            flag = false;
            btnt1.setText(string);
        } else if (v == this.btne) {
            if ("0".equals(string)) {
                string = "e";
            } else
                string += "e";
            flag = false;
            btnt1.setText(string);
        } else if (v == this.btnpower) {
            string += "^";
            flag = false;
            btnt1.setText(string);
        } else if (v == this.btnfa) {
            string += "!";
            flag = false;
            btnt1.setText(string);
        } else if (v == this.btnsq) {
            if ("0".equals(string) || flag)
                string = "";
            string += "√";
            flag = false;
            btnt1.setText(string);
        } else if (v == this.btnpai) {
            if ("0".equals(string) || flag) {
                string = "π";
            } else
                string += "π";
            flag = false;
            btnt1.setText(string);
        } else if (v == this.btnsin) {
            if ("0".equals(string) || flag) {
                string = "sin(";
            } else
                string += "sin(";
            flag = false;
            btnt1.setText(string);
        } else if (v == this.btncos) {
            if ("0".equals(string) || flag) {
                string = "cos(";
            } else
                string += "cos(";
            flag = false;
            btnt1.setText(string);
        } else if (v == this.btntan) {
            if ("0".equals(string) || flag) {
                string = "tan(";
            } else
                string += "tan(";
            flag = false;
            btnt1.setText(string);
        } else if (v == this.btnln) {
            if ("0".equals(string) || flag) {
                string = "ln(";
            } else
                string += "ln(";
            flag = false;
            btnt1.setText(string);
        } else if (v == this.btnpoint) {
            string = judge.judge1(string);
            flag = false;
            btnt1.setText(string);
        } else if (v == this.btnlog) {
            if ("0".equals(string) || flag) {
                string = "log(";
            } else
                string += "log(";
            flag = false;
            btnt1.setText(string);
        } else if (v == this.btndel) {
            if (flag) {
                string = "";
                btnt0.setText(string);
                string = "0";
                btnt1.setText(string);
            }

            if (!"0".equals(string)) {
                string = string.substring(0, string.length() - 1);
                if (0 == string.length())
                    string = "0";
            }
            flag = false;
            btnt1.setText(string);
        } else if (v == this.btnc) {
            string = "";
            btnt0.setText(string);
            string = "0";
            btnt1.setText(string);
            flag = false;
        }
    }
}
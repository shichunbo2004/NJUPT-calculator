package com.example.login.db;

public class ExchangeBean {
  private String unit1;
  private String unit2;
  private String value;

  public ExchangeBean(String unitQuery1, String unitQuery2, String valueQuery) {
    this.unit1=unitQuery1;
    this.unit2=unitQuery2;
    this.value=valueQuery;
  }

  public String getUnit1() {
    return unit1;
  }

  public void setUnit1(String unit1) {
    this.unit1 = unit1;
  }

  public String getUnit2() {
    return unit2;
  }

  public void setUnit2(String unit2) {
    this.unit2 = unit2;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }
}

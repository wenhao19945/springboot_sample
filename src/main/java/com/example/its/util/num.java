package com.example.its.util;

/**
 * @author WenHao
 * @ClassName num
 * @date 2022/1/14 15:20
 * @Description
 */
public class num {

  //斐波纳契数列
  public static void main(String[] args) {
    int a = 0;
    int b = 1;
    while (b < 100){
      System.out.println(b);
      int n = b;
      int m = a + b;
      a=n;
      b=m;
    }
  }

}

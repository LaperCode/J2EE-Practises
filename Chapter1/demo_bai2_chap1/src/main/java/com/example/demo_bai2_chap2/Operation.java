package com.example.demo_bai2_chap2;

public interface Operation {
    int apply(int lhs, int rhs);
    boolean handles(char op);
}
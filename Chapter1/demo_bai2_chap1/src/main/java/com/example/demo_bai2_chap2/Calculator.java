package com.example.demo_bai2_chap2;

import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class Calculator {
    private final Collection<Operation> operations;

    public Calculator(Collection<Operation> operations) {
        this.operations = operations;

        System.out.println("OPERATION"+operations);
    }

    public void calculate(int a, int b, char c) {
        operations.stream()
                .filter((operation) -> operation.handles(c))
                .map(operation -> operation.apply(a, b))
                .peek( (result) -> System.out.printf("%d %s %d = %s%n", a, c, b, result))
                .findFirst()
                .orElseThrow( () -> new IllegalArgumentException("Unknown operation "+ c));

    }
}

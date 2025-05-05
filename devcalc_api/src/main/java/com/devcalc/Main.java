package com.devcalc;

import io.javalin.Javalin;

public class Main {
    public static void main(String[] args) {
        Javalin app = Javalin.create().start(7000);
        CalculatorService calculator = new CalculatorService();

        app.get("/add", ctx -> {
            int a = Integer.parseInt(ctx.queryParam("a"));
            int b = Integer.parseInt(ctx.queryParam("b"));
            ctx.result(String.valueOf(calculator.add(a, b)));
        });

        app.get("/subtract", ctx -> {
            int a = Integer.parseInt(ctx.queryParam("a"));
            int b = Integer.parseInt(ctx.queryParam("b"));
            ctx.result(String.valueOf(calculator.subtract(a, b)));
        });

        app.get("/multiply", ctx -> {
            int a = Integer.parseInt(ctx.queryParam("a"));
            int b = Integer.parseInt(ctx.queryParam("b"));
            ctx.result(String.valueOf(calculator.multiply(a, b)));
        });

        app.get("/divide", ctx -> {
            int a = Integer.parseInt(ctx.queryParam("a"));
            int b = Integer.parseInt(ctx.queryParam("b"));
            if (b == 0) {
                ctx.status(400).result("Cannot divide by zero");
            } else {
                ctx.result(String.valueOf(calculator.divide(a, b)));
            }
        });
    }
}

package com.example.calculatormcp.tool;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Service;

/**
 * Calculator MCP Tool
 * Each @Tool method = one operation Claude can call.
 * Claude picks the right tool automatically based on what you ask!
 */
@Service
public class CalculatorTool {

    // ─────────────────────────────────────────────
    //  BASIC OPERATIONS
    // ─────────────────────────────────────────────

    @Tool(description = "Add two numbers together")
    public String add(
            @ToolParam(description = "First number") double a,
            @ToolParam(description = "Second number") double b) {
        double result = a + b;
        return String.format("%.2f + %.2f = %.2f", a, b, result);
    }

    @Tool(description = "Subtract second number from first number")
    public String subtract(
            @ToolParam(description = "First number") double a,
            @ToolParam(description = "Second number to subtract") double b) {
        double result = a - b;
        return String.format("%.2f - %.2f = %.2f", a, b, result);
    }

    @Tool(description = "Multiply two numbers together")
    public String multiply(
            @ToolParam(description = "First number") double a,
            @ToolParam(description = "Second number") double b) {
        double result = a * b;
        return String.format("%.2f × %.2f = %.2f", a, b, result);
    }

    @Tool(description = "Divide first number by second number")
    public String divide(
            @ToolParam(description = "Numerator (number to be divided)") double a,
            @ToolParam(description = "Denominator (number to divide by)") double b) {
        if (b == 0) return "Error: Cannot divide by zero!";
        double result = a / b;
        return String.format("%.2f ÷ %.2f = %.2f", a, b, result);
    }

    @Tool(description = "Get the remainder when dividing first number by second number (modulo)")
    public String modulo(
            @ToolParam(description = "First number") double a,
            @ToolParam(description = "Second number (divisor)") double b) {
        if (b == 0) return "Error: Cannot modulo by zero!";
        double result = a % b;
        return String.format("%.2f %% %.2f = %.2f", a, b, result);
    }

    // ─────────────────────────────────────────────
    //  POWER & ROOT OPERATIONS
    // ─────────────────────────────────────────────

    @Tool(description = "Raise a number to the power of an exponent (e.g. 2 to the power of 3 = 8)")
    public String power(
            @ToolParam(description = "Base number") double base,
            @ToolParam(description = "Exponent (power to raise to)") double exponent) {
        double result = Math.pow(base, exponent);
        return String.format("%.2f ^ %.2f = %.2f", base, exponent, result);
    }

    @Tool(description = "Find the square root of a number")
    public String squareRoot(
            @ToolParam(description = "Number to find the square root of") double number) {
        if (number < 0) return "Error: Cannot find square root of a negative number!";
        double result = Math.sqrt(number);
        return String.format("√%.2f = %.2f", number, result);
    }

    @Tool(description = "Find the cube root of a number")
    public String cubeRoot(
            @ToolParam(description = "Number to find the cube root of") double number) {
        double result = Math.cbrt(number);
        return String.format("∛%.2f = %.2f", number, result);
    }

    @Tool(description = "Find the nth root of a number (e.g. 4th root of 16 = 2)")
    public String nthRoot(
            @ToolParam(description = "Number to find the root of") double number,
            @ToolParam(description = "Which root to find (e.g. 4 for 4th root)") double n) {
        if (n == 0) return "Error: Root cannot be zero!";
        double result = Math.pow(number, 1.0 / n);
        return String.format("%.2f ^ (1/%.0f) = %.2f", number, n, result);
    }

    // ─────────────────────────────────────────────
    //  PERCENTAGE OPERATIONS
    // ─────────────────────────────────────────────

    @Tool(description = "Calculate percentage of a number (e.g. 20% of 500 = 100)")
    public String percentage(
            @ToolParam(description = "The percentage value (e.g. 20 for 20%)") double percent,
            @ToolParam(description = "The total number to calculate percentage of") double total) {
        double result = (percent / 100.0) * total;
        return String.format("%.2f%% of %.2f = %.2f", percent, total, result);
    }

    @Tool(description = "Calculate what percentage one number is of another (e.g. 50 is what % of 200?)")
    public String percentageOf(
            @ToolParam(description = "The part number") double part,
            @ToolParam(description = "The total/whole number") double total) {
        if (total == 0) return "Error: Total cannot be zero!";
        double result = (part / total) * 100.0;
        return String.format("%.2f is %.2f%% of %.2f", part, result, total);
    }

    @Tool(description = "Calculate percentage increase or decrease between two numbers")
    public String percentageChange(
            @ToolParam(description = "Original/old value") double original,
            @ToolParam(description = "New value") double newValue) {
        if (original == 0) return "Error: Original value cannot be zero!";
        double change = ((newValue - original) / original) * 100.0;
        String direction = change >= 0 ? "increase" : "decrease";
        return String.format("%.2f → %.2f = %.2f%% %s", original, newValue, Math.abs(change), direction);
    }

    // ─────────────────────────────────────────────
    //  LOGARITHM & EXPONENTIAL
    // ─────────────────────────────────────────────

    @Tool(description = "Calculate the natural logarithm (ln) of a number")
    public String naturalLog(
            @ToolParam(description = "Number to find the natural log of (must be positive)") double number) {
        if (number <= 0) return "Error: Number must be greater than zero for logarithm!";
        double result = Math.log(number);
        return String.format("ln(%.2f) = %.6f", number, result);
    }

    @Tool(description = "Calculate the base-10 logarithm (log10) of a number")
    public String log10(
            @ToolParam(description = "Number to find the log base 10 of (must be positive)") double number) {
        if (number <= 0) return "Error: Number must be greater than zero for logarithm!";
        double result = Math.log10(number);
        return String.format("log10(%.2f) = %.6f", number, result);
    }

    @Tool(description = "Calculate e raised to the power of a number (exponential)")
    public String exponential(
            @ToolParam(description = "Exponent to raise e to") double exponent) {
        double result = Math.exp(exponent);
        return String.format("e ^ %.2f = %.6f", exponent, result);
    }

    // ─────────────────────────────────────────────
    //  TRIGONOMETRY (angle in degrees)
    // ─────────────────────────────────────────────

    @Tool(description = "Calculate sine of an angle in degrees")
    public String sine(
            @ToolParam(description = "Angle in degrees") double degrees) {
        double result = Math.sin(Math.toRadians(degrees));
        return String.format("sin(%.2f°) = %.6f", degrees, result);
    }

    @Tool(description = "Calculate cosine of an angle in degrees")
    public String cosine(
            @ToolParam(description = "Angle in degrees") double degrees) {
        double result = Math.cos(Math.toRadians(degrees));
        return String.format("cos(%.2f°) = %.6f", degrees, result);
    }

    @Tool(description = "Calculate tangent of an angle in degrees")
    public String tangent(
            @ToolParam(description = "Angle in degrees") double degrees) {
        double result = Math.tan(Math.toRadians(degrees));
        return String.format("tan(%.2f°) = %.6f", degrees, result);
    }

    // ─────────────────────────────────────────────
    //  ROUNDING & ABSOLUTE VALUE
    // ─────────────────────────────────────────────

    @Tool(description = "Round a number to a specified number of decimal places")
    public String round(
            @ToolParam(description = "Number to round") double number,
            @ToolParam(description = "Number of decimal places to round to") int decimalPlaces) {
        double factor = Math.pow(10, decimalPlaces);
        double result = Math.round(number * factor) / factor;
        return String.format("round(%.6f, %d) = %." + decimalPlaces + "f", number, decimalPlaces, result);
    }

    @Tool(description = "Get the absolute value of a number (remove negative sign)")
    public String absoluteValue(
            @ToolParam(description = "Number to get the absolute value of") double number) {
        double result = Math.abs(number);
        return String.format("|%.2f| = %.2f", number, result);
    }

    @Tool(description = "Get the floor of a number (round down to nearest integer)")
    public String floor(
            @ToolParam(description = "Number to floor") double number) {
        double result = Math.floor(number);
        return String.format("floor(%.2f) = %.0f", number, result);
    }

    @Tool(description = "Get the ceiling of a number (round up to nearest integer)")
    public String ceiling(
            @ToolParam(description = "Number to ceil") double number) {
        double result = Math.ceil(number);
        return String.format("ceil(%.2f) = %.0f", number, result);
    }

    // ─────────────────────────────────────────────
    //  FACTORIAL & NUMBER THEORY
    // ─────────────────────────────────────────────

    @Tool(description = "Calculate the factorial of a non-negative integer (e.g. 5! = 120)")
    public String factorial(
            @ToolParam(description = "Non-negative integer to calculate factorial of (max 20)") int number) {
        if (number < 0)  return "Error: Factorial is not defined for negative numbers!";
        if (number > 20) return "Error: Number too large! Maximum is 20.";
        long result = 1;
        for (int i = 2; i <= number; i++) result *= i;
        return String.format("%d! = %d", number, result);
    }

    @Tool(description = "Check if a number is prime (divisible only by 1 and itself)")
    public String isPrime(
            @ToolParam(description = "Integer to check if it is prime") int number) {
        if (number < 2) return number + " is NOT a prime number.";
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0)
                return number + " is NOT a prime number. (divisible by " + i + ")";
        }
        return number + " IS a prime number! ✅";
    }

    @Tool(description = "Find the Greatest Common Divisor (GCD) of two integers")
    public String gcd(
            @ToolParam(description = "First integer") int a,
            @ToolParam(description = "Second integer") int b) {
        int x = Math.abs(a), y = Math.abs(b);
        while (y != 0) { int t = y; y = x % y; x = t; }
        return String.format("GCD(%d, %d) = %d", a, b, x);
    }

    @Tool(description = "Find the Least Common Multiple (LCM) of two integers")
    public String lcm(
            @ToolParam(description = "First integer") int a,
            @ToolParam(description = "Second integer") int b) {
        int x = Math.abs(a), y = Math.abs(b);
        int gcdVal = x;
        int tempY = y;
        while (tempY != 0) { int t = tempY; tempY = gcdVal % tempY; gcdVal = t; }
        long result = (long) x / gcdVal * y;
        return String.format("LCM(%d, %d) = %d", a, b, result);
    }

    // ─────────────────────────────────────────────
    //  AREA & GEOMETRY
    // ─────────────────────────────────────────────

    @Tool(description = "Calculate area of a circle given its radius")
    public String circleArea(
            @ToolParam(description = "Radius of the circle") double radius) {
        if (radius < 0) return "Error: Radius cannot be negative!";
        double result = Math.PI * radius * radius;
        return String.format("Area of circle (r=%.2f) = %.4f", radius, result);
    }

    @Tool(description = "Calculate area of a rectangle given width and height")
    public String rectangleArea(
            @ToolParam(description = "Width of the rectangle") double width,
            @ToolParam(description = "Height of the rectangle") double height) {
        double result = width * height;
        return String.format("Area of rectangle (%.2f × %.2f) = %.2f", width, height, result);
    }

    @Tool(description = "Calculate area of a triangle given base and height")
    public String triangleArea(
            @ToolParam(description = "Base of the triangle") double base,
            @ToolParam(description = "Height of the triangle") double height) {
        double result = 0.5 * base * height;
        return String.format("Area of triangle (base=%.2f, height=%.2f) = %.2f", base, height, result);
    }

    // ─────────────────────────────────────────────
    //  FINANCE HELPERS
    // ─────────────────────────────────────────────

    @Tool(description = "Calculate simple interest (SI = Principal × Rate × Time / 100)")
    public String simpleInterest(
            @ToolParam(description = "Principal amount") double principal,
            @ToolParam(description = "Annual interest rate in percent (e.g. 5 for 5%)") double rate,
            @ToolParam(description = "Time period in years") double years) {
        double si = (principal * rate * years) / 100.0;
        double total = principal + si;
        return String.format("Principal: %.2f | Rate: %.2f%% | Time: %.1f yrs\nSimple Interest: %.2f | Total Amount: %.2f",
                principal, rate, years, si, total);
    }

    @Tool(description = "Calculate compound interest")
    public String compoundInterest(
            @ToolParam(description = "Principal amount") double principal,
            @ToolParam(description = "Annual interest rate in percent (e.g. 5 for 5%)") double rate,
            @ToolParam(description = "Time period in years") double years,
            @ToolParam(description = "Number of times interest compounds per year (e.g. 12 for monthly)") int n) {
        double amount = principal * Math.pow(1 + (rate / 100.0) / n, n * years);
        double ci = amount - principal;
        return String.format("Principal: %.2f | Rate: %.2f%% | Time: %.1f yrs | Compounded: %d/yr\nCompound Interest: %.2f | Total Amount: %.2f",
                principal, rate, years, n, ci, amount);
    }
}

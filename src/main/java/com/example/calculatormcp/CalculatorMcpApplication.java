package com.example.calculatormcp;

import com.example.calculatormcp.tool.CalculatorTool;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CalculatorMcpApplication {

    public static void main(String[] args) {
        SpringApplication.run(CalculatorMcpApplication.class, args);
    }

    /**
     * Register all @Tool methods from CalculatorTool so Claude can discover them.
     */
    @Bean
    public ToolCallbackProvider calculatorTools(CalculatorTool calculatorTool) {
        return MethodToolCallbackProvider.builder()
                .toolObjects(calculatorTool)
                .build();
    }
}

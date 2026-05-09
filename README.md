# Calculator MCP Server
### Spring Boot + Spring AI → Claude Desktop

A complete calculator MCP server with 25+ math operations.
Ask Claude in plain English — it picks the right tool automatically!

---

## All Available Tools

### Basic Operations
| Ask Claude | Tool |
|---|---|
| "Add 25 and 37" | `add` |
| "Subtract 100 from 250" | `subtract` |
| "Multiply 12 by 15" | `multiply` |
| "Divide 144 by 12" | `divide` |
| "What is 17 mod 5?" | `modulo` |

### Power & Roots
| Ask Claude | Tool |
|---|---|
| "2 to the power of 10" | `power` |
| "Square root of 144" | `squareRoot` |
| "Cube root of 27" | `cubeRoot` |
| "4th root of 256" | `nthRoot` |

### Percentage
| Ask Claude | Tool |
|---|---|
| "What is 18% of 500?" | `percentage` |
| "50 is what percent of 200?" | `percentageOf` |
| "Percentage change from 80 to 100" | `percentageChange` |

### Logarithm & Exponential
| Ask Claude | Tool |
|---|---|
| "Natural log of 100" | `naturalLog` |
| "Log base 10 of 1000" | `log10` |
| "e to the power of 3" | `exponential` |

### Trigonometry
| Ask Claude | Tool |
|---|---|
| "Sine of 45 degrees" | `sine` |
| "Cosine of 60 degrees" | `cosine` |
| "Tangent of 30 degrees" | `tangent` |

### Rounding & Absolute
| Ask Claude | Tool |
|---|---|
| "Round 3.14159 to 2 decimal places" | `round` |
| "Absolute value of -42" | `absoluteValue` |
| "Floor of 4.9" | `floor` |
| "Ceiling of 4.1" | `ceiling` |

### Number Theory
| Ask Claude | Tool |
|---|---|
| "Factorial of 7" | `factorial` |
| "Is 97 a prime number?" | `isPrime` |
| "GCD of 48 and 18" | `gcd` |
| "LCM of 4 and 6" | `lcm` |

### Geometry
| Ask Claude | Tool |
|---|---|
| "Area of circle with radius 7" | `circleArea` |
| "Area of rectangle 10 by 5" | `rectangleArea` |
| "Area of triangle base 8 height 6" | `triangleArea` |

### Finance
| Ask Claude | Tool |
|---|---|
| "Simple interest: 10000 at 8% for 3 years" | `simpleInterest` |
| "Compound interest: 50000 at 6% for 5 years monthly" | `compoundInterest` |

---

## Build

```cmd
cd calculator-mcp
mvn clean package -DskipTests
```

JAR: `target/calculator-mcp-1.0.0.jar`

---

## Claude Desktop Config

```json
{
  "mcpServers": {
    "calculator-mcp": {
      "command": "java",
      "args": [
        "-jar",
        "C:\\Users\\vindh\\Downloads\\calculator-mcp\\target\\calculator-mcp-1.0.0.jar"
      ]
    }
  }
}
```

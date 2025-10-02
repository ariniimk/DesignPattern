# Design Patterns Demo Java Project

This project demonstrates **six different software design patterns** in Java.  
It includes:
- 2 Behavioral patterns
- 2 Creational patterns
- 2 Structural patterns

## Project Structure
```
DesignPatterns_Demo_Java_Project/
│
├── behavioral/
│   ├── observer/
│   │   └── Main.java
│   └── strategy/
│       └── Main.java
│
├── creational/
│   ├── factory/
│   │   └── Main.java
│   └── singleton/
│       └── Main.java
│
├── structural/
│   ├── adapter/
│   │   └── Main.java
│   └── decorator/
│       └── Main.java
│
└── README.md
```

## How to Run
1. Unzip the project.
2. Open the folder in your favorite IDE (IntelliJ IDEA / Eclipse / VS Code).
3. Navigate to one of the pattern folders (e.g., `behavioral/observer/`).
4. Open `Main.java` and run it.

## Expected Outputs (Sample)
- **Observer Pattern**: Displays weather station updates for phone and TV display.
- **Strategy Pattern**: Displays different payment strategies (Credit Card, PayPal).
- **Factory Pattern**: Creates different shapes like Circle and Square.
- **Singleton Pattern**: Shows same instance used multiple times.
- **Adapter Pattern**: Media player plays MP3 and MP4 files via adapter.
- **Decorator Pattern**: Coffee cost and description changes with add-ons.

## Notes
- No infinite loops (`while(true)`) are used.
- Code follows Java best practices: separate classes, logging, and validations.
- Demonstrates defensive programming and extendability.


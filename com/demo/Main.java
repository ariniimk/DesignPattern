package com.demo;

import com.demo.behavioural.observer.ObserverDemo;
import com.demo.behavioural.strategy.StrategyDemo;
import com.demo.creational.factory.FactoryDemo;
import com.demo.creational.singleton.BuilderDemo;
import com.demo.structural.adapter.AdapterDemo;
import com.demo.structural.facade.FacadeDemo;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        logger.info("Starting DesignPatterns Demo Application");
        AtomicBoolean running = new AtomicBoolean(true);
        Scanner scanner = new Scanner(System.in);

        while (running.get()) {
            try {
                System.out.println("\n--- Design Patterns Demos ---");
                System.out.println("1) Behavioural: Observer");
                System.out.println("2) Behavioural: Strategy");
                System.out.println("3) Creational: Factory Method");
                System.out.println("4) Creational: Singleton + Builder");
                System.out.println("5) Structural: Adapter");
                System.out.println("6) Structural: Facade");
                System.out.println("7) Exit");
                System.out.print("Choose an option: ");

                String input = scanner.nextLine();
                if (input == null) continue;
                input = input.trim();
                switch (input) {
                    case "1": ObserverDemo.runDemo(); break;
                    case "2": StrategyDemo.runDemo(); break;
                    case "3": FactoryDemo.runDemo(); break;
                    case "4": BuilderDemo.runDemo(); break;
                    case "5": AdapterDemo.runDemo(); break;
                    case "6": FacadeDemo.runDemo(); break;
                    case "7": running.set(false); break;
                    default: System.out.println("Invalid option. Try again.");
                }
            } catch (Exception e) {
                logger.log(Level.SEVERE, "Unhandled exception in main loop", e);
            }
        }

        System.out.println("Application exiting. Goodbye!");
        scanner.close();
        logger.info("DesignPatterns Demo Application stopped");
    }
}

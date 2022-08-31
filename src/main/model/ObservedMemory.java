package main.model;

@FunctionalInterface
public interface ObservedMemory {
    void alteredValue(String newValue);
}
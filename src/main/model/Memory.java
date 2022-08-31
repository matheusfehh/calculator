package main.model;

import java.util.ArrayList;
import java.util.List;

public class Memory {
    
    private enum CommandType {
        RESET, NUMBER, DIVISION, MULTIPLICATION, ADDITION, SUBTRACTION, EQUAL, POINT;
    }

    private static final Memory memory = new Memory();
    private final List<ObservedMemory> observers = new ArrayList<>();

    private CommandType lastOperation = null;
    private boolean replace;
    private String currentText = "";
    private String bufferText = "";

    private Memory() {
        
    }

    public static Memory getMemory() {
        return memory;
    }

    public void addObservers(ObservedMemory observer) {
        observers.add(observer);
    }

    public String getCurrentText() {
        return currentText.isEmpty() ? "0" : currentText;
    }

    public void commandProcess(String value) {

        CommandType commandType = detectCommandType(value);

        try {
            
            if (commandType == null) {
                return;
            } else if (commandType == CommandType.RESET) {
                currentText = "";
                bufferText = "";
                replace = false;
                lastOperation = null;
            } else if (commandType == CommandType.NUMBER || commandType == CommandType.POINT) {
                currentText = replace ? value : currentText + value;
                replace = false;
            } else {
                replace = true;
                currentText = getResult();
                bufferText = currentText;
                lastOperation = commandType;
            }

        } catch (NumberFormatException e) {
            replace = true;
            currentText = "Impossível";
            bufferText = "";
            lastOperation = commandType;
        }

    }

    private String getResult() {
		if (lastOperation == null || lastOperation == CommandType.EQUAL) {
			return currentText;
		}
		
		double bufferNumber = Double.parseDouble(bufferText.replace(",", "."));
		double currentNumber = Double.parseDouble(currentText.replace(",", "."));
		
		double result = 0;
		if (lastOperation == CommandType.ADDITION) {
			result = bufferNumber + currentNumber;
		} else if (lastOperation == CommandType.DIVISION) {
			result = bufferNumber / currentNumber;
		}  else if (lastOperation == CommandType.SUBTRACTION) {
			result = bufferNumber - currentNumber;
		} else if (lastOperation == CommandType.MULTIPLICATION) {
			result = bufferNumber * currentNumber;
		}
		
		String stringResult = Double.toString(result).replace(".", ",");
		boolean number = stringResult.endsWith(",0");
		return number ? stringResult.replace(",0", "") : stringResult;
	}

    private CommandType detectCommandType(String value) {

        if (currentText.isEmpty() && value == "0") {
            return null;
        }

        try {
            Integer.parseInt(value);
            return CommandType.NUMBER;
        } catch (NumberFormatException e) {
            if ("AC".equals(value)) {
                return CommandType.RESET;
            } else if ("/".equals(value)) {
                return CommandType.DIVISION;
            } else if ("x".equals(value)) {
                return CommandType.MULTIPLICATION;
            } else if ("+".equals(value)) {
                return CommandType.ADDITION;
            } else if ("-".equals(value)) {
                return CommandType.SUBTRACTION;
            } else if ("=".equals(value)) {
                return CommandType.EQUAL;
            } else if (",".equals(value) && !currentText.contains(",")) {
                return CommandType.POINT;
            } else {
                return null;    
            }
        }

    }

}
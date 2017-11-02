import java.util.ArrayList;

public class Calculator
{

    public ArrayList<Double> operands;
    public ArrayList<Character> operators;

    public Calculator()
    {
        operands = new ArrayList<>();
        operators = new ArrayList<>();
    }

    public void performOperation(double operand)
    {
        operands.add(operand);
    }

    public void performOperation(String operator)
    {
        performOperation(operator.substring(0, 1));
    }

    public void performOperation(char operator)
    {
        if(operator != '+' && operator != '-' && operator != '*' && operator != '/' && operator != '%' && operator != '=')
        {
            throw new IllegalArgumentException("Invalid operator");
        }
        operators.add(operator);
    }

    public String getOperations()
    {
        if (operators.size() != operands.size() - 1 && operators.get(operators.size() - 1) != '=')
        {
            if (operators.size() < operands.size())
            {
                return "Imbalanced operations: Too many operators!1";
            } else
            {
                return "Imbalanced operations: Too many operands!1";
            }
        }
        else if(operators.size() != operands.size() && operators.get(operators.size() - 1) == '=')
        {
            if (operators.size() < operands.size())
            {
                return "Imbalanced operations: Too many operators!2";
            } else
            {
                return "Imbalanced operations: Too many operands!2";
            }
        }

        String ops = "";
        for (int i = 0; i < operators.size(); i++)
        {
            ops += operands.get(i);
            ops += " ";
            ops += operators.get(i);
            ops += " ";
        }
        if (operators.get(operators.size() - 1) != '=')
        {
            ops += operands.get(operands.size() - 1);
        }
        return ops;
    }

    public double getResults()
    {
        boolean broken = false;
        for(int i = 0; i < operators.size() && i < operands.size() - 1 && !broken; i++)
        {
            switch(operators.get(i))
            {
            case '*':
                operands.set(i, operands.get(i) * operands.get(i + 1));
                break;
            case '/':
                operands.set(i, operands.get(i) / operands.get(i + 1));
                break;
            case '%':
                operands.set(i, operands.get(i) % operands.get(i + 1));
                break;
            case '=':
                broken = true;
                break;
            }
        }
        for(int i = 0; i < operators.size() && i < operands.size() - 1 && !broken; i++)
        {
            switch(operators.get(i))
            {
            case '+':
                operands.set(i, operands.get(i) + operands.get(i + 1));
                break;
            case '-':
                operands.set(i, operands.get(i) - operands.get(i + 1));
                break;
            case '=':
                broken = true;
                break;
            }
        }
        double results = operands.get(0);
        operands.clear();
        operators.clear();
        return results;
        
    }

}

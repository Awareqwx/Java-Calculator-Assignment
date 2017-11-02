
public class CalculatorTest
{

    public static void arrPrint(Object[] arr)
    {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++)
        {
            System.out.print(arr[i]);
            if (i + 1 < arr.length)
            {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
    
    public static void main(String[] args)
    {
        Calculator c = new Calculator();
        c.performOperation(10.5);
        c.performOperation('+');
        c.performOperation(5.2);
        c.performOperation('*');
        c.performOperation(10);
        c.performOperation('=');
        System.out.println(c.getOperations());
        arrPrint(c.operands.toArray());
        arrPrint(c.operators.toArray());
        System.out.println(c.getResults());
    }

}

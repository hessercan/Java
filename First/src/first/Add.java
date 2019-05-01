/*
 * Mark Hesser
 * HesserCAN 
 * mark@hessercan.com
 * www.hessercan.com
 */
package first;

/**
 * @author mark
 */
public class Add {
    double num1;
    double num2;
    double sum;
    
    public Add(){
        
    }
    
    public Add(double a, double b) {
        num1 = a;
        num2 = b;
    }
    public Add(float a, float b) {
        num1 = a;
        num2 = b;
    }
    public String getSum() {
        sum = num1 + num2;
        String result = String.format("The sum of %.2f and %.2f is %.2f", num1, num2, sum);
        return result;
    }
}

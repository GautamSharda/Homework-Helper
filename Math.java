public class Mathematics{
    public String getGreeting(){
        return "Welcome to the math section";
    }
    public String Quadratic (double a, double b, double c){
        double m = (Math.pow(b,2))-(4*a*c);
        double quad = ((-1*b) + (Math.pow(m,(1/2))));
        double quadneg = (quad*-1);
        return "One solution is " + quad + " And the other one is " + quadneg;
    }
    public String Linear (double a, double b) {
        double linear = a+b;
        return "The value of y is " + linear;
    }
    public String trigfunctions (double a, double b){
        double numerator = a * Math.PI;
        double denominator = b;
        double sine = Math.round(Math.sin(numerator/denominator)*100.0)/100.0;
        double cosine = Math.round(Math.cos(numerator/denominator)*100.0)/100.0;
        double tangent = Math.round(Math.tan(numerator/denominator)*100.0)/100.0;
        double cosecant = Math.round(1/sine*100.0)/100.0;
        double secant = Math.round(1/cosine*100.0)/100.0;
        double cotangent = Math.round(1/tangent*100.0)/100.0;
        return "Sine: " + sine + " Cosine: " + cosine + " Tangent: " + tangent + " Cosecant: " + cosecant + " Secant: " + secant + " Cotangent: " + cotangent;
    }
    public String doubleangleSine (double a, double b){
        double numerator = a * Math.PI;
        double denominator = b;
        double x = numerator/denominator;
        double doubleAngle = Math.round(2*Math.sin(x)*Math.cos(x)*100.0)/100.0;
        return "The double angle for sine is " + doubleAngle;
    }
    public String doubleangleCosine (double a, double b){
        double numerator = a * Math.PI;
        double denominator = b;
        double x = numerator/denominator;
        double doubleAngle = Math.round(Math.pow(Math.cos(x),2)-(Math.pow(Math.sin(x),2)*100.0))/100.0;
        return "The double angle for cosine is " + doubleAngle;
    }
    public String doubleangleTangent (double a, double b){
        double numerator = a * Math.PI;
        double denominator = b;
        double x = numerator/denominator;
        double doubleAngle = Math.round(2*Math.tan(x)/(1-Math.pow(Math.tan(x),2)));
        return "The double angle for tangent is " + doubleAngle; 
    }
}
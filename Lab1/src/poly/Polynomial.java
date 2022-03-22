package poly;

public class Polynomial {
    
    //properties
    
    private double[] coeffs;
    
    private int degree;
    
    /**
     * polynomial constructor
     * gives default values to object if there is no value as a parameter
    */
    
    public Polynomial(){
        
        degree = 0;
        
        coeffs = new double[1];
        
        coeffs [0] = degree;
        
        
    }
    
    /**
     * 2nd polynomial constructor
     * to create polynomial image as cx^y with given values 
    */
    
    public Polynomial(int x, double y){
        
        degree = x;
        
        coeffs = new double[degree+1];
        
        coeffs[x] = y;
        
    }
    
    /**
     * 3rd polynomial constructor
     * to use given array as a coefficients 
     * and set degree of a polynomial
    */
    
    
    public Polynomial(double [] x){
        
        for(int i = 0; i<x.length;i++){
            
            if(x[i] != 0) degree = i;
        }
        
        coeffs = x;
        
        
    }
    /**
     * getDegree method
     * to get degree of polynomial 
     * from coeffs property of object
    */
    
    public int getDegree(){
        
        return coeffs.length-1;
        
    }
    
    /**
     * getter
     * gets coefficient of given parameter(which represents wanted degree)
    */
    
    public double getter(int x){
        
        if(coeffs.length>x) return coeffs[x];
        
        else return 0;
    }
    
    /**
     * eval method 
     * to evaluate polynomial with given x value 
    */
    
    public double eval(double x){
        
        double sum1 = 0;
        
        for(int i = 0; i<coeffs.length;i++){
            
            sum1 += Math.pow(x, i)*coeffs[i];
            
        }
        
        return sum1;
    }
    
    /**
     *eval2 method 
     * evaluates polynomial with Horner's method 
     * @param double to evaluate
     * @return final value
    */
    
    public double eval2(double x){
        
        double sum2 = coeffs[degree];
        
        for(int i = degree; i>0; i--){
            
            sum2 = coeffs[i-1] + x*sum2;
            
        }
        
        return sum2;
    }
    
    /**
     * adding method
     * @param polynomial to add 
     * @return the result of addititon
    */
    
    public Polynomial add(Polynomial p2){
        
        int max = Math.max(this.degree, p2.degree);
        
        double[] coeffssum = new double [max+1];
        
        for(int i = 0; i<=max ; i++){
            
            if(i> p2.degree && i<= this.degree) coeffssum[i] = this.coeffs[i];
            
            else if(i > this.degree && i <= p2.degree) coeffssum[i] = p2.coeffs[i];
            
            else coeffssum [i] = this.coeffs[i] + p2.coeffs[i];
            
            
        }
        
        return new Polynomial(coeffssum);
        
    }
    /**
     * substracitng method
     * @param polynomial to substract
     * @return result of substraction
    */
    
    public Polynomial sub(Polynomial p2){
        
        
        int max = Math.max(this.degree, p2.degree);
        
        double[] coeffssum = new double [max+1];
        
        for(int i = 0; i<=max ; i++){
            
            if(i> p2.degree && i<= this.degree) coeffssum[i] = this.coeffs[i];
            
            else if(i > this.degree && i <= p2.degree) coeffssum[i] = -p2.coeffs[i];
            
            else coeffssum [i] = this.coeffs[i] - p2.coeffs[i];
            
            
        }
        
        return new Polynomial(coeffssum);
        
        }
        
    /**
     * multiplication method
     * with two for loop to multipliy all terms 
     * @param polynomial to multiply
     * @return result of multiplication
    */
    
    public Polynomial mult(Polynomial p2) {
            
        Polynomial poly = new Polynomial(this.degree + p2.degree , 0);
            
            
        for (int i = 0; i <= this.degree; i++)
               
            
            for (int j = 0; j <= p2.degree; j++)
                    
                poly.coeffs[i+j] += (this.coeffs[i] * p2.coeffs[j]);
            
            return poly;
        }
    
    /**
     * leadingterm
     * to find leading term
    */
    
    public void leadingterm(){
                
        for(int i = coeffs.length-1; i>=0;i--){
            
            if(coeffs[i] != 0){
                
                degree = i;
                
                break;
                
            }
        }
    }
        
    /**
     * division method
     * @param polynomial to divide
     * @return result of the divison
     *  given pseudo code is used 
    */
    
    public Polynomial div(Polynomial p2){
        
        //Polynomial poly2 = new Polynomial(this.degree-p2.degree, 0 );
        
        double [] coeffsdiv = new double [this.degree+1];
        Polynomial px = this;
        Polynomial tx;
        
        while(px.degree >= p2.degree){
            
            px.leadingterm();
            p2.leadingterm();
            tx = new Polynomial (px.degree-p2.degree, px.coeffs[px.degree] / p2.coeffs[p2.degree]);
            //tx.coeffs[px.degree-p2.degree] = px.coeffs[px.degree] / p2.coeffs[p2.degree];
            //px = px.sub(p2.mult(tx));
            coeffsdiv[px.degree-p2.degree] = px.coeffs[px.degree] / p2.coeffs[p2.degree];
            px = px.sub(p2.mult(tx));
        }
        
       return new Polynomial(coeffsdiv) ;
    }
    
    /**
     * composing method
     * @param polynomial
     * @return result of the composition of two polynomials
     * creates new polynomial for each turns of for loop
     * then uses multiplication method to calculate
     * after it assisgnes value to composed polynomial until for loop ends
    */
    
    public Polynomial compose(Polynomial p2) {
        
        Polynomial composed = new Polynomial(0, 0);
        
        for (int i = this.degree; i >= 0; i--) {
            
            Polynomial composing = new Polynomial(0 , this.coeffs[i]);
            
            composed = composing.add(p2.mult(composed));
            
        }
        
        return composed;
    
    }
        
    /**
     * tostring method 
     * to represent objects as a polynomial string
    */
    
    public String toString(){
        
        String stringver = "";
        
        if(coeffs.length == 1) return stringver += "0";
        
        for(int i = coeffs.length-1; i>=0; i--){
            
            if(coeffs [i] != 0 && i !=0){
                
                if(coeffs[i] > 0) stringver += " + " + coeffs[i] + "x^"+i+" ";
                
                else if (coeffs[i]<0) stringver +=" - "+ Math.abs(coeffs[i]) + "x^"+i+" ";
                
            }
            else if( i == 0 ){
                if(coeffs[i] > 0) stringver += " + " + coeffs[i]+" ";
                
                else if (coeffs[i]<0) stringver +=" - "+ Math.abs(coeffs[i]) +" ";
                
            }
            
            
            else continue;
        }
        
        if(coeffs[degree]>0) return stringver.substring(3);
        
        else return stringver.substring(1);

    }
    
    
    
}


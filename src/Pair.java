/**
 *
 * @author Jacek Byzdra
 * email: jacekbwwa@gmail.com
 */
public class Pair {
    
    String str1;
    String str2;
    int int1;
    int int2;
    Double dbl1;
    Double dbl2;
    
    
    public Pair(){
        
    }
    
    public Pair(String str1){
        this.str1=str1;
    }
    
    public Pair(String str1, String str2){
        this.str1=str1;
        this.str2=str2;
    }
    
    public Pair(String str1, int int1){
        this.str1=str1;
        this.int1=int1;
    }
    
    public Pair(String str1, int int1, int int2){
        this.str1=str1;
        this.int1=int1;
        this.int2=int2;
    }
    
    public Pair(int int1, int int2){
        this.int1=int1;
        this.int2=int2;
    }
    
    public Pair(Double dbl1){
        this.dbl1=dbl1;
    }
    
    public Pair(Double dbl1, Double dbl2){
        this.dbl1=dbl1;
        this.dbl2=dbl2;
    }
    
    public Pair(String str1, Double dbl1){
        this.str1=str1;
        this.dbl1=dbl1;
    }
    
    public Pair(String str1, Double dbl1, Double dbl2){
        this.str1=str1;
        this.dbl1=dbl1;
        this.dbl2=dbl2;
    }
    
    
    public String getStr1(){
        return str1;
    }
    
    public String getStr2(){
        return str2;
    }
    
    public int getInt1(){
        return int1;
    }
    
    public int getInt2(){
        return int2;
    }
    
    public Double getDbl1(){
        return dbl1;
    }
    
    public Double getDbl2(){
        return dbl2;
    }
    
    public void setInt1(int int1){
        this.int1=int1;
    }
    
    public void setInt2(int int2){
        this.int2=int2;
    }
    
    public void setStr1(String str1){
        this.str1=str1;
    }
    
    public void setStr2(String str2){
        this.str2=str2;
    }
    
    public void setDbl1(Double dbl1){
        this.dbl1=dbl1;
        
    }
    
    public void setDbl2(Double dbl2){
        this.dbl2=dbl2;
    }
    /**
 *
 * @author Jacek Byzdra
 * email: jacekbwwa@gmail.com
 */
    
}

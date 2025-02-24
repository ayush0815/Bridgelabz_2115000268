package Annotation;
import java.util.ArrayList;

public class SuppressWarningsExample {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        ArrayList list = new ArrayList(); 
        list.add("String");  
        
        for(Object obj : list) {
            System.out.println(obj);
        }
    }
}
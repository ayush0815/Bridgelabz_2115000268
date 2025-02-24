package Annotation;
class LegacyAPI {
    
    @Deprecated
    public void oldFeature() {
        System.out.println("This is the old feature, which is deprecated.");
    }
    
    public void newFeature() {
        System.out.println("This is the new and improved feature.");
    }
}


public class DeprecatedExample {
    public static void main(String[] args) {
        LegacyAPI api = new LegacyAPI();
        api.oldFeature(); 
        api.newFeature();  
    }
}
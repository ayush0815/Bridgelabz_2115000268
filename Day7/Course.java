class Course{
    private String courseName;
    private int duration;
    private float fee;

    private static String instituteName = "GLA University";

    Course(String courseName, int duration, int fee){
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }

    void displayCourseDetails(){
        System.out.println("\nCourse name is: " + courseName);
        System.out.println("Duration is: " + duration);
        System.out.println("Fee is: " + fee);
    }

    static void updateInstituteName(String name){
        instituteName = name;
        System.out.println("\nInstitute name is updated to: " + instituteName);
    }

    public static void main(String[] args){
        Course person1 = new Course("M.Tech", 2 , 178000);
        Course person2 = new Course("B.Tech", 4, 180000);

        person1.displayCourseDetails();
        person2.displayCourseDetails();

        Course.updateInstituteName("Random University");
    }

}


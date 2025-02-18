import java.util.ArrayList;
import java.util.List;
import java.util.Set;

// Abstract JobRole Class 
abstract class JobRole {
    private String roleName;
    private Set<String> requiredSkills;

    public JobRole(String roleName, Set<String> requiredSkills) {
        this.roleName = roleName;
        this.requiredSkills = requiredSkills;
    }

    public String getRoleName() {
        return roleName;
    }

    public Set<String> getRequiredSkills() {
        return requiredSkills;
    }
}
// Specific Job roles with required skills
class SoftwareEngineer extends JobRole {
    public SoftwareEngineer() {
        super("Software Engineer", Set.of("Java", "Spring Boot", "Data Structures", "OOPS"));
    }
}

class DataScientist extends JobRole {
    public DataScientist() {
        super("Data Scientist", Set.of("Python", "Machine Learning", "NLP", "Statistics"));
    }
}

class ProductManager extends JobRole {
    public ProductManager() {
        super("Product Manager", Set.of("Agile", "User Research", "Product Roadmap", "Market Analysis"));
    }
}

// Generic Resume class which processes resumes for different Job roles)
class Resume<T extends JobRole> {
    private String candidateName;
    private Set<String> candidateSkills;
    private T jobRole;

    public Resume(String candidateName, Set<String> candidateSkills, T jobRole) {
        this.candidateName = candidateName;
        this.candidateSkills = candidateSkills;
        this.jobRole = jobRole;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public Set<String> getCandidateSkills() {
        return candidateSkills;
    }

    public T getJobRole() {
        return jobRole;
    }

    public String screenResume() {
        Set<String> requiredSkills = jobRole.getRequiredSkills();
        int matchedSkills = 0;

        for (String skill : candidateSkills) {
            if (requiredSkills.contains(skill)) {
                matchedSkills++;
            }
        }

        double matchPercentage = (matchedSkills * 100.0) / requiredSkills.size();

        if (matchPercentage >= 75) {
            return "Accepted";
        } else if (matchPercentage >= 50) {
            return "Needs Review";
        } else {
            return "Rejected";
        }
    }

    @Override
    public String toString() {
        return candidateName + " applied for " + jobRole.getRoleName() +
               " | Skills: " + candidateSkills + " | Screening Result: " + screenResume();
    }
}

// Resume Screening System which handles multiple job roles using Wildcards)
class ResumeScreeningSystem {
    private List<Resume<? extends JobRole>> resumes = new ArrayList<>();

    public void addResume(Resume<? extends JobRole> resume) {
        resumes.add(resume);
    }

    public void processResumes() {
        System.out.println("Processing Resumes:");
        for (Resume<? extends JobRole> resume : resumes) {
            System.out.println(resume);
        }
    }
}
public class ResumeScreening {
    public static void main(String[] args) {
        ResumeScreeningSystem screeningSystem = new ResumeScreeningSystem();

        // Creating different job roles
        SoftwareEngineer seRole = new SoftwareEngineer();
        DataScientist dsRole = new DataScientist();
        ProductManager pmRole = new ProductManager();

        // Creating resume instances
        Resume<SoftwareEngineer> resume1 = new Resume<>("Ayush", Set.of("Java", "Spring Boot", "OOPS"), seRole);
        Resume<DataScientist> resume2 = new Resume<>("Vaibhav", Set.of("Python", "Machine Learning", "Deep Learning", "NLP"), dsRole);
        Resume<ProductManager> resume3 = new Resume<>("Aditya", Set.of("Agile", "Market Analysis"), pmRole);
        Resume<SoftwareEngineer> resume4 = new Resume<>("Aviral", Set.of("C++", "React"), seRole);

        // Adding resumes to screening system
        screeningSystem.addResume(resume1);
        screeningSystem.addResume(resume2);
        screeningSystem.addResume(resume3);
        screeningSystem.addResume(resume4);

        // Processing all resumes
        screeningSystem.processResumes();
    }
}

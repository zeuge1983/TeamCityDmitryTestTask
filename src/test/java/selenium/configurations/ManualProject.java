package selenium.configurations;

public enum ManualProject {

    NEW_MANUAL_PROJECT_DATA(
            "TC project",
            "Project_123",
            "TC manual project"
    );

    private final String name;
    private final String projectId;
    private final String description;

    ManualProject(String name, String projectId, String description) {
        this.name = name;
        this.projectId = projectId;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getProjectId() {
        return projectId;
    }

    public String getDescription() {
        return description;
    }
}
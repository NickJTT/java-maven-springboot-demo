package mavenspringboot.demo.projects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import org.springframework.stereotype.Service;

@Service
public class ProjectService {
  private List<Project> projects = new ArrayList<>(Arrays.asList(
    new Project("Java", "Java Project", "Java Description"),
    new Project("Maven", "Maven Project", "Maven Description"),
    new Project("Spring", "Spring Project", "Spring Description")
  ));

  public List<Project> getProjects() {
    return this.projects;
  }

  public Project getProject(String id) {
    return this.projects.stream().filter(project -> project.getId().equals(id)).findFirst().get();
  }

  public void createProject(Project project) {
    this.projects.add(project);
  }

  public void updateProject(String id, Project project) {
    IntStream.range(0, this.projects.size())
      .filter(i -> this.projects.get(i).getId().equals(id))
      .findFirst()
      .ifPresent(i -> projects.set(i, project));
  }

  public void deleteProject(String id) {
    projects.removeIf(project -> project.getId().equals(id));
  }
}

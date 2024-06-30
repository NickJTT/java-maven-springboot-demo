package mavenspringboot.demo.projects;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProjectsController {
  @Autowired
  private ProjectService projectService;

  @RequestMapping(method=RequestMethod.GET, value="/projects")
  public List<Project> getProjects() {
    return projectService.getProjects();
  }

  @RequestMapping(method=RequestMethod.GET, value="/project/{id}")
  public Project getProject(@PathVariable("id") String id) {
    return projectService.getProject(id);
  }

  @RequestMapping(method=RequestMethod.POST, value="/projects")
  public void createProject(@RequestBody Project project) {
    this.projectService.createProject(project);
  }

  @RequestMapping(method=RequestMethod.PUT, value="/projects/{id}")
  public void updateProject(@PathVariable("id") String id, @RequestBody Project project) {
    this.projectService.updateProject(id, project);
  }

  @RequestMapping(method=RequestMethod.DELETE, value="/projects/{id}")
  public void deleteProject(@PathVariable("id") String id) {
    this.projectService.deleteProject(id);
  }
}

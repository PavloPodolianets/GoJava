package kickstarter.dao.defaultServices;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kickstarter.dao.interfaces.iDAO;
import kickstarter.dao.interfaces.iProjectService;
import kickstarter.entity.Project;

public class DefaultProjectService implements iProjectService {
	List<Project> projects;

	public DefaultProjectService() {
		projects = new ArrayList<Project>();
		int categoryID = 5;

		Project project = new Project();
		project.setCategoryID(categoryID);
		project.setName("Create electrobike");
		project.setDescription("high efficiency");
		project.setShortDescription("short description");
		project.setHistory("history of bike creation");
		project.setLinkToVideo("www.link.to.demo.video");
		project.setPledged(25);
		project.setGoal(2000);
		project.setID(23);
		project.setInvestmentOptions(new String[] { "1$ - ", "10$ -", "40$ -" });
		project.setAmount(new Double[] { (double) 1, (double) 10, (double) 40 });
		projects.add(project);

		categoryID = 4;
		project = new Project();
		project.setCategoryID(categoryID);
		project.setName("Paint the fence of the school");
		project.setDescription("raising money for paint");
		project.setInvestmentOptions(new String[] { "1$ - ", "10$ -", "40$ -" });
		project.setAmount(new Double[] { (double) 1, (double) 10, (double) 40 });
		project.setID(8);
		projects.add(project);

		categoryID = 4;
		project = new Project();
		project.setCategoryID(categoryID);
		project.setName("Help Build ACRE,s New Home in Chicago");
		project.setDescription("The renovation of our new space and expansion of our Chicago programming!");
		project.setShortDescription("Help ACRE achieve our most ambitious project to date");
		project.setInvestmentOptions(new String[] { "100$ - ", "150$ -",
				"400$ -" });
		project.setAmount(new Double[] { (double) 100, (double) 150, (double) 400 });
		project.setPledged(5000);
		project.setGoal(10000);
		project.setID(1);
		projects.add(project);

		categoryID = 5;
		project = new Project();
		project.setCategoryID(categoryID);
		project.setName("Microduino mCookie");
		project.setDescription("Small, stackable, Arduino-compatible electronics for makers, designers, engineers, students and curious tinkerers of all ages.");
		project.setShortDescription("The smallest electronic modules on LEGO");
		project.setHistory("history of Microduino mCookie");
		project.setLinkToVideo("https://www.microduino.cc/module/view?id=53da0abdc69eee000055f55d");
		project.setPledged(205);
		project.setGoal(20000);
		project.setID(20);
		project.setInvestmentOptions(new String[] { "10$ - ", "20$ -", "100$ -" });
		project.setAmount(new Double[] { (double) 10, (double) 20, (double) 100 });
		projects.add(project);
	}

	@Override
	public int getProjectsLength() {
		return projects.size();
	}

	@Override
	public Project getProjectById(int ID) {
		int length = projects.size();
		for (int index = 0; index < length; index++) {
			Project currentProject = (Project) projects.get(index);
			if (currentProject.getID() == ID) {
				return currentProject;
			}
		}
		return null;
	}

	@Override
	public List<Project> getAll() {
		return projects;
	}

	@Override
	public void createProjects(iDAO interfaceDAO)
			throws SQLException {
		// TODO Auto-generated method stub
	}

	@Override
	public List<Project> sortProjectsByCategoryID(int categoryID)  {
			List<Project> sortedProjects = new ArrayList<Project>();
			int length = projects.size();
			for (int index = 0; index < length; index++) {
			Project	project = projects.get(index);
				if (project.getCategoryID() == categoryID) {
					sortedProjects.add(project);
				}
			}
			return sortedProjects;
		}

	@Override
	public void updateProject(Project project) {
		// TODO Auto-generated method stub
		
	}
}

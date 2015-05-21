package kickstarter.pages.view;

import kickstarter.entities.Project;
import kickstarter.mvc.interfaces.iModel;
import kickstarter.mvc.options.ModelOptions;
import kickstarter.mvc.options.ViewOptions;
import kickstarter.repository.EntityStorage;
import kickstarter.repository.ProjectRepository;
import kickstarter.repository.iStorage;

public class Projects extends PageView {

	public Projects(ProjectRepository projects, iModel imodel) {
		this.projects = projects;
		this.imodel = imodel;
	}

	public iStorage<Project> sortProjectsByCategoryID(int categoryID) {

		iStorage<Project> sortedProjects = new EntityStorage<Project>();
		int length = projects.getProjectsLength();
		for (int index = 0; index < length; index++) {
			Project project = projects.getProject(index);
			if (project.categoryID == categoryID) {
				sortedProjects.add(project);
			}
		}
		return sortedProjects;
	}

	public String printProjectsInfo(int categoryID) {
		String result = "";
		iStorage<Project> sortedToSelect = sortProjectsByCategoryID(categoryID);
		int length = sortedToSelect.length();
		strOptions = new String[length];
		intOptions = new int[length];
		for (int index = 0; index < length; index++) {
			Project project = sortedToSelect.getEntity(index);

			strOptions[index] = Integer.toString(project.ID);
			intOptions[index] = project.ID;

			result += ("ID:<" + project.ID + "> name:<" + project.name
					+ "> short desc.:<" + project.shortDescription + "> goal:<"
					+ project.goal + "> pledged:<" + project.pledged
					+ "> days to go:<" + project.daysToGo + ">");
		}
		ViewOptions vo = imodel.getViewOptions();
		vo.intProjects = intOptions;
		vo.strProjects = strOptions;

		return result;
	}

	public String getHeader() {

		String header = "";
		header += "\n________________________";
		header += "\n|     Projects         |";
		header += "\n|______________________|";
		header += "\n";
		ModelOptions mo = imodel.getModelOptions();
		int categogyID = mo.intSelectedCategory;
		header += printProjectsInfo(categogyID);
		header += "\n------------------------";
		header += "\nSelect project by ID:<ID>";
		header += "\nOptions:  <p> - previous page";
		return header;
	}

}
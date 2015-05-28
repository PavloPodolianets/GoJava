package com.goit.kickstarter.glmax.pages;

import java.util.ArrayList;

import com.goit.kickstarter.glmax.controller.Kickstarter;
import com.goit.kickstarter.glmax.enteties.Project;
import com.goit.kickstarter.glmax.model.DataSource;

public class CategoryPage implements Page {
	private DataSource dataSource = Kickstarter.getDataSource();
	private String categoryName;
	private ArrayList<Project> projects;
	private ArrayList<String> page = new ArrayList<String>();

	public CategoryPage(int categoryIndex) {
		this.categoryName = dataSource.getCategoryName(categoryIndex);
		projects = dataSource.getProjectsList(categoryIndex);
	}

	@Override
	public ArrayList<String> getPage() {
		page.add("You in category: " + categoryName);
		page.add("");
		page.add("Plese choose project from list below:");
		for (Project category : projects) {
			page.add(projects.indexOf(category)+1+") "+category.getName());
		}
		page.add("");
		page.add("0) Exit");
		return page;
	}

}
package ua.goit.kyrychok.kickstarter.dao;

import ua.goit.kyrychok.kickstarter.model.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.String.format;
import static org.apache.commons.lang3.time.DateUtils.*;
import static ua.goit.kyrychok.kickstarter.Utils.convertDate;

public class MemoryDataProvider implements DataProvider {
    private static final String WELCOME_MESSAGE = "This is HelloMessage";

    private List<Category> categories = new ArrayList<>();
    private AtomicInteger categorySequence = new AtomicInteger(10);
    private AtomicInteger projectSequence = new AtomicInteger(10);
    private AtomicInteger faqSequence = new AtomicInteger(10);
    private AtomicInteger projectEventSequence = new AtomicInteger(10);
    private AtomicInteger rewardSequence = new AtomicInteger(10);

    public static MemoryDataProvider getInstance() {
        MemoryDataProvider memoryDataProvider = new MemoryDataProvider();
        memoryDataProvider.init();
        return memoryDataProvider;
    }

    @Override
    public String getWelcomeMessage() {
        return WELCOME_MESSAGE;
    }

    @Override
    public List<Category> getCategories() {
        return categories;
    }

    @Override
    public Category getCategory(int id) {
        for (Category category : categories) {
            if (category.getId() == id) {
                return category;
            }
        }
        throw new IndexOutOfBoundsException(format("Category with id = \"%s\" not found", id));
    }

    @Override
    public Project getProject(int id) {
        for (Category category : categories) {
            for (Project project : category.getProjects()) {
                if (project.getId() == id) {
                    return project;
                }
            }
        }
        throw new IndexOutOfBoundsException(format("Project with id = \"%s\" not found", id));
    }

    @Override
    public void addFaq(int projectId, Faq faq) {
        Project project = getProject(projectId);
        faq.setId(faqSequence.getAndIncrement());
        project.addFaq(faq);
    }

    @Override
    public List<Reward> getRewards(int projectId) {
        Project project = getProject(projectId);
        return project.getRewards();
    }

    @Override
    public void incProjectBalance(int projectId, Integer amount) {
        Project project = getProject(projectId);
        project.setBalance(project.getBalance() + amount);
    }

    @Override
    public Reward getReward(int id) {
        for (Category category : categories) {
            for (Project project : category.getProjects()) {
                for (Reward reward : project.getRewards()) {
                    if (reward.getId() == id) {
                        return reward;
                    }
                }
            }
        }
        throw new IndexOutOfBoundsException(format("Reward with id = \"%s\" not found", id));
    }

    private Category getNewCategory(String name) {
        Category category = new Category(name);
        category.setId(categorySequence.getAndIncrement());
        return category;
    }

    private Project getNewProject(String name, int goal, Date deadlineDate,
                                  String shortDescription, int balance, String demoLink) {
        Project project = new Project(name, goal, deadlineDate, shortDescription,
                balance, demoLink);
        project.setId(projectSequence.getAndIncrement());
        return project;
    }

    private Faq getNewFaq(String question, String answer) {
        Faq faq = new Faq(question, answer);
        faq.setId(faqSequence.getAndIncrement());
        return faq;
    }

    private ProjectEvent getNewProjectEvent(Date date, String text) {
        ProjectEvent projectEvent = new ProjectEvent(date, text);
        projectEvent.setId(projectEventSequence.getAndIncrement());
        return projectEvent;
    }

    private Reward getNewReward(int goal, String text) {
        Reward reward = new Reward(goal, text);
        reward.setId(rewardSequence.getAndIncrement());
        return reward;
    }

    private void init() {
        Category category1 = getNewCategory("Category 1");
        Project project1 = getNewProject("1st project in 1st category", 10000, addHours(new Date(), 4),
                "desc", 350000, "http://stackoverflow.com/");
        project1.addFaq(getNewFaq("Question 1", "Answer on question 1"));
        project1.addFaq(getNewFaq("Question 2", "Answer on question 2"));
        project1.addFaq(getNewFaq("Question 3", "Answer on question 3"));
        project1.addProjectEvent(getNewProjectEvent(convertDate("12.07.2015"), "Project was started"));
        project1.addProjectEvent(getNewProjectEvent(convertDate("10.07.2015"), "Thank you"));
        project1.addReward(getNewReward(1000, "Some reward for donate 10$"));
        project1.addReward(getNewReward(3000, "Some reward for donate 30$"));
        project1.addReward(getNewReward(4000, "Some reward for donate 40$"));
        category1.addProject(project1);
        Project project2 = getNewProject("2nd project in 1st category", 1000, addDays(new Date(), 4),
                "desc2", 350, "");
        category1.addProject(project2);
        categories.add(category1);

        Category category2 = getNewCategory("Category 2");
        Project project3 = getNewProject("1st project in 2st category", 1000000, addMinutes(new Date(), 10),
                "desc21", 600000, "");
        category2.addProject(project3);
        categories.add(category2);

        categories.add(getNewCategory("Empty Category"));
    }
}

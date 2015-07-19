package ua.goit.kyrychok.kickstarter.mvc.controller;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ua.goit.kyrychok.kickstarter.mvc.model.ProjectModel;
import ua.goit.kyrychok.kickstarter.mvc.view.ProjectView;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class ProjectControllerTest {

    @Mock
    private ProjectModel model;
    @Mock
    private ProjectView view;
    @Mock
    private BaseController baseController;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test()
    public void whenShowModelRenderMainPage() throws Exception {
        ProjectController controller = new ProjectController();
        controller.setParentController(baseController);
        controller.setView(view);
        controller.setModel(model);

        controller.showModel();

        verify(view, times(1)).render(model);
    }
}
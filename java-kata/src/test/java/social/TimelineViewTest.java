package social;

import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class TimelineViewTest extends ApplicationTest {
    private Timeline timeline = new Timeline();

    static {
        System.setProperty("testfx.headless", "true");
    }

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new TabPane(new Tab("text", new TimelineView(timeline))), 800, 600);
        stage.setScene(scene);
        stage.show();
    }

    @Test
    public void adds_a_post_to_the_listview_when_entered_in_textfield_and_button_clicked() {
        // given:
        String message = "dis mah message";

        // when:
        timeline.post(message);

        // then:
        ListView<String> timelineList = lookup("#postingsList").query();
        ObservableList<String> items = timelineList.getItems();
        assertThat(items, is(not(empty())));
        assertThat(items.get(items.size() - 1), is(message));
    }
}

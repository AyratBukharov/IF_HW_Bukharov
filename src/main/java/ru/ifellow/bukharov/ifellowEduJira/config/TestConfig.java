package ru.ifellow.bukharov.ifellowEduJira.config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.LoadPolicy;
import org.aeonbits.owner.Config.Sources;

@Sources({"classpath:config.properties",
        "system:properties"
})
@LoadPolicy(Config.LoadType.MERGE)
public interface TestConfig extends Config {

    @Key("base.url")
    String baseUrl();

    @Key("username")
    String username();

    @Key("password")
    String password();

    @Key("task.name")
    String taskName();

    @Key("success.message")
    String successMessage();

    @Key("topic.text")
    String topicText();

    @Key("description.text")
    String descriptionText();

    @Key("tags.text")
    String tagsText();

    @Key("environment.text")
    String environmentText();

    @Key("project.text")
    String projectText();

    @Key("type.task.text")
    String typeTaskText();

    @Key("priority.text")
    String priorityText();

    @Key("related.task.text")
    String relatedTaskTet();

    @Key("executor.text")
    String executorText();

    @Key("summary.text")
    String summaryText();
}

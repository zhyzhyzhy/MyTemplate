package cc.lovezhy.template.springboot.quartz;

import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzConfig {
    private Scheduler scheduler;

    @Autowired
    public QuartzConfig(Scheduler scheduler) {
        this.scheduler = scheduler;
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            JobDetail jobDetail = JobBuilder.newJob(SimpleJob.class)
                    .storeDurably()
                    .build();

            Trigger trigger = TriggerBuilder.newTrigger()
                    .withSchedule(SimpleScheduleBuilder.repeatHourlyForever())
                    .build();

            scheduler.scheduleJob(jobDetail, trigger);
        };
    }
}

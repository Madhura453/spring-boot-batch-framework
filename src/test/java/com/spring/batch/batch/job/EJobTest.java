package com.spring.batch.batch.job;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.spring.batch.batch.step.EStep;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.job.flow.FlowStep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {EJob.class})
@ExtendWith(SpringExtension.class)
class EJobTest {
    @Autowired
    private EJob eJob;

    @MockBean
    private EStep eStep;

    @MockBean
    private Job job;

    @MockBean
    private JobBuilderFactory jobBuilderFactory;

    /**
     * Method under test: {@link EJob#jdaRegularRpaJob()}
     */
    @Test
    void testJdaRegularRpaJob() throws Exception {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   org.springframework.batch.core.job.builder.JobBuilderException: java.lang.IllegalArgumentException: JobRepository must be set
        //       at org.springframework.batch.core.job.builder.SimpleJobBuilder.build(SimpleJobBuilder.java:60)
        //       at com.spring.batch.batch.job.EJob.jdaRegularRpaJob(EJob.java:30)
        //   In order to prevent jdaRegularRpaJob()
        //   from throwing JobBuilderException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   jdaRegularRpaJob().
        //   See https://diff.blue/R013 to resolve this issue.

        when(this.jobBuilderFactory.get((String) any())).thenReturn(new JobBuilder("Name"));
        when(this.eStep.regularJdaChunkBasedStep()).thenReturn(new FlowStep());
        this.eJob.jdaRegularRpaJob();
    }

    /**
     * Method under test: {@link EJob#jdaRegularRpaJob()}
     */
    @Test
    void testJdaRegularRpaJob2() throws Exception {
        when(this.jobBuilderFactory.get((String) any())).thenReturn(new JobBuilder("Name"));
        when(this.eStep.regularJdaChunkBasedStep()).thenThrow(new Exception("An error occurred"));
        assertThrows(Exception.class, () -> this.eJob.jdaRegularRpaJob());
        verify(this.jobBuilderFactory).get((String) any());
        verify(this.eStep).regularJdaChunkBasedStep();
    }

    /**
     * Method under test: {@link EJob#jdaRegularRpaJob()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testJdaRegularRpaJob3() throws Exception {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.spring.batch.batch.job.EJob.jdaRegularRpaJob(EJob.java:28)
        //   In order to prevent jdaRegularRpaJob()
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   jdaRegularRpaJob().
        //   See https://diff.blue/R013 to resolve this issue.

        when(this.jobBuilderFactory.get((String) any())).thenReturn(null);
        when(this.eStep.regularJdaChunkBasedStep()).thenReturn(new FlowStep());
        this.eJob.jdaRegularRpaJob();
    }

    /**
     * Method under test: {@link EJob#jdaRegularRpaJob()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testJdaRegularRpaJob4() throws Exception {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   org.springframework.batch.core.job.builder.JobBuilderException: java.lang.IllegalArgumentException: JobRepository must be set
        //       at org.springframework.batch.core.job.builder.SimpleJobBuilder.build(SimpleJobBuilder.java:60)
        //       at com.spring.batch.batch.job.EJob.jdaRegularRpaJob(EJob.java:30)
        //   In order to prevent jdaRegularRpaJob()
        //   from throwing JobBuilderException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   jdaRegularRpaJob().
        //   See https://diff.blue/R013 to resolve this issue.

        when(this.jobBuilderFactory.get((String) any())).thenReturn(new JobBuilder("Name"));
        when(this.eStep.regularJdaChunkBasedStep()).thenReturn(new FlowStep());
        this.eJob.jdaRegularRpaJob();
    }

    /**
     * Method under test: {@link EJob#jdaRegularRpaJob()}
     */
    @Test
    void testJdaRegularRpaJob5() throws Exception {
        when(this.jobBuilderFactory.get((String) any())).thenReturn(new JobBuilder("Name"));
        when(this.eStep.regularJdaChunkBasedStep()).thenThrow(new Exception("An error occurred"));
        assertThrows(Exception.class, () -> this.eJob.jdaRegularRpaJob());
        verify(this.jobBuilderFactory).get((String) any());
        verify(this.eStep).regularJdaChunkBasedStep();
    }

    /**
     * Method under test: {@link EJob#jdaRegularRpaJob()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testJdaRegularRpaJob6() throws Exception {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.spring.batch.batch.job.EJob.jdaRegularRpaJob(EJob.java:28)
        //   In order to prevent jdaRegularRpaJob()
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   jdaRegularRpaJob().
        //   See https://diff.blue/R013 to resolve this issue.

        when(this.jobBuilderFactory.get((String) any())).thenReturn(null);
        when(this.eStep.regularJdaChunkBasedStep()).thenReturn(new FlowStep());
        this.eJob.jdaRegularRpaJob();
    }
}


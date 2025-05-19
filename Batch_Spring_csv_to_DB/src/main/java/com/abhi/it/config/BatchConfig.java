package com.abhi.it.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.transaction.PlatformTransactionManager;

import com.abhi.it.entity.Customer;
import com.abhi.it.repository.CustomerRepository;

@Configuration
@EnableBatchProcessing
public class BatchConfig {
	
	@Autowired
	private CustomerRepository cr;

	//item reader bean
	@Bean
	public FlatFileItemReader<Customer> customerReader(){
		FlatFileItemReader<Customer> itemReader = new FlatFileItemReader<Customer>();
		
		itemReader.setResource(new FileSystemResource("src/main/resources/customer.csv"));
		itemReader.setName("cutomer-item-reader");
		itemReader.setLinesToSkip(1);
		itemReader.setLineMapper(lineMapper());
		
		return itemReader;
	}

	private LineMapper<Customer> lineMapper() {
		// TODO Auto-generated method stub
		DefaultLineMapper<Customer> lineMapper = new DefaultLineMapper<Customer>();
		
		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
		lineTokenizer.setDelimiter(",");
		lineTokenizer.setStrict(false);
		lineTokenizer.setNames("id","name", "country", "DOB");
		
		BeanWrapperFieldSetMapper<Customer> fieldSetMapper = new BeanWrapperFieldSetMapper<Customer>();
		fieldSetMapper.setTargetType(Customer.class);
		
		lineMapper.setFieldSetMapper(fieldSetMapper);
		lineMapper.setLineTokenizer(lineTokenizer);
		
		return lineMapper;
	}
	
	//item processor bean
	@Bean
	public customerProcessor customerProcessor() {
		return new customerProcessor();
	}
	
	//item writer bean
	@Bean
	public RepositoryItemWriter<Customer> customerWriter(){
		RepositoryItemWriter<Customer> itemWriter = new RepositoryItemWriter<Customer>();
		itemWriter.setRepository(cr);
		itemWriter.setMethodName("save");
		return itemWriter;
	}
	
	// step bean
	@Bean
	public Step step(JobRepository jobRepo, PlatformTransactionManager transactionManage) {
		return new StepBuilder("step-1", jobRepo)
				.<Customer,Customer>chunk(5, transactionManage)
				.reader(customerReader())
				.writer(customerWriter())
				.build();
				
	}
	
	//job bean
	@Bean
	public Job job(JobRepository jobRepo, Step step) {
		return new JobBuilder("customer-import", jobRepo)
				.flow(step)
				.end()
				.build();
	}
}

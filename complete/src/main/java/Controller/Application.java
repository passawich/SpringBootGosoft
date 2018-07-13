package Controller;
import java.sql.Date;
import java.util.Arrays;


import org.apache.log4j.Logger;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ConnectDB.Database;


@SpringBootApplication
public class Application extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }
	
	public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            System.out.println("Let's inspect the beans provided by Spring Boot:");
            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
//                System.out.println(beanName);
            }
        };
    }
    
    @Bean
    public Service servicelog(){
    	return new Service();
    }
    
    @Bean
    public Database database(){
    	return new Database();
    }
    
    @Bean
    JdbcTemplate jdbctemplate(){
    	JdbcTemplate jdbctemplate = new JdbcTemplate();
    	jdbctemplate.setDataSource(datasource());
    	return jdbctemplate;
    }
    
    @Bean
    DriverManagerDataSource datasource(){
    	DriverManagerDataSource datasource = new DriverManagerDataSource();
    	datasource.setDriverClassName("com.mysql.jdbc.Driver");
    	datasource.setUrl("jdbc:mysql://localhost/spring?characterEncoding=utf-8");
    	datasource.setUsername("root");
    	datasource.setPassword("");
    	return datasource;
    }


//  private static Logger log = Logger.getLogger(Controller.class);
//		enum OrderEvents{
//			FULFILL,
//			PAY,
//			CANCEL
//		}
//		
//		enum OrderStates{
//			SUBMITTED,
//			PAID,
//			FULFILLED,
//			CANCELLED
//		}
//		
//		@Component
//		class Runner implements ApplicationRunner{
//			private final StateMachineFactory<OrderStates,OrderEvents> factory;
//		
//			Runner(StateMachineFactory<OrderStates,OrderEvents> factory){
//				this.factory = factory;
//			}
//
//			@Override
//			public void run(ApplicationArguments args) throws Exception {
//				// TODO Auto-generated method stub
//				
//				Long orderId = 13232L;
//				StateMachine<OrderStates,OrderEvents> machine = this.factory.getStateMachine("13232");
//				machine.getExtendedState().getVariables().putIfAbsent("orderId", orderId);
//				machine.start();
//				log.info("current state : " + machine.getState().getId().name());
//				machine.sendEvent(OrderEvents.PAY);
//				log.info("current state : " + machine.getState().getId().name());
//				Message<OrderEvents> eventsMessage = MessageBuilder
//						.withPayload(OrderEvents.FULFILL)
//						.setHeader("a","b")
//						.build();
//				machine.sendEvent(eventsMessage);
//				log.info("current state : " + machine.getState().getId().name());
//			}
//		}
//		
////		@Entity
////		@Data
////		@NoArgsConstructor
////		@AllArgsConstructor
////		class Orde{
////			@Id
////			@GeneratedValue
////			private Long id;
////			private Date datetime;
////			private String state;
////			
////			public  void Order(Date d , OrderStates os){
////				this.datetime = d;
////				this.setOrderState(os);
////			}
////			public OrderStates getOrderState() {
////				return OrderStates.valueOf(this.state);
////			}
////			public void setOrderState(OrderStates s) {
////				this.state = s.name();
////			}
////			
////		}
//		
////		@Service
////		class OrderService {
////			private final OrderRepository orderRepository;
////			
////			OrderService(OrderRepository orderRepository){
////				this.orderRepository = orderRepository;
////			}
////			
////			Order create(Date when) {
////				return this.orderRepository.save(new Order(when,OrderStates.SUBMITTED));
////			}
////		}
//		
//		//@Log
//		@Configuration
//		@org.springframework.statemachine.config.EnableStateMachineFactory
//		class SimpleEnumStatemachineConfiguration extends StateMachineConfigurerAdapter<OrderStates,OrderEvents>{
//		
//		@Override
//		public void configure(StateMachineTransitionConfigurer<OrderStates,OrderEvents> transitions) throws Exception {
//			transitions
//			.withExternal().source(OrderStates.SUBMITTED).target(OrderStates.PAID).event(OrderEvents.PAY)
//			.and()
//			.withExternal().source(OrderStates.PAID).target(OrderStates.FULFILLED).event(OrderEvents.FULFILL)
//			.and()
//			.withExternal().source(OrderStates.SUBMITTED).target(OrderStates.CANCELLED).event(OrderEvents.CANCEL)
//			.and()
//			.withExternal().source(OrderStates.PAID).target(OrderStates.CANCELLED).event(OrderEvents.CANCEL);
//			}
//			
//		@Override
//		public void configure(StateMachineStateConfigurer<OrderStates,OrderEvents> states) throws Exception {
//			states
//				.withStates()
//				.initial(OrderStates.SUBMITTED)
//				.stateEntry(OrderStates.SUBMITTED, context ->{
//					Long orderId = Long.class.cast(context.getExtendedState().getVariables().getOrDefault("orderId", -1L));
//					log.info("orderId is " +orderId + ".");
//					log.info("entering submitted state");
//				})
//				.state(OrderStates.PAID)
//				.end(OrderStates.FULFILLED)
//				.end(OrderStates.CANCELLED);
//		}
//	}
		
    
}

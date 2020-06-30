package lab.spboot.bulkhead;

import java.time.Duration;

import io.github.resilience4j.bulkhead.Bulkhead;
import io.github.resilience4j.bulkhead.BulkheadConfig;
import io.github.resilience4j.bulkhead.BulkheadRegistry;
import lab.spboot.bulkhead.service.MockService;
import lab.spboot.bulkhead.service.MockServiceImpl;

public class MockClient {

	static Bulkhead bulkhead = null;
	static MockService service = new MockServiceImpl();
	
	public MockClient() {
		 
		 BulkheadConfig config = BulkheadConfig.custom().maxConcurrentCalls(2).maxWaitDuration(Duration.ofMillis(10))
					.build();
			BulkheadRegistry registry = BulkheadRegistry.of(config);
			bulkhead = registry.bulkhead("service");
			
	}
	
	 public void executeMockService() {
		 Runnable runnable = () -> service.computeWork();
			bulkhead.executeRunnable(runnable);
	 }
}

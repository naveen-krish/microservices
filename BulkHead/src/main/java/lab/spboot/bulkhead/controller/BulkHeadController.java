package lab.spboot.bulkhead.controller;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.resilience4j.bulkhead.Bulkhead;
import io.github.resilience4j.bulkhead.BulkheadConfig;
import io.github.resilience4j.bulkhead.BulkheadFullException;
import io.github.resilience4j.bulkhead.BulkheadRegistry;
import lab.spboot.bulkhead.service.MockService;

@RestController
public class BulkHeadController {

	@Autowired
	MockService mockService;
	
	static Bulkhead bulkhead = null;
	
	@RequestMapping("/mock")
	//@Bulkhead(name = "mockService" ,fallbackMethod="callMockService",type = Bulkhead.Type.SEMAPHORE)
	public void callMockService() {
		
		try {
			BulkheadConfig config = BulkheadConfig.custom().maxConcurrentCalls(1).maxWaitDuration(Duration.ofMillis(1))
					.build();
		
			BulkheadRegistry registry = BulkheadRegistry.of(config);
			bulkhead = registry.bulkhead("service");
			Runnable runnable = () -> mockService.computeWork();
			bulkhead.executeRunnable(runnable);
		} catch (BulkheadFullException e) {
			System.out.println(" << fallback method called >> ");
		}
		
		//mockService.computeWork();
	}
	
	public void callMockService(Exception e) {
		System.out.println(" << fallback method called >> ");
	}
}

package lab.spboot.api.controller;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CacheController {
	
	private AtomicInteger count = new AtomicInteger();
	
	@RequestMapping("/v1/api/cache-demo")
	public ResponseEntity getCounter() {
		
		CacheControl cacheControl = CacheControl.maxAge(60, TimeUnit.SECONDS).cachePublic();
		//CacheControl cacheControl = CacheControl.noCache().cachePublic();
		long counter = count.incrementAndGet();
		return ResponseEntity.ok().cacheControl(cacheControl).body(counter);
		
	}

}

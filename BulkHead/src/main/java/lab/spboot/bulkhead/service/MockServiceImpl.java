package lab.spboot.bulkhead.service;

import java.time.LocalTime;

import org.springframework.stereotype.Service;

@Service
public class MockServiceImpl implements MockService{

	@Override
	
	public void computeWork() {
		try {
			Thread.sleep(3000);
			System.out.println(LocalTime.now() + " Service executed.. " + Thread.currentThread().getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	
	
}

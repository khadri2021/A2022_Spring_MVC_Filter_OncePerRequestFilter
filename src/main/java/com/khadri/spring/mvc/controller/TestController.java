package com.khadri.spring.mvc.controller;

import java.util.concurrent.ForkJoinPool;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

@Controller
public class TestController {

	@RequestMapping("/say")
	@ResponseBody
	public DeferredResult<String> sayWish() {
		System.out.println("TestController Invoked");
		

		DeferredResult<String> deferredResult = new DeferredResult<>();
		
		// The processing of your request took long time.
		
		
		ForkJoinPool.commonPool().execute(()->{
		 System.out.println("Processing In Separate Thread");
		 	
		 	try {
		 		Thread.sleep(4000);
		 	}catch (InterruptedException e) {
				// TODO: handle exception
			}
		 	deferredResult.setResult("Hello");
		 
		 	System.out.println("Separate Thread is completed");
		 
		});
		
		
		
		return deferredResult;
	}
}

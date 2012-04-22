/*
 * Copyright 2002-2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.si.retrysample;

import org.springframework.integration.annotation.Header;

/**
 * Our ExceptionalServiceActivator always throws Exceptions :)
 * @author Amol Nayak
 *
 */
public class ExceptionalServiceActivator {

	/**
	 * Always throws an exception 
	 * @param payload
	 */
	public void handle(String payload,@Header("retry_count")Integer retryAttempt) {
		if(retryAttempt == 0)
			System.out.println("Processing message for the first time");
		else
			System.out.println("Retrying the message processing, attempt number is " + retryAttempt);
		
		throw new IllegalArgumentException("Throwing exception for payload " + payload);
	}
}

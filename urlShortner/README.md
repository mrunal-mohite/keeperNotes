URL Shortener Project (Spring Boot)

This is a simple URL Shortener project built using Java and Spring Boot.
It converts long URLs into short URLs and also keeps track of most frequently shortened domains.
All data is stored in memory using HashMap (no database).

I created this project step by step using Spring Tool Suite (STS).

 Steps I followed to create this project:

1.Created a new Spring Boot project using Spring Initializr in STS.

2.Selected Maven project with Java 17 and added Spring Web dependency.

3.Created packages:

	1)controller
	
	2)service
	
	3)model
	
	4)util

4.Implemented Base62Encoder utility class to generate short codes from numbers.

5.Created UrlService class to:

	1)Store original URL and short URL mapping using HashMap
	
	2)Generate short URL using Base62Encoder
	
	3)Store domain count for metrics
	
	4)Return top 3 most used domains

6.Created UrlShortenerController class to expose REST APIs.

7.Tested APIs using browser and Postman.

 How the project works:

1.When user sends a long URL, the system generates a short code using Base62 encoding.

2.Same URL always returns the same short URL.

3.Short URL is mapped back to the original URL.

4.Domain name is extracted from the URL and count is maintained.

5.Metrics API returns top 3 most shortened domains.

 How to run the project:

1.Open the project in Spring Tool Suite (STS) as a Maven project.

2.Run the main class: UrlShortenerApplication.java.

3.Application will start on port 8081.

4.Base URL will be:
http://localhost:8081

 APIs available:

1.Shorten URL API (POST):
http://localhost:8081/api/shorten?url=https://example.com

Response:
http://localhost:8081/api/{shortCode}

2.Redirect API (GET):
http://localhost:8081/api/{shortCode}

Redirects to the original URL.

3.Metrics API (GET):
http://localhost:8081/api/metrics

Example output:
google.com : 5
youtube.com : 3
wikipedia.org : 2

 Features implemented:

1.Same URL always generates the same short URL.

2.Short URL redirects to original URL.

3.Data is stored in memory using HashMap.

4.Top 3 most frequently shortened domains are shown.

5.Base62 encoding is used to generate short code.

6.Simple REST APIs using Spring Boot.

 Technology used:

1.Java 17

2.Spring Boot

3.Maven

4.REST API

5.HashMap for in-memory storage

 Testing:

1.APIs tested using browser and Postman.

2.Application runs successfully on port 8081.

 Future improvements:

1.Add database (MySQL or MongoDB).

2.Add exception handling and validation.

3.Add expiration time for short URLs.

4.Add user authentication.

5.Add unit test cases.

Author:
Mrunal Mohite
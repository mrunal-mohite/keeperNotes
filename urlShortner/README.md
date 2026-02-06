URL Shortener Service - Spring Boot (Java)

This project is a simple URL shortener service built using Java and Spring Boot for InfraCloud assignment. 
It provides REST APIs to shorten a URL, redirect to the original URL and show metrics of most frequently shortened domains. 
All data is stored in memory using HashMap.

How to run the project:
1. Open the project in STS as Maven project.
2. Run UrlshortenerApplication.java.
3. Application will start on port 8081.
4. Base URL: http://localhost:8081

APIs:
1. Shorten URL API (POST):
   /api/shorten?url=https://example.com
   Response: http://localhost:8081/r/abc123

2. Redirect API (GET):
   /r/{shortCode}
   Redirects to original URL.

3. Metrics API (GET):
   /api/metrics
   Example output:
   Udemy: 6
   YouTube: 4
   Wikipedia: 2

Features:
- Same URL always returns the same short URL.
- Short URL redirects to original URL.
- URLs are stored in memory (no database).
- Metrics API returns top 3 most shortened domains.

Technology used:
- Java 17
- Spring Boot
- Maven
- REST APIs

Testing:
Unit tests can be run using mvn test command.

Docker (Bonus):
Dockerfile is provided to build and run the application as container.

Author:
Mrunal Mohite

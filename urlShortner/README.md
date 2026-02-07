# URL Shortener Project (Spring Boot)

This project is created as part of InfraCloud assignment.
It is a simple URL Shortener application built using Java and Spring Boot.
The application provides APIs to shorten a URL, redirect to the original URL and show top domains that are shortened most.

All data is stored in memory using HashMap (no database is used).

Steps I followed to create this project:

1. Created a Spring Boot project using Spring Tool Suite (STS).
2. Added required dependencies like Spring Web.
3. Created main package com.example.urlshortener.
4. Created controller, service and utility classes.
5. Implemented API to shorten a URL.
6. Implemented API to redirect short URL to original URL.
7. Implemented API to show top 3 domains shortened.
8. Tested APIs using browser/Postman.
9. Added README file and pushed project to GitHub.

How to run this project:

1. Clone the project from GitHub.
2. Open the project in Spring Tool Suite (STS) as a Maven project.
3. Run the main class UrlshortenerApplication.java.
4. Application will start on port 8081.

Base URL:
http://localhost:8081

APIs:

1. Shorten URL API (POST)
Endpoint:
POST /api/shorten?url=https://example.com

Response:
http://localhost:8081/r/abc123

2. Redirect API (GET)
Endpoint:
GET /r/{shortCode}

This will redirect to the original URL.

3. Metrics API (GET)
Endpoint:
GET /api/metrics

Example Output:
Udemy: 6
YouTube: 4
Wikipedia: 2

Features:
- Same URL always returns the same short URL.
- Short URL redirects to original URL.
- Data is stored in memory.
- No database is used.
- Metrics API returns top 3 domains.

Tools and Technologies:
- Java 17
- Spring Boot
- Maven
- STS (Spring Tool Suite)
- GitHub

Author:
Mrunal Mohite

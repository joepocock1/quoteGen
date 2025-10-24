# 🧘‍♂️ QuoteGen – Stoic Quote Generator

QuoteGen is a clean, minimalistic **Spring Boot + Thymeleaf** web app that delivers timeless Stoic wisdom at the click of a button — without ever reloading the page.

Built as part of a personal learning and portfolio project, it demonstrates how to combine **Spring MVC**, **Thymeleaf templating**, and **asynchronous JavaScript (Fetch API)** for a responsive, production-style architecture.

---

## 🌟 Features

- 🧠 **Dynamic Stoic Quotes**  
  Retrieves quotes in real time from the [Stoic Quote Public API](https://github.com/tlcheah2/stoic-quote-lambda-public-api).

- ⚡ **Asynchronous Updates (AJAX / Fetch API)**  
  The “Another One” button fetches new quotes via a background API call — no page refresh required.

- 🎨 **Responsive UI with Bootstrap 5**  
  Clean, mobile-first design with shared navbar and footer fragments for consistency.

- 🧩 **Reusable Thymeleaf Layouts**  
  Modular templates (`layout.html`, `fragments/`) demonstrate best practices for templating and maintainability.

- 💾 **REST API Endpoint**  
  A simple backend API at `/api/quotes/stoic/random` returns quotes in JSON format.

- 🔒 **Separation of Concerns**  
  All client logic is in an external JS file (`quotes.js`); no inline scripts.

---

## 🧱 Tech Stack

| Layer | Technology |
|-------|-------------|
| Backend | Java 21, Spring Boot 3.5.7 |
| Frontend | Thymeleaf, Bootstrap 5 |
| Async / Client | Fetch API (Vanilla JS) |
| Build Tool | Gradle |
| Template Engine | Thymeleaf |
| API Source | [Stoic Quote Lambda API](https://github.com/tlcheah2/stoic-quote-lambda-public-api) |

---

## ⚙️ How It Works

1. **Spring Boot Controller** fetches a Stoic quote from the external API via a service layer.  
2. **Thymeleaf view** renders the quote dynamically into the page.  
3. When the user clicks “Another One,”  
   the client’s `quotes.js` uses `fetch()` to call `/api/quotes/stoic/random`.  
4. The new quote is returned as JSON and injected directly into the DOM — no full reload needed.

---

## 🧰 How to Run Locally

Follow these steps to run QuoteGen on your machine.

### 1️⃣ Clone the repository

git clone https://github.com/joepocock1/quoteGen.git
cd quoteGen

### 2️⃣ Check Java & Gradle
Ensure you have Java 21+ installed:

bash
Copy code
java -version
You can use the Gradle wrapper included with the project (no need to install Gradle manually).

### 3️⃣ Run the application
bash
Copy code
./gradlew bootRun
💡 On Windows use:

bash
Copy code
gradlew.bat bootRun
After the build completes, you’ll see something like:

nginx
Copy code
Tomcat started on port 8080 (http)
Started QuoteGenApplication in 2.4 seconds

### 4️⃣ Open your browser
Visit 👉 http://localhost:8080

You’ll see the home page where you can generate Stoic quotes instantly — without reloading the page.

🧩 Optional: Build a JAR file
If you’d rather run it as a standalone application:

bash
Copy code
./gradlew build
Then:

bash
Copy code
java -jar build/libs/quoteGen-0.0.1-SNAPSHOT.jar
✅ Stopping the app
Press CTRL + C in the terminal to stop the running Spring Boot server.

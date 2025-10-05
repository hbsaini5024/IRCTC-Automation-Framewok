🚄 IRCTC Automation Framework
This is a Selenium-based automation framework built from scratch to automate the IRCTC website using Java and TestNG.
It follows the Page Object Model (POM) design pattern and covers critical flows like login, search, and booking. 
CAPTCHA is handled manually—users enter it via Selenium IDE, and the code captures and submits it during login. The framework also supports cross-browser testing to ensure compatibility across Chrome, Firefox, and Edge.

📦 Tech Stack
- Java 11+
- Selenium WebDriver
- TestNG
- Maven
- Page Object Model (POM)
- Extent Reports
- Apache POI (for data-driven testing)
- WebDriverManager (for driver management)

🚀 Features
- ✅ Modular framework using Page Object Model
- ✅ Automated login, search, booking flows
- ✅ CAPTCHA handling using OCR (Tesseract or third-party API)
- ✅ Dynamic waits and robust element handling
- ✅ Data-driven testing using Excel
- ✅ Cross-browser support
- ✅ Extent Reports integration
- ✅ Screenshot capture on failure
- ✅ Logging with Log4j

🔐 CAPTCHA Handling
CAPTCHA is handled manually via user input in Selenium IDE, which the code then captures and submits during login.

📁 Data-Driven Testing
Data Driven testing is used to search for the trains between multiple stations ( from source to destination).

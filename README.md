# 🛒 SauceDemo Website - Java OOPs Project

A simulated version of the SauceDemo e-commerce website built using **Java** and **Object-Oriented Programming (OOP)** principles. This project is ideal for understanding how to apply **Encapsulation, Inheritance, Abstraction, and Polymorphism** in real-world scenarios using Java.

---

## 🚀 Project Goals

- Apply Java OOP principles to structure test automation and business logic.
- Simulate user interactions like login, product selection, cart, and logout.
- Demonstrate clean code practices using page object models and test layers.

---

## 🧠 OOP Principles in Action

### ✅ 1. Encapsulation

**Where:** `LoginPage.java`, `HomePage.java`, `CartPage.java`

All web elements and interactions are **encapsulated** inside page classes. This restricts direct access and ensures control through public methods.

```java
public class LoginPage {
    private WebDriver driver;

    private By username = By.id("user-name");
    private By password = By.id("password");

    public void enterUsername(String user) {
        driver.findElement(username).sendKeys(user);
    }

    public void enterPassword(String pass) {
        driver.findElement(password).sendKeys(pass);
    }

    public void clickLogin() {
        driver.findElement(loginBtn).click();
    }
}
➡️ Encapsulates page behavior behind methods and hides web element locators as private.

🔗 2. Inheritance
Where: BasePage.java → Inherited by LoginPage, HomePage, etc.

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
}
➡️ Common functionality like WebDriver access is centralized in BasePage, and all page classes inherit it.

🧱 3. Abstraction
Where: BaseTest.java and DriverManager.java

Abstracts test environment setup and teardown logic, hiding technical setup details from test logic.

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
➡️ Abstraction is used to hide low-level setup/cleanup steps, promoting reuse and readability.

🔁 4. Polymorphism
Where: Use of overridden methods in page classes like loadPage()


public class Page {
    public void loadPage() {
        System.out.println("Loading generic page");
    }
}

public class LoginPage extends Page {
    @Override
    public void loadPage() {
        System.out.println("Loading login page...");
    }
}
➡️ Method overriding enables polymorphism—loadPage() behaves differently based on the object instance.

🧪 Test Flow (Implemented in TestSauceDemo.java)
User logs in using valid credentials

Items are added to the cart

User proceeds to checkout

Order is completed

User logs out

📁 Folder Structure
SauceDemoCucumber
│
├── src/test/java
│ ├── pages/ # Page Object Model classes
│ │ ├── BasePage.java # Inheritance & Abstraction
│ │ ├── LoginPage.java # Encapsulation
│ │ ├── CartPage.java
│ │ ├── ProductPage.java
│ │ └── LogoutPage.java
│ │
│ ├── stepDefinitions/ # Step Definitions
│ │ └── Steps.java # Gherkin to Java glue
│ │
│ └── runner/
│ └── TestRunner.java # Cucumber test runner
│
├── src/test/resources/
│ └── features/
│ └── sauce.feature # Gherkin feature file
│
├── pom.xml # Maven dependencies and plugins
└── cucumber.html # Cucumber HTML Report
▶️ How to Run
Clone the repository


git clone https://github.com/Polo1996134/SauceDemo-Website-using-Java-OOPs-Concept.git
cd SauceDemo-Website-using-Java-OOPs-Concept
Open in IntelliJ/Eclipse

Run the tests


Right-click on TestRunner.java -> Run

🏁 Summary Table
OOP Principle	Applied In	Purpose
Encapsulation	LoginPage, HomePage, CartPage	Restrict direct access to fields
Inheritance	BasePage, BaseTest	Share functionality across child classes
Abstraction	BaseTest, DriverManager	Hide complexity from test logic
Polymorphism	Page class hierarchy	Enable dynamic method resolution

📜 License
This project is for educational purposes. Contact the author for usage rights.

🙌 Contributing
Fork the repo

Create a branch

Commit and push your code

Create a pull request

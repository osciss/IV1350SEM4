# IV1350 – Repair Electric Bike

Object-Oriented Design, KTH IV1350  
Seminar 3 – Implementation | Seminar 4 – Exceptions and Design Patterns

## Project Members

- Alena Arsalan Amir – aaamir@kth.se
- Oscar Granath – osgr@kth.se
- Emilia Lindqvist – emilia4@kth.se

## About

This project implements the **Repair Electric Bike** scenario in Java, based on the object-oriented design from Seminar 2. The program follows the MVC and Layer architectural patterns.

**Seminar 3** implemented the basic flow of the scenario.

**Seminar 4** added exception handling for error conditions and the Observer design pattern to notify technicians and receptionists about updates to repair orders.
After teacher feedback on the MVC design, the observer solution was corrected. The previous observer design passed the model object `RepairOrder` directly to observers in `view`, which created an MVC dependency from view to model. The corrected design passes an immutable `RepairOrderUpdateDTO` from `model.dto` instead, preserving MVC separation and protecting the model's encapsulation.

### Packages

| Package | Description |
|---|---|
| `startup` | Contains `Main`, which creates all objects and starts the application |
| `view` | Simulates the user interface with hard-coded calls to the controller |
| `controller` | Mediates between the view and lower layers |
| `controller.exception` | Controller-level exceptions |
| `model` | Contains domain entities such as `RepairOrder` and `DiagnosticReport` |
| `model.dto` | Data transfer objects: `CustomerDTO`, `RepairOrderDTO`, and `RepairOrderUpdateDTO` |
| `integration` | Handles data storage via `CustomerRegistry`, `RepairOrderRegistry`, `RegistryCreator`, and `Printer` |
| `integration.exception` | Integration-level exceptions |

## Requirements

- Java JDK 17 or later
- JUnit 5 standalone JAR (for running tests)

Download the JUnit JAR and place it in the `lib/` folder:  
[junit-platform-console-standalone-1.10.0.jar](https://repo1.maven.org/maven2/org/junit/platform/junit-platform-console-standalone/1.10.0/junit-platform-console-standalone-1.10.0.jar)

## How to Run

### Windows (PowerShell)

Run the program:
```powershell
.\run.ps1
```

Run the tests:
```powershell
.\runTests.ps1
```

### Mac/Linux

Run the program:
```bash
bash run.sh
```

## Project Structure

```
IV1350_sem3/
├── src/
│   └── se/kth/iv1350/repairelectricbike/
│       ├── controller/
│       │   ├── Controller.java
│       │   ├── ErrorLogger.java
│       │   └── exception/
│       │       └── CustomerOperationFailedException.java
│       ├── integration/
│       │   ├── CustomerRegistry.java
│       │   ├── Printer.java
│       │   ├── RegistryCreator.java
│       │   ├── RepairOrderRegistry.java
│       │   └── exception/
│       │       ├── CustomerNotFoundException.java
│       │       └── DatabaseFailureException.java
│       ├── model/
│       │   ├── Bike.java
│       │   ├── Customer.java
│       │   ├── DiagnosticReport.java
│       │   ├── RepairOrder.java
│       │   ├── RepairOrderObserver.java
│       │   ├── RepairTask.java
│       │   └── dto/
│       │       ├── CustomerDTO.java
│       │       └── RepairOrderDTO.java
│       ├── startup/
│       │   └── Main.java
│       └── view/
│           ├── View.java
│           ├── RepairOrderView.java
│           └── RepairOrderLogger.java
├── test/
│   └── se/kth/iv1350/repairelectricbike/
│       ├── controller/
│       │   └── ControllerTest.java
│       ├── integration/
│       │   ├── CustomerRegistryTest.java
│       │   └── RepairOrderRegistryTest.java
│       └── model/
│           └── RepairOrderTest.java
├── lib/
│   └── junit-platform-console-standalone-1.10.0.jar (download separately)
├── run.ps1
├── runTests.ps1
└── .gitignore
```

## Sample Output

```
1. Find customer
   Customer found: Oscar
2. Create repair order
   Repair order created.
3. Find all repair orders
   ID: 1, Date: 2026-05-17, Problem: Battery dead, State: NEWLY CREATED
4. Add diagnostic result
 Repair Order Updated 
Repair Order ID: 1
Date: 2026-05-14
Problem: Battery dead
State: NEWLY CREATED
Repair Tasks: []
Diagnostic Results: [ID: 1 - Replace dead battery]

   Diagnostic result added.
5. Add repair task
 Repair Order Updated 
Repair Order ID: 1
...
   Repair task added.
6. Accept repair order

 Repair Order Updated 
Repair Order ID: 1
Date: 2026-05-14
Problem: Battery dead
State: ACCEPTED
Repair Tasks: [Replace battery]
Diagnostic Results: [ID: 1 - Replace dead battery]

   Repair order accepted.

--- Demonstrating error handling ---
Finding customer with unknown number:
   ERROR: No customer found with phone number 00000.
Finding customer causing database failure:
   ERROR: Could not reach the database. Please try again later.
```

## Test Results

```
[        30 tests found           ]
[         0 tests skipped         ]
[        30 tests started         ]
[         0 tests aborted         ]
[        30 tests successful      ]
[         0 tests failed          ]
```

## Log Files

The program generates two log files:

- **`error-log.txt`** — logs database failures with timestamp and stack trace, for developer debugging
- **`repair-order-log.txt`** — logs every repair order update with timestamp, via the Observer pattern

## MVC Correction After Teacher Feedback

After teacher feedback, the observer design was revised because the previous solution let `RepairOrderView` and `RepairOrderLogger` receive the domain object `RepairOrder` directly through the Observer pattern. That made classes in the `view` package depend on a model entity, which violates MVC.

The corrected design keeps observers push-based, but `RepairOrder` now creates and sends an immutable `RepairOrderUpdateDTO` containing only the data needed for display and logging. This preserves MVC separation, avoids exposing the internal model object, and still lets the observers update without calling the controller or fetching extra data.

## Repository

- **GitHub:** https://github.com/osciss/IV1350SEM4.git

- **Note about exceptions:** The integration exception classes include Javadoc and provide informative messages and optional causes via the standard `Exception` constructors (message/cause).

# Bank Management System

![Image](https://github.com/user-attachments/assets/72cdc7a6-f63a-459b-8d30-b7e835a2757c)

## Project Description
A Java-based bank management system that allows administrators, employees, and customers to register (`sign up`) and authenticate (`sign in`) with unique usernames and passwords. The system provides role-specific functionalities through tailored menus.

## Core Features
### User Roles:
1. **Administrator**  
   - Manages employees/customers (add/remove)  
   - Views financial summaries (income/expenses/loans)  
   - Processes account openings/closures  
   - Searches users by name/ID  

2. **Employee**  
   - Processes withdrawals/transfers/deposits  
   - Opens/closes customer accounts  
   - Searches customers by name/ID  

3. **Customer**  
   - Checks balance  
   - Deposits/withdraws funds  
   - Pays loans  
   - Purchases mobile credit  

### Key Classes:
- **`Bank`**  
  - Bank name, type (private/public)  
  - Stores administrator, employee/customer lists  
  - Tracks annual revenue/expenses  

- **`User` (Abstract Parent Class)**  
  - ID (auto-generated: `M`/`E`/`C` prefix)  
  - Full name, username, password  
  - Methods: `signUp()`, `signIn()`, ID generation  

- **`Administrator`/`Employee`/`Customer`**  
  - Extend `User` with role-specific methods  

## Technical Requirements
### File Handling:
- **Admin credentials**: Stored in `admin.txt` (Line 1: admin name, Line 2: bank name)  
- **Employee list**: `employees.txt` (one name per line)  
- **User data**: Saved in separate files after registration  

### Advanced Java Concepts:
- Inheritance (`extends`), polymorphism  
- Abstract classes, `super`/`this`, `static`  
- Type casting, packages  
- File I/O for persistent storage  

## Bonus Features
- **GUI Implementation** (Java Swing)  
- **Complaint System**: Customers submit complaints (stored in `complaints.txt`)  

---

## Example Workflow
```plaintext
[Sign In]
Username: admin123
Password: ********

[Admin Menu]
1. Add Employee
2. View Customer List
3. Process Loan
...

[Employee Action]
Transfer $500 from Account:123 to Account:456

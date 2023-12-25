# User Management System CLI

## Introduction

This project aims to design a User Management System using a Command Line Interface (CLI) following SOLID Design Principles. The system will allow users to perform actions such as creating, reading, updating, and deleting user information.

## Design Principles

### SOLID Principles

1. **Single Responsibility Principle (SRP):**
   - Each class or module should have only one reason to change. In our design, classes are created with a single responsibility to adhere to this principle.

2. **Open/Closed Principle (OCP):**
   - Software entities (classes, modules, functions, etc.) should be open for extension but closed for modification. Our design allows for extending functionality without modifying existing code.

3. **Liskov Substitution Principle (LSP):**
   - Subtypes must be substitutable for their base types without altering the correctness of the program. This is achieved by using consistent interfaces across actions.

4. **Interface Segregation Principle (ISP):**
   - A class should not be forced to implement interfaces it does not use. Interfaces are designed with specific methods related to the corresponding actions.

5. **Dependency Inversion Principle (DIP):**
   - High-level modules should not depend on low-level modules; both should depend on abstractions. Abstractions should not depend on details; details should depend on abstractions. Dependency injection is used to achieve this principle.

## Components

### 1. User Model

- **Attributes:**
  - ID
  - Name
  - Phone
  - Address
  - Email ID

### 2. Command Interface

- **Actions:**
  - Create
  - Read
  - Update
  - Delete

- **Attributes:**
  - -n for name
  - -p for phone
  - -a for address
  - -e for email id
  - -i for ID
  - --all to get all users
  - -f for field name in the update action
  - -v for value of the field in the update action

### 3. User Store

- **Storage:**
  - Utilizes a HashMap to store user information.

### 4. Action Implementations

#### Create Action

- **Action Name:** Create
- **Attributes:** -n, -p, -a, -e
- **Result:** Message with ID / Duplicate User not allowed!

#### Read Action

- **Action Name:** Read
- **Attributes:** -i, -n, --all
- **Result:** User Object (single user information) by ID
- **Result:** (-all) User Objects (multiple user information) by all

#### Delete Action

- **Action Name:** Delete
- **Attributes:** -i
- **Result:** Message / User doesn't exist (success/failure)

#### Update Action

- **Action Name:** Update
- **Attributes:** -i, -f, -v
- **Result:** Message / User information updated (success/failure)

## Usage

### 1. Create User

```bash   
$ create -n John -p 1234567890 -a Nagpur -e john@example.com 
```
### 2. Read User
```bash   
$ read -i 123
```
```bash   
$ read -n John
```
```bash   
$ read -all
```
### 3. Update User

```bash   
$ update -i 123 -n Mark -p 789456123  //and other fields
```
### 4. Delete User

```bash   
$ delete -i 123 
```

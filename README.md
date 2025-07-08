# Quantum Book Store - Assessment

## Overview

This project is an extensible online book store system implemented in Java. It supports multiple types of books and is designed for easy addition of new product types in the future.

## Features

- **Book Types:**
  - PaperBook: Has stock, price, can be shipped
  - EBook: Has file type, can be sent via email
  - DemoBook: Not for sale
- **Inventory Management:**
  - Add books to inventory
  - Remove and return outdated books
  - Buy books by ISBN, quantity, and user contact info
- **Extensible Design:**
  - New product types can be added by implementing the `Product` interface

## Project Structure

- `Product.java` - Interface for all products
- `Book.java` - Abstract class for books, implements `Product`
- `PaperBook.java`, `EBook.java`, `DemoBook.java` - Concrete book types
- `Inventory.java` - Manages products in the store
- `MainStart.java` - Example usage and test cases
- `MailService.java`, `ShippingService.java` - Stubs for delivery services
- `FileType.java` - Enum for eBook file types

## How to Use

1. **Compile all Java files:**
   ```sh
   javac *.java
   ```
2. **Run the main class:**
   ```sh
   java MainStart
   ```
3. **Features demonstrated in `MainStart.java`:**
   - Adding different types of books
   - Buying books (with error handling)
   - Removing outdated books

## Extending the System

To add a new product type:

1. Implement the `Product` interface.
2. Add your product to the inventory using the `add` method.

## Notes

- All business logic is handled via polymorphism for easy extensibility.

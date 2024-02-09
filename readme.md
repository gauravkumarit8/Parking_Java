# Parking Lot Management System

This Java program simulates a parking lot management system. Users can perform various operations such as creating a 
parking lot, parking cars, removing cars from the parking lot, and querying information about parked cars.

## Usage

### Prerequisites

- Java Development Kit (JDK) installed on your system.

### Running the Program

1. Compile the `Main.java` file:
2. Run the `java` file

### Available Commands

1. create_parking_lot <capacity>: Create a parking lot with the specified capacity.
2. park <registration_number> <color>: Park a car with the given registration number and color.
3. leave <slot_number>: Remove a car from the parking lot by slot number.
4. status: Print the current status of the parking lot.
5. registration_numbers_for_cars_with_colour <color>: Get registration numbers of cars with the specified color.
6. slot_number_for_registration_number <registration_number>: Get slot number for a car with the specified registration number.
7. slot_numbers_for_cars_with_colour <color>: Get slot numbers of cars with the specified color.
8. help: Print available commands.
9. exit: Exit the program.
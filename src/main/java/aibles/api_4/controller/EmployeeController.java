package aibles.api_4.controller;

import aibles.api_4.Employee;
import aibles.api_4.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") int id) {
        Optional<Employee> employee = employeeService.getEmployeeById(id);
        if (employee.isPresent()) {
            return new ResponseEntity<>(employee.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/department/{departmentID}")
    public ResponseEntity<List<Employee>> getEmployeesByDepartment(@PathVariable("departmentID") int departmentID) {
        List<Employee> employees = employeeService.getEmployeesByDepartment(departmentID);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
    @GetMapping("/name/{firstName}")
    public ResponseEntity<List<Employee>> getEmployeesByName(@PathVariable("firstName") String firstName) {
        List<Employee> employees = employeeService.getEmployeesByName(firstName);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
    @GetMapping("/birthdate/{birthDate}")
    public ResponseEntity<List<Employee>> getEmployeesByBirthDate(@PathVariable("birthDate") @DateTimeFormat(pattern="yyyy-MM-dd") Date birthDate) {
        List<Employee> employees = employeeService.getEmployeesByBirthDate(birthDate);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
}



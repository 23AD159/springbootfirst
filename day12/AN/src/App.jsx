import { Routes, Route, Link } from 'react-router-dom';
import { useState } from 'react';
import Signup from './components/Signup';
import Login from './components/Login';
import EmployeeList from './components/EmployeeList';
import './app.css';
import axios from "axios";

function App() {
  const [employees, setEmployees] = useState([]);

  const addEmployee = (employee) => {
    setEmployees([...employees, employee]);
  };

  const updateEmployee = async (index, updatedEmployee) => {
  const employeeToUpdate = employees[index];

  try {
    await axios.put(`http://localhost:3001/api/employee/${employeeToUpdate.id}`, updatedEmployee);

    const updated = [...employees];
    updated[index] = { ...employeeToUpdate, ...updatedEmployee };
    setEmployees(updated);
  } catch (error) {
    console.error("Error updating employee:", error);
    alert("Failed to update employee in database.");
  }
};


  const deleteEmployee = async (index) => {
  const employeeToDelete = employees[index];

  try {
   await axios.delete(`http://localhost:3001/api/employee/${employeeToDelete.id}`);

    const updated = employees.filter((_, i) => i !== index);
    setEmployees(updated);
  } catch (error) {
    console.error("Error deleting employee:", error);
    alert("Failed to delete employee from database.");
  }
};


  return (
    <div>
      <header className="bg-dark text-white p-3 shadow-sm">
        <div className="container d-flex justify-content-between align-items-center">
          <h2 className="m-0">Employee Management System</h2>
          <nav>
            <Link to="/signup" className="btn btn-outline-light me-2">Signup</Link>
            <Link to="/login" className="btn btn-outline-light me-2">Login</Link>
            <Link to="/employeeList" className="btn btn-outline-light">Employees</Link>
          </nav>
        </div>
      </header>

      <main className="container my-5">

      <Routes>
        <Route path="/signup" element={<Signup onSignup = {addEmployee}/>} />
        <Route path="/login" element={<Login />} />

        <Route path="/employeeList" element={
          <EmployeeList
            employees={employees}
            onUpdate={updateEmployee}
            onDelete={deleteEmployee}
          />
        } />
      </Routes>
      </main>

      <footer className="bg-secondary text-white text-center p-3 mt-auto">
        <p>&copy; 2025 Employee Management System</p>
      </footer>
    </div>
  );
}

export default App;
import { Routes, Route, Link } from 'react-router-dom';
import Signup from './components/Signup';
import Login from './components/Login';
import EmployeeList from './components/EmployeeList';

function App() {
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
          <Route path="/signup" element={<Signup />} />
          <Route path="/login" element={<Login />} />
          <Route path="/employeeList" element={<EmployeeList />} />
        </Routes>
      </main>

     
      <footer className="bg-secondary text-white text-center p-3 mt-auto">
        &copy; 2025 Employee Management System
      </footer>
    </div>
  );
}

export default App;

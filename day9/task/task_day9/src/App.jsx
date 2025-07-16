import React from 'react';
import { Link } from 'react-router-dom';
import Login from './components/Login';
import Register from './components/Register';
import './App.css'; // Import the CSS file

function App() {
  return (
    <div>
    
      <header className="header">
        <h2>Auth App</h2>
        <nav>
          <Link to="/Register" className="nav-link">Register</Link>
          <Link to="/Login" className="nav-link">Login</Link>
        </nav>
      </header>

     
      <Register />
      <Login />

      <footer className="footer">
        <p>&copy; 2025 Employee Management System</p>
      </footer>
    </div>
  );
}

export default App;

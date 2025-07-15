import { Routes, Route, Link } from 'react-router-dom';
import Signup from './components/Signup';
import Login from './components/Login';
import './app.css'

function App() {
  return (
    <div>
      <header className="header">
        <h2>Auth App</h2>
        <nav>
          <Link to="/signup" className="nav-link">Signup</Link>
          <Link to="/login" className="nav-link">Login</Link>
        </nav>
      </header>

      <Routes>
        <Route path="/signup" element={<Signup />} />
        <Route path="/login" element={<Login />} />
      </Routes>

      <footer className="footer">
        <p>&copy; 2025 Employee Management System</p>
      </footer>
    </div>
  );
}

export default App;
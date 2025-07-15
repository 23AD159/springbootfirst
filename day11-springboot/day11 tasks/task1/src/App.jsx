import Signup from './components/Signup';
import Login from './components/Login';
import './app.css';

function App() {
  return (
    <div>
      <header className="header">
        <h2>Auth App</h2>
      </header>

      <main className="main-container">
        <div className="form-container">
          <Signup />
        </div>
        <div className="form-container">
          <Login />
        </div>
      </main>

      <footer className="footer">
        <p>&copy; 2025 Employee Management System</p>
      </footer>
    </div>
  );
}

export default App;

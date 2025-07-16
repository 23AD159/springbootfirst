import React from 'react';
import { Link } from 'react-router-dom';

const Header = () => (
  <header style={{ padding: '10px', backgroundColor: '#282c34', color: 'white' }}>
    <h2>Auth App</h2>
    <nav>
      <Link to="/Register" style={{ marginRight: '10px', color: 'white' }}>Register</Link>
      <Link to="/Login" style={{ color: 'white' }}>Login</Link>
    </nav>
  </header>
);

export default Header;

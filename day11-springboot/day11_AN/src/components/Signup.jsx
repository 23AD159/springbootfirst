import { useState } from "react";
import axios from "axios";

const Signup = () => {
  const [name, setName] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [userName, setUserName] = useState("");
  const [roleNames, setRoleNames] = useState("");

  async function handleSubmit(event) {
    event.preventDefault();

    try {
      const response = await axios.post("http://localhost:3001/api/auth/register", {
        name,                      
        email,
        password,
        userName,                  
        roleNames: roleNames
          .split(',')
          .map(role => role.trim()) 
      });

      console.log(response.data);
      alert("Registration Successful");
    } catch (e) {
      console.log("Register error", e);
      alert("Register error!!");
    }
  }

  return (
    <div>
      <h2>Register</h2>
      <form onSubmit={handleSubmit}>
        <label htmlFor="name">Name:</label>
        <input
          type="text"
          id="name"
          value={name}
          onChange={e => setName(e.target.value)}
        />
        <br /><br />

        <label htmlFor="email">Email:</label>
        <input
          type="text"
          id="email"
          value={email}
          onChange={e => setEmail(e.target.value)}
        />
        <br /><br />

        <label htmlFor="password">Password:</label>
        <input
          type="password"
          id="password"
          value={password}
          onChange={e => setPassword(e.target.value)}
        />
        <br /><br />

        <label htmlFor="userName">Username:</label>
        <input
          type="text"
          id="userName"
          value={userName}
          onChange={e => setUserName(e.target.value)}
        />
        <br /><br />

        <label htmlFor="roleNames">Roles:</label>
        <input
          type="text"
          id="roleNames"
          value={roleNames}
          onChange={e => setRoleNames(e.target.value)}
        />
        <br /><br />

        <button type="submit">Register</button>
      </form>
    </div>
  );
};

export default Signup;
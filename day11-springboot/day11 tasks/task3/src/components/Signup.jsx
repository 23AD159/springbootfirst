import { useState } from "react";
import axios from "axios";
import {useNavigate} from 'react-router-dom';

const Signup = () => {
  const [name, setName] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [userName, setUserName] = useState("");
  const [roleNames, setRoleNames] = useState([]);

  const navigate = useNavigate();

  const handleRoleChange = (e) =>{
    const role = e.target.value;
    if(e.target.checked){
      setRoleNames([...roleNames,role]);
    }
    else{
      setRoleNames(roleNames.filter(r=>r !== role));
    }
  };

  async function handleSubmit(event) {
    event.preventDefault();

    try {
      const response = await axios.post("http://localhost:3001/api/auth/register", {
      name,                      
      email,
      password,
      userName,                  
      roleNames 
});

navigate('/login');


      console.log(response.data);
      alert("Registration Successful");
    } catch (e) {
      console.log("Register error", e);
      alert("Register error!!");
    }
  }

  return (
    <div>
      <h1>Register Form</h1>
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

        <label>Roles:</label> <br />
        <label>
          <input type = "checkbox" value = "ADMIN" onChange = {handleRoleChange} />
          ADMIN
        </label><br />

        <label>
          <input type = "checkbox" value = "USER" onChange = {handleRoleChange} />
          USER
        </label><br />

        <label>
          <input type = "checkbox" value = "ROLE_ADMIN" onChange = {handleRoleChange} />
          ROLE_ADMIN
        </label><br />

        <label>
          <input type = "checkbox" value = "ROLE_USER" onChange = {handleRoleChange} />
          ROLE_USER
        </label><br />
        
        <br />

        <button type="submit">Register</button>
      </form>
    </div>
  );
};

export default Signup;
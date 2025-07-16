import { useState } from "react";
import axios from "axios";

const Register = () => {
    const [name, setName] = useState("");
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [userName, setUserName] = useState("");
    const [roles, setRoles] = useState("");

    async function handleRegister(event) {
        event.preventDefault();
        try {
            const response = await axios.post("http://localhost:3001/api/auth/register", {
                name,
                email,
                userName,
                password,
                roles
            });
            console.log(response.data);
            alert("Registration Successful");
        } catch (e) {
            console.log("Registration error:", e);
            alert("Invalid Registration");
        }
        console.log("Form Submitted");
    }

    return (
        <div style={{ padding: '20px' }}>
            <h2>Register</h2>
            <form onSubmit={handleRegister}>
                <label htmlFor="Name">Name</label>
                <input id="Name" name="Name" value={name} type="text" onChange={e => setName(e.target.value)} />
                <br />
                <label htmlFor="email">Email</label>
                <input id="email" name="email" value={email} type="text" onChange={e => setEmail(e.target.value)} />
                <br />
                <label htmlFor="password">Password</label>
                <input id="register-password" name="password" type="password" value={password} onChange={e => setPassword(e.target.value)} />
                <br />
                <label htmlFor="username">Username</label>
                <input id="username" name="username" value={userName} type="text" onChange={e => setUserName(e.target.value)} />
                <br />
                <label htmlFor="roles">Roles</label>
                <input id="roles" name="roles" value={roles} type="text" onChange={e => setRoles(e.target.value)} />
                <br /><br />
                <button type="submit">Register</button>
            </form>
        </div>
    );
};

export default Register;

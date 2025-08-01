import { useState } from "react";
import axios from "axios";

const Login = () =>{
    const [userName,setUserName] = useState("");
    const [password,setPassword] = useState("");

    async function handleLogin(event){
        event.preventDefault();
        try{
            const token = await axios.post("http://localhost:3001/api/auth/login",{userName,password})
            console.log(token);
            alert("Login Sucessful")

        }catch(e){
            console.log("Login error:",e);
            alert("Invalid Credentials")
        }
        console.log("Form Submitted");
    }
  

    return(
        <div>
            <h2>Login</h2>
            <div>
                <form onSubmit={handleLogin}>
                    <label htmlFor="userName">User Name</label>
                    <input id="userName" name="userName" value = {userName} type ="text" onChange={e =>setUserName(e.target.value)}/>
                    <br /><br />
                    <label htmlFor="password">Password</label>
                    <input id="login-password" name="password" type="password" value = {password}  onChange={e =>setPassword(e.target.value)}/>
                    <br />
                    <br />
                    <button>Login</button>

                </form>
            </div>
        </div>
    );
};
export default Login;
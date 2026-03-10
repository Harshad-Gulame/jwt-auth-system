import { useNavigate  } from "react-router-dom";
import { useState } from "react";
import axios from "axios";

export default function Login() {
  const navigate = useNavigate();
  const [email,setEmail] = useState("");
  const [password,setPassword] = useState("");

  const loginUser = async () => {

    const res = await axios.post(
      "http://localhost:8080/api/auth/login",
      {
        email,
        password
      }
    );

    localStorage.setItem("token",res.data.token);

    navigate("/dashboard");

    alert("Login Successful");
  };

  return (
    <div>

      <h2>Login</h2>

      <input
        placeholder="Email"
        onChange={(e)=>setEmail(e.target.value)}
      />

      <br/>

      <input
        type="password"
        placeholder="Password"
        onChange={(e)=>setPassword(e.target.value)}
      />

      <br/>

      <button onClick={loginUser}>
        Login
      </button>

    </div>
  );
}
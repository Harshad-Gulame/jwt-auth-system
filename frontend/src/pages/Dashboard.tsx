import { useEffect } from "react";
import { useNavigate } from "react-router-dom";
export default function Dashboard() {

  const navigate = useNavigate();
  const token = localStorage.getItem("token");

  useEffect(() => {
    if (!token) {
      navigate("/");
    }
  }, []);

  return (
    <div>
      <h1>Dashboard</h1>
      <p>Login successful</p>
    </div>
  );
}
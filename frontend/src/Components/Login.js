import React,{ useState, useEffect } from "react";
import Axios from "axios";

function Login() {
    const [user, setUser] = useState("");

    useEffect(() => {
        Axios.post("/api/users")
        .then((response) => {
            if(response.data) {
                console.log(response.data);
                setUser(response.data);
            } else {
                alert("failed");
            }
        });
    }, []);
    return (
        <div className = "App">
            <div>
                <li>
                    <ul>
                        {user.email}
                    </ul>
                    <ul>
                        {user.password}
                    </ul>
                </li>
            </div>
        </div>
    )
}

export default Login;
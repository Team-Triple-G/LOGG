import React from "react";
import LoginForm from "./LoginForm";
import LogoutForm from "./LogoutForm"

export default function Index() {
    if(sessionStorage.getItem("userId") === null){
        return (
            <LoginForm />
        );
        
    } else {
        return (
            <LogoutForm />
        )
    }
}
import React from 'react';

export default function LogoutForm() {
    console.log("test!!")
    const onClickLogout = () => {
        sessionStorage.removeItem("userId")
        sessionStorage.removeItem("userNickName")
        document.location.href = '/'
    }
        return (
        <div>
        <input
        type="text"
        placeholder="닉네임"
        name="userNickname"
        value={sessionStorage.getItem("userNickName")}
        ></input>
            <div>
                <button type='button' onClick={onClickLogout}>Logout</button>
            </div>
        </div>
        )
    }
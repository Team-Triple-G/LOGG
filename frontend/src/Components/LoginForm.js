import React, { useState } from 'react';
import axios from 'axios';

export default function Login() {
    const [inputId, setInputId] = useState('')
    const [inputPassword, setInputPassword] = useState('')

    const handleInputId = (e) => {
        setInputId(e.target.value)
    }

    const handleInputPassword = (e) => {
        setInputPassword(e.target.value)
    }

    const onClickLogin = () => {
        console.log('click login')
        console.log('ID : ', inputId)
        console.log('PW : ', inputPassword)
        axios.post('http://localhost:8080/api/v1/user/login', {
            'userId': inputId,
            'userPassword': inputPassword
            }
        )
        .then(res => {
            console.log(res)
            const data = res.data;
            console.log(data.data)
            console.log('userId: ', data.data.userId)
            console.log('userNickName: ', data.data.userNickname)
            console.log('userPassword: ', data.data.userPassword)
            if(data.data.userId === inputId) {
                console.log('======================','로그인 성공')
                localStorage.setItem('userId', inputId)
                localStorage.setItem('userNickName', data.data.userNickname)
                localStorage.setItem('userPassword', inputPassword)
                console.log(localStorage)
            }
            // 작업 완료 되면 페이지 이동(새로고침)
            // document.location.href = '/'
        })
        .catch(error => {
            console.log(error.response)
            const status = error.response.status;
            console.log(status);
            alert('아이디와 비밀번호를 확인해 주세요.')
        })
    }

    return(
        <div>
            <h2>Login</h2>
            <div>
                <label htmlFor='input_id'>ID : </label>
                <input type='text' name='input_id' value={inputId} onChange={handleInputId} />
            </div>
            <div>
                <label htmlFor='input_pw'>Password : </label>
                <input type='password' name='input_Password' value={inputPassword} onChange={handleInputPassword} />
            </div>
            <div>
                <button type='button' onClick={onClickLogin}>Login</button>
            </div>
        </div>
    )
}
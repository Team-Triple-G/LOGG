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
            const data = res.data.data;

            console.log(data)
            console.log('data.data.userId :: ', data.userId)
            console.log('data.data.userId :: ', data.userNickname)
            // if(res.data.userId === undefined){
            //     // id 일치하지 않는 경우 userId = undefined, msg = '입력하신 id 가 일치하지 않습니다.'
            //     console.log('======================',res.data.msg)
            //     alert('입력하신 id 가 일치하지 않습니다.')
            // } else if(res.data.userId === null){
            //     // id는 있지만, pw 는 다른 경우 userId = null , msg = undefined
            //     console.log('======================','입력하신 비밀번호 가 일치하지 않습니다.')
            //     alert('입력하신 비밀번호 가 일치하지 않습니다.')
            // } else if(res.data.userId === inputId) {
            //     // id, pw 모두 일치 userId = userId1, msg = undefined
            //     console.log('======================','로그인 성공')
            //     sessionStorage.setItem('user_id', inputId)
            // }
            // // 작업 완료 되면 페이지 이동(새로고침)
            // document.location.href = '/'
        })
        .catch(error => {
            console.log(error.response)
            const status = error.response.status;
            console.log(status);

            // if(status === 401){}
            // console.log(err.data)
            // console.log(err.status)
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
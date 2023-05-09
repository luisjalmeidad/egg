import React, { useContext, useEffect, useRef, useState } from 'react'
import { useNavigate } from 'react-router'
import { Link } from 'react-router-dom'
import { AuthContext } from '../../context/AuthContext'
import { loginUser } from '../../services/UserService'
import "./login.scss"

export default function Login() {

  const [error, setError] = useState(false)

  const emailRef = useRef()
  const passwordRef = useRef()
  const { dispatch } = useContext(AuthContext)
  const navigate = useNavigate()
  const { data } = useContext(AuthContext)
  useEffect(() => {
    if (data.user) {
      navigate("/")
    }
  })

  async function handleLogin(e) {
    e.preventDefault()
    try {
      const email = emailRef.current.value
      const password = passwordRef.current.value
      const user = await loginUser(email, password)
      dispatch({
        type: "LOGIN",
        payload: user
      })
      navigate("/")
    } catch (error) {
      console.log(error);
      setError(true)
      setTimeout(()=>{
        setError(false)
      },5000)
    }

  }

  return (
    <div className='login'>
      <div className="form-wrapper">
        <h3>Login Usuario</h3>
        <form onSubmit={handleLogin}>
          <input type="email" ref={emailRef} placeholder='email' />
          <input type="password" ref={passwordRef} placeholder='password' />
          <button type='submit'>Login</button>
        </form>
        {error && <span style={{color:'red'}}>Email o contraseña incorrectos</span>}
        <span>No tenes una cuenta <Link to={"/register"}>Register</Link></span>
      </div>
    </div>

  )
}

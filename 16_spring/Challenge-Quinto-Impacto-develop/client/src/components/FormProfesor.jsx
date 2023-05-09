import React, { useRef, useState } from 'react'
import { Link, useNavigate } from 'react-router-dom'
import { saveProfesor } from '../services/ProfesorService'

export default function FormProfesor() {

    const [error, setError] = useState(false)
    const navigate = useNavigate()

    const emailRef = useRef()
    const passwordRef = useRef()
    const nameRef = useRef()
    const lastNameRef = useRef()


    async function handleSaveProfesor(e) {
        e.preventDefault()
        try {
            const profesor = {
                email: emailRef.current.value,
                password: passwordRef.current.value,
                nombre: nameRef.current.value,
                apellido:lastNameRef.current.value,
                cursos: []
            }
            await saveProfesor(profesor)
            navigate("/login")
        } catch (error) {
            console.log(error);
            setError(true)
            setTimeout(() => {
                setError(false)
            }, 5000)
        }
    }

    return (
        <div className='registro-profesor'>
            <h3>Registro Profesor</h3>
            <form className='form-profesor' onSubmit={handleSaveProfesor}>
                <input type="email" ref={emailRef} placeholder='example@example.com' />
                <input type="password" ref={passwordRef} placeholder='Password' />
                <input type="text" ref={nameRef} placeholder='Name' />
                <input type="text" ref={lastNameRef} placeholder='Lastname' />
                <button type='submit'>Register</button>
            </form>
            {error && <span style={{color:'red'}}>Hubo un error al registrarse</span>}
            <span>Tenes una cuenta <Link to={"/login"}>Login</Link></span>
        </div>
    )
}

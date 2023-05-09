import React, { useRef, useState } from 'react'
import { useNavigate } from 'react-router'
import { Link } from 'react-router-dom'
import { saveAlumno, updateAlumno } from '../services/AlumnoService'

export default function FormAlumno({ alumno }) {

  const [error, setError] = useState(false)
  const navigate = useNavigate()

  const emailRef = useRef()
  const passwordRef = useRef()
  const nameRef = useRef()
  const ageRef = useRef()
  const dateRef = useRef()
  const descriptionRef = useRef()

  async function handleSaveAlumno(e) {
    e.preventDefault()

    let date = new Date(dateRef.current.value)
    date.setDate(date.getDate() + 1)
    const newAlumno = {
      email: emailRef.current.value,
      password: passwordRef.current.value,
      nombre: nameRef.current.value,
      edad: ageRef.current.value,
      fechaDeNacimiento: date,
      historia: descriptionRef.current.value,
      cursos: []
    }
    console.log(newAlumno);
    const res = await saveAlumno(newAlumno)
    if (res) {
      navigate("/login")
    } else {
      setError(true)
      setTimeout(() => {
        setError(false)
      }, 5000)

    }
  }

  async function handleUpdateAlumno(e) {
    e.preventDefault()
    const newAlumno = {
      email: emailRef.current.value,
      password: passwordRef.current.value,
      nombre: nameRef.current.value,
      edad: ageRef.current.value,
      fechaDeNacimiento: dateRef.current.value,
      historia: descriptionRef.current.value,
      cursos: alumno.cursos
    }
    const res = await updateAlumno(newAlumno)
    if (res) {
      navigate("/login")
    } else {
      setError(true)
      setTimeout(() => {
        setError(false)
      }, 5000)

    }
  }

  return (
    <div className='registro'>
      <h3>Registro Alumno</h3>
      <form className='form-alumno'>
        <input type="email" ref={emailRef} defaultValue={alumno?.email} placeholder='example@example.com' />
        <input type="password" ref={passwordRef} placeholder='Password' />
        <input type="text" ref={nameRef} defaultValue={alumno?.nombre} placeholder='Name' />
        <input type="number" ref={ageRef} defaultValue={alumno?.edad} placeholder='Age' />
        <input type="date" ref={dateRef} defaultValue={alumno?.fechaDeNacimiento} />
        <textarea placeholder='Description...' ref={descriptionRef} defaultValue={alumno?.historia}></textarea>
        {alumno ? <button onClick={(e) => handleUpdateAlumno(e)} type='submit'>Modificar</button> : <button onClick={(e) => handleSaveAlumno(e)} type='submit'>Register</button>}
      </form>
      {error && <span style={{ color: 'red' }}>Hubo un error al registrarse</span>}
      <span>Tenes una cuenta <Link to={"/login"}>Login</Link></span>
    </div>
  )
}

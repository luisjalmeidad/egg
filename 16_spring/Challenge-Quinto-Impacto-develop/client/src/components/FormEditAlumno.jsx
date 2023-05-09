import React, { useEffect, useRef, useState } from 'react'
import { useNavigate, useParams } from 'react-router'
import { getAlumnoById, updateAlumno } from '../services/AlumnoService'
import "../App.scss"

export default function FormAlumno() {


    const [alumno, setAlumno] = useState()
    const [error, setError] = useState(false)
    const navigate = useNavigate()
    const {id} = useParams()

    useEffect(()=>{
        getAlumnoById(id).then(res => setAlumno(res))
    },[id])

    const passwordRef = useRef()
    const nameRef = useRef()
    const ageRef = useRef()
    const dateRef = useRef()
    const descriptionRef = useRef()


    async function handleUpdateAlumno(e) {
        e.preventDefault()

        let date = new Date(dateRef.current.value)
        date.setDate(date.getDate()+1)


        const newAlumno = {
            email: alumno.email,
            password: passwordRef.current.value,
            nombre: nameRef.current.value,
            edad: ageRef.current.value,
            fechaDeNacimiento: date,
            historia: descriptionRef.current.value,
            cursos: alumno.cursos
        }
        const res = await updateAlumno(alumno.id,newAlumno)
        if (res) {
            navigate("/")
        } else {
            setError(true)
            setTimeout(() => {
                setError(false)
            }, 5000)

        }
    }

    return (
        <div className='modificar'>
            <h3>Modificar Alumno</h3>
            <form className='form-alumno'>
                <input type="password" ref={passwordRef} placeholder='Password' />
                <input type="text" ref={nameRef} defaultValue={alumno?.nombre} placeholder='Name' />
                <input type="number" ref={ageRef} defaultValue={alumno?.edad} placeholder='Age' />
                <input type="date" ref={dateRef}/>
                <textarea placeholder='Description...' ref={descriptionRef} defaultValue={alumno?.historia}></textarea>
                <button onClick={(e) => handleUpdateAlumno(e)} type='submit'>Modificar</button>
            </form>
            {error && <span style={{ color: 'red' }}>Hubo un error al modificar</span>}
        </div>
    )
}

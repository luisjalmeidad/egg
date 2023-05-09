import React, { useEffect, useRef, useState } from 'react'
import { Link } from 'react-router-dom'
import { getAllAlumnos, getAlumnosByName } from '../../services/AlumnoService'
import "./alumnos.scss"

export default function Alumnos() {

  const inputNameAlumno = useRef()
  const [alumnosByName, setAlumnosByName] = useState([])

  async function handleClickSearch() {
    const res = await getAlumnosByName(inputNameAlumno.current.value)
    setAlumnosByName(res)
  }

  useEffect(() => {
    getAllAlumnos().then(res => {
      setAlumnosByName(res)
      console.log(res)
    })
  }, [])

  return (
    <div className='alumnos'>
      <div className='search'>
        <input type="search" ref={inputNameAlumno} placeholder='Buscar por nombre' />
        <button onClick={handleClickSearch}>Buscar</button>
      </div>
      {alumnosByName.length > 0 &&
        <div className='list'>
          <h3>Alumnos</h3>
          {alumnosByName.map((alumno, i) =>
            <Link key={i} to={`/alumno/${alumno.id}`}>

              <span>{alumno.nombre}</span> <span>{alumno.email}</span>

            </Link>
          )}
        </div>
      }

    </div>
  )
}

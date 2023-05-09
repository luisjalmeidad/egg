import React, { useContext, useEffect, useRef, useState } from 'react'
import { useNavigate } from 'react-router-dom';
import { AuthContext } from '../context/AuthContext';
import { saveCurso } from '../services/CursoService';

export default function FormCurso() {
  const inputName = useRef()
  const inputHorario = useRef()
  const inputTurno = useRef()
  const [loading, setLoading] = useState({
    error:false,
    success:false
  })

  const navigate = useNavigate()
  const {data} = useContext(AuthContext) 

  useEffect(()=>{
    if (data.user.role !== 'ADMIN') {
      navigate("/")
    }
  })

  async function crearCurso(e) {
    e.preventDefault();
    try {
      const curso = {
        nombre: inputName.current.value,
        horario: inputHorario.current.value,
        turno: inputTurno.current.value,
        profesor: null,
        alumnos: []
      }
      saveCurso(curso)
      setLoading({
        error:false,
        success:true
      })
    } catch (error) {
      console.log(error);
      setLoading({
        error:true,
        success:false
      })
    }

  }
  return (
    <div className='registro-curso'>
      <h3>Crear curso</h3>
      <form onSubmit={crearCurso} className='form-curso'>
        <input type="text" ref={inputName} placeholder='Nombre del curso' />
        <input type="text" ref={inputHorario} placeholder='horario ' />
        <select ref={inputTurno}>
          <option value="">Turno</option>
          <option value="MAÑANA">Mañana</option>
          <option value="TARDE">Tarde</option>
          <option value="NOCHE">Noche</option>
        </select>
        <button type="submit">Crear curso</button>
      </form>
      {loading.error && <span style={{color:'red'}}>Error al crear curso</span>}
      {loading.success && <span style={{color:'green'}}>El curso se creo correctamente</span>}
    </div>
  )
}

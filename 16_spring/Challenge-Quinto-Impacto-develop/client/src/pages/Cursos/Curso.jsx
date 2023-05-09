import React, { useEffect, useState } from 'react'
import { Link, useParams } from 'react-router-dom';
import { getCursoById } from '../../services/CursoService';
import "./curso.scss"

export default function Curso() {
    const { id } = useParams();
    const [curso, setCurso] = useState({})

    useEffect(() => {
        getCursoById(id).then(res => setCurso(res))
    }, [id])
    return (
        <div style={{ display: "flex", flexDirection: "column", alignItems: "center" }}>
            <div className='curso'>

                <section className='info'>
                    <span>Nombre: {curso.nombre}</span>
                    <span>turno: {curso.turno}</span>
                    <span>Horario: {curso.horario}</span>
                </section>
                <div className='integrantes'>
                    <p>Profesor : {curso.profesor ? <Link style={{textDecoration:"none", color:"black"}} to={`/profesor/${curso.profesor.id}`}>{curso.profesor.nombre}</Link> : "Este curso no tiene profesor"}</p>
                    <section className='alumnos'>
                    <h4>Alumnos</h4>
                        {
                            curso.alumnos?.length > 0 ? curso.alumnos.map((alumno, i) => <Link to={`/alumno/${alumno.id}`} className='link-to' key={i}>{alumno.nombre}</Link>)
                                : <p>El curso no tiene alumnos inscriptos</p>
                        }
                    </section>
                </div>

            </div>
        </div>
    )
}

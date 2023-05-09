import React, { useContext, useEffect, useState } from 'react'
import { useParams } from 'react-router';
import { Link } from 'react-router-dom';
import { getAlumnoById } from '../../services/AlumnoService'
import {AuthContext} from '../../context/AuthContext'
import "./perfilAlumno.scss"

export default function PerfilAlumno() {

    const { id } = useParams();
    const [alumno, setAlumno] = useState({})
    const {data} = useContext(AuthContext)

    useEffect(() => {
        getAlumnoById(id).then(res => setAlumno(res))
    }, [id])


    return (
        <div style={{ display: "flex", flexDirection: "column", alignItems: "center" }}>

            <div className='perfil-alumno'>

                <section className='info'>
                    { parseInt(id) === data.user.id && <i className='icon-modificar'><Link to={`/alumno/update/${alumno.id}`}>✏</Link></i>}
                    <span>Nombre: {alumno.nombre}</span>
                    <span>Edad: {alumno.edad}</span>
                    <span>Nacimiento: {new Date(alumno.fechaDeNacimiento).toLocaleDateString()}</span>
                    <span>Email: {alumno.email}</span>
                    <span>Historia: {alumno.historia}</span>
                </section>
                <section className='cursos'>
                    <h4>Cursos</h4>
                    {
                        alumno.cursos?.length > 0 ? alumno.cursos.map((curso, i) => <Link className='link-to' to={`/curso/${curso.id}`} key={i}>{curso.nombre}</Link>)
                            : (data.user.id === parseInt(id)) && <Link className='add-cursos-link' to={`/alumno/add-cursos/${id}`}>Inscribirse a cursos</Link>
                    }
                </section>
            </div>
            {alumno.cursos?.length > 0 && (data.user.id === parseInt(id)) && <Link className='add-cursos-link' to={`/alumno/add-cursos/${id}`}>Inscribirse a cursos</Link>}
        </div>
    )
}

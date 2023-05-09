import React, { useContext, useEffect, useState } from 'react'
import { Link, useParams } from 'react-router-dom';
import { AuthContext } from '../../context/AuthContext';
import { getProfesorById, removeCursoToProfesor } from '../../services/ProfesorService';
import "./perfilProfesor.scss"

export default function PerfilProfesor() {
    const { id } = useParams();
    const [profesor, setProfesor] = useState({})
    const { data } = useContext(AuthContext)
    const [cursos, setCursos] = useState([])

    async function removeCurso(curso) {
        try {
            const res = await removeCursoToProfesor(profesor.id, curso.id)
            setProfesor(res)
            setCursos(cursos.filter(e => e.id !== curso.id))
        } catch (error) {
            console.log(error);
            return
        }

    }

    useEffect(() => {
        getProfesorById(id).then(res => {
            setProfesor(res)
            console.log(res)
            setCursos(res.cursos)
        })
    }, [id])

    return (
        <div style={{ display: "flex", flexDirection: "column", alignItems: "center" }}>
            <div className='perfil-profesor'>

                <section className='info'>
                    <span>Nombre: {profesor.nombre}</span>
                    <span>Apellido: {profesor.apellido}</span>
                    <span>Email: {profesor.email}</span>
                </section>
                <section className='cursos'>
                    <h4>Cursos</h4>
                    {
                        cursos?.length > 0 ? cursos.map((curso, i) =>
                            <div className='curso-info'>
                                <Link className='link-to' to={`/curso/${curso.id}`} key={i}>
                                    {curso.nombre}
                                </Link>
                                {(data.user.id === parseInt(id)) | data.user.role === "ADMIN" ?
                                    <i className='delete-curso-icon' onClick={() => removeCurso(curso)}>✖</i>
                                    : ""}
                            </div>)
                            : (data.user.id === parseInt(id)) && <Link className='add-cursos-link' to={`/profesor/add-cursos/${id}`}>Inscribirse a cursos</Link>
                    }
                </section>
            </div>
            {cursos?.length > 0 && (data.user.id === parseInt(id)) && <Link className='add-cursos-link' to={`/profesor/add-cursos/${id}`}>Inscribirse a cursos</Link>}
        </div>
    )
}

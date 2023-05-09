import React, { useContext, useEffect, useState } from 'react'
import { useNavigate, useParams } from 'react-router-dom';
import { AuthContext } from '../../context/AuthContext';
import { getCursosWhereProfesorNotIn } from '../../services/CursoService';
import { addCursosProfesor, getProfesorById } from '../../services/ProfesorService';
import "./perfilProfesor.scss"

export default function CursosProfesor() {
    const { id } = useParams();
    const [profesor, setProfesor] = useState({})
    const [cursosToShow, setCursosToShow] = useState([])
    const [cursosToAdd, setCursosToAdd] = useState([])

    const {data} = useContext(AuthContext)
    const navigate = useNavigate()
    useEffect(() => {
        if(data.user.role === 'ALUMNO'){
            navigate("/")
        }
        if(data.user.role === 'PROFESOR' && data.user.id !== parseInt(id)){
            navigate("/")
        }
    })

    useEffect(() => {
        getProfesorById(id).then(res => setProfesor(res))
        getCursosWhereProfesorNotIn(id).then(res => setCursosToShow(res))
    }, [id])

    function selectCurso(curso) {
        const index = cursosToAdd.indexOf(curso);
        if (index !== -1) {
            setCursosToAdd(cursosToAdd.slice(0, index).concat(cursosToAdd.slice(index + 1)));
        } else {
            setCursosToAdd(cursosToAdd.concat(curso));
        }
    }
    async function enviarCursos(){
        const res = await addCursosProfesor(id,cursosToAdd)
        setCursosToShow(await getCursosWhereProfesorNotIn(id))
        navigate(`/profesor/${id}`)
    }
    return (
        <div style={{ display: "flex", flexDirection: "column", alignItems: "center" }}>

            <div className='perfil-profesor'>

                <section className='info'>
                    <span>Nombre: {profesor.nombre}</span>
                    <span>Edad: {profesor.apellido}</span>
                    <span>Email: {profesor.email}</span>
                </section>
                <section className='cursos'>
                <h3>Cursos</h3>
                    {
                        cursosToShow.length > 0 && cursosToShow.map((e, i) =>
                            <CursoAux key={i} curso={e} selectCurso={selectCurso} />
                        )}
                    
                </section>
            </div>
            <button onClick={enviarCursos}>Agregar cursos</button>
        </div>
    )
}

function CursoAux({ curso, selectCurso }) {

    const [selected, setSelected] = useState(false)

    return (
        <span className={selected ? "link-to selected" : "link-to"} onClick={() => {
            selectCurso(curso)
            setSelected(!selected)
        }}>{curso.nombre}</span>
    )
}

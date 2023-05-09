import axios from "axios";
import {API_URL, BASE_HEADERS} from "./index"

const API_CURSOS = `${API_URL}/cursos`


export async function saveCurso(curso){
    const res = await axios.post(`${API_CURSOS}`,curso,BASE_HEADERS)
    return res.data
}

export async function deleteProfesorFromCurso(idCurso){
    const res = await axios.patch(`${API_CURSOS}/delete-profesor/${idCurso}`)
    return res.data
}

export async function getCursosByName(name){
    const res = await axios.get(`${API_CURSOS}/search?nombre=${name}`)
    return res.data
}

export async function getCursosWhereAlumnoNotIn(id){
    const res = await axios.get(`${API_CURSOS}/alumno/${id}`)
    return res.data
}

export async function getCursosWhereProfesorNotIn(){
    const res = await axios.get(`${API_CURSOS}/profesor`)
    return res.data
}

export async function getAllCursos(){
    const res = await axios.get(API_CURSOS)
    return res.data
}

export async function getCursoById(idCurso){
    const res = await axios.get(`${API_CURSOS}/${idCurso}`)
    return res.data
}

export async function updateCurso(idCurso,curso){
    const res = await axios.put(`${API_CURSOS}/${idCurso}`,curso,BASE_HEADERS)
    return res.data
}
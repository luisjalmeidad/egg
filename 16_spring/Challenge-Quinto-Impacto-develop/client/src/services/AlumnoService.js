import axios from "axios";
import {API_URL, BASE_HEADERS} from "./index"

const API_ALUMNOS = `${API_URL}/alumnos`


export async function saveAlumno(alumno){
    const res = await axios.post(`${API_ALUMNOS}`,alumno,BASE_HEADERS)
    return res.data
}

export async function addCursosAlumno(idAlumno,cursos){
    const res = await axios.patch(`${API_ALUMNOS}/${idAlumno}`,cursos,BASE_HEADERS)
    return res.data
}

export async function getAlumnosFromCurso(idCurso){
    const res = await axios.get(`${API_URL}/cursos/${idCurso}`)
    return res.data
}

export async function getAllAlumnos(){
    const res = await axios.get(API_ALUMNOS)
    return res.data
}

export async function getAlumnoById(idAlumno){
    const res = await axios.get(`${API_ALUMNOS}/${idAlumno}`)
    return res.data
}

export async function updateAlumno(idAlumno,alumno){
    const res = await axios.put(`${API_ALUMNOS}/${idAlumno}`,alumno,BASE_HEADERS)
    return res.data
}

export async function getAlumnosByName(name){
    const res = await axios.get(`${API_ALUMNOS}/search?nombre=${name}`,BASE_HEADERS)
    return res.data
}
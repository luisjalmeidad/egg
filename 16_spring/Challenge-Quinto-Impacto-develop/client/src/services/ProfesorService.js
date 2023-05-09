import axios from "axios";
import {API_URL, BASE_HEADERS} from "./index"

const API_PROFESORES = `${API_URL}/profesores`


export async function saveProfesor(profesor){
    const res = await axios.post(`${API_PROFESORES}`,profesor,BASE_HEADERS)
    return res.data;
}

export async function removeCursoToProfesor(idProfesor,idCurso){
    const res = await axios.patch(`${API_PROFESORES}/${idProfesor}/${idCurso}`)
    return res.data

}

export async function addCursosProfesor(idProfesor,cursos){
    const res = await axios.patch(`${API_PROFESORES}/${idProfesor}`,cursos,BASE_HEADERS)
    return res.data;
}

export async function getProfesorFromCurso(idCurso){
    const res = await axios.get(`${API_URL}/cursos/${idCurso}`)
    return res.data;
}

export async function getAllProfesores(){
    const res = await axios.get(API_PROFESORES)
    return res.data;
}

export async function getProfesorById(idProfesor){
    const res = await axios.get(`${API_PROFESORES}/${idProfesor}`)
    return res.data;
}

export async function getProfesorByName(name){
    const res = await axios.get(`${API_PROFESORES}/search?nombre=${name}`)
    return res.data;
}

export async function updateProfesor(idProfesor,profesor){
    const res = await axios.put(`${API_PROFESORES}/${idProfesor}`,profesor,BASE_HEADERS)
    return res.data;
}
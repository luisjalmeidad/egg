import React, { useContext } from 'react'
import { Link } from 'react-router-dom'
import { AuthContext } from '../../context/AuthContext'
import "./home.scss"

export default function Home() {
  const {data} = useContext(AuthContext)
  return (
    <div className='home'>
      <Link to={"/alumno"}><article>Buscar Alumno </article></Link>
      <Link to={"/profesor"}><article>Buscar Profesor</article></Link>
      <Link to={"/curso"}><article>Buscar Curso</article></Link>
      {data.user.role === "ADMIN" && <Link to={"/admin"}><article>Admin Dashboard</article></Link>}
    </div>
  )
}

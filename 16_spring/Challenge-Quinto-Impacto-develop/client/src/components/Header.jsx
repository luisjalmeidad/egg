import React, { useContext } from 'react'
import { Link } from 'react-router-dom'
import {AuthContext} from '../context/AuthContext'

export default function Header() {
    const {data,dispatch} = useContext(AuthContext)
    function logout(){
        dispatch({
            type:"LOGOUT"
        })
    }
    const user = data.user
    return (
        <div className='header'>
            <Link to={"/"}>Home</Link>
            <Link to={"/login"}>{user ? <span onClick={logout}>logout</span> : <span>login</span>}</Link>
            <Link to={"/register"}>Register</Link>
            <Link to={user.role ==="ALUMNO" ? `/alumno/${user.id}`: user.role ==="PROFESOR" ? `/profesor/${user.id}`:""}>{user.email}</Link>
        </div>
    )
}
